package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/features/shopclues.feature" 
,monochrome = true , 
glue = "steps")
public class RunShopClues extends AbstractTestNGCucumberTests {

}
