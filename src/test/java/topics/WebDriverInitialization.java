/* Step1 */
package topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Karthik Vemulapalli
 * This Class explains about WebDriver initialization based on Browser desired
 */

public class WebDriverInitialization {
	
	// WebDriver is an Interface
	// we can not create object for an Interface
	// driver is an instance variable of WebDriver
	
	public static WebDriver driver;
	
	// 'launchBrowser' Method Returns WebDriver Object
	// WebDriverManager maintain the latest driver version to respective latest browser
	// ChromeDriver(), EdgeDriver(), FirefoxDriver() are Classes
	
	public void launchBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			//We need to write System.setProperty in place of WebDriverManager, for explanation see at the bottom
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/*
	 * System.setProperty("webdriver.chrome.driver", "Chrome Driver Path with Extension '.exe'")
	 * During runtime Selenium checks the key 'webdriver.chrome.driver' and take the value 'ChromeDriver Path' to find driver and executes the code
	 * 
	 * I have neglected the 'System.setProperty' because, everytime we need to keep the driver updated to browser compatibility 
	 * I have used WebDriverManager because this manages the driver with browser compatibility
	 */
	
	/*
     * System.setProperty (BrowserSyntax, BrowserPath);
     * - For Chrome Browser, BrowserSyntax = �webdriver.chrome.driver�
     * - For Edge Browser, BrowserSyntax = �webdriver.edge.driver�
     * - For Firefox Browser, BrowserSyntax = �webdriver.gecko.driver�
     */
		
}
