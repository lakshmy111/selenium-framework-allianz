package com.allianz.test;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemoExtendReport {
	public static void main(String[] args) {
	
		//initialize report. run once before all @Test method
		
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	extent.attachReporter(spark);
	
	//before test method
	ExtentTest test = 	extent.createTest("MyFirstTest");
	
	//after test method
	 test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
	 
	 //after suite
	extent.flush();

}}

