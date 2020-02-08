package com.rubyonrails.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.rubyonrails.qa.util.TestUtil;



/**
 * 
 * @author Prajna
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()  {
	try {	prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\rubyonrails\\qa\\config\\config.properties");
		prop.load(fis);

	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

	/**
	 * This method will initialize the browser depending on the browser name
	 * specified in the config.properties file. Also, opens the URL in the browser
	 * 
	 * @throws Exception
	 */
	public static void browserInitialization() throws Exception {
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Prajna\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Prajna\\iexploredriver.exe");
			driver = new InternetExplorerDriver();

		} else {
			throw new Exception("Invalid Brower Type");
		}

		driver.manage().window().maximize(); // Maximize the window
		driver.get(url);
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS); // wait till the page is completely loaded
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); // implicit wait

	}

}
