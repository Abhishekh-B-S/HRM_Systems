package testNGPractice;

import org.testng.annotations.Test;

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
import com.hrm.hr.genericutility.BaseClass;

public class HeadToAssi extends BaseClass{
	
	@Test
	public void addDetails() throws Throwable
	{
		String UN = file.CommonDataFromProperty("unhead");
		String PWD = file.CommonDataFromProperty("pwdhead");
		String value=excel.readDataFromExcelFile("DropDown", 1, 0);
	    String value1 = excel.readDataFromExcelFile("Corporate", 12, 2);
	    String value2=excel.readDataFromExcelFile("Branches", 9, 1);
	    String UNO = file.CommonDataFromProperty("unoff");
		String PWDO = file.CommonDataFromProperty("pwdoff");
		String value3=excel.readDataFromExcelFile("DropDown", 2, 0);
		
		String UNA = file.CommonDataFromProperty("unassi");
		String PWDA = file.CommonDataFromProperty("pwdassi");
		String valueA=excel.readDataFromExcelFile("DropDown", 3, 0);
		
		String dept = excel.readDataFromExcelFile("Corporate", 12, 2);
		String branch = excel.readDataFromExcelFile("Branches", 9, 1);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
	    
	    //Login in as HR Head
	    loginPageTest lp=new loginPageTest(driver);
	    lp.login(UN, PWD, value); 
	    web.swithToAlertWindowAndAccpect(driver);
	    
	    //Home page Corporate module handle
	    Hr_Head_HomePage hr=new Hr_Head_HomePage(driver);
	    hr.addCorporate();	   
	    Corporate_pom_page cr=new Corporate_pom_page(driver);
	    cr.newAddDeptName();    
	    Add_Corp_Page add=new Add_Corp_Page(driver);
	    add.corpname(value1);
	    web.swithToAlertWindowAndAccpect(driver);
	    
	   //Branch
	    hr.addBranches(driver);
	    Branches_pom_page br=new Branches_pom_page(driver);
		br.addBranch(driver);
		Add_New_BranchPom brn=new Add_New_BranchPom(driver);
		brn.newBranch(value2);
		web.swithToAlertWindowAndAccpect(driver);
		hr.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);
		
		
		//login as hr officer		
		lp.login(UNO, PWDO, value3);
		web.swithToAlertWindowAndAccpect(driver);
		
		hrofficer_HomePage hro=new hrofficer_HomePage(driver);
		hro.empbtn();
		Thread.sleep(3000);
		
		hro.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);
		
		//login as hr assistant
		lp.login(UNA, PWDA, valueA);
		web.swithToAlertWindowAndAccpect(driver);
		
		HrAssistant_HomePage hra=new HrAssistant_HomePage(driver);
		hra.empBtn();
		Add_Employee_Pom_Page emp=new Add_Employee_Pom_Page(driver);
		emp.addEmployee();
		AddEmp_Form_PomPage ad=new AddEmp_Form_PomPage(driver);
		ad.addEmpDetails(excel.getList("Employee"), driver, dept, branch, image, file1);
		web.swithToAlertWindowAndAccpect(driver);
		
		hra.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);	
	}
	

}
