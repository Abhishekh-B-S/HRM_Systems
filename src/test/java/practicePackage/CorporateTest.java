package practicePackage;

import org.testng.annotations.Test;

public class CorporateTest {

	@Test(groups = { "smoke","Regression"})
	public void addcorporate()
	{
		System.out.println("---New Department Name Added Succesfully---");
	}
	
	@Test(groups = "Sanity")
	public void updateCorporate()
	{
		System.out.println("---Department Name Updated Succesfully---");
	}
	
	@Test
	public void deleteCorporate()
	{
		System.out.println("---Department Name Deleted Succesfully---");
	}

}
