package practicePackage;

import org.testng.annotations.Test;

public class ReadDataFromOtherClass {
	
	
	@Test(dataProviderClass = DataProviderClassSeperate.class,dataProvider = "readMultipleData")
	public void movies(String name,String status) throws Throwable
	{
		
		System.out.println(name+"----->"+status);
	}
	
}
