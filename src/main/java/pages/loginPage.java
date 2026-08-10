package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;
import keywords.waitFor;

public class loginPage {

    private final waitFor wait;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement emailAddress;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement password;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "form[action='/login'] p")
    private WebElement loginErrorMessage;


    public loginPage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }


    private void enterText(WebElement element, String value) {

        wait.waitForVisibility(element);

        element.clear();
        element.sendKeys(value);
    }


    public void enterEmail(String email) {

        enterText(emailAddress, email);
    }


    public void enterPassword(String passwordValue) {

        enterText(password, passwordValue);
    }


    public void clickLoginButton() {

        wait.waitForClickability(loginButton).click();
    }


    public void validLogin(String email, String passwordValue) {

        enterEmail(email);
        enterPassword(passwordValue);

        browserKeywords.scrollWindow();

        clickLoginButton();
    }


    // New method for invalid login
    public void invalidLogin(String email, String passwordValue) {

        enterEmail(email);
        enterPassword(passwordValue);

        browserKeywords.scrollWindow();

        clickLoginButton();
    }


    public String getLoginErrorMessage() {

        return wait
                .waitForVisibility(loginErrorMessage)
                .getText()
                .trim();
    }


    public boolean isLoginErrorDisplayed() {

        try {

            return wait
                    .waitForVisibility(loginErrorMessage)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}