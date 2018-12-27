package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DemoLoginPage;
import com.crm.qa.pages.DemoRegisterPage;
import com.crm.qa.pages.DemoSignInPage;
import com.crm.qa.util.TestUtil;

public class DemoLoginPageTest extends TestBase{

	DemoLoginPage dlp;
	DemoRegisterPage drp;
	DemoSignInPage dsp;
	TestUtil testUtil;
	
	public DemoLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		dlp= new DemoLoginPage();
	}
	
	@Test
	public void loginPageTitle()
	{
		String title=dlp.validatePagetitle();
		Assert.assertEquals(title, "Index");
	}
	
	@Test
	public void signup() throws InterruptedException
	{
		drp=dlp.signUp(prop.getProperty("username"));
		Thread.sleep(5000);
		/*driver.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(5000);
		drp=dlp.skipSignIn();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(5000);
		dsp=dlp.signIn();*/
	}
	
/*	@Test
	public void skipsignIn() {
		drp=dlp.skipSignIn();
	}
	
	@Test
	public void signIn()
	{
		dsp=dlp.signIn();
	} */
}
