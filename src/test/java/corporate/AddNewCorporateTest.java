package corporate;

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
import org.testng.annotations.Listeners;

@Listeners(com.hrm.hr.genericutility.ListenersImplementation.class)
public class AddNewCorporateTest {

	public static void main(String[] args) throws Throwable {


		FileInputStream fi = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pr=new Properties();
		pr.load(fi);

		String B=pr.getProperty("browser");
		String U=pr.getProperty("url");
		String UN=pr.getProperty("unhead");
		String PWD=pr.getProperty("pwdhead");

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

		driver.findElement(By.name("hr_email")).sendKeys(UN);

		driver.findElement(By.name("hr_password")).sendKeys(PWD);

		WebElement obj1= driver.findElement(By.id("hr_type"));

		Select obj2=new Select(obj1);

		obj2.selectByValue("HR Head");

		driver.findElement(By.xpath("//button[@name='login_hr']")).click();

		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		FileInputStream fis = new FileInputStream("./src/test/resources/Corporate.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String dept = wb.getSheet("Sheet1").getRow(5).getCell(2).getStringCellValue();

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		driver.findElement(By.name("corporate_name")).sendKeys(dept);

		driver.findElement(By.name("corp")).click();
		a.accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();

		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();

		a.accept();

		driver.quit();









	}

}
