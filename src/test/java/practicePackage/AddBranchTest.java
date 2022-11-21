package practicePackage;

import org.testng.annotations.Test;

public class AddBranchTest {
	
	@Test(priority=1, invocationCount = 0, enabled=true)
	public void addBranch()
	{
		System.out.println("New Branch Added Succesfully");
	}
	
	@Test(priority=2, invocationCount = 2,enabled=true,dependsOnMethods = "addBranch")
	public void updateBranch()
	{
		System.out.println("Branch name updated succesfully");
	}
	
	@Test(priority=3, invocationCount = 0,enabled=true,dependsOnMethods = "updateBranch")
	public void deleteBranc()
	{
		System.out.println("Branch name deleted succesfully");
	}
}
