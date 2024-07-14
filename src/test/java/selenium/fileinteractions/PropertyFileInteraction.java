package selenium.fileinteractions;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileInteraction {
	
	public static String getGlobalPropertyValue(String PropertyName) {
		Properties prop = new Properties();
		FileInputStream FIS = null;
		
		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\global.properties";
		try {
			FIS = new FileInputStream(FilePath);
			prop.load(FIS);
		} catch (Exception e) { e.printStackTrace(); }
		
		return prop.getProperty(PropertyName);
	}
	
}
