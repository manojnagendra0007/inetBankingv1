package com.inetBankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialize the WebDriver Object
	WebDriver ldriver;
	
	//create a constructor for pageclass-LoginPage
	public LoginPage(WebDriver rdriver)
	{
	 	ldriver=rdriver;
	 	PageFactory.initElements(rdriver, this);
	}
	
	//finding WebElements
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement passwrd;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	//actions or methods of actions to be performed on that WebElements
	
	public void typeuserid(String uid)
	{
		userid.sendKeys(uid);
	}
	public void typepasswrd(String pwd)
	{
		passwrd.sendKeys(pwd);
	}
	public void clicklogin()
	{
		login.click();
	}
	

}
