package testNGPractice;

import org.testng.annotations.Test;

import com.hms.hr.pompages.AddEmp_Form_PomPage;
import com.hms.hr.pompages.Add_Employee_Pom_Page;
import com.hms.hr.pompages.HrAssistant_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.BaseClass;

public class AddNewEmployee extends BaseClass{
	
	@Test
	public void addEmp() throws Throwable
	{
		String UN = file.CommonDataFromProperty("unassi");
		String PWD = file.CommonDataFromProperty("pwdassi");
		String value=excel.readDataFromExcelFile("DropDown", 3, 0);
		
		String dept = excel.readDataFromExcelFile("Corporate", 11, 2);
		String branch = excel.readDataFromExcelFile("Branches", 8, 1);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
		
		
		loginPageTest lp=new loginPageTest(driver);
		lp.login(UN, PWD, value);
		
		web.swithToAlertWindowAndAccpect(driver);
		
		HrAssistant_HomePage hra=new HrAssistant_HomePage(driver);
		hra.empBtn();
		
		Add_Employee_Pom_Page ad=new Add_Employee_Pom_Page(driver);
		ad.addEmployee();
		
		
		
	    AddEmp_Form_PomPage add=new AddEmp_Form_PomPage(driver);
	    add.addEmpDetails(excel.getList("Employee"), driver, dept, branch,image,file1);
	    
	    web.swithToAlertWindowAndAccpect(driver);
	    
	    hra.logoutdrop();
	    web.swithToAlertWindowAndAccpect(driver);
	    
	    
		
	}

}
