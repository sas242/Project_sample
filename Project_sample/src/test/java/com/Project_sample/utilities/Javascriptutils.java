package com.Project_sample.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascriptutils {
	
	public static void clickElementByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor JS= ((JavascriptExecutor)driver);
		JS.executeScript("arguments[0].click();",element);
		
		
	}

}
