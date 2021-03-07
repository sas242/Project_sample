package com.Project_sample.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Project_sample.pageobjects.Loginpage;
import com.Project_sample.utilities.Xlutils;

public class TC_LoginDDT_002 extends Baseclas
{
	
    @Test(dataProvider = "Logindata")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		Loginpage lp = new Loginpage(driver);
		lp.setpassword(user);
		logger.info("User name provided");

		lp.setpassword(pwd);
		logger.info("password provided");

		lp.clicksubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
     driver.switchTo().alert().accept();//close alert
     Assert.assertTrue(false);
		logger.warn("login failed");

}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");

			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
	}
    
    public boolean isAlertPresent()//User defined method to check the alert is present or not
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
	@DataProvider(name="Logindata")
  String[][] getdata() throws IOException
  {
		String path=System.getProperty("user.dir")+"src/test/java/com/Project_sample/Testdata/Logindata.xls";
	   int rownum =Xlutils.getRowcount(path,"Sheet1");
	   int colcount=Xlutils.getcellcount(path,"Sheet1",1);
	   String Logindata[][] = new String[rownum][colcount];
	   for(int i=1;i<=rownum;i++)
	   {
		   for(int j=0;j<colcount;j++)
		   {
			   Logindata[i-1][j]=Xlutils.getcelldata(path,"Sheet1",i,j);
			   
		   }
	   }
	   return Logindata;
  }
}
