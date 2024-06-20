package topics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Karthik Vemulapalli
 * This Class is about Taking Screenshot and Save in Framework
 */


public class Screenshot {
		
	public static void TakeScreenshot(WebDriver driver) {
		
		Date DateObj = new Date();
		SimpleDateFormat SDFObj = new SimpleDateFormat("ddMMyyyyhhmmss");
		//Current DateWithTime Generation
		String DateWithTime = SDFObj.format(DateObj);
		
		try {			
			String CurrentDirectory = System.getProperty("user.dir");
			String ScreenshotFrameworkPath = "\\src\\test\\resources\\ScreenShotImages\\";
			
			File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
			//To generate random Screenshot
			FileUtils.copyFile(scrshot, new File(CurrentDirectory+ScreenshotFrameworkPath+"ScreenShot_"+DateWithTime+".png"));
		
		} catch (Exception e) {
			System.out.print("Failed: Capture Screenshot");
		}
	}

}
