package com.Project_sample.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Project_sample.utilities.Readconfig;

public class Baseclas {
	Readconfig readconfig=new Readconfig();
	public  String baseurl= readconfig.getApplicationurl();
	public String username= readconfig.getusername();
	public String password= readconfig.getpassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger  = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("WebDriver.chrome.driver",readconfig.getchromepath());
				driver = new ChromeDriver();
		}
		else
		{
			if(br.equals("firefox"))
			{
				System.setProperty("webDriver.gecko.driver",readconfig.getfirefoxpath());
				driver = new FirefoxDriver();
			}
			else
			{
				if(br.equals("IE browser"))
				{
					System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
					driver = new InternetExplorerDriver();
				}
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(baseurl);
			}
		}
				
				
	}
	
  @AfterClass
	public void teardown()
	{
		driver.quit();
	}
  //Captures screenshots when the test cases are failed
   
     public void capturescreen(WebDriver driver,String tname) throws IOException{
    	 TakesScreenshot ts = (TakesScreenshot)driver;
    	 File source=ts.getScreenshotAs(OutputType.FILE);
    	 File target=new File(System.getProperty("user.dir")+"/Screenshots" + tname+ ".png");
    	 FileUtils.copyFile(source,target);
    	 System.out.println("screenshot taken");
    	
    	 
     }
     //Method To generate random string
     public String randomestring()
 	{
 		String generatedstring=RandomStringUtils.randomAlphabetic(8);
 		return generatedstring;
 	}
 	public static String randomenum()
 	{
 		   String generatedstring2=  RandomStringUtils.randomNumeric(4);
 		   return generatedstring2;
 		
 	}
  
  
}
