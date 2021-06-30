package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;

	public ReadConfig()
	{
		File src=new File("./Configurations/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("exception is"+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("MainURL");
		return url;
	}
	public String getUsername()
	{
		String un=pro.getProperty("Username");
		return un;
	}
	public String getpassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("Chromepath");
		return chromepath;

	}
	public String getFirefoxpath()
	{
		String Firefoxpath=pro.getProperty("Chromepath");
		return Firefoxpath ;

	}
	public String getIEpath()
	{
		String IEpath=pro.getProperty("InternetExplorerPath");
		return IEpath ;

	}
	
	public String getCityName()
	{
		String cityName=pro.getProperty("CityName");
		return cityName ;

	}
	public String getCityCode()
	{
		String citycode=pro.getProperty("Cityshortcode");
		return citycode ;

	}
	
}


