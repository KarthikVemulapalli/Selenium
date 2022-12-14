package Introduction;

//Operates data in the table

import java.util.List;

//interacting with table rows & columns and fetching data 

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Karthik Vemulapalli
 * This Class is about WebTable Interaction
 */

public class WebTable {
	
	private WebDriver driver;
	public WebTable(WebDriver driverCall) {
		this.driver = driverCall;
	}

	public void PrintAllValuesInTable(By Element) {
		
		//found the required table from web page
		WebElement DesiredTable = driver.findElement(Element);
		
		//Storing all the rows of table in list
		List<WebElement> tablerows = DesiredTable.findElements(By.tagName("tr"));
		
		//fetching data from table using WebElement for loop
		for (WebElement tablerow: tablerows) {
			List<WebElement> tablecolumns = tablerow.findElements(By.tagName("td"));
			
			for (WebElement tablecolumn: tablecolumns) {
				String Coldata = tablecolumn.getText();
				System.out.println(Coldata);
			} 
		}
	}
	
}
