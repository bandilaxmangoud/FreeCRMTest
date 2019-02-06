package com.crm.qa.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.STHomePage;
import com.crm.qa.pages.STLoginPage;

import com.crm.qa.util.ExcelTest;
import com.crm.qa.util.Log;
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
		Log.startLog("Test is starting");
		stloginpage=new STLoginPage();
		
	}

	@Test
	public void stLoginPageTestTitle()
	{
		String title=stloginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Coupa CW");
	}
	
	@Test
	public void stLoginTest(Method method) throws Exception
	{
		//sthomepage=stloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//sthomepage=stloginpage.login();
		Log.info(method.getName() + "test is starting");
		ExcelTest eat = new ExcelTest(prop.getProperty("excelPath"));
		sthomepage=stloginpage.login(eat.getCellData("Credentials","UserName",3),eat.getCellData("Credentials", "PassWord", 3));
		Thread.sleep(5000);
		//sthomepage=stloginpage.login();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		Log.endLog("Test is ending");
		driver.quit();
	}
}
