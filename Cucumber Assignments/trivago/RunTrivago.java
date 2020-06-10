package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/features/trivago.feature" , 
glue = "steps" ,
monochrome = true /*,
snippets = SnippetType.CAMELCASE*/ )
public class RunTrivago extends AbstractTestNGCucumberTests {

}
