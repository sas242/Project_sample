package com.Project_sample.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerpage {
	WebDriver ldriver;
	
	public AddCustomerpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		}

	@FindBy (xpath="//a[@href=\"addcustomerpage.php\"]")
	WebElement lnkAddCustomer;
	
	@FindBy (name="name")
	WebElement txtcustomername;
	
	@FindBy(xpath="//*[@name=\"rad1\"and @value=\"f\"]")
	WebElement rbGender;

	@FindBy(name="dob")
	WebElement txtdob;
	
	@FindBy (name="addr")
   WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpin;
	
	@FindBy(name ="telephoneno")
	WebElement txtphoneno;
	
	@FindBy(name="emailid")
	WebElement txtemail;
	
	@FindBy(name ="password")
	WebElement txtpassword;
	
	@FindBy(name="sub")
	WebElement btnsubmit;
	
	//Action Methods for the elements
	
	public void clickAddCustomer()
	{
		lnkAddCustomer.click();
		}
	
	public void custname(String cname)
	{
	txtcustomername.sendKeys(cname);
}
	public void custGender(String cgender)
	{
		rbGender.click();
	}
  public void custdob(String mm,String dd,String yy)
  {
	  txtdob.sendKeys(mm);
	  txtdob.sendKeys(dd);
      txtdob.sendKeys(yy);
  }
  
  public void custaddress(String addr) {
	  txtaddress.sendKeys(addr);
  }
  
  public void custcity(String city) {
	  txtcity.sendKeys(city);
  }
  
  public void custstate(String state) {
	  txtstate.sendKeys(state);
  }
  
  public void custpinno(String pinno) {
	  txtpin.sendKeys(String.valueOf(pinno));
  }
  
  public void custtelephone(String telephoneno)
  {
	  txtphoneno.sendKeys(telephoneno);
  }
  public void custemailid(String Emailid)
  {
	  txtemail.sendKeys(Emailid);
  }
  public void custpassword(String pwd)
  {
	  txtpassword.sendKeys(pwd);
  }
  public void clicksubmit()
  {
	 btnsubmit.click();
  }
}