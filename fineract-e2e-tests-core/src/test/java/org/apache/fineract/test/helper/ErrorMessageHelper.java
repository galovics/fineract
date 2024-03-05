package org.apache.fineract.test.helper;

import java.io.IOException;
import retrofit2.Response;

public class ErrorMessageHelper {

    public static String requestFailed(Response response) throws IOException {
        return String.format("Request failed. Error:\n%s", response.errorBody() != null ? response.errorBody().string() : null);
    }

    public static String requestFailedWithCode(Response response) {
        return String.format("Response has error code: %2d", response.code());
    }
}
