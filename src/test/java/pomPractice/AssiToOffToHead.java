package pomPractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.hms.hr.pompages.AddEmp_Form_PomPage;
import com.hms.hr.pompages.Add_Employee_Pom_Page;
import com.hms.hr.pompages.HrAssistant_HomePage;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.hrofficer_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssiToOffToHead {

	

	public static void main(String[] args) throws Throwable {
		
		
		File_Utility file=new File_Utility();
		Excel_Utility excel=new Excel_Utility();
		WebDriver_Utility web=new WebDriver_Utility();
		
		String BROWSER=file.CommonDataFromProperty("browser");
		String URL=file.CommonDataFromProperty("url");
		String UN=file.CommonDataFromProperty("unassi");
		String PWD=file.CommonDataFromProperty("pwdassi");
		String UNO=file.CommonDataFromProperty("unoff");
		String PWDO=file.CommonDataFromProperty("pwdoff");
		String UNH=file.CommonDataFromProperty("unhead");
		String PWDH=file.CommonDataFromProperty("pwdhead");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		web.maximizeWindow(driver);
		driver.get(URL);
		
		String type=excel.readDataFromExcelFile("DropDown", 3, 0);
		String type1=excel.readDataFromExcelFile("DropDown", 2, 0);
		String type2=excel.readDataFromExcelFile("DropDown", 1, 0);
		String dept1=excel.readDataFromExcelFile("DropDown", 4, 3);
		String branch1=excel.readDataFromExcelFile("DropDown", 4, 4);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
		loginPageTest lp = new loginPageTest(driver);
		lp.login(UN, PWD, type);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		HrAssistant_HomePage hrassi=new HrAssistant_HomePage(driver);
		hrassi.empBtn();
		
		Add_Employee_Pom_Page ademp=new Add_Employee_Pom_Page(driver);
		ademp.addEmployee();
		
		Thread.sleep(3000);
		
		AddEmp_Form_PomPage addform=new AddEmp_Form_PomPage(driver);
		addform.addEmpDetails(excel.getList("Employee"), driver, dept1, branch1, file1, image);
		
		web.swithToAlertWindowAndAccpect(driver);	
		
		hrassi.logoutdrop();
		
		web.swithToAlertWindowAndAccpect(driver);
		
		lp.login(UNO, PWDO, type1);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		hrofficer_HomePage hroff=new hrofficer_HomePage(driver);
		hroff.empbtn();
		
		hroff.logoutdrop();
		
		web.swithToAlertWindowAndAccpect(driver);
		
		lp.login(UNH, PWDH, type2);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		Hr_Head_HomePage hrhead=new Hr_Head_HomePage(driver);
		hrhead.addEmployee();
		
		hrhead.logoutdrop();
		
		web.swithToAlertWindowAndAccpect(driver);
		
	
		
		
	}

}
