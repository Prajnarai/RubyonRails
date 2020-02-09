package com.rubyonrails.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;

public class ContributeToGitPages extends TestBase {
	/**
	 * Locator for Contribute on Git link
	 */
	@FindBy(xpath="//a[contains(text(),'Contribute on GitHub')]")
	WebElement contribute;
	
	public ContributeToGitPages() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * To click on Contribute to Git link
	 */
	public void clickOnContributeToGit() {
		contribute.click();
	}
	

}
