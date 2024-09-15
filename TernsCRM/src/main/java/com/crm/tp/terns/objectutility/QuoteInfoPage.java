package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class QuoteInfoPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public QuoteInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerinfo;
	
	@FindBy(xpath="//span[@id='dtlview_Subject']")
	private WebElement actSubjectName;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement actOrgName;
	
	@FindBy(xpath="//td[@id='mouseArea_Billing Address']")
	private WebElement actBillingAdd;

	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getActSubjectName() {
		return actSubjectName;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActBillingAdd() {
		return actBillingAdd;
	}
	
	
	

}
