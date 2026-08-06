package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import base.baseClass;
import pages.productPage;


public class productTesting {
	
	baseClass base = new baseClass();
	productPage productPage;
	@Test
	public void VarifyAllProductVisibleOnScreen(){
		base.openBrowser();
		productPage = new productPage();
		productPage.clickOnProduct();
		productPage.isAllProductVisibleOnScreen();
		productPage.clickOnFirstProduct();
		//base.closeBrowser();
	}
}
