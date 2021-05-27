package com.inetBankingv1.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.AddCustomerPage;
import com.inetBankingv1.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_002 extends BaseClass
{
   @Test
   public void addNewCustomer() throws IOException, InterruptedException
   {
	   
	   driver.get(BaseUrl);
		 driver.manage().window().maximize();
		 
		 logger.info("Url was launched");
	//creating obj for page class LoginPage 	 
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
	 //creating obj for page class AddCustomerPage    
	   AddCustomerPage addcust=new AddCustomerPage(driver);
	   addcust.clickNewCustomer();
	   logger.info("clicked on new customer");
	   
	   addcust.typeName("manoj");
	   logger.info("entered name");
	   
	   addcust.clickGender();
	   logger.info("clicked particular gender");
	   
	   addcust.typeDob("26", "10", "1997");
	   logger.info("entered date of birth");
	   
	   addcust.typeAddress("India");
	   logger.info("entered address");
	   
	   addcust.typeCity("Hyderabad");
	   logger.info("entered city");
	   
	   addcust.typeState("Telangana");
	   logger.info("entered state");
	   
	   addcust.typePin("500050");
	   logger.info("entered pincode");
	   
	   String email=randomstring1()+"@gmail.com";
	   addcust.typeEmail(email);
	   logger.info("entered randomemailid");
	   
	   String mobileno=randomnum();
	   addcust.typeMobilenumber(mobileno);
	   logger.info("entered randommobilenumber");
	   
	   addcust.typePassword("mnmnmn");
	   logger.info("entered password");
	   
	   addcust.clickSubmit();
	   logger.info("clicked on submit");
	   Thread.sleep(10000);
	   
	   boolean reg=driver.getPageSource().contains("Customer Registered Successfully!!!");
	   
	   if(reg==true)
	   {
		   Assert.assertTrue(true); 
		   logger.info("test case is passed...");
	   }
	   else
	   {
		   captureScreen(driver,"addNewCustomer");
		   Assert.assertTrue(false);
		   logger.info("test case is failed...");
	   }
	   
	 
	   
   }
   
  
   
	
}
