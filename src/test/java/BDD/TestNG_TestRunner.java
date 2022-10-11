package BDD;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(										//Here CucumberOptions is imported from TestNG
		features = "src/test/resources/BDDFeatures",   	//Feature files path
		glue = "BDD/StepDefinitions") 					//StepDefinition (Code) path

public class TestNG_TestRunner extends AbstractTestNGCucumberTests {
	
}
