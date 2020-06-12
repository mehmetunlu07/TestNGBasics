package com.review;
// go to https://www.saucedemo.com
//    @Test
//	  sign in
//	  verify the products text appears
//	  quit
//  @Test
//	go to https://www.saucedemo.com
//	sign in
//	on the sorting dropdown select Price (low to high)
//	verify product Sauce Labs Onesi appears first
import org.testng.annotations.Test;

import com.utils.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifySaucedemo extends CommonMethods {

	@Test
	public void verifyProductText() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		String expectedText = "Sauce Labs Backpack";
		String actualText = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		Assert.assertEquals(actualText, expectedText, "Product Text did not verified");

	}

	@BeforeMethod
	public void navigateToUrl() {
		setUp();
	}

	@AfterMethod
	public void close() {
		// tearDown();
	}

}
