package pomPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hms.hr.pompages.AddEmp_Form_PomPage;
import com.hms.hr.pompages.Add_Corp_Page;
import com.hms.hr.pompages.Add_Employee_Pom_Page;
import com.hms.hr.pompages.Add_New_BranchPom;
import com.hms.hr.pompages.Branches_pom_page;
import com.hms.hr.pompages.Corporate_pom_page;
import com.hms.hr.pompages.HrAssistant_HomePage;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.hrofficer_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewHeadToAssiTest {

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
		
		WebDriver driver=new ChromeDriver();
		web.maximizeWindow(driver);
		driver.get(URL);
		
		
		String type=excel.readDataFromExcelFile("DropDown", 3, 0);
		String type1=excel.readDataFromExcelFile("DropDown", 2, 0);
		String type2=excel.readDataFromExcelFile("DropDown", 1, 0);
		String dept1=excel.readDataFromExcelFile("Corporate", 9, 2);
		String branch1=excel.readDataFromExcelFile("Branches", 5, 1);
		String deptadd=excel.readDataFromExcelFile("DropDown", 6, 3);
		String branchadd=excel.readDataFromExcelFile("DropDown", 6, 4);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
		loginPageTest lp = new loginPageTest(driver);
		lp.login(UNH, PWDH, type2);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		Hr_Head_HomePage hrhead=new Hr_Head_HomePage(driver);
		hrhead.addCorporate();
		
		Corporate_pom_page cr=new Corporate_pom_page(driver);
		cr.newAddDeptName();
		
		Add_Corp_Page corp=new Add_Corp_Page(driver);
		corp.corpname(dept1);
		web.swithToAlertWindowAndAccpect(driver);
		
		hrhead.addBranches(driver);
		
		Branches_pom_page br=new Branches_pom_page(driver);
		br.addBranch(driver);
		
		Add_New_BranchPom br1=new Add_New_BranchPom(driver);
		br1.newBranch(branch1);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		hrhead.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);
		
		lp.login(UNO, PWDO, type1);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		hrofficer_HomePage hro=new hrofficer_HomePage(driver);
		hro.empbtn();
		
		Thread.sleep(3000);
		
		hro.logoutdrop();
		
		web.swithToAlertWindowAndAccpect(driver);
		
		lp.login(UN, PWD, type);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		HrAssistant_HomePage hrassi=new HrAssistant_HomePage(driver);
		hrassi.empBtn();
		
		Add_Employee_Pom_Page emp=new Add_Employee_Pom_Page(driver);
		emp.addEmployee();
		
		AddEmp_Form_PomPage form=new AddEmp_Form_PomPage(driver);
		form.addEmpDetails(excel.getList("Employee"), driver, deptadd, branchadd, file1, image);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		hrassi.logoutdrop();
		
		web.swithToAlertWindowAndAccpect(driver);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		

	}

}
