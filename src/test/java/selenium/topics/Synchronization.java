package selenium.topics;

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
	
	/*
	 * Thread.sleep() - Static Wait by Java
	 * Implicit Wait - Dynamic Wait by Selenium
	 * Explicit Wait - Dynamic Wait by Selenium
	 * Fluent Wait - Dynamic Wait by Selenium
	 */
	
	/*
	 * FluentWait(class) implements Wait (Interface)
	 * WebDriverWait(class) extends FluentWait
	 */
	
	public void StaticWait(int Seconds) {
		try {
			Thread.sleep(Seconds*1000);
		} catch (InterruptedException e) {
			System.out.println("Failed: Static Wait");
		}
	}
	
	public void ImplicitWait() {
		/*
		 * The below method is out dated i.e. @Deprecated. So we can see StrikeOff
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void ExplicitWait(WebElement Element) {
		/*
		 * Explicit Wait is defined using WebDriverWait
		 * The default polling time is set to 500ms
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(Element));
	}
	
	public void FluentWait(WebElement Element) {
		/*
		 * Explicit Wait is defined using FluentWait
		 */
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

}