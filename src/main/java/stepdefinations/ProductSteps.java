package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;

public class ProductSteps {

    productPage productPage;

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
}