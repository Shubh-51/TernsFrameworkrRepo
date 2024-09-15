package com.crm.tp.terns.productstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.tp.terns.basetest.BaseClass;

import com.crm.tp.terns.objectutility.CreatingNewProductPage;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.ProductInfoPage;
import com.crm.tp.terns.objectutility.ProductsPage;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;


public class CreateProductTest extends BaseClass {
	
	@Test(groups="SmokeTest")
	public void createProductWithMandatoryInformationTest() throws EncryptedDocumentException, IOException {
		
		//Step1:Read data fromExcel Sheet
		String proName=elib.getDataFromExcelFile("Products", 1, 2)+jlib.generateRandomNumber();
		// Step6:Navigate to product Page
		
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to Product  Page");
		HomePage hp=new HomePage(driver);
		hp.getProButton().click();
		
		// Step2:Navigate to CreateNew Product page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to new Product  Page");
		ProductsPage pg = new ProductsPage(driver);
		pg.getProButton().click();

		// Step3:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Fill all the details in New Product  Page");
		CreatingNewProductPage cnpg = new CreatingNewProductPage(driver);
		cnpg.createNewPro(proName);

		// Step4:Verify the Product name
		ProductInfoPage pip = new ProductInfoPage(driver);
		boolean headerinfopro = pip.getHeaderInfo().getText().contains(proName);
		String actProName = pip.getEditPro().getText();
		Assert.assertTrue(headerinfopro);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product headerInfo is verifed");
		Assert.assertEquals(actProName, proName);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product Name is verifed");
	}
	
	@Test(groups="RegressionTest")
	public void createProductWithSupportDateAndSalesDateTest() throws EncryptedDocumentException, IOException {
		//Step1:Read data from Excel Sheet
		String proName=elib.getDataFromExcelFile("Products", 2, 2)+jlib.generateRandomNumber();
		int timeSales=elib.getNumericDataFromExcelFile("Products", 2, 3);
		int timeSupport=elib.getNumericDataFromExcelFile("Products", 2, 4);
		
		//Step2:
		String salesStartDate=jlib.getSystemDateInYYYYMMDD();
		String startSupportDate=jlib.getSystemDateInYYYYMMDD();
		String endSalesDate=jlib.getRequireDateInYYYYMMDDFromCalendar(timeSales);
		String expiryDate=jlib.getRequireDateInYYYYMMDDFromCalendar(timeSupport);
		
		// Step3:Navigate to product Page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to Product  Page");
		HomePage hp=new HomePage(driver);
		hp.getProButton().click();
		
		// Step4:Navigate to CreateNew Product page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to new Product  Page");
		ProductsPage pg = new ProductsPage(driver);
		pg.getProButton().click();

		// Step5:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Fill all the details in New Product  Page");
		CreatingNewProductPage cnpg = new CreatingNewProductPage(driver);
		cnpg.createNewProWithSupportDateAndSalesDate(proName, salesStartDate,startSupportDate ,endSalesDate, expiryDate);

		// Step6:Verify the Product name
		ProductInfoPage pip = new ProductInfoPage(driver);
		boolean headerinfopro = pip.getHeaderInfo().getText().contains(proName);
		String actProName = pip.getEditPro().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(headerinfopro);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product headerInfo is verifed");
		sa.assertEquals(actProName, proName);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product Name is verifed");
		String actEditSalesStartDate=pip.getEditSalesStartDate().getText();
		sa.assertEquals(actEditSalesStartDate, salesStartDate);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Start Sales date is verifed");
		String actEditSupportStartDate=pip.getEditSupportStartDate().getText();
		sa.assertEquals(actEditSupportStartDate, startSupportDate);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Start Support date is verifed");
		String actEditSalesEndDate=pip.getEditSalesEndDate().getText();
		sa.assertEquals(actEditSalesEndDate, endSalesDate);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "End Sales date is verifed");
		String actExpiryDate=pip.getEditExpiryDate().getText();
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Expiry Support date is verifed");
		sa.assertEquals(actExpiryDate, expiryDate);
		sa.assertAll();
			
	}
	@Test(groups="RegressionTest")
	public void createProductWithProductImageInformationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//Step1:Read data fromExcel Sheet
		String proName=elib.getDataFromExcelFile("Products", 3, 2)+jlib.generateRandomNumber();
		String imgFilePath=elib.getDataFromExcelFile("Products", 3, 5);
		
		// Step2:Navigate to product Page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to Product  Page");
		HomePage hp=new HomePage(driver);
		hp.getProButton().click();
		
		// Step3:Navigate to CreateNew Product page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to new Product  Page");
		ProductsPage pg = new ProductsPage(driver);
		pg.getProButton().click();

		// Step4:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Fill all the details in New Product  Page");
		CreatingNewProductPage cnpg = new CreatingNewProductPage(driver);
		cnpg.createNewProWithProImageInformation(proName,imgFilePath);

		// Step5:Verify the Product name
		ProductInfoPage pip = new ProductInfoPage(driver);
		boolean headerinfopro = pip.getHeaderInfo().getText().contains(proName);
		String actProName = pip.getEditPro().getText();
		Assert.assertTrue(headerinfopro);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product headerInfo is verifed");
		Assert.assertEquals(actProName, proName);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Product Name is verifed");
	}
	
	
	
	
	
	
	
	
}
