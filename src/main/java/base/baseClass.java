package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import keywords.browserKeywords;
import utility.ConfigReader;

public class baseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        browserKeywords.openBrowser(ConfigReader.getProperty("browser"));
        browserKeywords.openUrl(ConfigReader.getProperty("baseUrl"));
        driver = browserKeywords.getDriver();
    }

    //@AfterMethod(alwaysRun = true)
    public void tearDown() {
        browserKeywords.closeBrowser();
        driver = null;
    }
}
