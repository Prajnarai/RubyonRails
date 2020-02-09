package com.rubyonrails.qa.test;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.ContributeToGitPages;
import com.rubyonrails.qa.pages.HomePage;

import junit.framework.Assert;

public class ContributeToGitPagesTest extends TestBase{
	Logger log = Logger.getLogger(ContributeToGitPagesTest.class);

	ContributeToGitPages contribute;
	HomePage homepage;
	public ContributeToGitPagesTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		log.info("Opening Browser");
		browserInitialization();
		homepage= new HomePage();
		contribute = new ContributeToGitPages();
	}
	/**
	 * this test clicks on Contribute to Git link
	 */
	@Test
	public void clickOnContributeToGitTest() {
		log.info("Click on Contribute to Git");
		contribute.clickOnContributeToGit();
	}
	/**
	 * This test validates the title of the clicked Contribute to Git page
	 */
	@Test
	public void validateTitleTest() {
		log.info("Checking the Title after clicking the page");
		String Title=homepage.validateTitle();
		log.info("Title of the page is" + Title);
		Assert.assertEquals("Contribute Title does not match", prop.getProperty("contributeTitle"), Title);
	}
	/**
	 * This test closes all opened browser
	 */
	@AfterClass
	public void tearDownTest() {
		log.info("Closing the browser");
		driver.quit();
	}
	
	
}
