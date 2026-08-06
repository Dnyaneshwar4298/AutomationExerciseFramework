package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.productPage;


public class productTesting {
	
	BaseClass base = new BaseClass();
	productPage productPage;
	@Test
	public void VarifyAllProductVisibleOnScreen(){
		base.openBrowser();
		productPage = new productPage();
		productPage.clickOnProduct();
		productPage.isAllProductVisibleOnScreen();
		productPage.clickOnFirstProduct();
		base.closeBrowser();
	}
}
