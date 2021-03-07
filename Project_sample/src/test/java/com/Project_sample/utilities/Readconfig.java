package com.Project_sample.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	
	public Readconfig()
	{
		File src=new File("./configurations/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);//to read the data from config.properties
			pro = new Properties();
			pro.load(fis); //By using the load method the properties from properties file
			}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	//Method creation for all the variables

	public String getApplicationurl()
	{
		String url = pro.getProperty("baseurl");
		return url;
	}
	public String getusername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getchromepath()
	{
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
	public String getfirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
		}
	public String getIEpath()
	{
		String IEpath = pro.getProperty("IEpath");
		return IEpath;
	}
	
}
