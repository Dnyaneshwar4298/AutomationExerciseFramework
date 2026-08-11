package base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import keywords.browserKeywords;
import utility.ConfigReader;

public final class Hooks {
	 protected WebDriver driver;
    @Before
    public void setUp() {

        System.out.println("===== Starting Browser =====");

        browserKeywords.openBrowser(ConfigReader.getProperty("browser"));
        browserKeywords.openUrl(ConfigReader.getProperty("baseUrl"));
        driver = browserKeywords.getDriver();
    }

    @After
    public void tearDown() {

        System.out.println("===== Closing Browser =====");

        browserKeywords.closeBrowser();
        driver = null;
    }

	
}