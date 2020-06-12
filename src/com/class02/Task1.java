package com.class02;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
// See the order of execution before and after the priority and enable attributes
// before priority test order= 5-1-4-2-3
//  after priority test order= 4-3-2-1
public class Task1 {
  @Test(priority=4)
  public void firstTest() {
	  System.out.println("First test");
  }
  
  @Test(priority=3)
  public void secondTest() {
	  System.out.println("Second test");
  }
  
  @Test(priority=2)
  public void thirdTest() {
	  System.out.println("Third test");
  }
  
  @Test(priority=1)
  public void fourthTest() {
	  System.out.println("Fourth test");
  }
  
  @Test(priority=0, enabled=false)
  public void fifthTest() {
	  System.out.println("Fifth test");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("---Before method---");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("---After method---");
  }

 

}
