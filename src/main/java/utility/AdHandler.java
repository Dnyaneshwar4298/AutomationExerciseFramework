package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class AdHandler {

    public AdHandler() {
    }

    /**
     * Closes common ad overlays if they are present.
     * The test is not failed when an ad is absent.
     */
    public static void closeAdIfPresent(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            String[] closeLocators = {
                "//button[normalize-space()='Close']",
                "//a[normalize-space()='Close']",
                "//*[self::div or self::span][normalize-space()='Close']",
                "//*[contains(@class,'close-button')]",
                "//*[contains(@class,'close')]"
         
                
                
            };

            for (String locator : closeLocators) {
                List<WebElement> elements = driver.findElements(By.xpath(locator));

                for (WebElement element : elements) {
                    if (element.isDisplayed()) {
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                            return;
                        } catch (Exception ignored) {
                            // Try the next possible close element.
                        }
                    }
                }
            }

            // Some advertisements are hosted inside an iframe.
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));

            for (WebElement frame : frames) {
                try {
                    driver.switchTo().frame(frame);

                    for (String locator : closeLocators) {
                        List<WebElement> elements = driver.findElements(By.xpath(locator));
                        for (WebElement element : elements) {
                            if (element.isDisplayed()) {
                                element.click();
                                driver.switchTo().defaultContent();
                                return;
                            }
                        }
                    }
                } catch (NoSuchElementException | TimeoutException ignored) {
                    // Try next frame.
                } catch (Exception ignored) {
                    // Ignore one bad iframe and continue.
                } finally {
                    driver.switchTo().defaultContent();
                }
            }

        } catch (Exception e) {
            System.out.println("Ad popup was not closed: " + e.getMessage());
        }
    }
}
