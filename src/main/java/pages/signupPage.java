package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;
import keywords.browserKeywords;

public class signupPage extends baseClass {

	public static WebDriver driver = browserKeywords.getDriver();

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

	public static void registerNewUser(String name, String email) {
		newUserName.sendKeys(name);
		newUserEmail.sendKeys(email);
		scrollWindow();
		signupButton.click();

	}

	public static void scrollWindow() {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 300).perform();
		

	}


}
