package keywords;


import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class browserKeywords {

	public static ChromeDriver driver;

	public static void openBrowser(String browserName) {
		System.out.println("Opening Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			System.out.println("Opening Chrome Browser");
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}

	// Open URL
	public static void openUrl(String url) {
		driver.get(url);
		System.out.println("Opening URL: " + url);
	}
	
	// quiteBrowser
		public static void closeBrowser() {
			if (driver != null) {
				driver.quit();
				driver = null;
				System.out.println("Closing the browser");
			}
		}

	// Maximize Window
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// Full Screen
	public static void fullscreen() {
		driver.manage().window().fullscreen();
	}
	
	
	//minimize screen
	public static void screenreduce() {
		driver.manage().window().setSize(new Dimension(800, 600));

	}
	

	// Get Current URL
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Get Page Title
	public static String getTitle() {
		return driver.getTitle();
	}

	public static WebDriver getDriver() {
		
		return driver;
	}
	
	public static void scrollWindow() {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 600).perform();
		

	}
	
	public static String email = "user" + System.currentTimeMillis() + "@gmail.com";
}
