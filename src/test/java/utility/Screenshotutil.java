package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutil {

	public static void captureScreenshot(WebDriver driver, String testname) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// This line captures a screenshot of the current browser window and stores it
		// as a File object.

		// timestamp
		String time = new SimpleDateFormat("HHmmss-dd-MM-yyyy").format(new Date());

		try {
			FileUtils.copyFile(src,  new File("./Screenshots/" + testname + "-" + time + ".png"));
			System.out.println("ScreenShot captured Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
