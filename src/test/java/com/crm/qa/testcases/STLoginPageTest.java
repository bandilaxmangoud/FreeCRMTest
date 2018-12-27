package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.STHomePage;
import com.crm.qa.pages.STLoginPage;

public class STLoginPageTest extends TestBase{
	
	STLoginPage stloginpage;
	STHomePage sthomepage;
	
	public STLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
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
	public void stLoginTest()
	{
		sthomepage=stloginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
