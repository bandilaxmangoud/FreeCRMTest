package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class STHomePage extends TestBase{

	/*Home Icon*/
	@FindBy(xpath="//a[@id='openHome']")
	WebElement HomeIcon; 
	
	@FindBy(xpath="//ul[@class='logoDropdown']/li/a") 
	WebElement clientMenuDropdown;
	
	@FindBy(xpath="//ul[@id='clientMenu']/li[1]/input")  
	WebElement clientNameFilter;
	
	@FindBy(xpath="//*[@id='clientMenu']/li[2]/div/a[27]")
	WebElement selectClient;
	
	@FindBy(xpath="//ul[@class='logoDropdown']/li[2]/div")
	WebElement clientNameValidation;
	
	@FindBy(xpath="//div[@class='gn-trigger']")
	WebElement Menu;
	
	@FindBy(xpath="//ul[@class='gn-menu']/li[6]/a")
	WebElement requisitionMainMenu;
	
	@FindBy(xpath="//ul[@class='gn-menu']/li[6]/ul/li[1]/a")    
	WebElement createRequisitionSubMenu;
	
	@FindBy(xpath="//div[@class='panel-body']/ul/li[1]")
	WebElement selectReqType_newReq;
	
	@FindBy(xpath="//div[@class='panel-body']/ul/li[3]")
	WebElement createNewRequisition_newReq;
	
	
	public STHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/*Wait for Home Icon available in the page*/
	
	public void clickOnClientMenu()
	{
		clientMenuDropdown.click();
	}
	
	public void selectClient(String cName)
	{
		clientNameFilter.sendKeys(cName);
		Actions action = new Actions(driver);
		action.moveToElement(selectClient).build().perform();
		selectClient.click();
	}
	
	public STCreateReqPage reqCreation()
	{
		Menu.click();
		requisitionMainMenu.click();
		createRequisitionSubMenu.click();
		selectReqType_newReq.click();
		createNewRequisition_newReq.click();
		return new STCreateReqPage();
	}
}
