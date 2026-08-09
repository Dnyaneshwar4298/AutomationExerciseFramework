package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import keywords.browserKeywords;
import keywords.waitFor;
import utility.AdHandler;

public class productPage {

    private final waitFor wait;

  //  @FindBy(css = "a[href='/products']")
    @FindBy(css ="a[href=\"/product_details/1\"]")
    private WebElement productsLink;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement firstProduct;
    
    @FindBy(css = "class=\"continue-prompt-text\"")
    private WebElement closeadOnProductPage;
    
    public void closeadOnProductPage() {
    	closeadOnProductPage.click();
	}

    public productPage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }

    public void clickOnProduct() {
        wait.waitForClickability(productsLink).click();
    }

    public void isAllProductVisibleOnScreen() {
        WebDriver driver = browserKeywords.getDriver();

        List<WebElement> products = driver.findElements(
                By.cssSelector("div.productinfo.text-center"));

        Assert.assertFalse(products.isEmpty(), "No products found");

        for (WebElement product : products) {
            Assert.assertTrue(product.isDisplayed(), "A product is not displayed");
        }

        System.out.println("All products displayed. Count: " + products.size());
    }

    public void clickOnFirstProduct() {
        wait.waitForClickability(firstProduct).click();
        AdHandler.closeAdIfPresent(browserKeywords.getDriver());

        new WebDriverWait(browserKeywords.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("a[href=\"/product_details/1\"]"));
    }
}
