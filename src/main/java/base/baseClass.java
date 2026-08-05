package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import keywords.browserKeywords;

public class baseClass {
	
	public static WebDriver driver;
	@BeforeMethod
	public  void openBrowser() {
		browserKeywords.openBrowser("chrome");
		System.out.println("Chrome Browser Opened");
		browserKeywords.fullscreen();
		browserKeywords.openUrl("https://automationexercise.com");
		System.out.println("Automation Exercise Website Opened");
	}
	
	@AfterMethod
	public void closeBrowser() {
		browserKeywords.closeBrowser();
	}
}
