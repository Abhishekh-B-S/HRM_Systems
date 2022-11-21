package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.hr.genericutility.Excel_Utility;

public class DataProvider53 {
	
	@Test(dataProvider="getData")
	public void hrmStstem(String name,String a,String b)
	{
		System.out.println(name+"    "+a+"   "+b);
	}
	
//	@DataProvider
//	public Object[][] getdata()
//	{
//		Object[][] ob=new Object[5][3];
//				
//		ob[0][0]="Branch";
//		ob[0][1]="Corporate";
//		ob[0][2]="Employee";
//		
//		ob[1][0]="New Branch";
//		ob[1][1]="New Corporate";
//		ob[1][2]="New Employee";
//		
//		ob[2][0]="Update Branch";
//		ob[2][1]="Update Corporate";
//		ob[2][2]="Update Employee";
//		
//		ob[3][0]="Delete Branch";
//		ob[3][1]="Delete Corporate";
//		ob[3][2]="Delete Employee";
//		
//		ob[4][0]="Add Branch";
//		ob[4][1]="Add Corporate";
//		ob[4][2]="Add Employee";
//		
//		return ob;
		
		
		
	//}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Excel_Utility excel=new Excel_Utility();
		Object[][] obj = excel.readMultipleData("DataProvide");
		return obj;
				
	}

}
