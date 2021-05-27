package com.inetBankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	//initialize the WebDriver Object
	public WebDriver ldriver;
	
	//create a constructor for pageclass-LoginPage
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//finding WebElements
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomer;
	
	@FindBy(name="name")
	WebElement customername;
	
	
	@FindBy(xpath="//input[@value='m']")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dob;
	
	
	@FindBy(name="addr")
	WebElement address;
	
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement mobilenumber;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	
	public void clickNewCustomer()
	{
		newcustomer.click();
	}
	
	public void typeName(String name)
	{
		customername.sendKeys(name);
	}
	
	public void clickGender()
	{
		gender.click();
	}
	
	public void typeDob(String dd,String mm,String yy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
		
	}
	
	public void typeAddress(String addr)
	{
		address.sendKeys(addr);
	}
	
	public void typeCity(String ccity)
	{
		city.sendKeys(ccity);
	}
	
	public void typeState(String sstate)
	{
		state.sendKeys(sstate);
	}
	public void typePin(String ppin)
	{
		pin.sendKeys(String.valueOf(ppin));
	}
	public void typeMobilenumber(String mble)
	{
		mobilenumber.sendKeys(mble);
	}
	public void typeEmail(String eemail)
	{
		email.sendKeys(eemail);
	}
	
	public void typePassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		submit.click();
	}
	
	
	

}
