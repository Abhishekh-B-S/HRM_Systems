package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.hr.genericutility.WebDriver_Utility;

public class Hr_Head_HomePage extends WebDriver_Utility{

	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	private WebElement corporate;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	private WebElement addcorporate;
	
	@FindBy(xpath="(//a[@class='nav-link'])[5]")
	private WebElement branches;
	
	@FindBy(xpath="(//a[@class='nav-link'])[6]")
	private WebElement addbranches;
	
	@FindBy(xpath="(//a[@class='nav-link'])[7]")
	private WebElement employee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[8]")
	private WebElement addemployee;
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	private WebElement logdrop;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutbtn;
	
	
	public Hr_Head_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCorporate() {
		return corporate;
	}

	public WebElement getAddcorporate() {
		return addcorporate;
	}

	public WebElement getBranches() {
		return branches;
	}

	public WebElement getAddbranches() {
		return addbranches;
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

	public void addCorporate()
	{
		corporate.click();
		addcorporate.click();
	}
	
	public void addBranches(WebDriver driver)
	{
		waitForElemnetToBeClickAble(driver, branches);
		branches.click();
		addbranches.click();
	}
	
	public void addEmployee()
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
