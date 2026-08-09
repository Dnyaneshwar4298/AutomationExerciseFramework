package test;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.baseClass;
import keywords.browserKeywords;
import pages.productPage;
import utility.AdHandler;

public class productTesting extends baseClass {

	
    @Test
    public void verifyAllProductsVisibleAndOpenFirstProduct() {

        productPage productPage = new productPage();
        AdHandler AdHandler = new AdHandler();
        
       
        productPage.clickOnProduct(); 
        utility.AdHandler.closeAdIfPresent(driver);
        productPage.isAllProductVisibleOnScreen();
	
        browserKeywords.scrollWindow();
        productPage.clickOnFirstProduct();
    }
}
