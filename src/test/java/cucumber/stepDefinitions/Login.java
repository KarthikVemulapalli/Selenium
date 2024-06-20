package cucumber.stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Login {

	//We can provide ^ and $ to identify sentence with feature file
	@Given("^User is on Home Page$")
	public void stepUserIsOnHomePage() {
		System.out.println("Inside - User Home Page");
	}
	
	//Provide values by passing as arguments, String - {string}
	@When("User login to application using credentials {string} and {string}")
	public void stepUserLoginToApplicationUsingCredentials(String Username, String Password) {
		System.out.println("Inside - Credentials "+ Username + " and "+Password);
	}
	
	//Provide values by passing as arguments, integer - {int}
	@Then("AccountID {int} page is displayed")
	public void stepAccountPageIsDisplayed(int AccountID) {
		System.out.println("Inside - Account Page and AccountID: "+AccountID);
	}
	
	//We can also directly provide the sentence without ^, $
	@And("Validate account page title")
	public void stepValidateAccountPageTitle() {
		System.out.println("Inside - Account Page Title");
	}
	
	//DataTable Concept
	@When ("User SignUp into application using following data")
	public void stepUserSignupIntoApplication(DataTable Table) {
		List<List<String>> TableData = Table.asLists();
		
		System.out.println("Inside - User SignUp");
		System.out.print("     Table Data - "+ TableData.get(0).get(0));
		System.out.print(", "+TableData.get(0).get(1));
		System.out.print(", "+TableData.get(0).get(2));
		System.out.println(", "+TableData.get(0).get(3));
	}
	
	@Given ("BrowserName")
	public void stepBrowserName() {
		System.out.println("Inside - BrowserName");
	}
	
	@When ("Browser is trigerred")
	public void stepBrowserIsTrigerred() {
		System.out.println("Inside - Browser Is Trigerred");
	}
	
	@Then ("Validate browser title")
	public void stepValidateBrowserTitle() {
		System.out.println("Inside - Validate Browser Title");
	}
	
}
