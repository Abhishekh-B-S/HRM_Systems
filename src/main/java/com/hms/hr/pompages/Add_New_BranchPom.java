package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_New_BranchPom {
	
	@FindBy(name="branches_name")
	private WebElement newbranch;
	
	@FindBy(name="bran")
	private WebElement savebranch;
	
	public Add_New_BranchPom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewbranch() {
		return newbranch;
	}

	public WebElement getSavebranch() {
		return savebranch;
	}

	public void newBranch(String name) throws Throwable
	{
		Thread.sleep(2000);
		newbranch.sendKeys(name);
		savebranch.click();
	}
}
