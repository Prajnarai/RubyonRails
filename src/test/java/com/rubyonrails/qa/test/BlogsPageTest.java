package com.rubyonrails.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.BlogsPage;
import com.rubyonrails.qa.util.TestUtil;

public class BlogsPageTest extends TestBase {

	BlogsPage blogpage;
	TestUtil testutil;

	public BlogsPageTest() {
		super();

	}

	@BeforeClass
	public void setUp() throws Exception {
		browserInitialization();
		blogpage = new BlogsPage();
		testutil = new TestUtil();

	}

	@Test(priority = 1)
	public void clickOnBlogTest() {
		blogpage.clickOnBlog();
	}

	@Test(priority = 2)
	public void clickOnContributorsToRailsTest() {
		blogpage.clickOnLinkContributors();
	}

	@Test(priority = 3)
	public void clickOnThisWeekTest() {
		blogpage.clickOnThisWeek();
	}

	@Test(priority = 4)
	public void tableTitleTest() {
		String titleOfTable = blogpage.tableTitle();
		System.out.println(titleOfTable);
		// Assert.assertEquals(titleOfTable, actual);

	}

	@Test(priority = 5)
	public void displayTableContentsTest() { // this test will display all the contents of the table
		int rowCounts = blogpage.rowCount();
		int colCounts = blogpage.colCount();
		System.out.println("No of Rows: " + rowCounts);
		System.out.println("No of Rows: " + colCounts);

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
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		blogpage.clickOnBlog();

	}

	@Test(priority = 6)
	public void clickOnRelease() { // test to click on release menu
		blogpage.clickOnRelease();

	}

	@Test(priority = 7)
	public void clickOnActionTest() { // test to click on ActionChangeLog
		blogpage.clickOnActionChangeLog();
		testutil.navigateBack();
	}

}
