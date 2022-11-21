package pomPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.hms.hr.pompages.Add_Corp_Page;
import com.hms.hr.pompages.Corporate_pom_page;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

public class AddNewCorporatePomTest {

	public static void main(String[] args) throws Throwable {
		File_Utility file = new File_Utility();
		Excel_Utility excel = new Excel_Utility();
		WebDriver_Utility web = new WebDriver_Utility();

		String B=file.CommonDataFromProperty("browser");
		String U=file.CommonDataFromProperty("url");
		String UN=file.CommonDataFromProperty("unhead");
		String PWD=file.CommonDataFromProperty("pwdhead");
		
		

		WebDriver driver=null;
		if(B.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(B.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		web.maximizeWindow(driver);
		driver.get(U);
		web.waitForPageLoad(driver);
		
		
		String type=excel.readDataFromExcelFile("DropDown", 1, 0);
		String name=excel.readDataFromExcelFile("Corporate", 5, 2);
		loginPageTest lp = new loginPageTest(driver);
		lp.login(UN, PWD, type);
		
		

		
		web.swithToAlertWindowAndAccpect(driver);
		
		Hr_Head_HomePage hrhead=new Hr_Head_HomePage(driver);
		hrhead.addCorporate();
		
		Corporate_pom_page corp=new Corporate_pom_page(driver);
		corp.newAddDeptName();
		
		Add_Corp_Page nam=new Add_Corp_Page(driver);
		nam.corpname(name);
		web.swithToAlertWindowAndAccpect(driver);
	
		
		/*driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();

		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();

		web.swithToAlertWindowAndAccpect(driver);

		driver.quit();*/










	}

}
