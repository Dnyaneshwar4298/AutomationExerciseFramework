package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import keywords.browserKeywords;

public class homePage {

	@FindBy(xpath = "//a[@href=\"/login\"]")
	private WebElement singupLoginButton;

	@FindBy(xpath = "//a[@href='/contact_us']")
	private WebElement contactus;

	@FindBy(css = "input[data-qa=\"name\"]")
	private WebElement name;

	@FindBy(css = "input[data-qa=\"email\"]")
	private WebElement emailid;

	@FindBy(css = "input[data-qa=\"subject\"]")
	private WebElement subject;

	@FindBy(css = "textarea[data-qa=\"message\"]")
	private WebElement massage;

	@FindBy(css = "input[name=\"upload_file\"]")
	private WebElement uploadFile;

	@FindBy(css = "input[data-qa=\"submit-button\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class=\"status alert alert-success\"]")
	private WebElement responseMsg;

	public homePage() {

		PageFactory.initElements(browserKeywords.getDriver(), this);
	}

	public void clickSignUpLogin() {
		singupLoginButton.click();
	}

	public void clickContactUs() {
		contactus.click();
		System.err.println("contact form is opened ");
	}

	public void fillContactUsForm(String nme, String email, String subj, String msg) {
		contactus.click();
		System.err.println("contact form is opened ");
		name.sendKeys(nme);
		emailid.sendKeys(email);
		subject.sendKeys(subj);
		massage.sendKeys(msg);
		pages.signupPage.scrollWindow();
		uploadFile.sendKeys("/Users/danny/Library/Mobile Documents/com~apple~CloudDocs/Updated Resume /Automation");
		System.err.println("File Uploaded");
		submitBtn.click();
		System.out.println("Form submitted");
		signupPage.alertHandling();
	}



}
