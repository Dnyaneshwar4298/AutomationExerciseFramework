package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;

public class homePage {

	@FindBy(xpath = "//a[@href=\"/login\"]")
	private WebElement singupLoginButton;

	public homePage() {

		PageFactory.initElements(browserKeywords.getDriver(), this);
	}

	public void clickSignUpLogin() {
		singupLoginButton.click();
	}
}
