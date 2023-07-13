package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"steps"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@gmail"
)

public class TestRunner {

}
