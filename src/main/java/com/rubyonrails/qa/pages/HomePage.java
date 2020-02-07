package com.rubyonrails.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;

public class HomePage extends TestBase{

	//PageFactory
	
	@FindBy(xpath="//a[contains(text(),'Latest version')]")
	WebElement version;
	
	@FindBy(xpath="//p[@class='mobile-center']//img")
	WebElement image;
	
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
	
	@FindBy(xpath="//section[@class='more']//figure//img")
	WebElement footerlogo;
	
	@FindBy(xpath="//a[contains(text(),'rubyonrails.org:')]")
	WebElement home;
	
	
	
	
	//Initializing Page factory 
	
	public HomePage() throws IOException{		
			PageFactory.initElements(driver, this);
		}
		
	//Validating the Title of page

	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	//validating the logo
	
	public boolean validateLogo() {
		return image.isDisplayed();
	}
	
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
	public boolean footerLogo() {
		return footerlogo.isDisplayed();
	}
	
	
}
