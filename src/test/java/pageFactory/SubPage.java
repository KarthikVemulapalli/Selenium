package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubPage extends HomePage {
	
	public SubPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@aria-label='Gmail ']")
	WebElement googleGmailLink;
	
	public void launchGoogle_ClickGmail() {
		driver.get("https://google.com/");
		click(googleGmailLink);
	}

}