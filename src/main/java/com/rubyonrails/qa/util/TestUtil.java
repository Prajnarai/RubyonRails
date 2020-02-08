package com.rubyonrails.qa.util;

import com.rubyonrails.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static int PAGE_LOAD_TIMEOUT = 10;
	public static int IMPLICIT_WAIT = 10;
	public String fText = "This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License";
	public String sText="\"Rails\", \"Ruby on Rails\", and the Rails logo are trademarks of David Heinemeier Hansson. All rights reserved.";
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void frames() {
		driver.switchTo().frame("panel");
		
	}
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

}
