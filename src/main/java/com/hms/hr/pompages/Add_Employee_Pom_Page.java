package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.hr.genericutility.WebDriver_Utility;

public class Add_Employee_Pom_Page extends WebDriver_Utility {
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addemp;
	
	@FindBy(xpath="//tbody/tr[last()]/td/i[@class='fa fa-trash']")
	private WebElement deletebtn;
	
	@FindBy(xpath="//tbody/tr[last()]/td/i[@class='fa fa-edit']")
	private WebElement editbtn;
	
	public Add_Employee_Pom_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddemp() {
		return addemp;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}
	
	public void addEmployee()
	{
		addemp.click();
	}
	public void addEmployeeDeleteBtn()
	{
		deletebtn.click();
	}
	public void addEmployeeEditBtn(WebDriver driver)
	{
		scrollAction(driver, editbtn);
		waitForElemnetToBeClickAble(driver, editbtn);
		editbtn.click();
	}

}
