package com.Project_sample.testcases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.Project_sample.pageobjects.Loginpage;

public class TC_LoginTest_001 extends Baseclas {
	
	@Test
	public void LoginTest() throws IOException
	{
		driver.get(baseurl);
		logger.info("Application launched");
		Loginpage lp = new Loginpage(driver);
		lp.setusername(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clicksubmit();
		logger.info("loggedin successfully");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			capturescreen(driver,"LoginTest");//calls the method when the test fails
			Assert.assertTrue(false);
		}
	}

}
