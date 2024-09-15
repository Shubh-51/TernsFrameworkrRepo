package sampletest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.tp.terns.basetest.BaseClass;
import com.crm.tp.terns.objectutility.CreatingNewQuotePage;
import com.crm.tp.terns.objectutility.HomePage;
import com.crm.tp.terns.objectutility.QuotesPage;

public class TYP extends BaseClass{
	@Test
	public void qWERT() throws EncryptedDocumentException, IOException {
		String subject=elib.getDataFromExcelFile("Quotes",1,2)+jlib.generateRandomNumber();
		String quotestage=elib.getDataFromExcelFile("Quotes",1,3);
		String partialUrlOrg=elib.getDataFromExcelFile("Quotes",1,4);
		String orgName=elib.getDataFromExcelFile("Quotes",1,5)+jlib.generateRandomNumber();
		String orgdd=elib.getDataFromExcelFile("Quotes",1,6);
		String partialUrlQuote=elib.getDataFromExcelFile("Quotes",1,7);
		String userdd=elib.getDataFromExcelFile("Quotes",1,8);
		String billingdAdd=elib.getDataFromExcelFile("Quotes",1,9);
		String partialUrlPro=elib.getDataFromExcelFile("Quotes",1,11);
		String proName=elib.getDataFromExcelFile("Quotes",1,12)+jlib.generateRandomNumber();
		String prodd=elib.getDataFromExcelFile("Quotes",1,13);
		String qty=elib.getDataFromExcelFile("Quotes",1,14);
		HomePage hp=new HomePage(driver);
		hp.navigateToQuotesModule();
		
		//step6:click on Create Quote Button 
		QuotesPage qp=new QuotesPage(driver);
		qp.getCreateQuoteButton().click();
		
		//step7: fill all the valid details 
		CreatingNewQuotePage cnqp=new CreatingNewQuotePage(driver);
		cnqp.createNewQuotewithAllMandatoryInfo(subject, quotestage, partialUrlOrg,orgName,orgdd,
				orgName,partialUrlQuote,userdd,billingdAdd,partialUrlPro,proName,prodd,proName,qty);
		
		System.out.println("thankyou");
		
	}

}
