package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrAssistant_HomePage {
	
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement employee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addemployee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	private WebElement logdrop;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutbtn;
	
	public HrAssistant_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmployee() {
		return employee;
	}

	public WebElement getAddemployee() {
		return addemployee;
	}
	
	public WebElement getLogdrop() {
		return logdrop;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public void empBtn()
	{
		employee.click();
		addemployee.click();
		
	}
	
	public void logoutdrop()
	{
		logdrop.click();
		logoutbtn.click();		
	}

}
