package onlinestore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import onlinestore.base.TestBase;

public class TestUtils extends TestBase {

	public static long pageload_wait = 20;
	public static long implicit_wait = 20;

	static String Test_Data_Path= "E://Selenium Workspace//HybridFramework//src//main//java//onlinestore//testdata//InputSheet.xlsx";
	static Workbook book;
	static Sheet sheet;


	public void waitTime() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
	}
	
	public void impwait() {

		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait, TimeUnit.SECONDS);
	}

	public static Object[][] getTestData(String Sheetname) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(Test_Data_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet =book.getSheet(Sheetname);

		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println(colcount);

		Object[][] data = new Object[rowcount][colcount];
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}

		return data;
	}
	
	public void screenShot() throws IOException {
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentfolder = System.getProperty("user.dir");
		FileUtils.copyFile(sourcefile, new File (currentfolder + "/Screenshot/" + System.currentTimeMillis() + ".png"));
		
	}
}