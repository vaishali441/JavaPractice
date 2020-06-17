package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\bigbasket2.feature",monochrome = true , glue = "steps")
public class RunBigbasket2 extends AbstractTestNGCucumberTests{

}
