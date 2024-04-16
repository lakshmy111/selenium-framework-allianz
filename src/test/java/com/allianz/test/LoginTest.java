package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//assert the dashboard
		String actualHeader = driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin11111");
		driver.findElement(By.name("password")).sendKeys("admin123xxxxxx");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		String actualError = driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, "Invalid credentials");
		
	}

}
