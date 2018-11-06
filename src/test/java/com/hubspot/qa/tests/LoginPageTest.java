package com.hubspot.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.qa.pages.BasePage;
import com.hubspot.qa.pages.LoginPage;

public class LoginPageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		basePage= new BasePage();
		driver= basePage.init();
		prop = basePage.init_properties();
		loginPage= new LoginPage(driver);
		driver.get(prop.getProperty("url"));
   }
	
	@Test(priority=1)
	public void verifyLoginTitle()
	{
		String title= loginPage.LoginTitlePage();
	//	WebDriverWait wait= new WebDriverWait(driver,15);
	//	wait.until(ExpectedConditions.visibilityOf(UserName));
		System.out.println("Title :"+ title);
		Assert.assertEquals(title, "HubSpot | Redirecting...");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		//Assert.assertEquals(actual, expected);
	}
	
	/*public void tearDown()
	{
		driver.quit();
	}*/
	
	
}
