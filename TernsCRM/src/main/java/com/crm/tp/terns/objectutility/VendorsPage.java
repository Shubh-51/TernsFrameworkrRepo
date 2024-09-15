package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class VendorsPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createNewVendorButton;

	public WebElement getCreateNewVendorButton() {
		return createNewVendorButton;
	}
	
	
}
