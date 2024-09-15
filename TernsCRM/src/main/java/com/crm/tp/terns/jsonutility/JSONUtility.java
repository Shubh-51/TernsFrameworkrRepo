package com.crm.tp.terns.jsonutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * This Class is created to read the data from JSON files.
 * In JSON data present in the form of key and value pair.
 */

public class JSONUtility {
	/**
	 * 
	 * @param String key
	 * @return String value
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public String getDataFromJSONFile(String key) throws IOException, ParseException {
		FileReader fr=new FileReader("./ConfigData/appcommondata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject jsonobj=(JSONObject)obj;
		String value=jsonobj.get(key).toString();
		
	return value;
	}

}
