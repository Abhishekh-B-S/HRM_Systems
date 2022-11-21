package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.hr.genericutility.Excel_Utility;

public class ReadMultipleDataFromExcelTest {
	
	@Test(dataProvider="getData")
	public void movies(String name,String Status)
	{
		System.out.println(name+"------->"+Status);
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Excel_Utility excel=new Excel_Utility();
		Object[][] value = excel.readMultipleData("Sheet1");
		return value;
	}
	
	
	
	
	

}


