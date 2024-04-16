package com.allianz.utils;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public String[][] invalidData() {
		String data[][];
		data = new String[][] {{"john","john123","Invalid credentials"},{"saul","saul123","Invalid credentials"}};
		return data;
	}
}
