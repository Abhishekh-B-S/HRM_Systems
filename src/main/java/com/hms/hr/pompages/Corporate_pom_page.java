package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Corporate_pom_page {
	
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private WebElement newcorporate;
	
	@FindBy(id="example1_next")
	private WebElement nextbutton;
	
	public Corporate_pom_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewcorporate() {
		return newcorporate;
	}

	public WebElement getNextbutton() {
		return nextbutton;
	}
	
	public void newAddDeptName()
	{
		newcorporate.click();
	}
	
	
}
