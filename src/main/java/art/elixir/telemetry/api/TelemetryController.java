package art.elixir.telemetry.api;

import art.elixir.telemetry.model.TelemetryReport;
import art.elixir.telemetry.model.TelemetryResponse;
import art.elixir.telemetry.service.IntegrityService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TelemetryController {

  private final IntegrityService integrityService;

  public TelemetryController(IntegrityService integrityService) {
    this.integrityService = integrityService;
  }

  @GetMapping("/health")
  public TelemetryResponse health() {
    return new TelemetryResponse("OK", "ALLOW", "Lyra Telemetry API is up.");
  }

  @PostMapping("/telemetry")
  public ResponseEntity<TelemetryResponse> ingest(@Valid @RequestBody TelemetryReport report) {
    var decision = integrityService.evaluate(report.buildId(), report.crc32c());
    var resp = new TelemetryResponse("OK", decision.decision(), decision.message());

    // Exemplo de política: mismatch vira 202 Accepted (log + análise),
    // ou 403 se quiser bloquear. Aqui deixamos 202 para evitar “sinalizar” detalhes.
    if (!"ALLOW".equals(decision.decision())) {
      return ResponseEntity.accepted().body(resp);
    }
    return ResponseEntity.ok(resp);
  }
}
