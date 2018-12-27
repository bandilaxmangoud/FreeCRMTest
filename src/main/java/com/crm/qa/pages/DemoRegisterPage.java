package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DemoRegisterPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	WebElement firstName;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
	WebElement lastName;

	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	WebElement address;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email1;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement phone;

	@FindBy(xpath = "//input[@type='radio' and @value='Male']")
	WebElement male;

	@FindBy(xpath = "//input[@type='radio' and @value='Female']")
	WebElement feMale;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox1']")
	WebElement cricket;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox2']")
	WebElement movies;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox3']")
	WebElement hockey;

	@FindBy(xpath = "//div[@id='msdd']")
	WebElement launguage;

	@FindBy(xpath = "//select[@id='Skills']")
	WebElement skills;

	@FindBy(xpath = "//select[@id='countries']")
	WebElement country;

	@FindBy(xpath = "//span[@id='select2-country-container']")
	WebElement selectCountry;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchCountry;

	@FindBy(xpath = "//select[@id='yearbox']")
	WebElement yearBox;

	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")
	WebElement month;

	@FindBy(xpath = "//select[@id='daybox']")
	WebElement dayBox;

	@FindBy(xpath = "//input[@id='firstpassword']")
	WebElement firstpassword;

	@FindBy(xpath = "//input[@id='secondpassword']")
	WebElement secondPassword;

	@FindBy(xpath = "//button[@id='submitbtn' and @type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//button[@id='Button1' and @type='submit']")
	WebElement refreshBtn;

	public DemoRegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void select_list(WebElement ele,String status){
	     Select statusDropdown=new Select(ele);
	     statusDropdown.selectByVisibleText(status);
	  }
	public DemoWebTablePage validateRegistration(String fName, String lName, String addr, String email, String ph,String pwd1,String pwd2) throws InterruptedException {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		address.sendKeys(addr);
		email1.sendKeys(email);
		phone.sendKeys(ph);
		male.click();
		movies.click();
		launguage.click();
		select_list(country,"India");
		select_list(yearBox, "1986");
		Thread.sleep(2000);
		select_list(month, "April");
		Thread.sleep(2000);
		select_list(dayBox, "7");
		firstpassword.sendKeys(pwd1);
		secondPassword.sendKeys(pwd2);
		submitBtn.click();
		
		return new DemoWebTablePage();

	}

}
