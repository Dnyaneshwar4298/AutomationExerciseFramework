package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import keywords.browserKeywords;
import keywords.waitFor;
import utility.AdHandler;
import utility.ConfigReader;

public class AccountInformationPage {

    private final waitFor wait;

    @FindBy(css = "input[data-qa='password']")
    private WebElement password;

    @FindBy(id = "id_gender1")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;

    @FindBy(css = "input[data-qa='first_name']")
    private WebElement firstName;

    @FindBy(css = "input[data-qa='last_name']")
    private WebElement lastName;

    @FindBy(css = "input[data-qa='address']")
    private WebElement address;

    @FindBy(css = "input[data-qa='state']")
    private WebElement state;

    @FindBy(css = "input[data-qa='city']")
    private WebElement city;

    @FindBy(css = "input[data-qa='zipcode']")
    private WebElement zipCode;

    @FindBy(css = "input[data-qa='mobile_number']")
    private WebElement mobileNumber;

    @FindBy(css = "select[data-qa='country']")
    private WebElement country;

    @FindBy(css = "select[data-qa='days']")
    private WebElement dayDropdown;

    @FindBy(css = "select[data-qa='months']")
    private WebElement monthDropdown;

    @FindBy(css = "select[data-qa='years']")
    private WebElement yearDropdown;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreated;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    public AccountInformationPage() {
        PageFactory.initElements(browserKeywords.getDriver(), this);
        wait = new waitFor(browserKeywords.getDriver());
    }

    private void enterText(WebElement element, String value) {
        wait.waitForVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    private void selectVisibleText(WebElement element, String text) {
        wait.waitForVisibility(element);
        new Select(element).selectByVisibleText(text);
    }

    private void selectValue(WebElement element, String value) {
        wait.waitForVisibility(element);
        new Select(element).selectByValue(value);
    }

    private void selectIndex(WebElement element, int index) {
        wait.waitForVisibility(element);
        new Select(element).selectByIndex(index);
    }

    public void selectMrTitle() {
        wait.waitForClickability(titleMr).click();
    }

    public void selectMrsTitle() {
        wait.waitForClickability(titleMrs).click();
    }

    public void enterPassword(String value) {
        enterText(password, value);
    }

    public void enterFirstName(String value) {
        enterText(firstName, value);
    }

    public void enterLastName(String value) {
        enterText(lastName, value);
    }

    public void enterAddress(String value) {
        enterText(address, value);
    }

    public void enterState(String value) {
        enterText(state, value);
    }

    public void enterCity(String value) {
        enterText(city, value);
    }

    public void enterZipCode(String value) {
        enterText(zipCode, value);
    }

    public void enterMobileNumber(String value) {
        enterText(mobileNumber, value);
    }

    public void selectCountry(String value) {
        selectVisibleText(country, value);
    }

    public void selectDay(int index) {
        selectIndex(dayDropdown, index);
    }

    public void selectMonth(String value) {
        selectVisibleText(monthDropdown, value);
    }

    public void selectYear(String value) {
        selectValue(yearDropdown, value);
    }

    public void clickCreateAccount() {
        wait.waitForClickability(createAccountButton).click();
    }

    public void verifyAccountCreated() {
        Assert.assertTrue(
                wait.waitForVisibility(accountCreated).isDisplayed(),
                "Account Created message is not displayed");
    }

    public void clickContinue() {
        // Close any ad overlay before clicking Continue.
        AdHandler.closeAdIfPresent(browserKeywords.getDriver());
        wait.waitForClickability(continueButton).click();
        AdHandler.closeAdIfPresent(browserKeywords.getDriver());
    }

    public void logout() {
        wait.waitForClickability(logoutButton).click();
    }

    /**
     * Completes the account information form.
     * No Thread.sleep() is used; Selenium explicit waits handle synchronization.
     */
    public void completeAccountInformation() {
        String passwordValue = ConfigReader.getProperty("password");

        selectMrTitle();
        enterPassword(passwordValue);
        selectDay(29);
        selectMonth("April");
        selectYear("1998");
        enterFirstName("Danny");
        enterLastName("Patil");
        enterAddress("Pune Hinjewadi");
        selectCountry("Canada");
        enterState("Maharashtra");
        enterCity("Pune");
        enterZipCode("411057");
        enterMobileNumber("9876543210");

        clickCreateAccount();
        verifyAccountCreated();
        clickContinue();
    }
}
