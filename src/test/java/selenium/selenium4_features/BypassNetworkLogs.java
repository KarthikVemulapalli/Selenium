package selenium.selenium4_features;

import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;

public class BypassNetworkLogs {

	public void setNetworkData() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request -> {	
			
			String newURL = "";
			if(request.getRequest().getUrl().toString().contains("=shetty")) {
				newURL = request.getRequest().getUrl().toString().replace("=shetty", "=BadGuy");
				
				devtools.send(Fetch.continueRequest(
						request.getRequestId(), 
						Optional.of(newURL), 
						Optional.of(request.getRequest().getMethod()), 
						request.getRequest().getPostData(), 
						request.getResponseHeaders()
				));
			}
			else {
				devtools.send(Fetch.continueRequest(
						request.getRequestId(), 
						Optional.of(request.getRequest().getUrl()), 
						Optional.of(request.getRequest().getMethod()), 
						request.getRequest().getPostData(), 
						request.getResponseHeaders()
				));
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BypassNetworkLogs bynetlogs = new BypassNetworkLogs();
		bynetlogs.setNetworkData();
	}

}