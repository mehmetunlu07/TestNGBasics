package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

/**
 * test 1.titleValidation
 *      2.logoValidation
 *      3.validLogin()
 *      4.Validate that Welcome Admin is displayed
 *		Check the reports in test-output folder
 */
public class Hw1 extends CommonMethods{
	
//	@BeforeMethod
//	public void openAndNavigate() {
//		setUp();
//	}
//	
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
	
	@Test
	public void titleValidation() throws InterruptedException {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title validation  passed");
		}else {
			System.out.println("Title validation  failed");
		}
		Thread.sleep(2000);
	}
	
	@Test
	public void logoValidation() throws InterruptedException {
		WebElement logo=driver.findElement(By.xpath("//img[contains(@src, '/syntax.png')]"));
		boolean isDisplayed=logo.isDisplayed();
		if(isDisplayed) {
			System.out.println("Logo validation passed");
		}else {
			System.out.println("Logo validation failed");
		}
		Thread.sleep(2000);
	}
	
	
	
	@Test
	public void validLogin() throws InterruptedException {
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username,ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password,ConfigsReader.getProperty("password"));
		
		WebElement login=driver.findElement(By.id("btnLogin"));
		click(login);
		Thread.sleep(2000);
	}
	
	@Test
	public void welcomeAdminValidation() throws InterruptedException {
		String username=ConfigsReader.getProperty("username");
		validLogin();
		WebElement welcome=driver.findElement(By.id("welcome"));
		//boolean flag=welcome.isDisplayed();   //2.option to validate
		String welcomeAdmin=welcome.getText();
		
		if(welcomeAdmin.contains(username)) {
			System.out.println("Welcome Admin validation passed");
		}else {
			System.out.println("Welcome Admin validation failed");
		}
		Thread.sleep(2000);
	}

}
