
package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;

public class ProductSteps {

    productPage productPage;


    // =========================================================
    // EXISTING PRODUCT SCENARIOS
    // =========================================================

    @When("I navigate to the Products page")
    public void iNavigateToProductsPage() {

        productPage = new productPage();

        productPage.clickOnProduct();
    }


    @Then("I should see all products displayed")
    public void iShouldSeeAllProductsDisplayed() {

        productPage.isAllProductVisibleOnScreen();
    }


    @When("I click on the first product")
    public void iClickOnFirstProduct() {

        productPage.clickOnFirstProduct();
    }


    @And("I close the advertisement on the product page")
    public void iCloseTheAdvertisementOnProductPage() {

        productPage.closeadOnProductPage();
    }


    @Then("the product details page should be displayed")
    public void productDetailsPageShouldBeDisplayed() {

        String url = keywords.browserKeywords.getCurrentUrl();

        Assert.assertTrue(
                url.contains("product_details/1"),
                "Product details page was not displayed"
        );
    }


    // =========================================================
    // SEARCH PRODUCT
    // =========================================================

    @When("I search for {string}")
    public void iSearchFor(String productName) {

        productPage.searchProduct(productName);
    }


    @Then("I should see products matching {string}")
    public void iShouldSeeProductsMatching(String productName) {

        productPage.verifyProductSearchResult(productName);
    }


    // =========================================================
    // ADD PRODUCT TO CART
    // =========================================================

    @When("I add {string} to the cart")
    public void iAddProductToTheCart(String productName) {

        productPage.addProductToCart(productName);
    }


    @Then("the product {string} should be displayed in the cart")
    public void theProductShouldBeDisplayedInTheCart(String productName) {

        productPage.openCart();

        productPage.verifyProductInCart(productName);
    }


    // =========================================================
    // ADD MULTIPLE PRODUCTS TO CART
    // =========================================================

    @When("I add multiple products to the cart")
    public void iAddMultipleProductsToTheCart() {

        productPage.addMultipleProductsToCart();
    }


    @Then("all selected products should be displayed in the cart")
    public void allSelectedProductsShouldBeDisplayedInTheCart() {

        productPage.openCart();

        int productCount =
                keywords.browserKeywords.getDriver()
                        .findElements(
                                org.openqa.selenium.By.cssSelector(
                                        "tr[id^='product-']"
                                )
                        )
                        .size();

        Assert.assertTrue(
                productCount >= 2,
                "Multiple products were not added to cart"
        );
    }


    // =========================================================
    // REMOVE PRODUCT FROM CART
    // =========================================================

    @Given("I have a product {string} in the cart")
    public void iHaveAProductInTheCart(String productName) {

        productPage.addProductToCart(productName);

        productPage.openCart();
    }


    @When("I remove the product")
    public void iRemoveTheProduct() {

        productPage.removeProductFromCart();
    }


    @Then("the product should no longer be displayed in the cart")
    public void theProductShouldNoLongerBeDisplayedInTheCart() {

        productPage.verifyCartIsEmpty();
    }


    // =========================================================
    // CART PRICE AND TOTAL
    // =========================================================

    @Given("I have products in the cart")
    public void iHaveProductsInTheCart() {

        productPage.addMultipleProductsToCart();

        productPage.openCart();
    }


    @When("I open the cart")
    public void iOpenTheCart() {

        productPage.openCart();
    }


    @Then("the product prices should be displayed correctly")
    public void theProductPricesShouldBeDisplayedCorrectly() {

        productPage.verifyCartProductPrices();
    }


    @Then("the total price should be calculated correctly")
    public void theTotalPriceShouldBeCalculatedCorrectly() {

        productPage.verifyCartPriceAndTotal();
    }


    // =========================================================
    // PRODUCT DETAILS
    // =========================================================

    @When("I open a product")
    public void iOpenAProduct() {

        productPage.clickOnFirstProduct();
    }


    @Then("I should see all product details")
    public void iShouldSeeAllProductDetails() {

        productPage.verifyProductDetails();
    }
}

