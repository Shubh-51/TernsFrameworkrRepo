package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class VendorInfoPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public VendorInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerinfo;
	
	@FindBy(xpath="//span[@id='dtlview_Vendor Name']")
	private WebElement actVenName;
	
	@FindBy(xpath="//span[@id='dtlview_GL Account']")
	private WebElement actGLDDText;


	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getActVenName() {
		return actVenName;
	}

	public WebElement getActGLDDText() {
		return actGLDDText;
	}
	
	
	
	
}
