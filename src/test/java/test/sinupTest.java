package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseClass;
import keywords.browserKeywords;
import pages.AccountInformationPage;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;
import utility.ConfigReader;
import utility.TestData;

public class sinupTest extends baseClass {

    @Test(groups = "registration")
    public void registerLogoutAndLoginWithSameEmail() {

        homePage homePage = new homePage();
        signupPage signupPage = new signupPage();
        AccountInformationPage accountPage = new AccountInformationPage();
        loginPage loginPage = new loginPage();

        String email = TestData.getEmail();
        String password = ConfigReader.getProperty("password");

        // 1. Open Signup/Login
        homePage.clickSignUpLogin();

        // 2. Create new user with generated email
        signupPage.enterSignupCredentials("Danny", email);

        // 3. Complete account information
        accountPage.completeAccountInformation();

        Assert.assertTrue(homePage.isLoggedIn(),
                "User should be logged in after account creation");

        // 4. Logout
        accountPage.logout();

        // 5. Login again with THE SAME email and password
        loginPage.validLogin(email, password);

        Assert.assertTrue(homePage.isLoggedIn(),
                "User should be logged in again with the same credentials");

        System.out.println("Login successful with existing email: " + email);
        System.out.println("Current URL: " + browserKeywords.getCurrentUrl());
    }
}
