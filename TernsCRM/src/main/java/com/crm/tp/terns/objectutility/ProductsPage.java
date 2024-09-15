package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class ProductsPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement proButton;

	public WebElement getProButton() {
		return proButton;
	}
	
	

}
