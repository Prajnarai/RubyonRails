package com.rubyonrails.qa.test;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.HomePage;
import com.rubyonrails.qa.util.BrokenLinkUtil;
import com.rubyonrails.qa.util.TestUtil;

import junit.framework.Assert;

/**
 * This Test checks for the active and broken links from the home page:
 * https://rubyonrails.org/ , validates the title of the page, checks the header
 * and footer logo.
 * 
 * @author Prajna
 *
 */
public class HomePageTest extends TestBase {
	Logger log = Logger.getLogger(HomePageTest.class);
	HomePage homepage;
	TestUtil testutil;
	BrokenLinkUtil brokenLink;

	public HomePageTest() {
		super();

	}

	/**
	 * 
	 * Calls browserInitialization() from TestBase which will invoke the browser and
	 * the URL
	 */
	@BeforeClass
	public void setUp() throws Exception {
		log.info("Opening the browser and accessing the URL");
		browserInitialization();
		homepage = new HomePage();
		testutil = new TestUtil();
		brokenLink = new BrokenLinkUtil();
	}

	/**
	 * This test Calls findingLinks() from BrokenLinkUtil which checks if the links
	 * are active or broken
	 */

	@Test(priority = 1)
	public void checkBrokenLinksTest() {
		log.info("Checking if the links are working fine");
		brokenLink.findingLinks();
	}

	/**
	 * this test Validates the page Title
	 */
	@Test(priority = 2)
	public void validateTitleTest() {
		log.info("Validating the home page Title");
		String title = homepage.validateTitle();
		log.info("title of the home page: " + title);
		Assert.assertEquals(title, prop.getProperty("homeTitle"));

	}

	/**
	 * this test Validates the Header Logo
	 */
	@Test(priority = 3)
	public void logoDisplayTest() {
		log.info("Checking if the home page logo is displayed");
		boolean flag = homepage.validateLogo();
		Assert.assertTrue(flag);
	}

	/**
	 * this test Validates the Footer logo
	 */
	@Test(priority = 4)
	public void footerLogoTest() {
		log.info("Checking if the Footer logo of home page is displayed");
		boolean flogo = homepage.footerLogo();
		Assert.assertTrue(flogo);
	}

	/**
	 * this test Will close all open browser
	 */
	@AfterClass
	public void tearDown() {
		log.info("Closing the browser");
		driver.quit();
	}

}
