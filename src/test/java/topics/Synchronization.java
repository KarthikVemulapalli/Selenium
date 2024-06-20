package topics;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

/**
 * @author Karthik Vemulapalli
 * This Class is about WebDriver Synchronization Wait Methods
 */


public class Synchronization {
	
	private WebDriver driver;
	public Synchronization(WebDriver driverCall) {
		this.driver = driverCall;
	}
	
	public void StaticWait(int Seconds) {
		try {
			Thread.sleep(Seconds*1000);
		} catch (InterruptedException e) {
			System.out.println("Failed: Static Wait");
		}
	}
	
	public void ImplicitWait() {
		//Implicit Wait - Dynamic Wait

		//The below method is out dated i.e. @Deprecated. So we can see StrikeOff
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void ExplicitWait(WebElement Element) {
		//Explicit wait - Dynamic Wait
		/* Old Syntax 
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(Element));
	}
	
	public void FluentWait(WebElement Element) {
		/* Old syntax
		 * Wait wait = new FluentWait (driver);
		 * wait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class); */
		
		//Polling time - For every mentioned time period driver checks in the WebPage.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);

		wait.until(ExpectedConditions.visibilityOfAllElements(Element));
	}

}
