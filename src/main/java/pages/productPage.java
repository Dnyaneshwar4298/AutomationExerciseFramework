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

    // Products page
    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    // First product
    @FindBy(css = "a[href='/product_details/1']")
    private WebElement firstProduct;

    // Existing advertisement close button
    @FindBy(css = "class=\"continue-prompt-text\"")
    private WebElement closeadOnProductPage;


    // Search product
    @FindBy(id = "search_product")
    private WebElement searchProduct;

    @FindBy(id = "submit_search")
    private WebElement searchButton;


    // Cart
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;


    public productPage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }


    // Existing method - KEEP THIS
    public void closeadOnProductPage() {
        closeadOnProductPage.click();
    }


    // Navigate to Products page
    public void clickOnProduct() {

        wait.waitForClickability(productsLink).click();

        new WebDriverWait(
                browserKeywords.getDriver(),
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.urlContains("/products")
        );
    }


    public void isAllProductVisibleOnScreen() {

        WebDriver driver = browserKeywords.getDriver();

        List<WebElement> products = driver.findElements(
                By.cssSelector("div.productinfo.text-center"));

        Assert.assertFalse(
                products.isEmpty(),
                "No products found"
        );

        for (WebElement product : products) {

            Assert.assertTrue(
                    product.isDisplayed(),
                    "A product is not displayed"
            );
        }

        System.out.println(
                "All products displayed. Count: "
                + products.size()
        );
    }


   
    public void clickOnFirstProduct() {

        wait.waitForClickability(firstProduct).click();

        AdHandler.closeAdIfPresent(
                browserKeywords.getDriver()
        );

        new WebDriverWait(
                browserKeywords.getDriver(),
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.urlContains(
                        "product_details/1"
                )
        );
    }


    // =====================================================
    // SEARCH PRODUCT
    // =====================================================

    public void searchProduct(String productName) {

        wait.waitForVisibility(searchProduct).clear();

        searchProduct.sendKeys(productName);

        wait.waitForClickability(searchButton).click();
    }


    public void verifyProductSearchResult(String productName) {

        List<WebElement> products =
                browserKeywords.getDriver().findElements(
                        By.cssSelector(
                                "div.productinfo.text-center"
                        )
                );

        Assert.assertFalse(
                products.isEmpty(),
                "No products found for: " + productName
        );

        boolean productFound = false;

        for (WebElement product : products) {

            if (product.getText()
                    .toLowerCase()
                    .contains(productName.toLowerCase())) {

                productFound = true;
                break;
            }
        }

        Assert.assertTrue(
                productFound,
                "Product was not found: " + productName
        );
    }


    // =====================================================
    // ADD PRODUCT TO CART
    // =====================================================

    public  void addProductToCart(String productName) {

        WebElement addToCartButton =
                browserKeywords.getDriver().findElement(
                        By.xpath(
                                "//div[contains(@class,'single-products')]"
                                + "//p[normalize-space()='"
                                + productName
                                + "']/ancestor::div"
                                + "[contains(@class,'single-products')]"
                                + "//a[contains(@class,'add-to-cart')]"
                        )
                );

        wait.waitForClickability(addToCartButton).click();

        closeContinueShopping();
    }


    // =====================================================
    // ADD MULTIPLE PRODUCTS
    // =====================================================

    public void addMultipleProductsToCart() {

        List<WebElement> buttons =
                browserKeywords.getDriver().findElements(
                        By.cssSelector("a.add-to-cart")
                );

        Assert.assertTrue(
                buttons.size() >= 2,
                "Less than two products available"
        );

        buttons.get(0).click();

        closeContinueShopping();

        buttons.get(1).click();

        closeContinueShopping();
    }


    // =====================================================
    // OPEN CART
    // =====================================================

    public void openCart() {

        wait.waitForClickability(cartLink).click();

        new WebDriverWait(
                browserKeywords.getDriver(),
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.urlContains("/view_cart")
        );
    }


    // =====================================================
    // VERIFY PRODUCT IN CART
    // =====================================================

    public void verifyProductInCart(String productName) {

        WebElement product =
                browserKeywords.getDriver().findElement(
                        By.xpath(
                                "//td[contains(@class,'cart_description')]"
                                + "//a[normalize-space()='"
                                + productName
                                + "']"
                        )
                );

        Assert.assertTrue(
                product.isDisplayed(),
                productName + " is not displayed in cart"
        );
    }


    // =====================================================
    // REMOVE PRODUCT
    // =====================================================

    public void removeProductFromCart() {

        List<WebElement> deleteButtons =
                browserKeywords.getDriver().findElements(
                        By.cssSelector("a.cart_quantity_delete")
                );

        Assert.assertFalse(
                deleteButtons.isEmpty(),
                "No product available in cart"
        );

        deleteButtons.get(0).click();

        new WebDriverWait(
                browserKeywords.getDriver(),
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.stalenessOf(
                        deleteButtons.get(0)
                )
        );
    }


    // =====================================================
    // VERIFY CART EMPTY
    // =====================================================

    public void verifyCartIsEmpty() {

        List<WebElement> products =
                browserKeywords.getDriver().findElements(
                        By.cssSelector("tr[id^='product-']")
                );

        Assert.assertTrue(
                products.isEmpty(),
                "Product is still available in cart"
        );
    }


    // =====================================================
    // VERIFY CART PRICE
    // =====================================================

    public void verifyCartPriceAndTotal() {

        List<WebElement> prices =
                browserKeywords.getDriver().findElements(
                        By.cssSelector("td.cart_price p")
                );

        Assert.assertFalse(
                prices.isEmpty(),
                "Product price is not displayed"
        );

        List<WebElement> totals =
                browserKeywords.getDriver().findElements(
                        By.cssSelector(
                                "td.cart_total p.cart_total_price"
                        )
                );

        Assert.assertFalse(
                totals.isEmpty(),
                "Cart total is not displayed"
        );

        for (WebElement price : prices) {

            Assert.assertFalse(
                    price.getText().trim().isEmpty(),
                    "Product price is empty"
            );
        }

        Assert.assertFalse(
                totals.get(0).getText().trim().isEmpty(),
                "Cart total is empty"
        );
    }


    // =====================================================
    // PRODUCT DETAILS
    // =====================================================

    public void verifyProductDetails() {

        WebDriver driver =
                browserKeywords.getDriver();

        WebElement productName =
                driver.findElement(
                        By.cssSelector(
                                ".product-information h2"
                        )
                );

        WebElement category =
                driver.findElement(
                        By.xpath(
                                "//div[contains(@class,'product-information')]"
                                + "//p[contains(.,'Category:')]"
                        )
                );

        WebElement price =
                driver.findElement(
                        By.cssSelector(
                                ".product-information span span"
                        )
                );

        WebElement availability =
                driver.findElement(
                        By.xpath(
                                "//div[contains(@class,'product-information')]"
                                + "//b[contains(.,'Availability:')]"
                        )
                );

        Assert.assertTrue(
                productName.isDisplayed(),
                "Product name is not displayed"
        );

        Assert.assertTrue(
                category.isDisplayed(),
                "Product category is not displayed"
        );

        Assert.assertTrue(
                price.isDisplayed(),
                "Product price is not displayed"
        );

        Assert.assertTrue(
                availability.isDisplayed(),
                "Product availability is not displayed"
        );
    }


    // =====================================================
    // CONTINUE SHOPPING POPUP
    // =====================================================

    private void closeContinueShopping() {

        try {

            WebElement continueShopping =
                    new WebDriverWait(
                            browserKeywords.getDriver(),
                            Duration.ofSeconds(5)
                    ).until(
                            ExpectedConditions.elementToBeClickable(
                                    By.xpath(
                                            "//button[contains(.,'Continue Shopping')]"
                                    )
                            )
                    );

            continueShopping.click();

        } catch (Exception e) {

            System.out.println(
                    "Continue Shopping popup not displayed"
            );
        }
    }


	public void verifyCartProductPrices() {
		// TODO Auto-generated method stub
		
	}


}