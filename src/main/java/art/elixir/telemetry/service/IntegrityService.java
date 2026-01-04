package art.elixir.telemetry.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class IntegrityService {

  // Exemplo: CRCs “aceitos” por build.
  // No real: isso viria de config segura / DB / pipeline de release.
  private static final Set<String> ALLOWED_SAMPLE = Set.of(
      "E3069283", // exemplo conhecido de CRC32C("123456789")
      "DEADBEEF"  // placeholder
  );

  public Decision evaluate(String buildId, String crc32cHex) {
    String crc = crc32cHex.toUpperCase();

    if (!isPlausibleBuildId(buildId)) {
      return new Decision("FLAG", "BuildId format looks unusual.");
    }
    if (!ALLOWED_SAMPLE.contains(crc)) {
      return new Decision("SOFT_DENY", "Integrity mismatch: CRC32C not recognized for this build.");
    }
    return new Decision("ALLOW", "Telemetry accepted.");
  }

  private boolean isPlausibleBuildId(String buildId) {
    return buildId.length() <= 64 && buildId.chars().allMatch(ch ->
        Character.isLetterOrDigit(ch) || ch == '.' || ch == '-' || ch == '_' || ch == '+');
  }

  public record Decision(String decision, String message) {}
}
