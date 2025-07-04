package co.com.bancolombia.usecase.checkstatus;

import co.com.bancolombia.model.checkstatus.gateways.CheckStatusRepository;
import co.com.bancolombia.model.checkstatus.CheckStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckStatusUseCase {
    private final CheckStatusRepository checkStatusRepository;

    public CheckStatus getStatus() {
        return checkStatusRepository.getStatus();
    }
}
