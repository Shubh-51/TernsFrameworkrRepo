package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class OrganizationInfoPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement editorgName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfoText;

	public WebElement getEditorgName() {
		return editorgName;
	}

	public WebElement getHeaderInfoText() {
		return headerInfoText;
	}
	
	
}
