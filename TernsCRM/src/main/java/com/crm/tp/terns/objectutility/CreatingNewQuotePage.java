package com.crm.tp.terns.objectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class CreatingNewQuotePage {
	
	WebDriver driver=null;
	
	WebDriverUtility wlib=new WebDriverUtility();
	
	public CreatingNewQuotePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="subject")
	private WebElement editSubject;
	
	@FindBy(name="quotestage")
	private WebElement quoteStageDropdown;
	
	@FindBy(xpath="//input[@name='account_name']/../img")
	private WebElement organizationNameLookup;
	
	@FindBy(name="search_text")
	private WebElement editSearch;
	
	@FindBy(name="search_field")
	private WebElement inDropdown;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioButton;
	
	@FindBy(name="assigned_user_id")
	private WebElement userDropdown;
	
	@FindBy(name="bill_street")
	private WebElement editBillingAddress;
	
	@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingAddressRadioButton;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement productLookup;
	
	@FindBy(name="search_text")
	private WebElement editSearchPro;
	
	@FindBy(name="search_field")
	private WebElement inDropdownPro;
	
	@FindBy(name="search")
	private WebElement searchButtonPro;
	
	@FindBy(name="qty1")
	private WebElement editqty;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	

	public WebElement getEditSubject() {
		return editSubject;
	}

	public WebElement getQuoteStageDropdown() {
		return quoteStageDropdown;
	}

	public WebElement getOrganizationNameLookup() {
		return organizationNameLookup;
	}

	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getUserDropdown() {
		return userDropdown;
	}

	public WebElement getEditBillingAddress() {
		return editBillingAddress;
	}

	public WebElement getCopyBillingAddressRadioButton() {
		return copyBillingAddressRadioButton;
	}

	public WebElement getProductLookup() {
		return productLookup;
	}
	
	public WebElement getEditSearchPro() {
		return editSearchPro;
	}

	public WebElement getInDropdownPro() {
		return inDropdownPro;
	}
	
	public WebElement getEditqty() {
		return editqty;
	}

	public WebElement getSearchButtonPro() {
		return searchButtonPro;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	
	
	public void createNewQuotewithAllMandatoryInfo(String subject,String quoteStage,
			String partialUrlOrg,String searchOrg,String orgNamedd,
	String orgName,String partialUrlQuote,String userdd,
	String billingAddress,String partialUrlPro,
	String productName,String productdd,String proName,String qty) throws InterruptedException  {
		editSubject.sendKeys(subject);
		wlib.SelectOptionFromDropdownWithVisibleText(quoteStageDropdown,quoteStage);
		organizationNameLookup.click();
		wlib.switchToBrowserWindowWithPartailURL(driver,partialUrlOrg);
		editSearch.sendKeys(searchOrg);
		wlib.SelectOptionFromDropdownWithVisibleText(inDropdown,orgNamedd);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.toDismissAlertPopup(driver);
		wlib.switchToBrowserWindowWithPartailURL(driver, partialUrlQuote);
		userRadioButton.click();
		wlib.SelectOptionFromDropdownWithVisibleText(userDropdown,userdd);
		editBillingAddress.sendKeys(billingAddress);
		copyBillingAddressRadioButton.click();
		productLookup.click();
		wlib.switchToBrowserWindowWithPartailURL(driver,partialUrlPro);
		editSearchPro.sendKeys(productName);
		wlib.SelectOptionFromDropdownWithVisibleText(inDropdownPro,productdd);
		searchButtonPro.click();
		driver.findElement(By.xpath("//a[text()='"+proName+"']")).click();
		wlib.switchToBrowserWindowWithPartailURL(driver, partialUrlQuote);
		Thread.sleep(2000);
		editqty.sendKeys(qty);
		saveButton.click();
			
		
	}
	

}
