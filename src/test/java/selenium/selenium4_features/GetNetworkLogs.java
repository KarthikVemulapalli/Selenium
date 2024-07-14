package selenium.selenium4_features;

import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.network.Network;

public class GetNetworkLogs {

	public void getNetworkData() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devtools.addListener(Network.requestWillBeSent(), request -> {	
			if(request.getRequest().getMethod().toString().toUpperCase().contains("GET")) {
				System.out.println("Request URL - "+request.getRequest().getUrl());
			}
			
			/* Below code will replace Request Header value with new value
			 * request.getRequest().getHeaders().replace("x-recpatcha", "<newValue>");
			 */
		});
		
		
		devtools.addListener(Network.responseReceived(), response -> {
			if( Integer.valueOf(response.getResponse().getStatus().toString()) > 199 ) {
				System.out.println("Response URL - "+response.getResponse().getUrl());
				System.out.println("Response Status - "+response.getResponse().getStatus());
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
		GetNetworkLogs getnetlogs = new GetNetworkLogs();
		getnetlogs.getNetworkData();
	}

}