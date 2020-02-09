package com.rubyonrails.qa.test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.HomePage;
//import com.rubyonrails.qa.pages.HomePage;
import com.rubyonrails.qa.util.TestUtil;

public class YoutubeVideoTest extends TestBase {

	HomePage homepage;
	TestUtil testutil;

	public YoutubeVideoTest() {
		super();

	}

	@Test
	public void setup() throws Exception {
		browserInitialization();
		testutil = new TestUtil();
		testutil.videoFrame();
		homepage = new HomePage();

		homepage.playVideo();
		Actions builder = new Actions(driver);
		WebElement we = driver.findElement(By.className("ytp-chrome-bottom"));
		Action mouseMovement = builder.moveToElement(we).build();
		mouseMovement.perform();
		we.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement titleText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-title-link")));
		System.out.println(titleText.getText());

		WebElement time = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ytp-time-current")));
		System.out.println(time.getText());

	}

}
