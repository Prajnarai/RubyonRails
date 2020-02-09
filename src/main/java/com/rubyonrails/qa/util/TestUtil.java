package com.rubyonrails.qa.util;

import org.openqa.selenium.By;

import com.rubyonrails.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static int PAGE_LOAD_TIMEOUT = 10;
	public static int IMPLICIT_WAIT = 10;
	public String fText = "This work is licensed under a Creative Commons Attribution-ShareAlike 4.0 International License";
	public String sText="\"Rails\", \"Ruby on Rails\", and the Rails logo are trademarks of David Heinemeier Hansson. All rights reserved.";

	/**
	 * This method will navigate back the URL
	 */
	public void navigateBack() {
		driver.navigate().back();
	}
	/**
	 * To switch to the frame name " panel "
	 */
	
	public void firstFrame() {
		driver.switchTo().frame("panel");
		
	}
	/**
	 * To switch to the frame name " docwin "
	 */
	public void secondFrame() {
		driver.switchTo().frame("docwin");
	}
	/**
	 * To switch to the frame by class " video "
	 */
	public void videoFrame() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='video']")));
	}
	
	/**
	 * To switch back to main frame
	 */
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

}
