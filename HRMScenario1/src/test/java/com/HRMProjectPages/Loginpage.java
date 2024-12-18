package com.HRMProjectPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	
	public static WebDriver driver=new ChromeDriver();
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//locators
	
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="")
	WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginbutton;
	
	
	public void verifyLogin(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
	}
	public void verifyTitle()
	{
		//Str
	}
	
	public static void launchbrowser()
	{
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}
