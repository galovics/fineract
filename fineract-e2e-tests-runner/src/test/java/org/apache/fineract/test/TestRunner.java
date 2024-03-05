package org.apache.fineract.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "org.apache.fineract.test.stepdef",
        "org.apache.fineract.test.stepdef.common", "org.apache.fineract.test.stepdef.hook", "org.apache.fineract.test.stepdef.loan",
        "org.apache.fineract.test.stepdef.saving", "org.apache.fineract.test.config" })
public class TestRunner {}
