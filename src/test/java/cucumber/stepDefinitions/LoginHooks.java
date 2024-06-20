package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LoginHooks {

	@Before("@RegTest")
	public void prestepRegTestScenarios() {
		System.out.println("----- Executed Before Every RegTest -----");
	}
	
	@Before("@SmokeTest")
	public void prestepSmokeTestScenarios() {
		System.out.println("----- Executed Before Every SmokeTest -----");
	}

	@Before("@SanityTest")
	public void prestepSanityTestScenarios() {
		System.out.println("----- Executed Before Every SanityTest -----");
	}
	
	
	@After("@RegTest")
	public void poststepRegTestScenarios() {
		System.out.println("----- Executed After Every RegTest -----");
	}
	
	@After("@SmokeTest")
	public void poststepSmokeTestScenarios() {
		System.out.println("----- Executed After Every SmokeTest -----");
	}

	@After("@SanityTest")
	public void poststepSanityTestScenarios() {
		System.out.println("----- Executed After Every SanityTest -----");
	}

}
