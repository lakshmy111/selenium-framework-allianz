package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords{
	
	private WebDriver driver;
	private By userNameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//button[normalize-space()='Login']");
	private By errorLocator = By.xpath("//p[contains(normalize-space(),'Invalid')]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public  void enterUserName( String userName) {
		sendInputText(userNameLocator, userName);
		//this.driver.findElement(userNameLocator).sendKeys(userName);
	}
	
	public  void enterPassword( String password) {
		sendInputText(passwordLocator, password);
		//driver.findElement(passwordLocator).sendKeys(password);
	}
	public  void clickOnLogin()
	{
		clickElement(loginLocator);
		}
	
	//get invalid error messgae - shoudl return
	public  String getErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}
	
	
}
