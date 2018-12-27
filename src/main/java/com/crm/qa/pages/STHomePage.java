package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class STHomePage extends TestBase{

	@FindBy(xpath="//li[@class='dropdown']/a/img")
	WebElement clientMenu;
	
	@FindBy(xpath="//*[@id=\"clientMenu\"]/li[1]/input")  
	WebElement clientFilter;
	
	@FindBy(xpath="//*[@id=\"clientMenu\"]/li[2]/div/a[27]")
	WebElement selectClient;
	
	@FindBy(xpath="//*[@id=\"landingPage\"]/div[1]")
	WebElement createReqLink;
	
	@FindBy(xpath="//*[@id=\"etkresult\"]/li[1]")
	WebElement newReqType;
	
	@FindBy(xpath="//*[@id=\"maincreatreq\"]/div[2]/ul/li[3]")
	WebElement newReq;
	
	
	public STHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnClientMenu()
	{
		clientMenu.click();
	}
	
	public void selectClient(String cName)
	{
		clientFilter.sendKeys(cName);
		Actions action = new Actions(driver);
		action.moveToElement(selectClient).build().perform();
		selectClient.click();
	}
	
	public STCreateReqPage clickOnCreateReqLink()
	{
		createReqLink.click();
		newReqType.click();
		newReq.click();
		return new STCreateReqPage();
	}
}
