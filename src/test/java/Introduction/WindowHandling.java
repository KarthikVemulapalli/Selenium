package Introduction;

//Multiple window handling and drag a& drop action

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Karthik Vemulapalli This Class is about Window Handling Interaction
 */

public class WindowHandling {

	private WebDriver driver;
	public WindowHandling(WebDriver driverCall) {
		this.driver = driverCall;
	}

	public void SwitchToWindow(String WindowTitle) {
		
		String ParentWindow = driver.getWindowHandle(); 
			
		//Window handles method return Set of String
		Set<String> AllOpenWindows = driver.getWindowHandles();
		
		//to get the value from set object, we will use iterator
		Iterator<String> windowloop = AllOpenWindows.iterator();
		
		while(windowloop.hasNext()) {
			String Window = windowloop.next();
			
			if(!Window.equalsIgnoreCase(ParentWindow)) {
				driver.switchTo().window(Window);
				if(driver.getTitle().equalsIgnoreCase(WindowTitle)) {
					break;
				}
			}
		}
		
	}

}
