package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = ".\\src\\test\\java\\features\\bikewale.feature" ,monochrome = true , glue = "steps")
public class RunBikewale extends AbstractTestNGCucumberTests
{

}
