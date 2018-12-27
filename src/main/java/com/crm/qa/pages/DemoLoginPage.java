package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DemoLoginPage extends TestBase{

	@FindBy(xpath="//input[@id='email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//img[@id='enterimg']")
	WebElement enterBtn;
	
	@FindBy(xpath="//button[@id='btn1']")
	WebElement signInBtn;
	
	@FindBy(xpath="//button[@id='btn2']")
	WebElement skipSignInBtn;
	
	public DemoLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePagetitle()
	{
		return driver.getTitle();
	}
	
	public DemoRegisterPage signUp(String name)
	{
		emailTxt.sendKeys(name);
		enterBtn.click();
		return new DemoRegisterPage();
	}
	
	public DemoSignInPage signIn()
	{
		signInBtn.click();
		return new DemoSignInPage();
	}
	
	public DemoRegisterPage skipSignIn()
	{
		skipSignInBtn.click();
		return new DemoRegisterPage();
	}
}
