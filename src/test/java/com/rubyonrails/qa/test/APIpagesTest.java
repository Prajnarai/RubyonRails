package com.rubyonrails.qa.test;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.ApiPages;
import com.rubyonrails.qa.util.BrokenLinkUtil;
import com.rubyonrails.qa.util.TestUtil;

public class APIpagesTest extends TestBase{
	Logger log = Logger.getLogger(APIpagesTest.class);
	
	ApiPages apipages; 
	TestUtil testutil;
	BrokenLinkUtil brokenLink;
	public APIpagesTest() {
		super();
	}
	@BeforeClass
	public void setUp() throws Exception {
		log.info("Opening Browser");
		browserInitialization();
		apipages=new ApiPages();
		testutil = new TestUtil();
		brokenLink = new BrokenLinkUtil();
	}
	/**
	 * test to Click on API 
	 */
	@Test(priority=1)
	public void clickOnAPITest() {
		log.info("Clicking on API menu");
		apipages.clickOnAPI();
	}
	/**
	 * test to Check for Broken Links
	 */
	@Test(priority=2)
	public void checkBrokenLinksTest() {
		log.info("Checking for Active and broken links");
		testutil.secondFrame();
		brokenLink.findingLinks();
		testutil.defaultContent();
	}

/**
 * test to Click on ActionController	
 */
	@Test(priority=3)
	public void clickOnActionControllerTest() {
		log.info("Clicking on Action Controller");
		testutil.firstFrame();
		apipages.clickOnActionController();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testutil.defaultContent();
	}
	/**
	 *test to Click on AbstractController
	 */
	@Test(priority=4)
		public void clickOnAbstractControllerTest()	{
		log.info("Clicking on Abstarct Controller");
		testutil.firstFrame();
		apipages.clickOnAbstractController();
		testutil.defaultContent();
		}
	
	/**
	 * test to Click on Search
	 */
	
	@Test(priority=5)
	public void searchTest() {
	log.info("Click on Search ");
		testutil.firstFrame();
		apipages.search();
		
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
