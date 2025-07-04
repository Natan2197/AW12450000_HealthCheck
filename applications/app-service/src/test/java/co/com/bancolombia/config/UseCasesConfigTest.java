package co.com.bancolombia.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import co.com.bancolombia.model.checkstatus.gateways.CheckStatusRepository;
import org.springframework.context.annotation.Configuration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import co.com.bancolombia.model.checkstatus.CheckStatus;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Bean;
import org.junit.jupiter.api.Test;

public class UseCasesConfigTest {

    @Test
    void testUseCaseBeansExist() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class)) {
            String[] beanNames = context.getBeanDefinitionNames();

            boolean useCaseBeanFound = false;
            for (String beanName : beanNames) {
                if (beanName.endsWith("UseCase")) {
                    useCaseBeanFound = true;
                    break;
                }
            }

            assertTrue(useCaseBeanFound, "No beans ending with 'Use Case' were found");
        }
    }

    @Configuration
    @Import(UseCasesConfig.class)
    static class TestConfig {

        @Bean
        public CheckStatusRepository checkStatusRepository() {
            return () -> CheckStatus.builder()
                    .statusCode(200)
                    .messageStatus("mocked")
                    .build();
        }
    }
}