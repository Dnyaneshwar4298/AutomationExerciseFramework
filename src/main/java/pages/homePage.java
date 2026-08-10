package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;
import keywords.waitFor;
import utility.AdHandler;

public class homePage {

    private final waitFor wait;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUs;

    @FindBy(css = "input[data-qa='name']")
    private WebElement name;

    @FindBy(css = "input[data-qa='email']")
    private WebElement email;

    @FindBy(css = "input[data-qa='subject']")
    private WebElement subject;

    @FindBy(css = "textarea[data-qa='message']")
    private WebElement message;

    @FindBy(css = "input[name='upload_file']")
    private WebElement uploadFile;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(css = "div.status.alert.alert-success")
    private WebElement responseMessage;

    @FindBy(xpath = "//a[contains(.,'Logged in as')]")
    private WebElement loggedInUser;

    public homePage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }

    public void clickSignUpLogin() {
        wait.waitForClickability(signupLoginButton).click();
        AdHandler.closeAdIfPresent(browserKeywords.getDriver());
    }

    public void clickContactUs() {
        wait.waitForClickability(contactUs).click();
    }

    public void fillContactUsForm(String userName, String userEmail,
                                  String userSubject, String userMessage,
                                  String filePath) {

        clickContactUs();

        wait.waitForVisibility(name).sendKeys(userName);
        email.sendKeys(userEmail);
        subject.sendKeys(userSubject);
        message.sendKeys(userMessage);

        if (filePath != null && !filePath.isBlank()) {
            uploadFile.sendKeys(filePath);
        }

        submitButton.click();

        try {
            browserKeywords.getDriver().switchTo().alert().accept();
        } catch (Exception ignored) {
           
        }
    }

    public String getResponseMessage() {
        return wait.waitForVisibility(responseMessage).getText().trim();
    }

    public boolean isLoggedIn() {
        try {
            return wait.waitForVisibility(loggedInUser).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
