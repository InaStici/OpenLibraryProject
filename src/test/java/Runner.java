import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:build/cucumber-html/index.html"},
        glue = {
                "tests.stepdefinitions.StepDefinitions.java"
        },
        tags = ""
)
public class Runner {
}
