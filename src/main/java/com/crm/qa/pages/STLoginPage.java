package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class STLoginPage extends TestBase{
	
	@FindBy(xpath="//input[contains(@id,'DefaultContent_TxtEmailAddress')]")
	WebElement username;

	@FindBy(xpath="//input[contains(@id,'DefaultContent_TxtPassword')]")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Sign In']")
	WebElement loginBtn;
	
	public STLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public STHomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new STHomePage();
	}

	
	
	
	
}
