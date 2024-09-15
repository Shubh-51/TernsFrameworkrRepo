package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	WebDriver driver=null;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	@FindBy(name="accountname")
	private WebElement editOrgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	public void createNewOrg(String orgName) {
		editOrgName.sendKeys(orgName);
		savebutton.click();
	}

}
