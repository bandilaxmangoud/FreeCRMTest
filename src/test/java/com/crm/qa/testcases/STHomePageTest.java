package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.STCreateReqPage;
import com.crm.qa.pages.STHomePage;
import com.crm.qa.pages.STLoginPage;
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
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		stcreatereqpage = new STCreateReqPage();
		stloginpage = new STLoginPage();
		sthomepage = stloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void selectClientName() throws InterruptedException
	{
		sthomepage.clickOnClientMenu();
		sthomepage.selectClient("Thermo");
		Thread.sleep(2000);
		stcreatereqpage=sthomepage.clickOnCreateReqLink();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
}
