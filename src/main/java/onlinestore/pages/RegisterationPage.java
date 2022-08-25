package onlinestore.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onlinestore.base.TestBase;

public class RegisterationPage extends TestBase {
	
	SignInHomePage SignInHomePage;
	RegisterationFormPage RegisterationFormPage;
	
	@FindBy(id="email")
	WebElement enteremailaddress;
	
	@FindBy(id="email_create")
	WebElement enterregemailaddress;
	
	@FindBy(id="passwd")
	WebElement enterpassword;
	
	@FindBy(id="SubmitCreate")
	WebElement clickcreateaccount;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	WebElement clicksignin;
	
	public RegisterationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getRegisterationpagetitle() {
		String Title = driver.getTitle();
		return Title;
		
	}
	
	public String getRegisterationPageTitle() {
		String Title = driver.getTitle();
		return Title;
	}

	
	public void enterRegEmail(String email) {
		enterregemailaddress.sendKeys(email);
		enterregemailaddress.sendKeys(Keys.TAB);
	}
	
	public void enterEmailAddress(String email) {
		enteremailaddress.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		enterpassword.sendKeys(password);
	}
	
	public RegisterationFormPage clickCreateAccount() {
		clickcreateaccount.click();
		return new RegisterationFormPage();
	}

	public SignInHomePage clickSignin() {
		clicksignin.click();
		return new SignInHomePage();
	}
}
