package utilityPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

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

import com.hrm.hr.genericutility.DataBase_Utility;
import com.hrm.hr.genericutility.Excel_Utility;
import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.Java_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

public class AddEmpUtilityTest {

	public static void main(String[] args) throws Throwable, Throwable {
		File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		DataBase_Utility dlib=new DataBase_Utility();
		
		
		//read data from property file
		
		String BROWSER=flib.CommonDataFromProperty("browser");
		String URL=flib.CommonDataFromProperty("url");
		String UNHEAD=flib.CommonDataFromProperty("unassi");
		String PWDHEAD=flib.CommonDataFromProperty("pwdassi");
		
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
		wlib.maximizeWindow(driver);
		driver.get(URL);
		wlib.waitForPageLoad(driver);

		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);

		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);

		WebElement obj1= driver.findElement(By.id("hr_type"));
		wlib.select("HR Assistant", obj1);
		
		

		driver.findElement(By.xpath("//button[@name='login_hr']")).click();
		wlib.swithToAlertWindowAndAccpect(driver);
		

		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

		elib.getList("Sheet1", driver);

		
		WebElement dep = driver.findElement(By.name("employee_department"));
		wlib.select("IT Department", dep);
		

		WebElement b = driver.findElement(By.name("employee_branches"));
		wlib.select("Bengaluru", b);

		
		driver.findElement(By.name("employee_file201")).sendKeys("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\New Microsoft Office Word Document.docx");
		driver.findElement(By.name("employee_image")).sendKeys("C:\\Users\\ABHISHEK\\Desktop\\TY\\HRM\\New folder\\Screenshot (1).png");
		driver.findElement(By.name("emplo")).click();
		
		
		wlib.swithToAlertWindowAndAccpect(driver);

	}


}


