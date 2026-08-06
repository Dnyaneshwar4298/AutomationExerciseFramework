package test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;

import pages.AccountInformationPage;
import pages.homePage;
import pages.signupPage;

public class sinupTest {

    private BaseClass base = new BaseClass();

    private homePage homePage;
    private signupPage signupPage;
    private AccountInformationPage accountInformationPage;
   
    String email = "user" + System.currentTimeMillis() + "@gmail.com";

    
    @BeforeClass
    public void setup(){

        base.openBrowser();

        homePage = new homePage();
        signupPage = new signupPage();
        accountInformationPage = new AccountInformationPage();
        homePage.clickSignUpLogin();
        System.out.println("Clicked on Signup/Login button");
    }


    @Test(priority = 1)
    public  void verifyRegisterNewUser() {
		pages.signupPage.enterSignupCredentials();
	}
    

    @Test (priority = 2)
    public void verifyAccountInformation() throws InterruptedException{
    	
    	accountInformationPage.enterPassword("Danny1234");
    	System.err.println("password entered");
    	accountInformationPage.selectDay(29);
        accountInformationPage.selectMonth("April");
        accountInformationPage.selectYear("1998");
        System.err.println("DOB entered");
        accountInformationPage.enterFirstName("Danny");
        System.err.println("frirstname entered");
        accountInformationPage.enterLastName("Patil");
        System.err.println("lastname entered");
        accountInformationPage.enterAddress("Pune Hinjewadi");
        System.err.println("address entered");
        accountInformationPage.selectCountry("Canada");
        System.err.println("selected country");
        accountInformationPage.enterState("Maharashtra");
        System.err.println("state entered");
        accountInformationPage.enterCity("Pune");
        System.err.println("city entered");
        accountInformationPage.enterZipCode("411057");
        System.err.println("zipcode entered");
        accountInformationPage.enterMobileNumber("9876543210");
        System.err.println("mobilenumber entered");
        signupPage.scrollWindow();
        accountInformationPage.clickCreateAccount();
        
        Thread.sleep(2000);
        accountInformationPage.clickContinue();
        
        String actualresult = "Account Created!";

        Assert.assertEquals(actualresult, "Account Created!");

        System.out.println("Account Created Successfully");
        base.closeBrowser();
    }
    
}