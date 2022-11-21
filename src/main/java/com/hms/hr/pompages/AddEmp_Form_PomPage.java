package com.hms.hr.pompages;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.hr.genericutility.File_Utility;
import com.hrm.hr.genericutility.WebDriver_Utility;

public class AddEmp_Form_PomPage extends WebDriver_Utility {
	
	@FindBy(name="emplo")
	private WebElement savebtn;
	
	@FindBy(name="employee_department")
	private WebElement department;
	
	@FindBy(name="employee_branches")
	private WebElement branches;	
	
	@FindBy(name="employee_file201")
	private WebElement empfile;
	
	@FindBy(name="employee_image")
	private WebElement empimg;
	
	public AddEmp_Form_PomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getDepartment() {
		return department;
	}


	public WebElement getBranches() {
		return branches;
	}


	public WebElement getEmpfile() {
		return empfile;
	}


	public WebElement getEmpimg() {
		return empimg;
	}


	public void addEmpDetails(Map<String,String>map,WebDriver driver,String dept,String branch,String image,String file) throws Throwable
	{
		Thread.sleep(2000);
		for (Entry<String, String>set:map.entrySet()) {
			driver.findElement(By.name((set.getKey()))).sendKeys(set.getValue());
		}
		
		select(dept, department);
		select(branch, branches);
		empfile.sendKeys(file);
		empimg.sendKeys(image);
		savebtn.click();
		
		
	}
	

}
