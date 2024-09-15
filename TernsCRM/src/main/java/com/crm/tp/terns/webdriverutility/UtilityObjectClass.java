package com.crm.tp.terns.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static void setExtentTest(ExtentTest acttest) {
		test.set(acttest);
	}
	
	public static ExtentTest getExtentTest() {
		return test.get();
	}
	
	public static void setWebDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	public static WebDriver getWebDriver() {
		return driver.get();
	}

}
