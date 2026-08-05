package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

    public AccountInformationPage() {
        PageFactory.initElements(keywords.browserKeywords.getDriver(), this);
    }

    // Account Information

    @FindBy(css = "[data-qa='password']")
    private WebElement password;

    @FindBy(css = "input[data-qa='title']")
    private WebElement titleMr;

    @FindBy(id = "id_gender2")
    private WebElement titleMrs;


    // Address Information

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
    private WebElement createAccountBtn;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueBtn;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreated;

    //===================== Generic Methods =====================

    private void enterText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    private void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    private void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    private void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    //===================== project Methods =====================

    public void selectMrTitle() {
        titleMr.click();
    }

    public void selectMrsTitle() {
        titleMrs.click();
    }

    public void enterPassword(String pwd) {
        enterText(password, pwd);
    }

    public void enterFirstName(String fname) {
        enterText(firstName, fname);
    }

    public void enterLastName(String lname) {
        enterText(lastName, lname);
    }

    public void enterAddress(String addr) {
        enterText(address, addr);
    }

    public void enterState(String stateName) {
        enterText(state, stateName);
    }

    public void enterCity(String cityName) {
        enterText(city, cityName);
    }

    public void enterZipCode(String zip) {
        enterText(zipCode, zip);
    }

    public void enterMobileNumber(String mobile) {
        enterText(mobileNumber, mobile);
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(country, countryName);
    }

    public void selectDay(int index) {
        selectByIndex(dayDropdown, index);
    }

    public void selectMonth(String month) {
        selectByVisibleText(monthDropdown, month);
    }

    public void selectYear(String year) {
        selectByValue(yearDropdown, year);
    }

    public void clickCreateAccount() {
        createAccountBtn.click();
    }

    public WebElement clickContinue() {
        continueBtn.click();
		return accountCreated;
    }

    public boolean isAccountCreated() {
        return accountCreated.isDisplayed();
    }
}