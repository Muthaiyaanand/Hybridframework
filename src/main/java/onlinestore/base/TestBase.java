package onlinestore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import onlinestore.utilities.TestUtils;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("E://Selenium Workspace//HybridFramework//src//main//java//onlinestore//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void launchBrowser(){
		String browser_name = prop.getProperty("browser");
		System.out.println(browser_name);
		if(browser_name.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "E://Selenium Workspace//HybridFramework//Browser//chromedriver//chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "E://Selenium Workspace//HybridFramework//Browser//firefoxdriver//geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	public void launchUrl() {
		String url = prop.getProperty("url");
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

}
