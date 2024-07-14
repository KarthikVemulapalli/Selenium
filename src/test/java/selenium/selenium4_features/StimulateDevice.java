package selenium.selenium4_features;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;

public class StimulateDevice {
	
	/* Emulation Domain */

	public void adjustBrowserSize() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Emulation.setDeviceMetricsOverride(500, 900, 50, true, 
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()
				));
		
		coolingTime(3);
		driver.navigate().to("https://google.com/");
		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("Hello");
		coolingTime(2);
		driver.close();
	}
	
	public void coolingTime(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		StimulateDevice sdevice = new StimulateDevice();
		sdevice.adjustBrowserSize();
	}

}
