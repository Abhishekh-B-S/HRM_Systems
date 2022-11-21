package com.hrm.hr.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	
	
	public File_Utility file=new File_Utility();
	public Excel_Utility excel=new Excel_Utility();
	public WebDriver_Utility web=new WebDriver_Utility();
	public DataBase_Utility data=new DataBase_Utility();
	public Java_Utility java=new Java_Utility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null; // listeners 
	
	@BeforeSuite(groups = "smoke")
	public void connectToDb()
	{
		System.out.println("-----Database Connected Successfully-----");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String Browser = file.CommonDataFromProperty("browser");
		
		if (Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("----Invalid Browser-----");
		}
		
		String URL = file.CommonDataFromProperty("url");
		driver.get(URL);
		web.waitForPageLoad(driver);
		web.maximizeWindow(driver);
		sdriver=driver;    // to capture the screenshot
	}
	
	
	@AfterClass(groups = "smoke")
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterSuite(groups = "smoke")
	public void closeDb()
	{
		System.out.println("----Database Connection closed----");
	}
}
