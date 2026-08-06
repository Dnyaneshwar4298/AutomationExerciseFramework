package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	
	public loginPage() {
		PageFactory.initElements(keywords.browserKeywords.getDriver() ,this);
	}
	
	
	
	@FindBy(css ="input[data-qa=\"login-email\"]")
	private static WebElement emailAddress;
	
	@FindBy(css = "input[data-qa=\"login-password\"]")
	private static WebElement password;
	
	@FindBy(css = "button[data-qa=\"login-button\"]")
	private static WebElement ClickonLoginBtn;
	
	
	
    //===================== Generic Methods =====================

    private static void enterText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    
    //===================== project Methods =====================
    
	  private static void enterEmail(String email) {
		enterText(emailAddress, email);
	
		System.err.println("Entered email id ");

	}
	
	 public void enterPassword(String pwd) {
	        enterText(password, pwd);
	        System.err.println("password entered");
	    }
	 
	public static void ClickonLoginBtn() {
		ClickonLoginBtn.click();
		System.err.println("clicked login button");

	}
	
	
	public static void validLogin(String email , String pwd) {	
		enterText(emailAddress, email);
		System.err.println("Entered email id ");
		enterText(password, pwd);
        System.err.println("password entered");
        
	}
	


}
