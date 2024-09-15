package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class EditingQuoteInfoPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public EditingQuoteInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="subject")
	private WebElement editSubjectname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getEditSubjectname() {
		return editSubjectname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void editSubject(String editedSubjectName) {
		editSubjectname.clear();
		editSubjectname.sendKeys(editedSubjectName);
		saveButton.click();
	}
	
	
	
	

}
