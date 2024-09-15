package sampletest;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.crm.tp.terns.databaseutility.DataBaseUtility;

import com.crm.tp.terns.jsonutility.JSONUtility;
import com.crm.tp.terns.webdriverutility.JavaUtility;




public class ReadDataFromJsonFile {
	@Test
	public  void readData()  throws IOException, ParseException, SQLException {
		 JSONUtility jsonlib=new JSONUtility();
		String browser=jsonlib.getDataFromJSONFile("browser");
		System.out.println(browser);
		
		
	Assert.fail();
	}
	@Test
	public void readDataFromDb() throws SQLException {
		DataBaseUtility dlib=new DataBaseUtility();
		dlib.getDatabaseConnection();
		ResultSet set=dlib.exceuteSelectQuery("select * from leads");
		while(set.next()) {
			String data=set.getString(1);
			System.out.println(data);
		}
		
	}
	
	@Test
	public void getTime() {
		JavaUtility jlib=new JavaUtility();
		String systemdate=jlib.getSystemDateInYYYYMMDD();
		System.out.println(systemdate);
		String requiredate=jlib.getRequireDateInYYYYMMDDFromCalendar(30);
		System.out.println(requiredate);
	}

	
	
	

}
