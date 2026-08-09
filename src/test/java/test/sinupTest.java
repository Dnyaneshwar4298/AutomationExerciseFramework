package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import keywords.browserKeywords;
import pages.AccountInformationPage;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;


public class sinupTest {

    private BaseClass base = new BaseClass();

    private homePage homePage;
    private signupPage signupPage;
    private AccountInformationPage accountInformationPage;
    
   
  // String email = "user" + System.currentTimeMillis() + "@gmail.com";

    
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
    public  void EnterAccountInfo() throws InterruptedException {
		accountInformationPage.verifyAccountInformation();

	}
    
    @Test (priority =3)
    public void VarifyLogutModule() {
		accountInformationPage.ClickOnlogoutBtn();

	}
    @Test (priority = 4)
    public void varifyLoginWithExistingCredentials() {
    	pages.loginPage.validLogin(browserKeywords.email, "Danny1234");
		pages.signupPage.scrollWindow();
		pages.loginPage.ClickonLoginBtn();
		System.out.println("Login successfull");

	}
    
}