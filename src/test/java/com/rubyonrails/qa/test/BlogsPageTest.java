package com.rubyonrails.qa.test;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.BlogsPage;
import com.rubyonrails.qa.pages.HomePage;
import com.rubyonrails.qa.util.BrokenLinkUtil;
import com.rubyonrails.qa.util.TestUtil;
import org.apache.commons.lang3.StringUtils;

import junit.framework.Assert;

public class BlogsPageTest extends TestBase {

	Logger log = Logger.getLogger(BlogsPageTest.class);

	BlogsPage blogpage;
	TestUtil testutil;
	BrokenLinkUtil brokenLink;
	HomePage homepage;

	public BlogsPageTest() {
		super();

	}

	@BeforeClass
	public void setUp() throws Exception {
		log.info("Initializing the browser");
		log.info("Opening the URL");
		browserInitialization();
		blogpage = new BlogsPage();
		testutil = new TestUtil();
		brokenLink = new BrokenLinkUtil();
		homepage = new HomePage();
	}

	/**
	 * This test is to Check for active and broken links
	 */
	@Test(priority = 2)
	@Ignore
	public void checkBrokenLinksTest() {
		log.info("Checking the links");
		brokenLink.findingLinks();
	}

	/**
	 * This test is to Click on Blog link
	 */

	@Test(priority = 1)
	public void clickOnBlogTest() {
		log.info("Clicking on the Blog");
		blogpage.clickOnBlog();
		String blogTitle = homepage.validateTitle();
		log.info("Title of blog page" + blogTitle);
		Assert.assertEquals(prop.getProperty("blogTitle"), blogTitle);
	}

	/**
	 * This test is to Click on ContributorsToRails link
	 */
	@Test(priority = 3)
	public void clickOnContributorsToRailsTest() {
		log.info("Clicking on 18 ContributorsToRailsTest ");
		blogpage.clickOnLinkContributors();
	}

	/**
	 * this test is to Click on Week list
	 */
	@Test(priority = 4)
	public void clickOnThisWeekTest() {
		log.info("Clicking on this week from the table");
		blogpage.clickOnThisWeek();
	}

	/**
	 * this test is to validate title of the table
	 */

	@Test(priority = 5)
	public void tableTitleTest() {
		log.info("==========Title of the table=====");
		String pageTitle = homepage.validateTitle();
		log.info("Title of Contribute page: " + pageTitle);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try {
		String titleOfTable = blogpage.tableTitle();
		log.info(titleOfTable);
		if (StringUtils.isNotBlank(titleOfTable)) {
			if (titleOfTable.contains("week")) {
				Assert.assertEquals("Title doesn't match", "Rails Contributors - This week\n" + "Showing 21 people",
						titleOfTable);
			} else if (titleOfTable.contains("Range")) {
				Assert.assertEquals("Title doesn't match", "Rails Contributors - Date Range\n" + "Showing 21 people",
						titleOfTable);
			}else {
				fail("Unknown title found");
			}
		}
		}catch(StaleElementReferenceException staleElementReferenceException) {
			staleElementReferenceException.printStackTrace();
		log.error("===Stale state exception occured, Please verify");
		}

		log.info("Title matches");

	}

	/**
	 * 
	 * This test will display the table content and validate the first row values
	 */
	@Test(priority = 6)
	public void displayTableContentsTest() throws InterruptedException { // this test will display all the contents of
																			// the table

		int rowCounts = blogpage.rowCount();
		int colCounts = blogpage.colCount();
		log.info("No of Rows: " + rowCounts);
		log.info("No of Rows: " + colCounts);
		log.info("Displaying the table data");
		for (int k = 1; k <= colCounts; k++) {
			String headings = driver.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[1]//th[" + k + "]"))
					.getText();
			System.out.print(headings + "      			 ");
		}
		System.out.println();

		for (int i = 2; i <= rowCounts; i++) {
			for (int j = 1; j <= colCounts; j++) {

				String value = driver
						.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[" + i + "]//td[" + j + "]")).getText();

				System.out.print(value + "     		");

			}
			System.out.println();
		}
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		Thread.sleep(2000L);

		try {
			log.info("verifying the 1st row data");
			Assert.assertEquals("1st row", prop.getProperty("val1"),
					driver.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[2]//td[1]")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			log.info("verifying the 2nd row data");
			Assert.assertEquals("2nd row", prop.getProperty("name"),
					driver.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[2]//td[2]")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			log.info("verifying the 3rd row data");
			Assert.assertEquals("3rd row", prop.getProperty("date"),
					driver.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[2]//td[3]")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			log.info("verifying the 4th row data");
			Assert.assertEquals("4th row", prop.getProperty("commit"),
					driver.findElement(By.xpath("//*[@id='table-wrap']//tbody//tr[2]//td[4]")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		log.info("Closing the browser");
		driver.quit();
	}
	/*
	 * @Test(priority = 6) public void clickOnRelease() { // test to click on
	 * release menu blogpage.clickOnRelease();
	 * 
	 * }
	 * 
	 * @Test(priority = 7) public void clickOnActionTest() { // test to click on
	 * ActionChangeLog blogpage.clickOnActionChangeLog(); testutil.navigateBack(); }
	 */

}
