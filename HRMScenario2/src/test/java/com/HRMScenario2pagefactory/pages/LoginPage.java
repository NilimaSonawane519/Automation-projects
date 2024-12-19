package com.HRMScenario2pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbutton;

	public void verifyLogin(String un,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		loginbutton.click();
		 String currentUrl = driver.getCurrentUrl();
		 String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(currentUrl, expUrl, "Login failed, dashboard not found!");
		//Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login failed");
		System.out.println("Login completed!");
	}
	public void verifyTitle()
	{
		String acttitle = driver.getTitle();
	    String expectedTitle = "OrangeHRM"; 
	    Assert.assertEquals(acttitle, expectedTitle, "Title mismatch: Expected 'OrangeHRM' but got '" + acttitle + "'");
	    System.out.println("Title matched: " + acttitle);
	}
	
	
	
	
}
