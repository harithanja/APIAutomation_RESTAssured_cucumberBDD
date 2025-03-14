package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       features={"src/main/java/Features"},
       glue= {"Steps"},
        strict = true,
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@AddPlace or @back or @put or @remove"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
