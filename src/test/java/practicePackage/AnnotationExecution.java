package practicePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationExecution {
	
	@BeforeClass
	public void conClass()
	{
		System.out.println("Launch The Browser");
	}
	@BeforeMethod
	public void conMethod()
	{
		System.out.println("Login to the application");
	}
	@BeforeSuite
	public void conSuite()
	{
		System.out.println("Connect to the DataBase");
	}
	@Test
	public void conTest()
	{
		System.out.println("Test Scrip execution started");
	}
	@AfterClass
	public void conClasss()
	{
		System.out.println("Close tne browser");
	}
	@AfterMethod
	public void conMeth()
	{
		System.out.println("logout from the application");
	}
	@AfterSuite
	public void ConSuit()
	{
		System.out.println("Disconnect the database");
	}
	
	

}
