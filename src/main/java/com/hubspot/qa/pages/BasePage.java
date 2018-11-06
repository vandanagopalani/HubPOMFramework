package com.hubspot.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hubspot.qa.utilities.Constants;


public class BasePage {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver init()// Initialise method
	
	{
		System.setProperty("webdriver.chrome.driver","/Users/u2ft/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}

	public Properties init_properties()
	
	{
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/hubspot/qa/config/config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();// if File path is not found
		} catch (IOException e) {//if File is not loaded
		
			e.printStackTrace();
		}
		
		return prop;
		
	}
}
