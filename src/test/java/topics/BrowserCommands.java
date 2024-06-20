/* Step2 */
package topics;

import org.openqa.selenium.WebDriver;

/**
 * @author Karthik Vemulapalli
 * This Class is about basic browser commands
 */

public class BrowserCommands {
	
	private WebDriver driver;
	
	BrowserCommands(WebDriver driverCall){
		this.driver=driverCall;
	}
	
	// Get is used to launch a Website in the new browser webpage
	public void launchURL(String URL) {
		driver.get(URL);
	}
	
	// Get active page title name
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// Get active page complete URL
	public String getPageCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	// Close the current browser window
	public void closeCurrentWindow() {
		driver.close();
	}
	
	// Close the all instances (all windows) of browser
	public void closeBrowser() {
		driver.quit();
	}
	
	// This method simply launch URL in existing page. Driver doesnot wait till the page loads
	public void navigatePage(String URL) {
		driver.navigate().to(URL);
	}
	
	// Moves page forward. Based on cookies
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	// Moves page Backward. Based on cookies
	public void navigateBackward() {
		driver.navigate().back();
	}
	
	// Refresh the current page
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	// Get PageSource of page
	public String getPageSource() {
		return driver.getPageSource();
	}
	
}
