package co.com.bancolombia.model.checkstatus.gateways;

import co.com.bancolombia.model.checkstatus.CheckStatus;

public interface CheckStatusRepository {
    public CheckStatus getStatus();
}
