package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.DashboardPage;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLoginTest(String userName, String password,  String expectedHeader) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword( password);
		loginPage.clickOnLogin();
		
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//assert the dashboard
		DashboardPage dashboardPage = new DashboardPage(driver);
		String actualHeader = dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String userName, String password, String expectedError) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName( userName);
		loginPage.enterPassword( password);
		loginPage.clickOnLogin();
		String actualError = loginPage.getErrorMessage();
		Assert.assertEquals(actualError,expectedError);
		
	}

}
