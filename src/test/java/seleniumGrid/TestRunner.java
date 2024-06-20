package seleniumGrid;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class TestRunner {
	
	public static void main(String args[]) {

		try {
			SeleniumGridInitialization SGobj = new SeleniumGridInitialization();
			SGobj.launchBrowser("http://localhost:4444", "Windows", "Chrome");
			WebDriver driver = SGobj.getRemoteWebDriver();
			
			driver.get("https://www.google.com");
			driver.quit();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
