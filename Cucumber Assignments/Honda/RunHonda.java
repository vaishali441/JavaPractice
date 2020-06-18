package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\honda.feature", monochrome = true , glue = "steps")
public class RunHonda  extends AbstractTestNGCucumberTests{

}
