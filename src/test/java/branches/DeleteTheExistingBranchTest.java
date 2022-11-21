package branches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteTheExistingBranchTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String UNHEAD=p.getProperty("unhead");
		String PWDHEAD=p.getProperty("pwdhead");

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
		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);
		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);

		WebElement person = driver.findElement(By.name("hr_type"));

		Select obj=new Select(person);
		obj.selectByValue("HR Head");

		driver.findElement(By.name("login_hr")).click();

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[6]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.xpath("(//button[@class='btn btn-danger btn-sm'])[10]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("braches")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		driver.close();












	}

}
