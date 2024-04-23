package com.allianz.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2ExcelTest {
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("src/test/resources/test_Data/HRMData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file) ;
		XSSFSheet sheet = book.getSheet("invalidLoginTest");
		
		String value = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount-1][cellCount];
		DataFormatter format = new DataFormatter();
		
		
		for (int r = 1; r<rowCount ; r++) {
			for (int c=0;c<cellCount;c++){
				//String value1 =    //sheet.getRow(r).getCell(c).getStringCellValue();
				//System.out.println(value1);
				
				data[r-1][c] = format.formatCellValue(sheet.getRow(r).getCell(c)); 
				}
		}
		
		book.close();
		file.close();
		
		
	}

}
