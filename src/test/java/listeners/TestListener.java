package listeners;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import keywords.browserKeywords;
import utility.Screenshotutil;

public class TestListener implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = browserKeywords.getDriver();
		
		if(driver!= null) {
			Screenshotutil.captureScreenshot(driver, result.getName());
		} else {
			System.out.println("Driver null . Screenshot cannot be captured");
		}
	}
}
