package com.crm.tp.terns.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class is used to deal with different types of webDriver methods like
 * implicit  wait,explicit wait ,switch to child browser etc.
 */

public class WebDriverUtility {
	WebDriver driver=null;
	
	/**
	 * @param WebDriver
	 * return null
	 * this method is used maximize the browser window
	 */
	public void maximizeBrowserWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * @param WebDriver
	 * return null
	 * this method is used wait from each element to perform action
	 */
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	/**
	 * @param WebDriver
	 * @param WebElement
	 * return null
	 * this method is used wait for a element to be clickable.
	 * 
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * @param WebDriver
	 * @param WebElement
	 * return null
	 * this method is used wait for a element to be visible
	 * 
	 */
	
	public void waitForElementTo(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to switch the window with help of partial url
	 * @param driver
	 * @param partialUrl
	 */
	public void switchToBrowserWindowWithPartailURL(WebDriver driver,String partialUrl) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String id=it.next();
			driver.switchTo().window(id);
			String cururl=driver.getCurrentUrl();
			if(cururl.contains(partialUrl)) {
				break;
			}
			
		}
	}
	
	/**
	 * This method is used to switch the window with the help of partial text
	 * @param driver
	 * @param partialtitle
	 */
	public void switchToBrowserWithPartialTitle(WebDriver driver,String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String id=it.next();
			driver.switchTo().window(id);
			String title=driver.getTitle();
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to help accept the alert popup
	 * @param driver
	 */
	public void toAcceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method is used to help dismiss the alert popup
	 * @param driver
	 */
	public void toDismissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to help accept the alert popup
	 * @param WebElement
	 * @param String
	 */
	public void SelectOptionFromDropdownWithVisibleText(WebElement element,String visibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to mouse hover at any targeted Element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}



