package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties properties;

	static { //A static block runs only once, when the class is loaded.
		//It executes before any object is created or any static method is called.
		
		try {
			FileInputStream Fis = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(Fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getProperties(String key) {
		return properties.getProperty(key);
	}

}