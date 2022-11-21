package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.hr.genericutility.WebDriver_Utility;

public class Branches_pom_page extends WebDriver_Utility{
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement addBranch;
	
	public Branches_pom_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddBranch() {
		return addBranch;
	}
	
	public void addBranch(WebDriver driver)
	{
		waitForElemnetToBeClickAble(driver, addBranch);
		addBranch.click();
	}
}
