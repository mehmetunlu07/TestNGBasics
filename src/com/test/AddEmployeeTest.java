package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddEmployeePageElements;
import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

	@Test
	public void addEmployeePage() throws InterruptedException {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		
		 
		//wait(15);
		System.out.println(driver.getTitle());
		
		//driver.findElement(By.id("menu_pim_viewPimModule")).click();  //menu_pim_viewPimModule
		
		//driver.findElement(By.id("menu_pim_addEmployee")).click();   //firstName
		
		//driver.findElement(By.id("firstName")).sendKeys("David");
		addEmp.addEmployee(ConfigsReader.getProperty("firstname"), ConfigsReader.getProperty("lastname"));
		
		//sendText(addEmp.firstname, ConfigsReader.getProperty("firstname"));
		//sendText(addEmp.lastname, ConfigsReader.getProperty("lastname"));
		//sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
//		waitAndClick(addEmp.saveEmp);
		
		Thread.sleep(5000);
		
		//add assertion to verify that employee has been added successfully
		
		
	}


}
