package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import keywords.browserKeywords;

public class AccountInformationPage {

    public AccountInformationPage() {
        PageFactory.initElements(keywords.browserKeywords.getDriver(), this);
    }

    // Account Information

    @FindBy(css = "[data-qa='password']") // encapsulation
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
    
    @FindBy(css ="a[href=\"/logout\"]")
    private WebElement logout;

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
    
    public void ClickOnlogoutBtn() {
		logout.click();
		System.out.println("clicked on LogoutButton");

	}

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
    
    public  void verifyAccountInformation() throws InterruptedException {
    	enterPassword("Danny1234");
    	
    	System.err.println("password entered");
    	selectDay(29);
       selectMonth("April");
        selectYear("1998");
        System.err.println("DOB entered");
     enterFirstName("Danny");
        System.err.println("frirstname entered");
       enterLastName("Patil");
        System.err.println("lastname entered");
        enterAddress("Pune Hinjewadi");
        System.err.println("address entered");
       selectCountry("Canada");
        System.err.println("selected country");
        enterState("Maharashtra");
        System.err.println("state entered");
        enterCity("Pune");
        System.err.println("city entered");
        enterZipCode("411057");
        System.err.println("zipcode entered");
        enterMobileNumber("9876543210");
        System.err.println("mobilenumber entered");
        signupPage.scrollWindow();
        clickCreateAccount();
        System.err.println("Clicked on Create button");
        Thread.sleep(2000);
        signupPage.scrollWindow();
       clickContinue();
      signupPage.closeAdPopup();
       String actualresult = "Account Created!";

       Assert.assertEquals(actualresult, "Account Created!");

       System.out.println("Account Created Successfully");
       //base.closeBrowser();
       System.out.println(browserKeywords.getDriver().getCurrentUrl());

	}
}