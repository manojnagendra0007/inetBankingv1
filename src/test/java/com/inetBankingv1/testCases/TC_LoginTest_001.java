package com.inetBankingv1.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
  @Test
  public void logintest() throws IOException {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	 driver.get(BaseUrl);
	 driver.manage().window().maximize();
	 
	 logger.info("Url was launched");
	 
	//creating an object for pageclass-LoginPage
	 LoginPage lp=new LoginPage(driver);
	 lp.typeuserid(UserId);
	 logger.info("entered username");
	 
	 lp.typepasswrd(Password);
	 logger.info("entered password");
	 
	 lp.clicklogin();
	 logger.info("clicked login button");
	 
	 if(isAlertPresent()==true)
	 {
		 logger.info("login failed -invalid user alert is present");
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(false);
		 logger.warn(" login  failed");
		
	 }
	 else
	 {
		Assert.assertTrue(true);
		logger.info("login passed");
	 }
	 
	 
	 
	 //asserting the title name
	 
	/* Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	 System.out.println("assretion passed-actual value=expected value");*/
	 if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	 {
		 Assert.assertTrue(true);
		 logger.info("login test case passed");
	 }
	 else 
	 {
		 captureScreen(driver,"logintest");
		 Assert.assertTrue(false);
		 logger.info("login test case failed"); 
	 }
	 
	 

	 
  }
}
