package com.HRMprojectTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestData.Logindataprovider;
import Utility.Utilityclass;


public class LoginTest {
    public static WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "exceldata", dataProviderClass = Logindataprovider.class)
    public void testLogin(String un, String psw) {
        try {
            // Use explicit wait to ensure username field is visible before interacting
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(By.name("username")).sendKeys(un);
      	  driver.findElement(By.name("password")).sendKeys(psw);
      	  driver.findElement(By.xpath("//button[@type='submit']")).click();


            // Wait for the page to load and for the dashboard to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']//h6[text()='Dashboard']")));

            // Validate the URL after login
            String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
            String actUrl = driver.getCurrentUrl();

            if (!actUrl.equals(expUrl)) {
                Utilityclass.getScreenshot(driver, "loginfail");
                Assert.fail("Login failed. URL mismatch.");
            } else {
                Utilityclass.getScreenshot(driver, "dashboard");
            }

        } catch (Exception e) {
            Utilityclass.getScreenshot(driver, "unexpectedError");
            throw e; // Rethrow exception to fail the test
        }
    }

    @AfterMethod
    public void logout() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            if (driver.getCurrentUrl().contains("dashboard")) {
                // Wait for logout icon to be clickable before clicking it
                WebElement logoutIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")));
                logoutIcon.click();
                Utilityclass.getScreenshot(driver, "logoutMenu");

                // Wait for logout link to be visible
                WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Log")));
                logoutLink.click();

                Utilityclass.getScreenshot(driver, "logout");
                System.out.println("Login successful and logout completed.");
            } else {
                System.out.println("Invalid credentials.");
            }
        } catch (Exception e) {
            Utilityclass.getScreenshot(driver, "logoutError");
            throw e; // Rethrow to fail the test if logout fails
        }
    }

    @BeforeTest
    public static void launchBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
