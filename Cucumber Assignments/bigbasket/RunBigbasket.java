package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/features/bigbasket.feature" , glue = "steps" , monochrome = true)
public class RunBigbasket extends AbstractTestNGCucumberTests {

}
