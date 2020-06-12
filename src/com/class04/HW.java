package com.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class HW extends CommonMethods {
	
	
	@Test(dataProvider = "userDataFromExcel", groups = { "homework", "addEmp", "regression" })
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		wait(1);

		// add employee information
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = addEmp.employeeId.getAttribute("value");

		// click on Create Login Details
		click(addEmp.checkboxLoginDetails);
		wait(1);
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);
		wait(1);
		jsClick(addEmp.saveBtn);
		wait(1);

		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");

		// take screeshot
		takeScreenshot(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Rajo", "Capoor", "raj123", "AmirKhan_@123" },
				{ "Johny", "Smith", "john123", "AmirKhan_@123" }, { "Maryl", "Ann", "mary123", "AmirKhan_@123" },
				{ "Rohanis", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Alican", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testData/Excel.xlsx", "Employee");
	}

}
