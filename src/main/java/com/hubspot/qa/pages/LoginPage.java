package com.hubspot.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	//1. WebElements -- in the form of Page obeject factory
	
	//2. Actions--Methods
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(xpath="//*[@id='loginBtn']")
	WebElement loginButton;
	
	// Initialize the element of the page objects with the driver coming from the base page/class
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);

    }
	
	public String LoginTitlePage()
	{
		return driver.getTitle();
	}

	public HomePage login(String username, String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginButton.click();
		return new HomePage(driver);
	}  
}