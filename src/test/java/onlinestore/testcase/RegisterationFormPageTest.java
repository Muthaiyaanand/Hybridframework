package onlinestore.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import onlinestore.base.TestBase;
import onlinestore.pages.LandingPage;
import onlinestore.pages.RegisterationFormPage;
import onlinestore.pages.RegisterationPage;
import onlinestore.utilities.TestUtils;

public class RegisterationFormPageTest extends TestBase {
	
	LandingPage LandingPage;
	RegisterationPage RegisterationPage;
	RegisterationFormPage RegisterationFormPage;
	TestUtils TestUtils;
	
	String sheetname = "Sheet1";
	

	public RegisterationFormPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		launchBrowser();
		launchUrl();
		LandingPage = new LandingPage();
		//RegisterationPage = new RegisterationPage();
		RegisterationPage = LandingPage.clickSignIn();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_wait, TimeUnit.SECONDS);
		RegisterationPage.enterRegEmail(prop.getProperty("email"));
		TestUtils = new TestUtils();
		TestUtils.waitTime();
		TestUtils.scrollDown();
		//RegisterationFormPage = new RegisterationFormPage();
		RegisterationFormPage = RegisterationPage.clickCreateAccount();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_wait, TimeUnit.SECONDS);
		

	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtils.getTestData(sheetname);
		return data;
	}
		
	@Test(priority = 1, dataProvider = "getTestData")
	public void fillFormDetails(String titlegiven, String cfirstname, String clastname, String email, String password, String day, String month, String year , String signup, String optin, String addfname, String addlname, String company, String address1, String address2, String city,  String state, String postcode,  String country, String additionalinfo, String phone , String mobilephone, String futureref) throws IOException {
		RegisterationFormPage.clickTitle(titlegiven);
		RegisterationFormPage.enterPersonalDetails(cfirstname, clastname, email, password, signup, optin,addfname, addlname);
		RegisterationFormPage.enterDay(day);
		RegisterationFormPage.enterMonth(month);
		RegisterationFormPage.enterYear(year);
		RegisterationFormPage.enterPersonalDetails2(company, address1, address2, city, postcode, additionalinfo, mobilephone, phone, futureref);
		RegisterationFormPage.enterState(state);
		RegisterationFormPage.enterCountry(country);
		TestUtils.screenShot();
	}
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
