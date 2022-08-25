package onlinestore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import onlinestore.base.TestBase;
import onlinestore.utilities.TestUtils;

public class RegisterationFormPage extends TestBase  {


	TestUtils TestUtils = new TestUtils();

	@FindBy(id="id_gender1")
	WebElement clickMr;

	@FindBy(id="id_gender2")
	@CacheLookup
	//This will help to improve the performance of the script by getting the information from cache instead browser each time. Drawback is it 
	//will give stale exception when the browser is refreshed or DOM properties changed
	WebElement clickMrs;

	@FindBy(id="customer_firstname")
	WebElement enterCustomerFirstName;

	@FindBy(id="customer_lastname")
	WebElement enterCustomerLastName;

	@FindBy(id="email")
	WebElement validateEmail;

	@FindBy(xpath="//input[@name='passwd']")
	WebElement enterPassword;

	@FindBy(name="days")
	WebElement selectDay;

	@FindBy(name="months")
	WebElement selectMonth;

	@FindBy(name="years")
	WebElement selectYear;

	@FindBy(xpath="//input[@id='newsletter']")
	WebElement clickSignupCheckBox;

	@FindBy(xpath="//input[@id='optin']")
	WebElement clickOptInCheckBox;

	@FindBy(id="firstname")
	WebElement enterAddressrFirstName;

	@FindBy(id="lastname")
	WebElement enterAddressLastName;

	@FindBy(id="company")
	WebElement enterCompany;

	@FindBy(id="address1")
	WebElement enterAddress1;

	@FindBy(id="address2")
	WebElement enterAddress2;

	@FindBy(id="city")
	WebElement enterCity;

	@FindBy(xpath="//select[@id='id_state']")
	WebElement selectState;

	@FindBy(id="postcode")
	WebElement enterPostcode;

	@FindBy(xpath="//select[@id='id_country']")
	WebElement selectCountry;

	@FindBy(xpath="//textarea[@id='other']")
	WebElement enterAdditionalInfo;

	@FindBy(id="phone")
	WebElement enterHomePhone;

	@FindBy(id="phone_mobile")
	WebElement enterMobilePhone;

	@FindBy(id="alias")
	WebElement enterFutureReference;

	public RegisterationFormPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickTitle(String titlegiven) {
		if(titlegiven.equals("Mr.")) {
			clickMr.click();
		} else {
			clickMrs.click();
		}
	}

	public void enterPersonalDetails(String cfirstname, String clastname, String email, String password, String signup, String optin, String addfname, String addlname) {
		enterCustomerFirstName.sendKeys(cfirstname);
		enterCustomerLastName.sendKeys(clastname);
		validateEmail.click();
		String Printedemail= validateEmail.getAttribute("value");
		System.out.println(Printedemail);
		if(email.equals("Elakkiyacse19@gmail.com")) {

			System.out.println("The email printed in the email field is matching with given email");
		} else {
			validateEmail.sendKeys(email);
		}

		enterPassword.sendKeys(password);
		if(signup.equals("Yes")) {
			clickSignupCheckBox.click();
		}else {
			System.out.println("Signup not required");
		}

		if(optin.equals("Yes")) {
			clickOptInCheckBox.click();
		}else {
			System.out.println("optin not required");
		}
		
		if(addfname.equals("Elakkiya")) {

			System.out.println("Given AddressFname matches");
		} else {
			enterAddressrFirstName.clear();
			enterAddressrFirstName.sendKeys(addfname);
		}
		
		if(addlname.equals("Muthaiya")) {

			System.out.println("Given AddressFname matches");
		} else {
			enterAddressLastName.clear();
			enterAddressLastName.sendKeys(addlname);
		}

	}
	
	public void enterPersonalDetails2(String company, String address1, String address2, String city, String postcode, String additionalinfo, String mobilephone, String phone, String futureref) {
		enterCompany.sendKeys(company);
		enterAddress1.sendKeys(address1);
		enterAddress2.sendKeys(address2);
		enterCity.sendKeys(city);
		enterPostcode.sendKeys(postcode);
		enterAdditionalInfo.sendKeys(additionalinfo);
		String smobilephone= String.valueOf(mobilephone);
		System.out.println(smobilephone);
		enterMobilePhone.sendKeys(smobilephone);
		enterHomePhone.sendKeys(phone);
		enterFutureReference.clear();
		enterFutureReference.sendKeys(futureref);
	}

	public void enterDay(String day) {
		String[] day1 = day.split("\\.");
		System.out.println(day1[0]);
		System.out.println(day1[1]);

		Select select = new Select(selectDay);
		select.selectByValue(day1[0]);

	}

	public void enterYear(String year) {

		String[] year1 = year.split("\\.");
		System.out.println(year1[0]);
		System.out.println(year1[1]);
		Select select = new Select(selectYear);
		select.selectByValue(year1[0]);

	}

	public void enterMonth(String month) {
		String[] month1 = month.split("\\.");	
		System.out.println(month1[0]);
		System.out.println(month1[1]);
		Select select = new Select(selectMonth);
		select.selectByValue(month1[0]);

	}
	
	public void enterState(String state) {

		Select select = new Select(selectState);
		select.selectByVisibleText(state);

	}
	
	public void enterCountry(String country) {

		Select select = new Select(selectCountry);
		select.selectByVisibleText(country);

	}


}
