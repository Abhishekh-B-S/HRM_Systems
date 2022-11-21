package practicePackage;

import org.testng.annotations.Test;

public class BranchTest {
	
	@Test(groups = "smoke")
	public void addBranch()
	{
		System.out.println("---New Branch Added Succesfully---");
	}
	
	@Test(groups = "Regression")
	public void updateBranch()
	{
		System.out.println("---Branch Updated Succesfully---");
	}
	
	@Test
	public void deleteBranch()
	{
		System.out.println("---Branch Deleted Succesfully---");
	}

}
