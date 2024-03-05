package org.apache.fineract.test.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.client.util.FineractClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FineractClientConfiguration {

    @Autowired
    private ApiProperties apiProperties;

    @Bean
    public FineractClient fineractClient() {
        String baseUrl = apiProperties.getBaseUrl();
        String username = apiProperties.getUsername();
        String password = apiProperties.getPassword();
        String tenantId = apiProperties.getTenantId();

        String apiBaseUrl = baseUrl + "/fineract-provider/api/";

        log.info("Using base URL '{}'", apiBaseUrl);

        return FineractClient.builder().basicAuth(username, password).tenant(tenantId).baseURL(apiBaseUrl).insecure(true).build();
    }
}
