package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\shiksha.feature" , monochrome = true , glue = "steps")
public class RunShiksha extends AbstractTestNGCucumberTests {

}
