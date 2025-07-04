package co.com.bancolombia.checkstatus;

import co.com.bancolombia.model.checkstatus.gateways.CheckStatusRepository;
import co.com.bancolombia.model.checkstatus.CheckStatus;
import org.springframework.stereotype.Component;

@Component
public class CheckStatusAdapter implements CheckStatusRepository {
    @Override
    public CheckStatus getStatus() {
        return CheckStatus.builder()
                .statusCode(200)
                .messageStatus("Servicio ok")
                .build();
    }
}