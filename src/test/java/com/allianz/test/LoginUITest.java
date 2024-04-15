package com.allianz.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUITest {
	
	@Test(invocationCount =3)
	public void titleTest() {
		System.out.println("test");
	}
	
	@Test
	public void getTitle() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("\r\n"
				+ "https://opensource-demo.orangehrmlive.com/web/index.php");
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");		
		
	}
	@Test
	public void applicationDescriptionTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("\r\n"
				+ "https://opensource-demo.orangehrmlive.com/web/index.php");
		String text = driver.findElement(By.xpath("//div[@class='orangehrm-copyright-wrapper']/p")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "OrangeHRM OS 5.6.1");
		
	}

}
