package BDD;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(										//Here CucumberOptions is imported from JUnit
		//The below are CucumberOptions Attributes
		features = "src/test/resources/BDDFeatures/Login.feature",   	//features - feature files path
		glue = "BDD/StepDefinitions",					//glue - StepDefinition (Code) path
		stepNotifications = true,						//stepNotifications - provides result of each step
		tags = "@RegTest",								//tags - divide into groups
		plugin = {"pretty", "html:target/CucumberReports/report.html", //Cucumber reports generation
				"json:target/CucumberReports/report.json",
				"junit:target/CucumberReports/report.xml"},
		//dryRun=true, 		//Only validates does feature steps are implemented in StepDefinition. Donot execute code.
		monochrome=true		//Displays neat console output, removes unwanted symbols. Also provides path of the particular step 
		)

		/* 
		 Multiple tags can be executed using 
		 	'or' - "@RegTest or @SmokeTest" (Execute tests which has Reg or Smoke)
		 			Alternate syntax for or - "@RegTest,@SmokeTest"
			'And' - "@RegTest and @SmokeTest" (Execute tests that has both Reg and Smoke)
		*/

public class JUnit_TestRunner {
	
}
