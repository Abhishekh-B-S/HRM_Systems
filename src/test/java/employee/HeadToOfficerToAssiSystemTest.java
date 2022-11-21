package employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HeadToOfficerToAssiSystemTest {

	public static void main(String[] args) throws Throwable {


		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pr=new Properties();
		pr.load(fis);

		String B=pr.getProperty("browser");
		String U=pr.getProperty("url");
		String UOFF=pr.getProperty("unoff");
		String POFF=pr.getProperty("pwdoff");


		WebDriver driver=null;
		if(B.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(B.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.get(U);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.name("hr_email")).sendKeys(UOFF);

		driver.findElement(By.name("hr_password")).sendKeys(POFF);

		WebElement obj1= driver.findElement(By.id("hr_type"));

		Select obj2=new Select(obj1);

		obj2.selectByValue("HR Officer");

		driver.findElement(By.xpath("//button[@name='login_hr']")).click();

		Alert a=driver.switchTo().alert();
		a.accept();

		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

		FileInputStream fi = new FileInputStream("./src/test/resources/AddEmployee.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();

		ArrayList<String> list=new ArrayList<String>();
		list.add("employee_companyid");
		list.add("employee_firstname");
		list.add("employee_lastname");
		list.add("employee_middlename");
		list.add("branches_datefrom");
		list.add("branches_recentdate");
		list.add("employee_position");
		list.add("employee_contact");
		list.add("employee_sss");
		list.add("employee_tin");
		list.add("employee_hdmf_pagibig");
		list.add("employee_gsis");
		for (int i=0; i<=count; i++) {
			String value=sh.getRow(i).getCell(3).getStringCellValue();
			driver.findElement(By.name(list.get(i))).sendKeys(value);

		}
		WebElement dep = driver.findElement(By.name("employee_department"));

		Select dept=new Select(dep);
		dept.selectByValue("IT Department");

		WebElement b = driver.findElement(By.name("employee_branches"));

		Select branch=new Select(b);
		branch.selectByValue("Bengaluru");
		driver.findElement(By.name("employee_file201")).sendKeys("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
		driver.findElement(By.name("employee_image")).sendKeys("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		driver.findElement(By.name("emplo")).click();
		a.accept();

		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();

		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();

		a.accept();

		String UA=pr.getProperty("unassi");
		String PA=pr.getProperty("pwdassi");

		driver.findElement(By.name("hr_email")).sendKeys(UA);

		driver.findElement(By.name("hr_password")).sendKeys(PA);

		WebElement obj3= driver.findElement(By.id("hr_type"));

		Select obj4=new Select(obj3);

		obj4.selectByValue("HR Assistant");

		driver.findElement(By.xpath("//button[@name='login_hr']")).click();


		a.accept();

		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();

		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();

		a.accept();

		driver.quit();






	}

}
