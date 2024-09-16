package com.crm.tp.terns.vendorstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.tp.terns.basetest.BaseClass;
import com.crm.tp.terns.objectutility.CreatingNewVendorPage;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.VendorInfoPage;
import com.crm.tp.terns.objectutility.VendorsPage;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;


public class VendorTest extends BaseClass {
	
	@Test(groups="SmokeTest")
	public void createVendorTest() throws EncryptedDocumentException, IOException {

		// Step1:Read the data From ExcelSheet
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Read the data from excel sheet");
		String venName = elib.getDataFromExcelFile("Vendors", 1, 2) + jlib.generateRandomNumber();

		// Step2:Navigate to vendor page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to vendor page");
		HomePage hp = new HomePage(driver);
		hp.navigateToVendorsModule();

		// Step3:navigate to create New Vendor Page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to Create New vendor page");
		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateNewVendorButton().click();

		// Step4:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Fill all the details");
		CreatingNewVendorPage cvp = new CreatingNewVendorPage(driver);
		cvp.createNewVendor(venName);

		// Step5:Verify the details
		VendorInfoPage vip = new VendorInfoPage(driver);
		boolean headerinfo = vip.getHeaderinfo().getText().contains(venName);
		Assert.assertTrue(headerinfo);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Header info Is verified");
		String actVenName = vip.getActVenName().getText();
		Assert.assertEquals(actVenName, venName);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Vendor name  Is verified");
	}

	@Test(groups="RegressionTest")
	public void CreatevendorWithGLDDTest() throws EncryptedDocumentException, IOException {
		
		// Step1:Read the data From ExcelSheet
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Read the data from excel sheet");
		String venName= elib.getDataFromExcelFile("Vendors", 2, 2) + jlib.generateRandomNumber();
		String glddText= elib.getDataFromExcelFile("Vendors", 2, 3);

		// Step2:Navigate to vendor page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to vendor page");
		HomePage hp = new HomePage(driver);
		hp.navigateToVendorsModule();

		// Step3:navigate to create New Vendor Page
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Navigate to Create New vendor page");
		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateNewVendorButton().click();

		// Step4:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Fill all the details");
		CreatingNewVendorPage cvp = new CreatingNewVendorPage(driver);
		cvp.createNewVendorWithGLDD(venName, glddText);

		// Step5:Verify the details
		VendorInfoPage vip = new VendorInfoPage(driver);
		boolean headerinfo = vip.getHeaderinfo().getText().contains(venName);
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(headerinfo);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Header info Is verified");
		String actVenName = vip.getActVenName().getText();
		sa.assertEquals(actVenName, venName);
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Vendor name  Is verified");
		String actGLDDText=vip.getActGLDDText().getText();
		sa.assertEquals(actGLDDText, glddText);
	}
}
