package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {
	
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id = "employeeId")
	public WebElement employeeId;
	
	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;   
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement newEmployee;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void addEmployee(String first, String last) {
		sendText(firstName, first);
		sendText(lastName, last);
		jsClick(saveBtn);
	}

}
