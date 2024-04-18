package com.allianz.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class AddEmployeeTest extends AutomationWrapper {
	
	@Test
	public void uploadDisplayPictureTest() throws IOException {
		File file = new File("src/test/resources/Files/dummy.pdf");
		String path = file.getAbsolutePath();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-header-container']//button")).click();
		//driver.findElement(By.xpath("//div[@class='oxd-file-div oxd-file-div--active']/button")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
		
		String actualError = driver.findElement(By.xpath("//span[contains(normalize-space(), 'File type')]")).getText();
		String expectedError = "File type not allowed";
		Assert.assertTrue(actualError.contains(expectedError));
		
		
		//Runtime.getRuntime().exec("C:\\Automation Session\\automation_workspace\\HealthManagementAutomation\\src\\test\\resources\\UploadFile.exe");
		
		//click on pim menu. click on add employee
		//upload invalid image eg pdf file instead of image
	}

}
