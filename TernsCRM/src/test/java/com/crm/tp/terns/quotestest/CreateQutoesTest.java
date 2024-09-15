package com.crm.tp.terns.quotestest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.tp.terns.basetest.BaseClass;

import com.crm.tp.terns.objectutility.CreatingNewOrganizationPage;
import com.crm.tp.terns.objectutility.CreatingNewProductPage;
import com.crm.tp.terns.objectutility.CreatingNewQuotePage;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.OrganizationInfoPage;
import com.crm.tp.terns.objectutility.OrganizationPage;
import com.crm.tp.terns.objectutility.ProductInfoPage;
import com.crm.tp.terns.objectutility.ProductsPage;
import com.crm.tp.terns.objectutility.QuoteInfoPage;
import com.crm.tp.terns.objectutility.QuotesPage;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;


public class CreateQutoesTest extends BaseClass {
	
	@Test(groups="SmokeTest")
	public void createQuoteWithMandatoryInformationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//Step1:Read The data From Excel
		String subject=elib.getDataFromExcelFile("Quotes",1,2)+jlib.generateRandomNumber();
		String quotestage=elib.getDataFromExcelFile("Quotes",1,3);
		String partialUrlOrg=elib.getDataFromExcelFile("Quotes",1,4);
		String orgName=elib.getDataFromExcelFile("Quotes",1,5)+jlib.generateRandomNumber();
		String orgdd=elib.getDataFromExcelFile("Quotes",1,6);
		String partialUrlQuote=elib.getDataFromExcelFile("Quotes",1,7);
		String userdd=elib.getDataFromExcelFile("Quotes",1,8);
		String billingAdd=elib.getDataFromExcelFile("Quotes",1,9);
		String partialUrlPro=elib.getDataFromExcelFile("Quotes",1,11);
		String proName=elib.getDataFromExcelFile("Quotes",1,12)+jlib.generateRandomNumber();
		String prodd=elib.getDataFromExcelFile("Quotes",1,13);
		String qty=elib.getDataFromExcelFile("Quotes",1,14);
		
		//Step2:navigate to Organization Page
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to Orgnization Page");
		HomePage hp=new HomePage(driver);
		hp.getOrgButton().click();
		//Step3:Navigate to createNewOrg Page
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to new Orgnization Page");
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrgButton().click();
		
		//Step4:Fill all the details to create new org
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate fill all the details to create new Organization page");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createNewOrg(orgName);

		//Step5:Verify the orgname
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		boolean headerInfo=oip.getHeaderInfoText().getText().contains(orgName);
		String actOrgName=oip.getEditorgName().getText();
		Assert.assertTrue(headerInfo);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Organization headerInfo is verifed");
		Assert.assertEquals(actOrgName,orgName);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Orgnization Name is verifed");
		Thread.sleep(2000);
		//Step6:Navigate to product Page
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to Product  Page");
		hp.getProButton().click();
		//Step7:Navigate to CreateNew Product page
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to new Product  Page");
		ProductsPage pg=new ProductsPage(driver);
		pg.getProButton().click();
		
		//Step8:Fill all the details
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Fill all the details in New Product  Page");
		CreatingNewProductPage cnpg=new CreatingNewProductPage(driver);
		cnpg.createNewPro(proName);
		
		//Step9:Verify the Product name
		ProductInfoPage pip=new ProductInfoPage(driver);
		boolean headerinfopro=pip.getHeaderInfo().getText().contains(proName);
		String actProName=pip.getEditPro().getText();
		Assert.assertTrue(headerinfopro);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Product headerInfo is verifed");
		Assert.assertEquals(actProName,proName);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Product Name is verifed");
		Thread.sleep(2000);
		
		//Step10:navigate to Quotes Page
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to quotes page");
		hp.navigateToQuotesModule();
		
		//step11:click on Create Quote Button
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Navigate to new quotes page");
		QuotesPage qp=new QuotesPage(driver);
		qp.getCreateQuoteButton().click();
		//step12: fill all the valid details 
		UtilityObjectClass.getExtentTest().log(Status.INFO,"Fill all the details in new Create Quote page");
		CreatingNewQuotePage cnqp=new CreatingNewQuotePage(driver);
		cnqp.createNewQuotewithAllMandatoryInfo(subject, quotestage, partialUrlOrg,orgName,orgdd,
				orgName,partialUrlQuote,userdd,billingAdd,partialUrlPro,proName,prodd,proName,qty);
		
		//Step12:Verify Quote Name
		QuoteInfoPage qip=new QuoteInfoPage(driver);
		boolean headerinfoqQuote=qip.getHeaderinfo().getText().contains(subject);
		String actSubjectName=qip.getActSubjectName().getText().trim();
		String actOrgName1=qip.getActOrgName().getText().trim();
		String actBillingAdd=qip.getActBillingAdd().getText().trim();
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(headerinfoqQuote);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote headerInfo page is verifed");
		sa.assertEquals(actSubjectName, subject);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote Subject is verifed");
		sa.assertEquals(actOrgName1,orgName);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote OrgName is verifed");
		sa.assertEquals(actBillingAdd,billingAdd);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote Billing Address is verifed");
		sa.assertAll();
	}

}
