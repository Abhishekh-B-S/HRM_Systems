package com.hms.hr.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.hr.genericutility.WebDriver_Utility;

public class loginPageTest extends WebDriver_Utility{

	
	@FindBy(name="hr_email")
	private WebElement username;
	
	@FindBy(name="hr_password")
	private WebElement password;
	
	@FindBy(name="hr_type")
	private WebElement hrtype;
	
	@FindBy(name="login_hr")
	private WebElement loginclick;
	
	public loginPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getHrtype() {
		return hrtype;
	}
	
	public void login(String UNHEAD, String PWDHEAD, String text)
	{
		username.sendKeys(UNHEAD);
		password.sendKeys(PWDHEAD);
		select(text, hrtype);
		loginclick.click();
		
		
		
	}

	

}
