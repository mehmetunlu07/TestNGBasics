package com.class04;

import org.testng.annotations.Test;

public class deneme {
	
	@Test(priority=1)
	public void a() {
		System.out.println("a");
	}
	
	@Test
	public void b() {
		System.out.println("b");
	}

}
