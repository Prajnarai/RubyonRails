package com.rubyonrails.qa.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;

import com.rubyonrails.qa.base.TestBase;




public class BrokenLinkUtil extends TestBase {
	
	Logger log = Logger.getLogger(BrokenLinkUtil.class);

/**
 * Checking if the links are working or not
 */
	
	public void findingLinks() {
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCounts = links.size();
		log.info("Total links are " + linkCounts);
		for(int i=0;i<linkCounts;i++) {
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}
	
	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
}
