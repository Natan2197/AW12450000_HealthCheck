package co.com.bancolombia.model.checkstatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CheckStatus {
    private int statusCode;
    private String messageStatus;
}
