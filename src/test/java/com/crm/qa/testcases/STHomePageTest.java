package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.STCreateReqPage;
import com.crm.qa.pages.STHomePage;
import com.crm.qa.pages.STLoginPage;
import com.crm.qa.util.ExcelTest;
import com.crm.qa.util.TestUtil;

public class STHomePageTest extends TestBase{

	STLoginPage stloginpage;
	STHomePage sthomepage;
	STCreateReqPage stcreatereqpage;
	TestUtil testUtil;
	
	public STHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		//stcreatereqpage = new STCreateReqPage();
		ExcelTest eat = new ExcelTest(prop.getProperty("excelPath"));
		stloginpage = new STLoginPage();
		sthomepage = stloginpage.login(eat.getCellData("Credentials","UserName",3), eat.getCellData("Credentials", "PassWord", 3));
	}
	
	
	@Test
	public void selectClientName() throws InterruptedException
	{
		sthomepage.clickOnClientMenu();
		sthomepage.selectClient("Thermo");// hard coded value
		Thread.sleep(5000);
		stcreatereqpage=sthomepage.reqCreation();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
}
