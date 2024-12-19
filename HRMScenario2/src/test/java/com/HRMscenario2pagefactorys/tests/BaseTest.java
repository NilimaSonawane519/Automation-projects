package com.HRMscenario2pagefactorys.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.HRMScenario2pagefactory.pages.Adminpage;
import com.HRMScenario2pagefactory.pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage lp;
	public Adminpage ap;
	

	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		lp=new LoginPage(driver);
		ap=new Adminpage(driver);
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
