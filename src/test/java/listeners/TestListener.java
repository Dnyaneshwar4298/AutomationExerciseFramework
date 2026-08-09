package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import keywords.browserKeywords;
import utility.Screenshotutil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            WebDriver driver = browserKeywords.getDriver();
            Screenshotutil.captureScreenshot(driver, result.getName());
        } catch (Exception e) {
            System.out.println("Screenshot could not be captured: " + e.getMessage());
        }
    }
}
