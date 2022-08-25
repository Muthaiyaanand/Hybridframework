package onlinestore.testcase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import onlinestore.base.TestBase;
import onlinestore.pages.LandingPage;
import onlinestore.pages.RegisterationPage;
import onlinestore.utilities.TestUtils;
import onlinestore.pages.RegisterationFormPage;

public class RegisterationPageTest extends TestBase {

	LandingPage LandingPage;
	RegisterationPage RegisterationPage;
	RegisterationFormPage RegisterationFormPage;
	TestUtils TestUtils;

	public RegisterationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		launchBrowser();
		launchUrl();
		LandingPage = new LandingPage();
		//RegisterationPage = new RegisterationPage();
		RegisterationPage = LandingPage.clickSignIn();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_wait, TimeUnit.SECONDS);
		

	}

	@Test(priority=1)
	public void getRegisterationPageTitle() {
		String Title = RegisterationPage.getRegisterationPageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Login - My Store", "Registeration page title test failed");
		System.out.println("Pass1");
	}

	@Test(priority=1)
	public void enterRegEmailPassword() throws InterruptedException {
		RegisterationPage.enterRegEmail(prop.getProperty("email"));
		TestUtils = new TestUtils();
		TestUtils.waitTime();
		TestUtils.scrollDown();
		//RegisterationFormPage = new RegisterationFormPage();
		RegisterationFormPage = RegisterationPage.clickCreateAccount();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_wait, TimeUnit.SECONDS);
		System.out.println("Pass2");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
