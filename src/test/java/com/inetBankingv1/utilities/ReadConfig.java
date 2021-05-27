package com.inetBankingv1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties prp;
	//creating a constructor for class-ReadConfig     this is almost as same as like PageObject
		public ReadConfig()
	{
	   File src=new File(".//Configuration//config.properties");
	     
	 	try{
		    FileInputStream fips=new FileInputStream(src);
		        prp=new Properties();
			prp.load(fips);
	            }catch (Exception e) {
	                 System.out.println("Exception is" + e.getMessage());
	               }
	   }
		
	//method with string args	
	public  String getApplicationUrl()
	{
		String url=prp.getProperty("BaseUrl");
		return url;
				
	}
	
	public  String getUserId()
	{
		String userid=prp.getProperty("UserId");
		return userid;
				
	}
	
	public  String getPassword()
	{
		String password=prp.getProperty("Password");
		return password;
				
	}
	
	public  String getChromePath()
	{
		String chromepath=prp.getProperty("ChromePath");
		return chromepath;
				
	}
	
	public  String getIePath()
	{
		String iepath=prp.getProperty("IePath");
		return iepath;
				
	}

}
