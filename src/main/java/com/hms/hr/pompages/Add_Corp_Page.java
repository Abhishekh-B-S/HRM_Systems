package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Corp_Page {

	
	@FindBy(name="corporate_name")
	private WebElement newdeptname;
	
	@FindBy(name="corp")
	private WebElement savedeptname;
	
	public Add_Corp_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewdeptname() {
		return newdeptname;
	}

	public WebElement getSavedeptname() {
		return savedeptname;
	}
	
	public void corpname(String name) throws Throwable
	{
		Thread.sleep(2000);
		newdeptname.sendKeys(name);
		savedeptname.click();
	}
}
