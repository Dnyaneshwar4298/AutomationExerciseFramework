package pages;

import java.time.Duration;
import java.util.concurrent.StructuredTaskScope.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import keywords.browserKeywords;


public class signupPage extends BaseClass {

	public static WebDriver driver = browserKeywords.getDriver();
	//public static String email = "user" + System.currentTimeMillis() + "@gmail.com";
	


	// New User Signup
	@FindBy(name = "name")
	static WebElement newUserName;

	@FindBy(css = "input[data-qa='signup-email']")
	static WebElement newUserEmail;

	@FindBy(css = "button[data-qa=\"signup-button\"]")
	static WebElement signupButton;

	public signupPage() {

		PageFactory.initElements(browserKeywords.getDriver(), this);
	}


	public static void enterSignupCredentials() {
		newUserName.sendKeys("Danny");
		scrollWindow();
		newUserEmail.click();
		newUserEmail.sendKeys(browserKeywords.email);

		System.err.println("signup mail :"+ browserKeywords.email);
		scrollWindow();
		signupButton.click();

	}


	public static void scrollWindow() {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 300).perform();

	}
	
	public static void alertHandling() {
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.accept();
		
	}
	
	public static  void enterExistingSignUpCredentials(String name , String email) {
		newUserName.sendKeys(name);
		newUserEmail.sendKeys(email);
		scrollWindow();
		signupButton.click();

	}
	
	public static void closeAdPopup() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        WebElement closeButton = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("div[class=\"continue-prompt-text\"]")
	            )
	        );

	        closeButton.click();

	    } catch (TimeoutException e) {
	        System.out.println("Ad popup not displayed.");
	    }
	}

}
