package stepdefinations;

import org.testng.Assert;

import base.baseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.browserKeywords;
import pages.AccountInformationPage;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;
import utility.ConfigReader;
import utility.TestData;

public class SignupSteps extends baseClass {

    homePage homePage;
    signupPage signupPage;
    AccountInformationPage accountPage;
    loginPage loginPage;

    String email;
    String password;


    // =========================================================
    // NAVIGATE TO SIGNUP AND LOGIN PAGE
    // =========================================================

    @When("I navigate to the Signup and Login page")
    public void userClicksOnSignupLogin() {

        homePage = new homePage();
        signupPage = new signupPage();
        accountPage = new AccountInformationPage();
        loginPage = new loginPage();

        email = TestData.getEmail();

        password = ConfigReader
                .getProperty("password");

        homePage.clickSignUpLogin();
    }


    // =========================================================
    // EXISTING REGISTRATION SCENARIO
    // =========================================================

    @And("I register a new account with name {string} and a generated email")
    public void userEntersSignupNameAndGeneratedEmail(
            String name) {

        signupPage.enterSignupCredentials(
                name,
                email
        );
    }


    @And("I complete the account information")
    public void userCompletesAccountInformation() {

        accountPage.completeAccountInformation();
    }


    @Then("I should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {

        Assert.assertTrue(
                homePage.isLoggedIn(),
                "User should be logged in after account creation"
        );
    }


    @When("I logout from the account")
    public void userLogsOut() {

        accountPage.logout();
    }


    @And("I login again using the same email and password")
    public void userLogsInUsingSameEmailAndPassword() {

        loginPage.validLogin(
                email,
                password
        );
    }


    @Then("I should be logged in successfully again")
    public void userShouldBeLoggedInSuccessfullyAgain() {

        Assert.assertTrue(
                homePage.isLoggedIn(),
                "User should be logged in successfully with existing credentials"
        );

        System.out.println(
                "Login successful with existing email: "
                        + email
        );
    }


    // =========================================================
    // INVALID LOGIN
    // =========================================================

    @And("I enter an invalid email and password")
    public void iEnterAnInvalidEmailAndPassword() {

        loginPage.enterEmail(
                "invaliduser12345@gmail.com"
        );

        loginPage.enterPassword(
                "InvalidPassword123"
        );
    }


    @And("I click the Login button")
    public void iClickTheLoginButton() {

        loginPage.clickLoginButton();
    }


    @Then("I should see the login error message")
    public void iShouldSeeTheLoginErrorMessage() {

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed(),
                "Login error message was not displayed"
        );

        String actualMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                actualMessage,
                "Your email or password is incorrect!",
                "Incorrect login error message"
        );
    }


    // =========================================================
    // EXISTING EMAIL REGISTRATION
    // =========================================================

    @And("I enter an already registered email")
    public void iEnterAnAlreadyRegisteredEmail() {

        signupPage.enterExistingSignupCredentials(
                "Danny",
                browserKeywords.email
        );
    }


    @Then("I should see the email already exists message")
    public void iShouldSeeTheEmailAlreadyExistsMessage() {

        Assert.assertTrue(
                signupPage.isExistingEmailErrorDisplayed(),
                "Existing email error message was not displayed"
        );

        String actualMessage =
                signupPage.getExistingEmailErrorMessage();

        Assert.assertEquals(
                actualMessage,
                "Email Address already exist!",
                "Incorrect existing email error message"
        );
    }
}