package com.crm.tp.terns.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;



public class ListenerImpClass implements ISuiteListener,ITestListener{
	
	 public ExtentSparkReporter spark;
	 public  ExtentReports report;
	 public ExtentTest test;
	
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("=======ConfigTheReport===========");
		
		String date=new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark=new ExtentSparkReporter("./AdvanceReport/Reort_"+date+".html");
		spark.config().setDocumentTitle("CRM_Terns_Reports");
		spark.config().setReportName("Terns_CRM");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating_System","Windows");
		report.setSystemInfo("Browser","chrome");
		report.setSystemInfo("Browser_version","120");
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"=====>Start<=========");
		String testname=result.getMethod().getMethodName().toString();
		test=report.createTest(testname);
		UtilityObjectClass.setExtentTest(test);
		test.log(Status.INFO,"========>Started<==============");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"====>Completed<==========");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		String date=new Date().toString().replace(":", "_").replace(" ", "_");
		UtilityObjectClass.getWebDriver();
		UtilityObjectClass.getExtentTest();
		if(UtilityObjectClass.getExtentTest()!=null) {
			TakesScreenshot ts=(TakesScreenshot)UtilityObjectClass.getWebDriver();
			try {
				String filepath=ts.getScreenshotAs(OutputType.BASE64);
				UtilityObjectClass.getExtentTest().addScreenCaptureFromBase64String(filepath,testname+"_"+date);
				UtilityObjectClass.getExtentTest().log(Status.FAIL,testname);
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
	            System.out.println("ExtentTest object is null. Cannot add screenshot.");
	        }
			ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	

	
	

}
