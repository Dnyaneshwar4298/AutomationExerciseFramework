package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps() {
        homePage = new HomePage();
    }

    // =========================================================
    // Home Page
    // =========================================================

    @Then("home page should be displayed successfully")
    public void home_page_should_be_displayed_successfully() {

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page is not displayed successfully"
        );
    }


    // =========================================================
    // Logo
    // =========================================================

    @Then("Automation Exercise logo should be visible")
    public void automation_exercise_logo_should_be_visible() {

        Assert.assertTrue(
                homePage.isAutomationExerciseLogoDisplayed(),
                "Automation Exercise logo is not visible"
        );
    }


    // =========================================================
    // Navigation Menu
    // =========================================================

    @Then("navigation menu should be displayed")
    public void navigation_menu_should_be_displayed() {

        Assert.assertTrue(
                homePage.isNavigationMenuDisplayed(),
                "Navigation menu is not displayed"
        );
    }


    // =========================================================
    // Products
    // =========================================================

    @When("user clicks on Products menu")
    public void user_clicks_on_products_menu() {

        homePage.clickProducts();
    }


    @Then("products page should be displayed")
    public void products_page_should_be_displayed() {

        Assert.assertTrue(
                homePage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );
    }


    // =========================================================
    // Cart
    // =========================================================

    @When("user clicks on Cart menu")
    public void user_clicks_on_cart_menu() {

        homePage.clickCart();
    }


    @Then("cart page should be displayed")
    public void cart_page_should_be_displayed() {

        Assert.assertTrue(
                homePage.isCartPageDisplayed(),
                "Cart page is not displayed"
        );
    }


    // =========================================================
    // Signup / Login
    // =========================================================

    @When("user clicks on Signup Login menu")
    public void user_clicks_on_signup_login_menu() {

        homePage.clickSignUpLogin();
    }


    @Then("login page should be displayed")
    public void login_page_should_be_displayed() {

        Assert.assertTrue(
                homePage.isLoginPageDisplayed(),
                "Login page is not displayed"
        );
    }


    // =========================================================
    // Subscription
    // =========================================================

    @Then("subscription section should be displayed")
    public void subscription_section_should_be_displayed() {

        Assert.assertTrue(
                homePage.isSubscriptionSectionDisplayed(),
                "Subscription section is not displayed"
        );
    }


    // =========================================================
    // Footer
    // =========================================================

    @Then("footer should be displayed")
    public void footer_should_be_displayed() {

        Assert.assertTrue(
                homePage.isFooterDisplayed(),
                "Footer is not displayed"
        );
    }
}