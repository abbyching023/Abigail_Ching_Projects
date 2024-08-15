package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/java/Features"},

//        plugin = {"pretty", "json:cucumber.json", "html:target/cucumber-html-report", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},

        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},

        glue = {"StepDefinition","Utility"},

        tags = "@crud"
)

public class TestRunner {
}
