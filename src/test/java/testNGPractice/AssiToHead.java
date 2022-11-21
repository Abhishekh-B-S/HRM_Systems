package testNGPractice;

import org.testng.annotations.Test;

import com.hms.hr.pompages.AddEmp_Form_PomPage;
import com.hms.hr.pompages.Add_Employee_Pom_Page;
import com.hms.hr.pompages.HrAssistant_HomePage;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.hrofficer_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.BaseClass;

public class AssiToHead extends BaseClass{

	@Test
	public void addNewEmp() throws Throwable
	{
		String UNA = file.CommonDataFromProperty("unassi");
		String PWDA = file.CommonDataFromProperty("pwdassi");
		String valueA=excel.readDataFromExcelFile("DropDown", 3, 0);

		String dept = excel.readDataFromExcelFile("Corporate", 12, 2);
		String branch = excel.readDataFromExcelFile("Branches", 9, 1);
		String image=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		String file1=("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");


		String UN = file.CommonDataFromProperty("unhead");
		String PWD = file.CommonDataFromProperty("pwdhead");
		String value=excel.readDataFromExcelFile("DropDown", 1, 0);


		String UNO = file.CommonDataFromProperty("unoff");
		String PWDO = file.CommonDataFromProperty("pwdoff");
		String value3=excel.readDataFromExcelFile("DropDown", 2, 0);

		loginPageTest lp=new loginPageTest(driver);
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

		lp.login(UNO, PWDO, value3);
		web.swithToAlertWindowAndAccpect(driver);

		hrofficer_HomePage hro=new hrofficer_HomePage(driver);
		hro.empbtn();
		Thread.sleep(3000);

		hro.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);

		lp.login(UN, PWD, value); 
		web.swithToAlertWindowAndAccpect(driver);

		Hr_Head_HomePage hr=new Hr_Head_HomePage(driver);
		Thread.sleep(3000);
		hr.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);



	}

}
