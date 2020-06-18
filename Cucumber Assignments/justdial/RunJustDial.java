package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\justdial.feature" , monochrome = true , glue = "steps")
public class RunJustDial extends AbstractTestNGCucumberTests
{

}
