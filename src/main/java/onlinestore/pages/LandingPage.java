package onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import onlinestore.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath ="//a[@class='login']")
	WebElement signin;

	@FindBy(xpath="//*[@class='shop-phone']/strong")
	WebElement calluson;

	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactus;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLandingPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public String getcallUsOnNo() {
		String callusonnumber = calluson.getText();
		return callusonnumber;
	}
	
	public RegisterationPage clickSignIn() {
		signin.click();
		return new RegisterationPage();
	}
	
	public ContactUsPage clickContactUs() {
		contactus.click();
		return new ContactUsPage();
	}


}
