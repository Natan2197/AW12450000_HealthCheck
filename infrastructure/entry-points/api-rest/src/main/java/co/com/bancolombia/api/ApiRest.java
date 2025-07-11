package co.com.bancolombia.api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.model.checkstatus.CheckStatus;
import co.com.bancolombia.usecase.checkstatus.CheckStatusUseCase;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CheckStatusUseCase checkStatusUseCase;

    @GetMapping(path = "/usecase/life-status")
    public CheckStatus getStatusMicro() {
        return checkStatusUseCase.getStatus();
    }
}
