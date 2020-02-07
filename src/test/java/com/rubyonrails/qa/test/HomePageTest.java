package com.rubyonrails.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.HomePage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{

	HomePage homepage;
	public HomePageTest() throws IOException {
		super();
		
	}

	@BeforeClass
	public void setUp() throws Exception {
		browserInitialization();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title = homepage.validateTitle();
		String homeTitle = "Ruby on Rails | A web-application framework that includes everything needed to create database-backed web applications according to the Model-View-Controller (MVC) pattern.";		
		Assert.assertEquals(title, homeTitle);
	}
	
	@Test(priority=2)
	public void logoDisplayTest() {
		boolean flag =homepage.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void clickOnLinkEverythingTest() {
		homepage.clickOnLinkEverything();
		homepage.backToHome();
	}
	
	@Test(priority=4)
	public void clickOnLinkLearnTest() {
		homepage.clickOnLinkLearn();
		homepage.homeLogo();
	}
		
	@Test(priority=5)
	public void clickOnVersionTest() {
		homepage.clickOnVersion();
		driver.navigate().back();
	}
	@Test(priority=6)
	public void baseCampTest() {
		homepage.linkBasecamp();
		driver.navigate().back();
	}
	@Test(priority=7)
	public void linkTwitter() {
		homepage.railsOnTwitter();
		driver.navigate().back();
	}
	@Test(priority=8)
	public void weekInRails() {
		homepage.weekInRails();
		driver.navigate().back();
	}
	@Test(priority=9)
	public void footerConductlinkTest() {
		homepage.footerConduct();
		homepage.backToHome();
	}
	
	@Test(priority=10)
	public void footerLicenseLinkText() {
		homepage.footerLicense();
		driver.navigate().back();
	}
	@Test(priority=11)
	public void footerLogoTest() {
		boolean flogo = homepage.footerLogo();
		Assert.assertTrue(flogo);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
}
	
}
