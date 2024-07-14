package selenium.topics;

//Operates data in the table

import java.util.List;

//interacting with table rows & columns and fetching data 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
