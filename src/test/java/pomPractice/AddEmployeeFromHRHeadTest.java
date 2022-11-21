package pomPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.hr.pompages.AddEmp_Form_PomPage;
import com.hms.hr.pompages.Add_Employee_Pom_Page;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

public class AddEmployeeFromHRHeadTest {

	public static void main(String[] args) throws Throwable {

		File_Utility file=new File_Utility();
		Excel_Utility excel=new Excel_Utility();
		WebDriver_Utility web=new WebDriver_Utility();

		String BROWSER=file.CommonDataFromProperty("browser");
		String URL=file.CommonDataFromProperty("url");
		String UN =file.CommonDataFromProperty("unhead");
		String PWD=file.CommonDataFromProperty("pwdhead");
		
		
		String dept1=excel.readDataFromExcelFile("DropDown", 2, 3);
		String brnch1=excel.readDataFromExcelFile("DropDown", 2, 4);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");


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
		loginPageTest lp = new loginPageTest(driver);
		lp.login(UN, PWD, type);

		web.swithToAlertWindowAndAccpect(driver);
		
		Hr_Head_HomePage hrhead=new Hr_Head_HomePage(driver);
		hrhead.addEmployee();
		
		Add_Employee_Pom_Page addemp=new Add_Employee_Pom_Page(driver);
		addemp.addEmployee();
		
		AddEmp_Form_PomPage addnew=new AddEmp_Form_PomPage(driver);
		addnew.addEmpDetails(excel.getList("Employee"), driver, dept1, brnch1, image, file1 );
		
		web.swithToAlertWindowAndAccpect(driver);
		

	}

}
