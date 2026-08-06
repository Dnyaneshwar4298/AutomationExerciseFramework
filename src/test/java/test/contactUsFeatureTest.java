package test;



import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import keywords.browserKeywords;
import pages.homePage;
import pages.signupPage;


public class contactUsFeatureTest {
	private BaseClass base = new BaseClass();
	private homePage homePage;
	
	
	@Test
	public void fillContactUsForm() {
		
		base.openBrowser();
		homePage = new homePage();
		homePage.fillContactUsForm("Danny", signupPage.email, "Call me back", "having issue with the login detials");
		
		String actualResponse = browserKeywords.getDriver()
		        .findElement(By.xpath("//div[@class='status alert alert-success']"))
		        .getText()
		        .trim();

		Assert.assertEquals(actualResponse,
		        "Success! Your details have been submitted successfully.");
		
		System.err.println("Assertion Passed");
		base.closeBrowser();
	}
	
}
