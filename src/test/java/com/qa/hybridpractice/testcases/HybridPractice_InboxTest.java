package com.qa.hybridpractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;

public class HybridPractice_InboxTest extends Hybrid_Practice_TestBase {
	public HybridPractice_InboxTest() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validUsername"));
		driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		Thread.sleep(1000);
	}

	@Test()
	public void presenceOfInboxButton() {
		WebElement inboxButton = driver.findElement(By.cssSelector("a.rd_active"));
		softassert.assertTrue(inboxButton.isDisplayed(), "inboxButton is not displayed");
		softassert.assertAll();
		if (inboxButton.isDisplayed()) {
			System.out.println("Inbox Fucntionality is functional");
		} else {
			System.out.println("Inbox Fucntionality is not functional");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
