package com.crm.tp.terns.basetest;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.tp.terns.databaseutility.DataBaseUtility;
import com.crm.tp.terns.excelutility.ExcelUtility;
import com.crm.tp.terns.fileutility.FileUtility;
import com.crm.tp.terns.jsonutility.JSONUtility;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.LoginPage;
import com.crm.tp.terns.webdriverutility.JavaUtility;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;
import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public JSONUtility jsonlib=new JSONUtility();
	public DataBaseUtility dblib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void configBS() {
		System.out.println("=======ConnnectToDB==========");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void configBC() throws IOException {
		System.out.println("=====LaunchTheBrowser=======");
		//String browser=flib.getDataFromPropertiesFile("browser");
		String browser=System.getProperty("browser",flib.getDataFromPropertiesFile("browser"));
		//String browser=Browser;
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityObjectClass.setWebDriver(sdriver);
		
	}
	
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void configBM() throws IOException {
		
		System.out.println("=======LoginToApplication========");
		//String url=flib.getDataFromPropertiesFile("url");
		//String username=flib.getDataFromPropertiesFile("username");
		//String password=flib.getDataFromPropertiesFile("password");
		String url=System.getProperty("url",flib.getDataFromPropertiesFile("url"));
		String username=System.getProperty("username",flib.getDataFromPropertiesFile("username"));
		String password=System.getProperty("password",flib.getDataFromPropertiesFile("password"));
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url,username, password);
		
	}
	
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void configAM() {
		System.out.println("=====LogOutToApplication=====");
		HomePage hp=new HomePage(driver);
		hp.signOutToApp();
	}
	
	
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void configAC() {
		System.out.println("===========CloseTheBrowser==========");
		driver.quit();
		
	}
	
	
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void configAS() {
		System.out.println("========CloseTheDBConnection===========");
		
	}
}
