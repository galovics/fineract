package org.apache.fineract.test.factory;

import org.apache.fineract.client.models.PostClientsRequest;
import org.apache.fineract.test.helper.Utils;
import org.springframework.stereotype.Component;

@Component
public class ClientRequestFactory {

    private static final Long HEAD_OFFICE_ID = 1L;
    private static final Long LEGAL_FORM_ID_PERSON = 1L;
    public static final String DATE_FORMAT = "dd MMMM yyyy";
    public static final String DEFAULT_LOCALE = "en";

    public PostClientsRequest defaultClientCreationRequest() {
        return new PostClientsRequest()//
                .officeId(HEAD_OFFICE_ID)//
                .legalFormId(LEGAL_FORM_ID_PERSON)//
                .firstname(Utils.randomNameGenerator("Client_FirstName_", 5))//
                .lastname(Utils.randomNameGenerator("Client_LastName_", 5))//
                .externalId(randomClientId("ID_", 7))//
                .dateFormat(DATE_FORMAT)//
                .locale(DEFAULT_LOCALE)//
                .active(true)//
                .activationDate("04 March 2011");//
    }

    private String randomClientId(final String prefix, final int lenOfRandomSuffix) {
        return Utils.randomStringGenerator(prefix, lenOfRandomSuffix, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
