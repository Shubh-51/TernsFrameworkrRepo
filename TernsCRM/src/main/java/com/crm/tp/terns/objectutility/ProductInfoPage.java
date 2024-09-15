package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class ProductInfoPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement editPro;
	
	@FindBy(id="dtlview_Sales Start Date")
	private WebElement editSalesStartDate;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement editSupportStartDate;
	
	@FindBy(id="dtlview_Sales End Date")
	private WebElement editSalesEndDate;
	
	@FindBy(id="dtlview_Support Expiry Date")
	private WebElement editExpiryDate;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getEditPro() {
		return editPro;
	}

	public WebElement getEditSalesStartDate() {
		return editSalesStartDate;
	}

	public WebElement getEditSupportStartDate() {
		return editSupportStartDate;
	}

	public WebElement getEditSalesEndDate() {
		return editSalesEndDate;
	}

	public WebElement getEditExpiryDate() {
		return editExpiryDate;
	}
	
	
	
	
	
	
	
}
