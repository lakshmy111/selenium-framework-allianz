package com.allianz.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	/** 
	 * Convert sheet in 2-D array excluding header
	 * @param path
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public static Object[][] getSheetIntoTwoDimentionalArray(String path, String sheetName) throws IOException{
		FileInputStream file = new FileInputStream(path); //src/test/resources/test_Data/HRMData.xlsx
		XSSFWorkbook book = new XSSFWorkbook(file) ;
		XSSFSheet sheet = book.getSheet(sheetName); //invalidLoginTest		
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount-1][cellCount];
		DataFormatter format = new DataFormatter();
				
		for (int r = 1; r<rowCount ; r++) {
			for (int c=0;c<cellCount;c++){
		
				data[r-1][c] = format.formatCellValue(sheet.getRow(r).getCell(c)); 
				}
		}
		
		book.close();
		file.close();
	
		return data;
	
	}
}
