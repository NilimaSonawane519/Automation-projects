package com.HRMScenario2pagefactory.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Adminpage {
	

	private WebDriver driver;
	public Adminpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']//li[@class='oxd-main-menu-item-wrapper']")
	List<WebElement> countmenu;
	
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
	WebElement Adminlink;
	
	
	@FindBy(xpath="(//input[contains(@class,'oxd-input--active')])[1]")
	WebElement usersearchbox;
	
	@FindBy(xpath="/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
	WebElement Searchbtn;
	
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
	WebElement Recordfoundtext;
	
	@FindBy(xpath="(//i[contains(@class,'oxd-select-text--arrow')])[1]") //userrole dropdown
	WebElement selectarrow;
	
	@FindBy(xpath="(//div[@class='oxd-select-option'])[2]//span")
	WebElement Adminselect;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
	WebElement statusarrow;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span")//enable/disabled
	WebElement status;
	
	public void VerifyMenuCount()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

		int count = countmenu.size();
		System.out.println("Total menu count is: " + count);
		Assert.assertEquals(count, 12, "Count is not matching");
		System.out.println("Count is matching!! Test passed..");

		
		wait.until(ExpectedConditions.elementToBeClickable(Adminlink));
		Adminlink.click();
		driver.navigate().refresh();
		
	}
	
	public void searchbyName()
	{
		usersearchbox.sendKeys("Admin");
		Searchbtn.click();
		String records=Recordfoundtext.getText();
		System.out.println("Total records found by name Admin:"+records);
		Assert.assertTrue(true,records);
		driver.navigate().refresh();
	}
	
	public void SelectByuserRole()
	{
		selectarrow.click();
		Adminselect.click();
		String record=Recordfoundtext.getText();
		System.out.println("Total records found by user role are:"+record);
		Assert.assertTrue(true,record);
		driver.navigate().refresh();
	
		
	}
			public void selectBystatus() //throws InterruptedException
			{
				statusarrow.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(Recordfoundtext));
				status.click();
				String record=Recordfoundtext.getText();
				System.out.println("Total records found by status enabled are:"+record);
				Assert.assertTrue(true,record);
				
			}
	
}
