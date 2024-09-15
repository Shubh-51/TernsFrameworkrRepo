package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class CreatingNewVendorPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public CreatingNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="vendorname")
	private WebElement editVenName;
	
	@FindBy(name="glacct")
	private WebElement glDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	
	public WebElement getEditVenName() {
		return editVenName;
	}



	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getGlDD() {
		return glDD;
	}



	public void createNewVendor(String venName) {
		editVenName.sendKeys(venName);
		saveButton.click();
	}
	
	public void createNewVendorWithGLDD(String venName,String glddText) {
		editVenName.sendKeys(venName);
		wlib.SelectOptionFromDropdownWithVisibleText(glDD, glddText);
		saveButton.click();
	}

}
