package org.apache.fineract.test.stepdef;

import org.apache.fineract.test.support.TestContext;

public class AbstractStepDef {

    public TestContext testContext() {
        return TestContext.INSTANCE;
    }
}
