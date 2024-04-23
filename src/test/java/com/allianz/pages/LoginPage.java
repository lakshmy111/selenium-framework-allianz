package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void enterUserName(WebDriver driver, String userName) {
		driver.findElement(By.name("username")).sendKeys(userName);
	}
	
	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	//get invalid error messgae - shoudl return
	public static String getErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
	}
}
