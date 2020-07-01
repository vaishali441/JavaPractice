package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features = ".\\src\\test\\java\\features\\lenskart.feature", monochrome = true , glue = "steps")
public class RunLenskart extends AbstractTestNGCucumberTests{
	

}
