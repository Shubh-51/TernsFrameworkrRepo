package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class CreatingNewProductPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="productname")
	private WebElement editProName;
	
	@FindBy(name="sales_start_date")
	private WebElement editSalesStartDate;
	
	@FindBy(name="start_date")
	private WebElement editStartSupportDate;
	
	@FindBy(name="sales_end_date")
	private WebElement editSalesEndDate;
	
	@FindBy(name="expiry_date")
	private WebElement editExpiryDate;
	
	@FindBy(xpath="//input[@id='my_file_element']")
	private WebElement proImageInfo;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getEditProName() {
		return editProName;
	}



	public WebElement getSaveButton() {
		return saveButton;
	}
	
	



	public WebElement getEditSalesStartDate() {
		return editSalesStartDate;
	}
	

	public WebElement getEditStartSupportDate() {
		return editStartSupportDate;
	}



	public WebElement getEditSalesEndDate() {
		return editSalesEndDate;
	}



	public WebElement getEditExpiryDate() {
		return editExpiryDate;
	}

	

	public WebElement getProImageInfo() {
		return proImageInfo;
	}



	public void createNewPro(String proName) {
		editProName.sendKeys(proName);
		saveButton.click();
	}
	
	public void createNewProWithSupportDateAndSalesDate(String proName,String salesStartDate,
			String startSupportDate,String endSalesDate,String expiryDate) {
		editProName.sendKeys(proName);
		editSalesStartDate.sendKeys(salesStartDate);
		editStartSupportDate.sendKeys(startSupportDate);
		editSalesEndDate.sendKeys(endSalesDate);
		editExpiryDate.sendKeys(expiryDate);
		saveButton.click();
	}
	
	public void createNewProWithProImageInformation(String proName,String imgFilePath) {
		editProName.sendKeys(proName);
		proImageInfo.sendKeys(imgFilePath);
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
