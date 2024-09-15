package com.crm.tp.terns.objectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class QuotesPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public QuotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//img[@alt='Create Quote...']")
	private WebElement createQuoteButton;
	
	@FindBy(xpath="//a[text()='Quotes']/ancestor::td[@class='moduleName']")
	private WebElement quoteButton;
	
	@FindBy(name="search_text")
	private WebElement editSearchQuote;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@title='Quotes']/ancestor::tr/descendant::a[text()='edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement noQuoteText;
	

	@FindBy(xpath="//a[@title='Quotes']")
	private WebElement quoteName;
	
	
	public WebElement getCreateQuoteButton() {
		return createQuoteButton;
	}

	public WebElement getEditSearchQuote() {
		return editSearchQuote;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getQuoteButton() {
		return quoteButton;
	}
	
	public WebElement getQuoteName() {
		return quoteName;
	}
	

	public WebElement getNoQuoteText() {
		return noQuoteText;
	}
	

	public void searchQuoteWithQuoteName(String subjectDD,String subject) {
		wlib.SelectOptionFromDropdownWithVisibleText(searchDD,subjectDD);
		editSearchQuote.sendKeys(subject);
		searchButton.click();
		editButton.click();

	}
	public void searchQuoteAndClickOnDeleteButton(String subjectDD,String subject,String orgName) throws InterruptedException {
		
		wlib.SelectOptionFromDropdownWithVisibleText(searchDD,subjectDD);
		editSearchQuote.sendKeys(subject);
		Thread.sleep(4000);
		searchButton.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[9]/a[2]")).click();
		Thread.sleep(5000);
		wlib.toAcceptAlertPopup(driver);

	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
