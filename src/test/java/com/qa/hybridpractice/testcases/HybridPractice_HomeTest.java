package com.qa.hybridpractice.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;
import com.qa.hybridpractice.pages.HP_HomePageTest;

public class HybridPractice_HomeTest extends Hybrid_Practice_TestBase {
	public HybridPractice_HomeTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));
		HP_HomePageTest homeTest = new HP_HomePageTest(driver);
		homeTest.clickOnSignInLink();
		homeTest.enterUserName(prop.getProperty("validUsername"));
		homeTest.enterPassword(prop.getProperty("validPassword"));
		homeTest.clickOnSignInButton();
		Thread.sleep(3000);
		
	}
	@Test
	public void presenceOfRediffLogo() throws Exception {
		HP_HomePageTest homeTest = new HP_HomePageTest(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(homeTest.LogOutButton()));
		logoutButton.click();
		Thread.sleep(1000);
		homeTest.clickOnRediffHomeButton();
		Thread.sleep(1000);
		WebElement rediffLogo = homeTest.RediffLogo();
		softassert.assertTrue(homeTest.rediffLogoIsDisplayed(), "rediff logo is not displayed");
		softassert.assertAll();
		
		if(rediffLogo.isDisplayed()) {
			System.out.println("Log Out Button is Functional");
		}else {
			System.out.println("Log Out Button is not Functional");
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		}
	}


