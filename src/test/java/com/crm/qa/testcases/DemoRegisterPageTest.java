package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DemoLoginPage;
import com.crm.qa.pages.DemoRegisterPage;
import com.crm.qa.pages.DemoWebTablePage;



public class DemoRegisterPageTest extends TestBase{

	DemoLoginPage dlp;
	DemoRegisterPage drp;
	DemoWebTablePage dwt;
	
	
	
	public DemoRegisterPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		drp= new DemoRegisterPage();
		dlp= new DemoLoginPage();
		drp=dlp.signUp("username");
	}
	
@Test
public void registration() throws InterruptedException
{
	Thread.sleep(5000);
	dwt = drp.validateRegistration(
			prop.getProperty("firstname"),
			prop.getProperty("lastname"),
			prop.getProperty("address"), 
			prop.getProperty("email"), 
			prop.getProperty("phone"),
			prop.getProperty("pwd"),
			prop.getProperty("conpwd")
			);
	
}


}