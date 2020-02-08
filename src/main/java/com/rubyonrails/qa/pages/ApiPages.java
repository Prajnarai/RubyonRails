package com.rubyonrails.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;


public class ApiPages extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'API')]") //locator of API menu
	WebElement api;
	
	@FindBy(xpath="//input[@id='search']") //locator of search bar
	WebElement search;
	
	@FindBy(xpath="//h1[contains(text(),'ActionController')]") //locator of Action Controller from frame.
	WebElement actionController;

	@FindBy(xpath="//h1[contains(text(),'AbstractController')]") //locator of AbstractController from frame.
	WebElement abstractController;
	
	//initializing page factory
	
	public ApiPages() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAPI() { //method to click on API menu
		api.click();
	}
	
	public void search() {
		search.click();
		search.sendKeys("ActionDispatch");
		search.sendKeys(Keys.ARROW_DOWN);
		search.sendKeys(Keys.ENTER);
	}
	
	public void clickOnActionController() {
		actionController.click();
	}
	public void clickOnAbstractController() {
		
		abstractController.click();
	}
	
	
}
