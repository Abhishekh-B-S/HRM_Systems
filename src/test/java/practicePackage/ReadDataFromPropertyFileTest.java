package practicePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable  {
		//step 1: get java representation object of physical file
		FileInputStream fis= new FileInputStream("src\\test\\resources\\commondata.properties");
		
		//step 2: create object for properties class
		Properties obj=new Properties();
		
		//step 3: load the keys
		obj.load(fis);
		
		//step 4:get the value using getproperty
		String BROWSER=obj.getProperty("browser");
		String URL=obj.getProperty("url");
		String UNHEAD=obj.getProperty("unhead");
		String PWDHEAD=obj.getProperty("pwdhead");
		String UNOFF=obj.getProperty("unoff");
		String PWDOFF=obj.getProperty("pwdoff");
		String UNASSI=obj.getProperty("unassi");
		String PWDASSI=obj.getProperty("pwdassi");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UNHEAD);
		System.out.println(PWDHEAD);
		System.out.println(UNOFF);
		System.out.println(PWDOFF);
		System.out.println(UNASSI);
		System.out.println(PWDASSI);
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);
		
		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);
		
		WebElement obj1= driver.findElement(By.id("hr_type"));
		
		Select obj2=new Select(obj1);
		
		obj2.selectByValue("HR Head");
		driver.findElement(By.xpath("//button[@name='login_hr']")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
	}

}
