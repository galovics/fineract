package org.apache.fineract.test.helper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import retrofit2.Response;

public class ErrorHelper {

    public static void checkSuccessfulApiCall(Response response) throws IOException {
        assertThat(response.isSuccessful()).as(ErrorMessageHelper.requestFailed(response)).isTrue();

        if (response.code() != 200 && response.code() != 202 && response.code() != 204) {
            throw new AssertionError(ErrorMessageHelper.requestFailedWithCode(response));
        }
    }
}
