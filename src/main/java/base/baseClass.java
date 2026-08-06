package base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import keywords.browserKeywords;
import keywords.waitFor;
import utility.ConfigReader;

public class BaseClass {
	
	waitFor waitFor;
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser(){
		String browser = ConfigReader.getProperties("browser");
        String url = ConfigReader.getProperties("baseUrl");

        browserKeywords.openBrowser(browser);
        browserKeywords.openUrl(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		browserKeywords.closeBrowser();
	}
}
