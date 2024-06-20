package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Karthik Vemulapalli
 * This Class explains about Selenium Grid initialization based on Browser desired
 */

public class SeleniumGridInitialization {
	public static WebDriver remotedriver;
	
	public void launchBrowser(String CompleteHubIPAddress, String OS, String BrowserName) throws MalformedURLException {
		
		//CompleteHubIPAddress - "<IpAddressOfHub:HubLocalPort>"
		//If queries refer 'SeleniumGrid.pdf' in main/resources/SelenuimGrid 
		DesiredCapabilities DesiredCapObj = new DesiredCapabilities();
		
		if (BrowserName.equalsIgnoreCase("Chrome") && OS.equalsIgnoreCase("Windows")) {
			//Initially we set Browser capabilities, like desired browser to run, platform, etc.
			DesiredCapObj.setBrowserName("chrome");
			DesiredCapObj.setPlatform(Platform.WINDOWS);
			//Initialize WebDriver reference variable to RemoteWebDriver
			remotedriver = new RemoteWebDriver(new URL(CompleteHubIPAddress), DesiredCapObj);
		}
		else if (BrowserName.equalsIgnoreCase("Firefox") && OS.equalsIgnoreCase("Windows")) {
			DesiredCapObj.setBrowserName("firefox");
			DesiredCapObj.setPlatform(Platform.WINDOWS);
			remotedriver = new RemoteWebDriver(new URL(CompleteHubIPAddress), DesiredCapObj);
		}
	}
	
	public WebDriver getRemoteWebDriver() {
		return remotedriver;
	}
	
}
