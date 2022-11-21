package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void travelling(String src,String dest)
	{
		System.out.println(src+"-------->"+dest);
	}
	
	@Test(dataProvider = "getData1")
	public void travelling(String src,String dest,int price)
	{
		System.out.println(src+"-------->"+dest+"----->"+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		
		obj[1][0]="Goa";
		obj[1][1]="Bangalore";
		return obj;
	}
	
	
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] obj=new Object[2][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		obj[0][2]=550;
		
		obj[1][0]="Goa";
		obj[1][1]="Bangalore";
		obj[1][2]=600;
		return obj;
	}
	

}
