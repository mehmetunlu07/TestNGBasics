package com.class03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class hw1 extends CommonMethods {
	int i=1;
	
	@Test(dataProvider = "getData")
	public void AddEmloyee(String firstname, String lastname) {
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		addEmp.addEmployee(firstname, lastname);
		
		String newEmp=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		System.out.println(newEmp);
		
		SoftAssert sAssert=new SoftAssert();
		boolean isDisplayed=addEmp.newEmployee.isDisplayed();
		sAssert.assertTrue(isDisplayed, "New employee name is not displayed");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File souceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(souceFile, new File("screenshots/HRMS/picture"+i+".png"));
			i++;
		} catch (IOException e) {
			System.out.println("Screenshot was not taken");
			e.printStackTrace();

		}
		

	}

	@DataProvider
	public Object[][] getData(){
		Object[][]data= {   {"Adam","Smith"},
							{"Barn","Babil"},
							{"Cemil","Cazkir"},
							{"Davud","Demir"},
							{"Ekrem","Erdemir"}   };
		
		return data;
	}
	

}
