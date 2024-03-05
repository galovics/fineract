package org.apache.fineract.test.helper;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.client.models.GetCodesResponse;
import org.apache.fineract.client.models.PostCodeValueDataResponse;
import org.apache.fineract.client.models.PostCodeValuesDataRequest;
import org.apache.fineract.client.services.CodeValuesApi;
import org.apache.fineract.client.services.CodesApi;
import org.springframework.stereotype.Component;
import retrofit2.Response;

@Component
@RequiredArgsConstructor
public class CodeHelper {

    private static final String COUNTRY_CODE_NAME = "COUNTRY";
    private static final String STATE_CODE_NAME = "STATE";
    private static final String ADDRESS_TYPE_CODE_NAME = "ADDRESS_TYPE";

    private final CodesApi codesApi;
    private final CodeValuesApi codeValuesApi;

    public Response<PostCodeValueDataResponse> createAddressTypeCodeValue(String addressTypeName) throws IOException {
        Long codeId = retrieveCodeByName(ADDRESS_TYPE_CODE_NAME).getId();
        return codeValuesApi.createCodeValue(codeId, new PostCodeValuesDataRequest().name(addressTypeName)).execute();
    }

    public Response<PostCodeValueDataResponse> createCountryCodeValue(String countryName) throws IOException {
        Long codeId = retrieveCodeByName(COUNTRY_CODE_NAME).getId();
        return codeValuesApi.createCodeValue(codeId, new PostCodeValuesDataRequest().name(countryName)).execute();
    }

    public Response<PostCodeValueDataResponse> createStateCodeValue(String stateName) throws IOException {
        Long codeId = retrieveCodeByName(STATE_CODE_NAME).getId();
        return codeValuesApi.createCodeValue(codeId, new PostCodeValuesDataRequest().name(stateName)).execute();
    }

    public GetCodesResponse retrieveCodeByName(String name) throws IOException {
        return codesApi.retrieveCodes().execute().body().stream().filter(r -> name.equals(r.getName())).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Code with name " + name + " has not been found"));
    }
}
