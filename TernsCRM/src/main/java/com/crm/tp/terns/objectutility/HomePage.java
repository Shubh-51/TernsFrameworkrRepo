package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class HomePage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutButton;
	
	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement moreDropdown;
	
	@FindBy(name="Quotes")
	private WebElement quotes;
	
	@FindBy(xpath="//img[@style='width:16px;height:16px;']/ancestor::tr/descendant::a[text()='Organizations']")
	private WebElement orgButton;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement proButton;
	
	@FindBy(xpath="//a[text()='Vendors']")
	private WebElement vendorButton;
	
	
	public WebElement getProButton() {
		return proButton;
	}



	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}



	public WebElement getSignoutButton() {
		return signoutButton;
	}



	public WebElement getMoreDropdown() {
		return moreDropdown;
	}

	

	public WebElement getOrgButton() {
		return orgButton;
	}



	public WebElement getQuotes() {
		return quotes;
	}

	public WebElement getVendorButton() {
		return vendorButton;
	}



	public void signOutToApp() {
		wlib.mouseHoverToElement(driver, administratorIcon);
		signoutButton.click();
		
	}
	
	public void navigateToQuotesModule() {
		wlib.mouseHoverToElement(driver, moreDropdown);
		wlib.waitForElementToBeClickable(driver, quotes);
		quotes.click();
		
	}
	
	public void navigateToVendorsModule() {
		wlib.mouseHoverToElement(driver, moreDropdown);
		wlib.waitForElementToBeClickable(driver,vendorButton);
		vendorButton.click();
	}

	
	
	
	
	
	
}
