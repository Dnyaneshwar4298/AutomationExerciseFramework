package keywords;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
}
