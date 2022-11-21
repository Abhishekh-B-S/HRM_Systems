package practicePackage;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DecendingOrder {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement all = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		 all.click();
		 Select drop=new Select(all);
		 TreeSet<String> ite=new TreeSet<String>(Collections.reverseOrder());
		 List<WebElement> iteams=drop.getOptions();
		 for(WebElement a:iteams)
		 {
			 String text=a.getText();
			 ite.add(text);
		 }		 
		 for(String b:ite)
		 {
			 System.out.println(b);
		 }
		 
		 
		
	}

}
