package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.hr.pompages.Add_New_BranchPom;
import com.hms.hr.pompages.Branches_pom_page;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.BaseClass;


@Listeners(com.hrm.hr.genericutility.ListenersImplementation.class)
public class AddNewBranchTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void addBranch() throws Throwable
	{
		String UN=file.CommonDataFromProperty("unhead");
		String PWD=file.CommonDataFromProperty("pwdhead");
		String value=excel.readDataFromExcelFile("DropDown", 1, 0);
		String value1=excel.readDataFromExcelFile("Branches", 8, 1);
		
		loginPageTest lp=new loginPageTest(driver);
		lp.login(UN, PWD, value);
		web.swithToAlertWindowAndAccpect(driver);
		Hr_Head_HomePage hr=new Hr_Head_HomePage(driver);
		hr.addBranches(driver);
		Branches_pom_page br=new Branches_pom_page(driver);
		br.addBranch(driver);
		Add_New_BranchPom brn=new Add_New_BranchPom(driver);
		brn.newBranch(value1);	
		web.swithToAlertWindowAndAccpect(driver);
		hr.logoutdrop();
		web.swithToAlertWindowAndAccpect(driver);
	}
	
	@Test(groups = "integration")
	public void branch()
	{
		System.out.println("new branch added");
	}

}
