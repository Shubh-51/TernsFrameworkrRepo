package com.crm.tp.terns.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is created to read the data from Properties File.
 * You can read any data from properties file based on key.
 * In properties File all the data in the form of key and value pair.
 */

public class FileUtility {
	/**
	 * 
	 * @param String key
	 * @return String value
	 * @throws IOException
	 */

		public String getDataFromPropertiesFile(String key) throws IOException {
			FileInputStream fis=new FileInputStream("./ConfigData/local.properties");
			Properties prop=new Properties();
			prop.load(fis);
			String value=prop.getProperty(key);
		return value;
		}
}
