package com.crm.tp.terns.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.terns.webdriverutility.WebDriverUtility;

public class LoginPage {
	
	WebDriver driver=null;
	WebDriverUtility wlib=new WebDriverUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement editUsername;
	
	@FindBy(name="user_password")
	private WebElement editPassword;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getEditUsername() {
		return editUsername;
	}

	public WebElement getEditPassword() {
		return editPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String url,String username,String password) {
		driver.get(url);
		wlib.maximizeBrowserWindow(driver);
		wlib.waitForPageToLoad(driver);
		editUsername.sendKeys(username);
		editPassword.sendKeys(password);
		loginButton.click();
	}

}
