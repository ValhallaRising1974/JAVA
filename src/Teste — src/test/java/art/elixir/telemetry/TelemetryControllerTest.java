package art.elixir.telemetry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TelemetryControllerTest {

  @Autowired MockMvc mvc;

  @Test
  void health_ok() throws Exception {
    mvc.perform(get("/api/v1/health"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status").value("OK"));
  }

  @Test
  void telemetry_validates_payload() throws Exception {
    String json = """
      {
        "playerId":"p1",
        "matchId":"m1",
        "platform":"linux",
        "buildId":"2026.01.03+sha123",
        "crc32c":"E3069283",
        "clientUptimeMs":12000,
        "avgPingMs":42
      }
    """;

    mvc.perform(post("/api/v1/telemetry")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.decision").value("ALLOW"));
  }
}
