package branches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditTheExistingBranchNameTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String B=pro.getProperty("browser");
		String U=pro.getProperty("url");
		String UH=pro.getProperty("unhead");
		String PWD=pro.getProperty("pwdhead");
		
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
		driver.findElement(By.name("hr_email")).sendKeys(UH);
		driver.findElement(By.name("hr_password")).sendKeys(PWD);

		WebElement person = driver.findElement(By.name("hr_type"));

		Select obj=new Select(person);
		obj.selectByValue("HR Head");

		driver.findElement(By.name("login_hr")).click();

		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[6]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-sm'])[5]")).click();
		
		FileInputStream fi = new FileInputStream("./src/test/resources/BranchesTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		String edit = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-sm'])[5]")).click();
		driver.findElement(By.xpath("(//input[@name='corporate_name'])[46]")).click();
		driver.findElement(By.xpath("(//input[@name='corporate_name'])[46]")).clear();
		driver.findElement(By.xpath("(//input[@name='corporate_name'])[46]")).sendKeys(edit);
		
		
		
		
		
	   
		
		
		
		
		
		
	
		
		

		
		

	}

}
