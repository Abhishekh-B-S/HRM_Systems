package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hrofficer_HomePage {
	
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement employeeO;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addemployeeO;

	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	private WebElement logdrop;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutbtn;
	
	public hrofficer_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getEmployeeO() {
		return employeeO;
	}


	public WebElement getAddemployeeO() {
		return addemployeeO;
	}
	
	
	
	public WebElement getLogdrop() {
		return logdrop;
	}


	public WebElement getLogoutbtn() {
		return logoutbtn;
	}


	public void empbtn()
	{
		employeeO.click();
		addemployeeO.click();
		
	}
	
	public void logoutdrop()
	{
		logdrop.click();
		logoutbtn.click();		
	}
	
	
	
}




