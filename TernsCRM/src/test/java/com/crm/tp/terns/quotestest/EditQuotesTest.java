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
import com.crm.tp.terns.objectutility.EditingQuoteInfoPage;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.OrganizationInfoPage;
import com.crm.tp.terns.objectutility.OrganizationPage;
import com.crm.tp.terns.objectutility.ProductInfoPage;
import com.crm.tp.terns.objectutility.ProductsPage;
import com.crm.tp.terns.objectutility.QuoteInfoPage;
import com.crm.tp.terns.objectutility.QuotesPage;
import com.crm.tp.terns.webdriverutility.UtilityObjectClass;


public class EditQuotesTest extends BaseClass{
	
	@Test(groups="RegressionTest")
	public void createQuoteAndEditSubjectOfQuoteTest() throws EncryptedDocumentException, IOException, InterruptedException{

		//Step1:Read The data From Excel
		String subject=elib.getDataFromExcelFile("Quotes",4,2)+jlib.generateRandomNumber();
		String quotestage=elib.getDataFromExcelFile("Quotes",4,3);
		String partialUrlOrg=elib.getDataFromExcelFile("Quotes",4,4);
		String orgName=elib.getDataFromExcelFile("Quotes",4,5)+jlib.generateRandomNumber();
		String orgdd=elib.getDataFromExcelFile("Quotes",4,6);
		String partialUrlQuote=elib.getDataFromExcelFile("Quotes",4,7);
		String userdd=elib.getDataFromExcelFile("Quotes",4,8);
		String billingAdd=elib.getDataFromExcelFile("Quotes",4,9);
		String partialUrlPro=elib.getDataFromExcelFile("Quotes",4,11);
		String proName=elib.getDataFromExcelFile("Quotes",4,12)+jlib.generateRandomNumber();
		String prodd=elib.getDataFromExcelFile("Quotes",4,13);
		String qty=elib.getDataFromExcelFile("Quotes",4,14);
		String searchQuoteDD=elib.getDataFromExcelFile("Quotes",4,15);
		String EditSubjectName=elib.getDataFromExcelFile("Quotes",4,16)+jlib.generateRandomNumber();
		
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
		
		
		
		//Step13:Navigate to Quotes page
		qp.getQuoteButton().click();
		qp.searchQuoteWithQuoteName(searchQuoteDD, subject);
		
		//Step14:Edit subject 
		EditingQuoteInfoPage eqip=new EditingQuoteInfoPage(driver);
		eqip.editSubject(EditSubjectName);
		
		//Step15:Click on That Specific Quote to verify the edited deatils
		qp.getQuoteName().click();
		QuoteInfoPage qip=new QuoteInfoPage(driver);
		boolean headerinfoqQuote=qip.getHeaderinfo().getText().contains(EditSubjectName);
		String actSubjectName=qip.getActSubjectName().getText().trim();
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(headerinfoqQuote);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote headerInfo page is verifed");
		sa.assertEquals(actSubjectName, EditSubjectName);
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Quote Subject is verifed");
		sa.assertAll();
		
	}

}
