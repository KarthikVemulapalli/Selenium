package topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Karthik Vemulapalli
 * This Class is about Actions Class commands
 */

public class ActionsClass {
	
	private WebDriver driver;
	//Actions Class performs all Mouse and Keyboard Operations
	Actions actionsObj = new Actions(driver);
	
	public ActionsClass(WebDriver driverCall) {
		this.driver = driverCall;
	}
	
	public void DragAndDropElement(By Element, By ToElement) {		
		//Use dragAndDrop method and provide arguments as the from element and to element
		WebElement LElement = driver.findElement(Element);
		WebElement LToElement = driver.findElement(ToElement);
		
		actionsObj.dragAndDrop(LElement, LToElement).build().perform();	
	}
	
}
