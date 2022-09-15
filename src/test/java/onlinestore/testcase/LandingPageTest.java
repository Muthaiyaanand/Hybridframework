package onlinestore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import onlinestore.base.TestBase;
import onlinestore.pages.LandingPage;
import onlinestore.pages.RegisterationPage;

public class LandingPageTest extends TestBase {

	LandingPage landingpage;
	RegisterationPage Registerationpage;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		launchUrl();
		landingpage = new LandingPage();
	}

	@Test(priority=1)
	public void titleValidation() {
		String Title = landingpage.getLandingPageTitle();
		System.out.println(Title);
		Assert.assertEquals( Title,"My Store");
	}

//	@Test(priority=2)
//	public void contactnovalidation() {
//		
//		String PhoneNo = landingpage.getcallUsOnNo();
//		System.out.println(PhoneNo);
//		Assert.assertEquals(PhoneNo,"0123-456-789");
//		
//	}
//
//	@Test(priority=3)
//	public void signinpage() {
//		Registerationpage = landingpage.clickSignIn();
//	}
	
	@AfterMethod
	public void tesrDown() {
		driver.quit();
	}

}
