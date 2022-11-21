package practicePackage;

import org.testng.annotations.Test;

public class Employee {
	
	@Test(groups = "smoke")
	public void addEmployee()
	{
		System.out.println("---Employee details Added Succesfully---");
	}
	
	@Test(groups = "Regression")
	public void updateemployee()
	{
		System.out.println("---Employee details Updated Succesfully---");
	}
	
	@Test
	public void deleteemployee()
	{
		System.out.println("---Employee details Deleted Succesfully---");
	}


}
