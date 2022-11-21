package practicePackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetry {
	@Test(retryAnalyzer=com.hrm.hr.genericutility.RetryImplementationClass.class)
	
	
	public void practiceRetry()
	{
		System.out.println("----script01-----");
		System.out.println("----script02-----");
		System.out.println("----script03-----");
		Assert.fail();
		System.out.println("----script04-----");
		System.out.println("----script05-----");
		System.out.println("----script06-----");
	}

}
