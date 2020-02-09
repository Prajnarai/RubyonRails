package com.rubyonrails.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;


public class HomePage extends TestBase{

	//PageFactory
	
	/**
	 * Locator for Latest version — Rails 6.0.2.1 
	 */
	@FindBy(xpath="//a[contains(text(),'Latest version')]")
	WebElement version;
	/**
	 * Locator for Logo
	 */
	@FindBy(xpath="//p[@class='mobile-center']//img")
	WebElement image;
	
	/**
	 * Locator for links
	 */
	
	@FindBy(xpath="//a[contains(text(),'everything you need')]")
	WebElement linkeverything;
	
	@FindBy(xpath="//a[contains(text(),'you can learn it')]")
	WebElement linklearn;
	
	@FindBy(xpath="//a[contains(text(),'our large, friendly community')]")
	WebElement linkcommunity;
	
	@FindBy(xpath="//a[contains(text(),'Back to homepage')]")
	WebElement backhome;
	
	@FindBy(xpath="//a[contains(text(),'Basecamp')]")
	WebElement basecamp;
	
	@FindBy(xpath="//a[contains(text(),'Rails on Twitter')]")
	WebElement twitter;
	
	@FindBy(xpath="//a[contains(text(),'This Week in Rails')]")
	WebElement weekinrails;
	
	@FindBy(xpath="//a[contains(text(),'Conduct')]")
	WebElement conduct;
	
	@FindBy(xpath="//a[contains(text(),'License')]")
	WebElement license;
	
	@FindBy(xpath="//a[contains(text(),'rubyonrails.org:')]")
	WebElement home;
	
	@FindBy(xpath="//div[@id='player']//button[@aria-label='Play']")
	WebElement play;
	
	public void playVideo() { //play the video
		play.click();
	}
	
	
	/**
	 * Locators for Footer logo
	 */
	@FindBy(xpath="//section[@class='more']//figure//img")
	WebElement footerlogo;
	
	//Initializing Page factory 
	
	public HomePage() {		
			PageFactory.initElements(driver, this);
		}
	/**	
	 * Validating the Title of page
	 */

	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	/**	
	 * Validating the Logo of header
	 */
	
	public boolean validateLogo() {
		return image.isDisplayed();
	}
	/**
	 * 
	 *Validating the Logo of footer page
	 */
	public boolean footerLogo() {
		return footerlogo.isDisplayed();
	}
	
	/**
	 * Below methods are to verify if the links are clickable
	 */
	public void clickOnVersion() {
		version.click();
	}
	
	public void clickOnLinkEverything() {
		linkeverything.click();
	}
	public void clickOnLinkLearn() {
		linklearn.click();
	}
	
	public void clickOnLinkCommunity() {
		linkcommunity.click();
	}
	
	public void backToHome() {
		backhome.click();
	}
	
	public void homeLogo() {
		home.click();
	}
	
	public void linkBasecamp() {
		basecamp.click();
	}
	public void railsOnTwitter() {
		twitter.click();
	}
	public void weekInRails() {
		weekinrails.click();
	}
	public void footerConduct(){
		conduct.click();
	}
	public void footerLicense() {
		license.click();
	}
	
	
	
}
