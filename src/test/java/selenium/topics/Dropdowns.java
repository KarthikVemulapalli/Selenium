package selenium.topics;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Dropdowns {

	public void handleDropdown() {
		
		WebElement element = WebDriverInitialization.getDriver().findElement(By.xpath(""));
		Select selectdropdown = new Select(element);
		
		selectdropdown.selectByIndex(0);
		selectdropdown.selectByValue("value");
		selectdropdown.selectByVisibleText("visible text");
		
		/* Returns boolean value whether given dropdown is MultiSelect or not */
		boolean multiSelectDropdown = selectdropdown.isMultiple();
		
		/* Returns all webelements in List<WebElement> of dropdown */
		List<WebElement> dropdownElements = selectdropdown.getOptions();
		
		WebElement firstelement = selectdropdown.getFirstSelectedOption();
	}
	
}