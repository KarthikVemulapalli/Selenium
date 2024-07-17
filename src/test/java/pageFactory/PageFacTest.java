package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFacTest {
	
	public static WebDriver getDriver() {
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}

	public static void main(String args[]) {
		SubPage obj = new SubPage(getDriver());
		obj.launchGoogle_ClickGmail();
	}
	
}