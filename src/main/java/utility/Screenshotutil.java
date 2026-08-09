package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class Screenshotutil {

    private Screenshotutil() {
    }

    public static void captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return;
        }

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("HHmmss-dd-MM-yyyy").format(new Date());

        File folder = new File("screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File destination = new File(folder, testName + "-" + time + ".png");

        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot captured: " + destination.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }
    }
}
