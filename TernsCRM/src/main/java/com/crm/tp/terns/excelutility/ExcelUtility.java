package com.crm.tp.terns.excelutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is created to read the data from excel.
 * Find last row number.
 * Find last Cell number.
 * Data back into excel sheet
 */

public class ExcelUtility {
	
	public String getDataFromExcelFile(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		/**
		 * @param String
		 * @param int
		 * @param int
		 * @return String
		 * @throws EncryptedDocumentException
		 * @thows  IOException 
		 */
		FileInputStream fis=new FileInputStream("./TestScriptData/TestScriptData_terns.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		String value=sh.getRow(rowno).getCell(cellno).toString();
		wb.close();
	return 	value;
	}
	
	public int getNumericDataFromExcelFile(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		/**
		 * @param String
		 * @param int
		 * @param int
		 * @return int
		 * @throws EncryptedDocumentException
		 * @thows  IOException 
		 */
		FileInputStream fis=new FileInputStream("./TestScriptData/TestScriptData_terns.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int value=(int)sh.getRow(rowno).getCell(cellno).getNumericCellValue();
		wb.close();
	return 	value;
	}

}
