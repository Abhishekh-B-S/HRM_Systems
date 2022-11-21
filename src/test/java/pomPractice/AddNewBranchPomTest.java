package pomPractice;

import java.io.FileInputStream;
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

import com.hms.hr.pompages.Add_New_BranchPom;
import com.hms.hr.pompages.Branches_pom_page;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

public class AddNewBranchPomTest {
	
	public static void main(String[] args) throws Throwable {


	File_Utility file=new File_Utility();
	Excel_Utility excel=new Excel_Utility();
	WebDriver_Utility web=new WebDriver_Utility();
	
	
		String BROWSER=file.CommonDataFromProperty("browser");
		String URL=file.CommonDataFromProperty("url");
		String UNHEAD=file.CommonDataFromProperty("unhead");
		String PWDHEAD=file.CommonDataFromProperty("pwdhead");



		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		web.maximizeWindow(driver);
		driver.get(URL);
	web.waitForPageLoad(driver);
	String type=excel.readDataFromExcelFile("DropDown", 1, 0);
	String br=excel.readDataFromExcelFile("Branches", 2, 1);
	loginPageTest lp = new loginPageTest(driver);
	lp.login(UNHEAD, PWDHEAD, type);
	
		web.swithToAlertWindowAndAccpect(driver);
		
		

		Hr_Head_HomePage hrhead=new Hr_Head_HomePage(driver);
		hrhead.addBranches(driver);
		
		Branches_pom_page br1=new Branches_pom_page(driver);
		br1.addBranch(driver);
		
		
		Add_New_BranchPom br2=new Add_New_BranchPom(driver);
		br2.newBranch(br);
		
		web.swithToAlertWindowAndAccpect(driver);
	}

}
