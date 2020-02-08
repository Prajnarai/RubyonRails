package com.rubyonrails.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;




public class GuidesPages extends TestBase{
	
	/**
	 * this is the web element locator of Guides link
	 */
	@FindBy(xpath ="//a[contains(text(),'Guides')]")
	WebElement guides;
	
	/**
	 * web element locator of Guides Index drop down
	 */
	@FindBy(xpath="//a[@id='guidesMenu']")
	WebElement guidesindex;
	
	/**
	 * web element locator of Getting Started with Rails link from drop down
	 */
	@FindBy(xpath="//a[contains(text(),'Getting Started with Rails')]")
	WebElement getstarted;
	
	//Locator of Creating new rail project
	@FindBy(xpath="//ol[@class='chapters']//a[contains(text(),'Creating a New Rails Project')]")
	WebElement railproject;
	
	//Locator of Action Controller Overview from drop down
	@FindBy(xpath="//a[contains(text(),'Action Controller Overview')]")
	WebElement actioncontroller;
	
	//Locator of What Does a Controller Do under Action Controller Overview
	@FindBy(xpath="//ol[@class='chapters']//a[contains(text(),'What Does a Controller Do?')]")
	WebElement controller;
	
	//Locator to fetch Footer text.
	@FindBy(xpath="//div[@id='footer']//p[1]")
	WebElement firsttext;
	
	@FindBy(xpath="//div[@id='footer']//p[2]")
	WebElement secondtext;
	
	
	/**
	 * this method is used to click on the Guides link
	 */
	public void clickOnGuides() {
		guides.click();
	}
	
	/**
	 * method to click on GuidesIndex dropdown menu
	 */
	public void guidesIndex() {
		guidesindex.click();
	}
	/**
	 * method to click on Getting Started with Rails link from the drop down
	 * 
	 */
	public void getStartedRails() {
		getstarted.click();
	}
	
	/**
	 * this method is used to click on Creating new rail project
	 */
	public void clickOnCreatingRailProject() {
		railproject.click();
	}
	/**
	 * this method is used to click on Action Controller from drop down
	 */
	public void clickOnActionController() {
		actioncontroller.click();
	}
	/**
	 * this method is used to click on What does Controller do option from Action Controller from drop down
	 */
	public void whatActionController() {
		controller.click();
	}
	/**
	 * this method is used to fetch the footer text
	 * @return 
	 */
	public String firstFooterText() {
		return firsttext.getText();
	
	}
	/**
	 * this method is used to fetch the footer text
	 * @return 
	 */
	public String secondFooterText() {
		return secondtext.getText();
	
	}
	
	/**
	 * Constructor to initialize the PageFactory
	 */
	public GuidesPages() throws IOException{
		PageFactory.initElements(driver, this);
	}
	

}
