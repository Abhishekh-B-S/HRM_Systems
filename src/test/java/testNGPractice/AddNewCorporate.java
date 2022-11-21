package testNGPractice;

import org.testng.annotations.Test;

import com.hms.hr.pompages.Add_Corp_Page;
import com.hms.hr.pompages.Corporate_pom_page;
import com.hms.hr.pompages.Hr_Head_HomePage;
import com.hms.hr.pompages.loginPageTest;
import com.hrm.hr.genericutility.BaseClass;

public class AddNewCorporate extends BaseClass {
	
	@Test(groups = "smoke")
	public void addCorp() throws Throwable
	{
		String UN = file.CommonDataFromProperty("unhead");
		String PWD = file.CommonDataFromProperty("pwdhead");
		String value=excel.readDataFromExcelFile("DropDown", 1, 0);
	    String value1 = excel.readDataFromExcelFile("Corporate", 11, 2);
	    
	    //Login in 
	    loginPageTest lp=new loginPageTest(driver);
	    lp.login(UN, PWD, value);
	    
	    web.swithToAlertWindowAndAccpect(driver);
	    
	    //Home page Corporate module handle
	    Hr_Head_HomePage hr=new Hr_Head_HomePage(driver);
	    hr.addCorporate();
	    
	    //Corporate
	    Corporate_pom_page cr=new Corporate_pom_page(driver);
	    cr.newAddDeptName();
	    
	    //Add new Dept
	    Add_Corp_Page add=new Add_Corp_Page(driver);
	    add.corpname(value1);
	    
	    web.swithToAlertWindowAndAccpect(driver);
		    
	    //Logout
	    hr.logoutdrop();
	    web.swithToAlertWindowAndAccpect(driver);
 
	}
	
	@Test(groups = "integration")
	public void corporate()
	{
		System.out.println("new department added");
	}

}
