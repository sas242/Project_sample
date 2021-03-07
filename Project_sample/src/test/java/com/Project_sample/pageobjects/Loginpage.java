package com.Project_sample.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Project_sample.utilities.Javascriptutils;

public class Loginpage {
	WebDriver ldriver;
	public Loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		}
	@FindBy(name="uid")
		WebElement txtusername;
	
	@FindBy(name="password")
		WebElement txtpassword;
	
	@FindBy(name="btnlogin")
	 WebElement btnlogin;
	
	@FindBy(xpath="//a[@href=\"Logout.php\"]")
	   WebElement btnlogout;
	
	public void setusername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void clicksubmit()
	{
		//btnlogin.click();
		Javascriptutils.clickElementByJS(btnlogin,ldriver);
	}
		public void clicklogout()
		{
			btnlogout.click();
			
		}
	}

