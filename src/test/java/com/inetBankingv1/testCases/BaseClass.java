package com.inetBankingv1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBankingv1.utilities.ReadConfig;


public class BaseClass {
	
   ReadConfig readconfig=new ReadConfig();
   
	
	public String BaseUrl=readconfig.getApplicationUrl();
	public String UserId=readconfig.getUserId();
	public String Password=readconfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
  @Parameters("browser")
  @BeforeTest
  public void setUp(String br) {
	// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	 	 
	 // System.setProperty("webdriver.chrome.driver","C://User//Manoj//workspace//inetBankingv1//Drivers//chromedriver.exe");
	  
	  //here ./is the project directory we used  instead of System.getProperty("user.dir")+
	 //System.setProperty("webdriver.chrome.driver",".///Drivers//chromedriver.exe");
	  
	  if (br.equals("Chrome"))
		{
		  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		  driver=new ChromeDriver();
		}
	 else if(br.equals("Ie"))
	  	{
		  System.setProperty("webdriver.ie.driver",readconfig.getIePath());
		  driver=new InternetExplorerDriver();		  
	  	}
	 
	  logger=Logger.getLogger("inetBankingv1");
	  PropertyConfigurator.configure("log4j.properties");
	/*  	driver.get(BaseUrl);
		driver.manage().window().maximize();*/
		 
  }

  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
  
  public void captureScreen(WebDriver driver,String tname) throws IOException //user defined method for capturing the screen
  {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source= ts.getScreenshotAs(OutputType.FILE);
	  File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
	  FileUtils.copyFile(source, target);
	  System.out.println("Screenshot captured");
	  
  }
  
  public String randomstring1()//userdefined method to generate random value
  {
	 String  generatedalphastring=RandomStringUtils.randomAlphabetic(5);
	 return(generatedalphastring);
  }
  
  public String randomnum()//userdefined method to generate random value
  {
	   String generatednumericstring=RandomStringUtils.randomNumeric(10);
	   return(generatednumericstring);
  }
	

  public boolean isAlertPresent()//user defined method to check alert is present or not
  {
	  try
	  {
		  driver.switchTo().alert();
		  return true;
	  }
	  catch(NoAlertPresentException e)
	  {
		  return false;
	  }
  }
  
  public static void SwitchToWindowindex(int index,WebDriver driver)//user defined method to switch btwn tabs
	{
		String reqwindowid=null;
		Set<String> Windowhandleids=driver.getWindowHandles();
		Iterator<String> traverse=Windowhandleids.iterator();
		for(int i=1;i<=index;i++)
			reqwindowid=traverse.next();
			driver.switchTo().window(reqwindowid);
		
	}
}
