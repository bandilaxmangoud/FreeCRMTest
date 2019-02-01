package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.STHomePage;
import com.crm.qa.pages.STLoginPage;

import com.crm.qa.util.ExcelTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class STLoginPageTest extends TestBase{
	
	STLoginPage stloginpage;
	STHomePage sthomepage;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public STLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		stloginpage=new STLoginPage();
		
	}

	@Test
	public void stLoginPageTestTitle()
	{
		String title=stloginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Smart Track");
	}
	
	@Test
	public void stLoginTest() throws Exception
	{
		//sthomepage=stloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//sthomepage=stloginpage.login();
		ExcelTest eat = new ExcelTest(prop.getProperty("excelPath"));
		sthomepage=stloginpage.login(eat.getCellData("Credentials","UserName",3),eat.getCellData("Credentials", "PassWord", 3));
		
		//sthomepage=stloginpage.login();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
