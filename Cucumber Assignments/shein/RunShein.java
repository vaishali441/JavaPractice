package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\shein.feature" , monochrome =  true ,glue = "steps")
public class RunShein extends AbstractTestNGCucumberTests {

}
