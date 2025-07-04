package co.com.bancolombia.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import co.com.bancolombia.usecase.checkstatus.CheckStatusUseCase;
import org.springframework.test.web.servlet.MockMvc;
import co.com.bancolombia.model.checkstatus.CheckStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
class ApiRestTest {

    private MockMvc mockMvc;

    @Mock
    private CheckStatusUseCase checkStatusUseCase;

    @InjectMocks
    private ApiRest apiRest;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(apiRest).build();
    }

    @Test
    void apiRestTest() throws Exception {
        // Arrange
        CheckStatus mockResponse = CheckStatus.builder()
                .statusCode(200)
                .messageStatus("Servicio ok")
                .build();

        when(checkStatusUseCase.getStatus()).thenReturn(mockResponse);

        // Act & Assert
        mockMvc.perform(get("/api/usecase/life-status")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(200))
                .andExpect(jsonPath("$.messageStatus").value("Servicio ok"));
    }
}