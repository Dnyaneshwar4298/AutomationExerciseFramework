package test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.homePage;
import pages.loginPage;
import pages.signupPage;

public class loginTest extends loginPage{
	private BaseClass base = new BaseClass();
	private homePage homePage;
	private signupPage signupPage;
	private loginPage loginPage;

	@BeforeClass
	public void setup() {
		base.openBrowser();
		homePage = new homePage();
		signupPage = new signupPage();
		homePage.clickSignUpLogin();
		System.out.println("Clicked on Signup/Login button");
	}
	
	
	@Test
	public void varifyValidLogin() {
		signupPage = new signupPage();
		loginPage = new loginPage();
		pages.loginPage.validLogin(pages.signupPage.email, "Danny1234");
		//pages.signupPage.scrollWindow();
		pages.loginPage.ClickonLoginBtn();
		System.out.println("Login successfull");
		base.closeBrowser();
	}
	
	
}
