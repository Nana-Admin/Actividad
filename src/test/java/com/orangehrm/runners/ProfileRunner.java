package com.orangehrm.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/perfil",
        glue = "com.orangehrm.stepsdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/perfil"}
)
public class ProfileRunner {
}
