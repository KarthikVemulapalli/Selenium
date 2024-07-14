package selenium.selenium4_features;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class ExecuteCDPCommand {

	public void runCDPCommand() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		/* Refer 'https://chromedevtools.github.io/devtools-protocol/' for CDP parameters to be passed */
		Map<String, Object> cdpParameters = new HashMap<>();
		cdpParameters.put("width", 600);
		cdpParameters.put("height", 900);
		cdpParameters.put("deviceScaleFactor", 50);
		cdpParameters.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", cdpParameters);
		
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
		ExecuteCDPCommand executeCDP = new ExecuteCDPCommand();
		executeCDP.runCDPCommand();
	}
	
}