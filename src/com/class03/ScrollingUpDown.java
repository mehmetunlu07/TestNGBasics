package com.class03;

import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class ScrollingUpDown extends CommonMethods{
	
	@Test
	public void scrollUpDown() {
				
		wait(2);
		scrollDown(1000);
		wait(2);
		scrollUp(400);
		wait(2);
		scrollDown(300);
		wait(2);
		
		
	}

}
