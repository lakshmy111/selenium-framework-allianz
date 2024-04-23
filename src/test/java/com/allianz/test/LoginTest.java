package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLoginTest(String userName, String password,  String expectedHeader) {
		
		LoginPage.enterUserName(driver, userName);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//assert the dashboard
		String actualHeader = driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	
	
	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String userName, String password, String expectedError) {
		LoginPage.enterUserName(driver, userName);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		String actualError = LoginPage.getErrorMessage(driver);
		Assert.assertEquals(actualError,expectedError);
		
	}

}
