package com.rubyonrails.qa.test;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;
import com.rubyonrails.qa.pages.GuidesPages;
import com.rubyonrails.qa.pages.HomePage;
import com.rubyonrails.qa.util.TestUtil;

import junit.framework.Assert;

public class GuidePageTest extends TestBase{
     	GuidesPages guidepage;
		HomePage homepage;
		TestUtil testutil;
		public GuidePageTest() throws IOException {
			super(); //this will call TestBase constructor
			
		}	
		@BeforeClass
		public void setUp() throws Exception {
			browserInitialization();
			homepage = new HomePage();		
			guidepage = new GuidesPages();
			testutil= new TestUtil();
			
		}
		
		//Testcase for clicking the "Guides" link from the home page
		@Test
		public void clickOnGuidesMenuTest() { //
			guidepage.clickOnGuides();
		}
		//Testcase for clicking the "GuidesIndex" dropdown
		@Test
		public void clickOnGuidesIndexTest() {
			guidepage.guidesIndex();
		}
		//Testcase for clicking "Getting Started with Rails" from the dropdown
		@Test(dependsOnMethods = { "clickOnGuidesIndexTest" })
		public void startHereTest() {
			guidepage.getStartedRails();
		}
		//Testcase for clicking "Creating a New Rails Project" from the Chapters section
		@Test(dependsOnMethods = { "startHereTest" })
		public void clickOnCreatingRailProjectTest() {
			guidepage.clickOnCreatingRailProject();
			
		}
		
		//Testcase for clicking "Action Controller Overview" from the dropdown
		@Test(dependsOnMethods = { "clickOnGuidesIndexTest" })
		public void controllerTest() {
			guidepage.clickOnActionController();
		}
		
		//Testcase for clicking "What Does a Controller Do?" from the Chapters section
		@Test(dependsOnMethods = { "controllerTest" })
		public void whatActionControllerTest() {
			guidepage.whatActionController();
		}
		
		//TestCAse to verify the Footer texts.
		
		@Test
		public void footerText() {
			String firstText=guidepage.firstFooterText();
			String secondText=guidepage.secondFooterText();
			System.out.println(firstText);
			System.out.println("\n"+secondText);
			Assert.assertEquals(firstText, testutil.fText); //Verifying the text of footer
			Assert.assertEquals(secondText, testutil.sText);
			
			
		}
		
		@AfterClass
		public void backToHomeTest() {
			homepage.homeLogo();
		}
	}



