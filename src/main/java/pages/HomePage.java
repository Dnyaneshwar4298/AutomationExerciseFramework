package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;
import keywords.waitFor;
import utility.AdHandler;

public class HomePage {

    private final waitFor wait;

    // =========================================================
    // Existing Locators
    // =========================================================

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


    // =========================================================
    // Home Page Locators
    // =========================================================

    @FindBy(css = "a[href='/']")
    private WebElement homeMenu;

    @FindBy(css = "a[href='/products']")
    private WebElement productsMenu;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartMenu;

    @FindBy(css = "div.logo.pull-left img")
    private WebElement automationExerciseLogo;

    @FindBy(css = "div.shop-menu.pull-right")
    private WebElement navigationMenu;

    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    private WebElement subscriptionSection;

    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(css = "div.features_items")
    private WebElement productsPage;

    @FindBy(css = "section#cart_items")
    private WebElement cartPage;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    private WebElement loginPage;


    // =========================================================
    // Constructor
    // =========================================================

    public HomePage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }


    // =========================================================
    // Existing Methods
    // =========================================================

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
            // Browser alert is optional.
        }
    }


    public String getResponseMessage() {

        return wait.waitForVisibility(responseMessage)
                .getText()
                .trim();
    }


    public boolean isLoggedIn() {

        try {
            return wait.waitForVisibility(loggedInUser).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // =========================================================
    // Home Page Methods
    // =========================================================

    public boolean isHomePageDisplayed() {

        try {
            return wait.waitForVisibility(homeMenu).isDisplayed()
                    && browserKeywords.getDriver()
                    .getCurrentUrl()
                    .contains("automationexercise.com");
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isAutomationExerciseLogoDisplayed() {

        try {
            return wait.waitForVisibility(automationExerciseLogo)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isNavigationMenuDisplayed() {

        try {
            return wait.waitForVisibility(navigationMenu)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void clickProducts() {

        wait.waitForClickability(productsMenu).click();

        AdHandler.closeAdIfPresent(browserKeywords.getDriver());
    }


    public boolean isProductsPageDisplayed() {

        try {
            return wait.waitForVisibility(productsPage)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void clickCart() {

        wait.waitForClickability(cartMenu).click();

        AdHandler.closeAdIfPresent(browserKeywords.getDriver());
    }


    public boolean isCartPageDisplayed() {

        try {
            return wait.waitForVisibility(cartPage)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isLoginPageDisplayed() {

        try {
            return wait.waitForVisibility(loginPage)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isSubscriptionSectionDisplayed() {

        try {
            return wait.waitForVisibility(subscriptionSection)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isFooterDisplayed() {

        try {
            return wait.waitForVisibility(footer)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}