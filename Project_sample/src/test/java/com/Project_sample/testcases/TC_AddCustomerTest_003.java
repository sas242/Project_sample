package com.Project_sample.testcases;

import java.io.IOException;

import org.junit.Assert;

import com.Project_sample.pageobjects.AddCustomerpage;
import com.Project_sample.pageobjects.Loginpage;

public class TC_AddCustomerTest_003 extends Baseclas {
	
	public void Addnewcustomer() throws InterruptedException, IOException 
	{
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		logger.info("User name provided");
		lp.setpassword(password);
		logger.info("password provided");
		lp.clicksubmit();
		
		AddCustomerpage addcust = new AddCustomerpage(driver);
		addcust.clickAddCustomer();
		logger.info("providing customer details");
		addcust.custname("Aisha");
		addcust.custGender("Female");
		addcust.custdob("01","02" ,"1991");
		addcust.custaddress("India");
		addcust.custcity("blr");
		addcust.custstate("KA");
		addcust.custpinno("50060");
		addcust.custtelephone("7865438760");
		Thread.sleep(3000);
		    String email = randomestring()+"gmail.com";
		    addcust.custemailid(email);
            addcust.custpassword("abcdef");
            addcust.clicksubmit();
            Thread.sleep(3000);
            logger.info("Validation started");
		boolean res=driver.getPageSource().contains("customer registered successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else {
			capturescreen(driver,"addnewcustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}
	}
	

}
