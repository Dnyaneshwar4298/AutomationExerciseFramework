package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseClass;
import pages.homePage;
import pages.loginPage;
import utility.ConfigReader;
import utility.TestData;

public class loginTest extends baseClass {

    @Test(dependsOnGroups = "registration")
    public void verifyValidLogin() {
        homePage homePage = new homePage();
        loginPage loginPage = new loginPage();

        homePage.clickSignUpLogin();

        String email = TestData.getEmail();
        String password = ConfigReader.getProperty("password");

        loginPage.validLogin(email, password);

        Assert.assertTrue(homePage.isLoggedIn(),
                "Login was not successful");
    }
}
