package branches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_New_Branch_Test {

	public static void main(String[] args) throws Throwable {


		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties obj = new Properties();
		obj.load(fis);
		String BROWSER=obj.getProperty("browser");
		String URL=obj.getProperty("url");
		String UNHEAD=obj.getProperty("unhead");
		String PWDHEAD=obj.getProperty("pwdhead");

		FileInputStream fi = new FileInputStream("./src/test/resources/BranchesTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		String branch = wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();


		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);
		
		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);
		
		WebElement obj1= driver.findElement(By.id("hr_type"));

		Select obj2=new Select(obj1);

		obj2.selectByValue("HR Head");
		
		driver.findElement(By.xpath("//button[@name='login_hr']")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
		
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		
		driver.findElement(By.xpath("//p[text()='Add Braches']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		driver.findElement(By.name("branches_name")).sendKeys(branch);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		
		a.accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		
		a.accept();
		
		driver.quit();


	}

}
