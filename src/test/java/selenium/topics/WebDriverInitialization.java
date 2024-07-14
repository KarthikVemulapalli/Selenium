package selenium.topics;

import java.io.File;
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
	
	/* 
	 * WebDriver is an Interface
	 * we can not create object for an Interface
	 * 'driver' is an instance variable of WebDriver
	 */
	private static WebDriver driver;
	private String FS = File.separator;
	
	/*
	 * WebDriverManager is an AbstractClass (cannot create object for Abstract class)
	 * ChromeDriver(), EdgeDriver(), FirefoxDriver() are Classes
	 */
	
	public void launchBrowserUsingDriverPath(String BrowserName) {
		/*
		 * System.setProperty("webdriver.chrome.driver", "Driver Path with Extension '.exe'")
		 * During runtime Selenium checks the key 'webdriver.chrome.driver' and take the value 'Driver Path' to find driver and executes the code
		 */
		
		String DriverPath = System.getProperty("user.dir")+FS+"src"+FS+"test"+FS+"resources"+FS+"browserDrivers"+FS;
		
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath+"chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", DriverPath+"msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", DriverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public void launchBrowserUsingWebDriverManager(String BrowserName) {
		/*
		 * WebDriverManager will take care of browser driver downloads
		 */
		
		if (BrowserName.equalsIgnoreCase("Chrome")) {
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
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void openURL() {
		driver.get("https://www.google.com");
	}
	
	/*
	 * If we use driver after close() or quit() commands, Selenium throws 'NoSuchSessionException' 
	 */
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
	
	public static void main(String[] arguments) {
		WebDriverInitialization wdi = new WebDriverInitialization();
		wdi.launchBrowserUsingWebDriverManager("Chrome");
		wdi.openURL();
		wdi.quitBrowser();
	}
	
}