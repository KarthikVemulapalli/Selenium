package selenium4_features;

import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;

public class SetGeoLocation {
	
	public void setGeo() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Emulation.setGeolocationOverride(Optional.of(49.80375616), Optional.of(15.47490816), Optional.empty()));
		
		driver.navigate().to("https://google.com/");
		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("Netflix", Keys.ENTER);
	}

	public static void main(String[] args) {
		SetGeoLocation sgl = new SetGeoLocation();
		sgl.setGeo();
	}

}