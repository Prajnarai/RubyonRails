package com.rubyonrails.qa.test;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.ApiPages;
import com.rubyonrails.qa.util.TestUtil;

public class APIpagesTest extends TestBase{
	
	ApiPages apipages; 
	TestUtil testutil;
	public APIpagesTest() {
		super();
	}
	@BeforeClass
	public void setUp() throws Exception {
		browserInitialization();
		apipages=new ApiPages();
		testutil = new TestUtil();
	}
	
	@Test(priority=1)
	public void clickOnAPITest() {
		apipages.clickOnAPI();
	}
	
	
	@Test(priority=2)
	public void clickOnActionControllerTest() {
		testutil.frames();
		apipages.clickOnActionController();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testutil.defaultContent();
	}
	
	@Test(priority=3)
		public void clickOnAbstractControllerTest()	{
		testutil.frames();
		apipages.clickOnAbstractController();
		testutil.defaultContent();
		}
	
	
	
	@Test(priority=4)
	public void searchTest() {
	
		testutil.frames();
		apipages.search();
		
	}
}
