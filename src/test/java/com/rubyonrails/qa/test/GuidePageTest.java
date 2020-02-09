package com.rubyonrails.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.GuidesPages;
import com.rubyonrails.qa.pages.HomePage;
import com.rubyonrails.qa.util.BrokenLinkUtil;
import com.rubyonrails.qa.util.TestUtil;

import junit.framework.Assert;

public class GuidePageTest extends TestBase {
	Logger log = Logger.getLogger(GuidePageTest.class);

	GuidesPages guidepage;
	HomePage homepage;
	TestUtil testutil;
	BrokenLinkUtil brokenLink;

	public GuidePageTest() throws IOException {
		super(); // this will call TestBase constructor

	}

	@BeforeClass
	public void setUp() throws Exception {
		browserInitialization();
		homepage = new HomePage();
		guidepage = new GuidesPages();
		testutil = new TestUtil();
		brokenLink = new BrokenLinkUtil();
	}

	// Testcase for clicking the "Guides" link from the home page
	@Test(priority = 1)
	public void clickOnGuidesMenuTest() { //
		log.info("Clicking on Guides");
		guidepage.clickOnGuides();

		log.info("Validating the title of the page");
		String guideTitle = homepage.validateTitle();
		log.info("Title of the page is :" + guideTitle);
		Assert.assertEquals(prop.getProperty("guideTitle"), guideTitle);

	}

	// TestCAse to verify the Footer texts.

	@Test(priority = 2)
	public void footerText() {
		log.info("Validatng the Footer Text");
		String firstText = guidepage.firstFooterText();
		String secondText = guidepage.secondFooterText();
		log.info(firstText);
		log.info(secondText);
		System.out.println("\n" + secondText);
		Assert.assertEquals(firstText, testutil.fText); // Verifying the text of footer
		Assert.assertEquals(secondText, testutil.sText);

	}

	// test to verify if there are any broken links in the page
	@Test(priority = 3)
	public void checkBrokenLinksTest() {
		log.info("Checking if the links are working fine");
		brokenLink.findingLinks();
	}

	// Testcase for clicking the "GuidesIndex" dropdown
	@Test(priority = 4)
	public void clickOnGuidesIndexTest() {
		log.info("clicking OnGuidesIndex");
		guidepage.guidesIndex();

	}

	@Test(priority = 5)
	public void controllerTest() throws InterruptedException {
		guidepage.clickOnActionController();

	}

	@AfterClass
	public void tearDown() {
		log.info("Closing the browser");
		driver.quit();
	}

}
