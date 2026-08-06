package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import keywords.waitFor;

public class productPage {
	signupPage signupPage;
	waitFor waitFor;

	public productPage() {
		PageFactory.initElements(keywords.browserKeywords.getDriver(), this);
		waitFor = new waitFor(keywords.browserKeywords.getDriver());
	}

	@FindBy(css = "a[href=\"/products\"]")
	private WebElement product;

	@FindBy(css = "a[href=\"/product_details/1\"]")
	private WebElement clickOnFirstProduct;

	@FindBy(css = "path[stroke=\"#FAFAFA\"]")
	private WebElement removeAds;

	@FindBy(css = "div[class=\"close-button\"]")
	private WebElement removeAds2;

	////
	/// Methods
	///

	public void isAllProductVisibleOnScreen() {
		WebDriver driver = keywords.browserKeywords.getDriver();

		List<WebElement> AllProducts = driver.findElements(By.cssSelector("div[class=\"productinfo text-center\"]"));
		System.err.println("All product list " + AllProducts.size());

		Assert.assertTrue(AllProducts.size() > 0, "No Product found");
		for (WebElement products : AllProducts) {
			Assert.assertTrue(products.isDisplayed(), "Product is not displayed");
		}
		System.err.println("All product displayed");
	}

	public void clickOnFirstProduct() {
		signupPage = new signupPage();

		signupPage.scrollWindow();
		signupPage.scrollWindow();
		clickOnFirstProduct.click();
		System.out.println("clicked on first product");

		WebDriver driver = keywords.browserKeywords.getDriver();

		List<WebElement> ads = driver.findElements(By.cssSelector(".close"));

		if (!ads.isEmpty()) {
		    ads.get(0).click();
		    System.out.println("Ad closed");
		} else {
		    System.out.println("No ad present");
		}
	}

	public void clickOnProduct() {
		product.click();
		System.err.println("clicked on Product button");
	}

}
