package com.allianz.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUITest extends AutomationWrapper {
	
	
	@Test(invocationCount =3)
	public void titleTest() {
		System.out.println("test");
	}
	
	@Test
	public void getTitle() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");		
		
	}
	@Test
	public void applicationDescriptionTest() {

		String text = driver.findElement(By.xpath("//div[@class='orangehrm-copyright-wrapper']/p")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "OrangeHRM OS 5.6.1");
		
	}

}
