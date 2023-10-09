package com.qa.hybridpractice.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;
import com.qa.hybridpractice.pages.HP_LogOutPageTest;

public class HybridPractice_LogOutTest extends Hybrid_Practice_TestBase {
	public HybridPractice_LogOutTest() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));
		HP_LogOutPageTest logoutTest = new HP_LogOutPageTest(driver);
		logoutTest.clickOnSignInLink();
		logoutTest.enterUserName(prop.getProperty("validUsername"));
		logoutTest.enterPassword(prop.getProperty("validPassword"));
		logoutTest.clickOnSignInButton();
		Thread.sleep(1000);
	}

	@Test
	public void signOutMessageIsDisplayed() throws Exception {
		HP_LogOutPageTest logoutTest = new HP_LogOutPageTest(driver);
		logoutTest.clickOnLogOutButton();
		Thread.sleep(1000);
		WebElement signOutMessage = logoutTest.logOutMessage();
		softassert.assertTrue(logoutTest.logOutMessageIsDisplayed(), "signOutMessage is not displayed");
		softassert.assertAll();

		if (signOutMessage.isDisplayed()) {
			System.out.println("LogOut Function is functional");
		} else {
			System.out.println("LogOut Function is not functional");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
