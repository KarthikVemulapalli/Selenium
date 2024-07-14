package cucumber.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(										//Here CucumberOptions is imported from TestNG
		features = "src/test/resources/BDDFeatures",   	//Feature files path
		glue = "cucumber/stepDefinitions") 				//StepDefinition (Code) path

public class TestNG_TestRunner extends AbstractTestNGCucumberTests {
	
}