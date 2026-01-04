package art.elixir.telemetry.model;

import jakarta.validation.constraints.*;

public record TelemetryReport(
    @NotBlank @Size(max = 64) String playerId,
    @NotBlank @Size(max = 64) String matchId,
    @NotBlank @Size(max = 32) String platform,      // windows/linux/macos/lyra
    @NotBlank @Size(max = 64) String buildId,       // ex: 2026.01.03+sha
    @NotBlank @Pattern(regexp = "^[0-9A-Fa-f]{8}$") String crc32c, // 8 hex chars
    @Min(0) @Max(600_000) long clientUptimeMs,
    @Min(0) @Max(500) int avgPingMs
) {}
