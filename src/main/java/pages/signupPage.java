package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;
import keywords.waitFor;

public class signupPage {

    private final waitFor wait;

    @FindBy(name = "name")
    private WebElement newUserName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement newUserEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    public signupPage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }

    public void enterSignupCredentials(String name, String email) {
        wait.waitForVisibility(newUserName).sendKeys(name);
        newUserEmail.sendKeys(email);
        browserKeywords.scrollWindow();
        wait.waitForClickability(signupButton).click();
    }

    public void enterExistingSignupCredentials(String name, String email) {
        enterSignupCredentials(name, email);
    }

    public void scrollWindow() {
        new Actions(browserKeywords.getDriver())
                .scrollByAmount(0, 400)
                .perform();
    }
}
