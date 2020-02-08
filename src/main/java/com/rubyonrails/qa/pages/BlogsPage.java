package com.rubyonrails.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubyonrails.qa.base.TestBase;

public class BlogsPage extends TestBase{
	
	
	//initializing PageFactory
	public BlogsPage() {
		PageFactory.initElements(driver, this);
	}
	// locator for Blogs menu
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement blogs;
	
		
	//Locator for link "18 contributors to Rails in past week"
	@FindBy(xpath="//a[contains(text(),'18 contributors to Rails in past week')]")
	WebElement contributors;
	
	//Locator for "this week" contributors .
	@FindBy(xpath="//a[contains(text(),'This week')]")
	WebElement thisweek;
	
	//Row path of the table
	@FindBy(xpath="//*[@id='table-wrap']//tbody//tr")
	List<WebElement> allRows;
	
	//Column path of the table
	@FindBy(xpath="//*[@id='table-wrap']//tbody//tr[2]//td")
	List<WebElement> allColumns;
	
	
	//Locator of title of the table
	@FindBy(xpath="//h1[@id='title']")
	WebElement tableTitle;
	
	
	//locator for release menu
	@FindBy(xpath="//a[contains(text(),'Releases')]")
	WebElement releases;
	
	//Action Cable CHANGELOG
	
	@FindBy(xpath="//a[contains(text(),'Action Cable CHANGELOG')]")	
	WebElement actionCable;
	
	public void clickOnBlog() { //Method to click on Blogs link/menu
		blogs.click();
	}
	
	public void clickOnLinkContributors() { //method to click on link 18 contributors to Rails in past week
		contributors.click();
	}
	
	public void clickOnThisWeek() { //method to click on this week from  the table
		thisweek.click();
		
	}
	public int rowCount() { //method to find the row count
		return allRows.size();
		
	}
	public int colCount() { //method to find the col count
		return allColumns.size();
		
	}
	
	public String tableTitle() { // method to find the table text
		return tableTitle.getText();
	}
	
	public void clickOnRelease() { //method to click on release menu link
		releases.click();
	}
	public void clickOnActionChangeLog() { //Action Cable CHANGELOG
		actionCable.click();
	}
	
}
