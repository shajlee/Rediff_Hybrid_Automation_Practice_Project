package com.qa.hybridpractice.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;
import com.qa.hybridpractice.pages.HP_SignInLinkPageTest;

public class HybridPractice_SignInLinkTest extends Hybrid_Practice_TestBase {
	public HybridPractice_SignInLinkTest() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));

	}

	@Test(priority = 1)
	public void clickOnSignInLink() {
		HP_SignInLinkPageTest signInLinkPage = new HP_SignInLinkPageTest(driver);

		WebElement signInLink = signInLinkPage.SignInLink();

		if (signInLink.isDisplayed() && signInLink.isEnabled()) {
			System.out.println("Sign in Link is displayed and enabled");
			signInLink.click();
		} else {
			System.out.println("Sign in Link is not displayed and enabled");
		}

		WebElement rediffMailLogo = signInLinkPage.rediffMailLogo();
		softassert.assertTrue(rediffMailLogo.isDisplayed(), "rediffMailLogo is not displayed");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
