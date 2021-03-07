package com.Project_sample.utilities;
//Listener class to generate extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onstart(ITestContext testcontext)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timestamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//Specify locatio
	    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    extent.setSystemInfo("Hostname","localhost");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("user","Aisha");
	   
	    htmlReporter.config().setDocumentTitle("Project_sample");//Report title
	    htmlReporter.config().setReportName("Functional TestReport");//Report name
	    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//chart location
	    htmlReporter.config().setTheme(Theme.DARK);
	    }
	
	public void onTestsuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//creates the new entry in report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//Sends the pass information 
	}

	public void onTestfailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//creates the new entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));//Sends the fail information 
	    String screenshotpath=System.getProperty("userdir")+"\\Screenshots\\"+tr.getName()+".png";//Send screenshots to the file name mentioned
	   File f = new File(screenshotpath);
	  if(f.exists())
	  {
		  try {
			  logger.fail("screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotpath));//create new entry in the report on test skips
			  
		  
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
	  }
	}
		  public void onTestskipped(ITestResult tr)
		  {
			  logger=extent.createTest(tr.getName());//create new entry in report on test skipped
			  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		  }
		  
		  public void onFinish(ITestContext testcontext)
		  {
			  extent.flush();
		  }
	  }
	
	
	
	

