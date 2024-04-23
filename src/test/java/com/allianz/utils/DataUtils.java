package com.allianz.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public String[][] invalidData() {
		String data[][];
		data = new String[][] {{"john","john123","Invalid credentials"},{"saul","saul123","Invalid credentials"}};
		return data;
	}
	
	@DataProvider
	public Object[][] commonDataProvider(Method mtd) throws IOException{
		//current test name is sheet name
		String currentTestName = mtd.getName();
		return ExcelUtils.getSheetIntoTwoDimentionalArray("src/test/resources/test_data/HRMData.xlsx", currentTestName);
	}
	
}
