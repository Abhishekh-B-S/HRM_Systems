package practicePackage;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(groups = "smoke")
	public void script1()
	{
		System.out.println("---Script1 execution completed---");
	}

	@Test(groups = "Regression")
	public void script2()
	{
		System.out.println("---Script2 execution completed---");
	}

	@Test
	public void script3()
	{
		System.out.println("---Script3 execution completed---");
	}



}
