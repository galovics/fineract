package org.apache.fineract.test.api;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApiProperties {

    @Value("${fineract-test.api.base-url}")
    private String baseUrl;
    @Value("${fineract-test.api.username}")
    private String username;
    @Value("${fineract-test.api.password}")
    private String password;
    @Value("${fineract-test.api.tenant-id}")
    private String tenantId;
}
