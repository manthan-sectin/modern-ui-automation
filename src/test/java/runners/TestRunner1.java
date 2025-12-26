package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/SauceDemoLogin.feature",
    glue = {"stepDefinitions","hooks"},
    plugin = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber.json",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            "rerun:target/rerun.txt"
    },
    monochrome = true
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
}
