package org.apache.fineract.test.api;

import org.apache.fineract.client.services.ClientApi;
import org.apache.fineract.client.services.CodeValuesApi;
import org.apache.fineract.client.services.CodesApi;
import org.apache.fineract.client.util.FineractClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Autowired
    private FineractClient fineractClient;

    @Bean
    public ClientApi clientApi() {
        return fineractClient.createService(ClientApi.class);
    }

    @Bean
    public CodesApi codesApi() {
        return fineractClient.createService(CodesApi.class);
    }

    @Bean
    public CodeValuesApi codeValuesApi() {
        return fineractClient.createService(CodeValuesApi.class);
    }
}
