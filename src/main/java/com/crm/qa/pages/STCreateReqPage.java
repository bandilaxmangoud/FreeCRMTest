package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class STCreateReqPage extends TestBase{

	@FindBy(xpath="//input[@id='hiringManager']")
	WebElement hiringManager;

	
	
}
