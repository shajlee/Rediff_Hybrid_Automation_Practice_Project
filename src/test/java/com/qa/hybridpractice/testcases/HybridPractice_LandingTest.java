package com.qa.hybridpractice.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;
import com.qa.hybridpractice.pages.HP_LandingPageTest;

public class HybridPractice_LandingTest extends Hybrid_Practice_TestBase {

	public HybridPractice_LandingTest() throws Exception {
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
	public void validateTitleAndCurrentUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String actualTitle = prop.getProperty("title");
		String expectedTitle = driver.getTitle();

		String actualCurrentUrl = prop.getProperty("url");
		String expectedCurrentUrl = driver.getCurrentUrl();

		if (actualTitle.equals(expectedTitle) && actualCurrentUrl.equals(expectedCurrentUrl)) {
			System.out.println("The Page is Valid and Fucntional");
		} else {
			System.out.println("The Page is not Valid and Fucntional");

		}
	}

	@Test(priority = 2)
	public void signInButtonIsDisplayedAndEnabled() {
		HP_LandingPageTest landingPage = new HP_LandingPageTest(driver);
		landingPage.SignInButton();
		softassert.assertTrue(landingPage.signInButtonIsDisplayed(), "signInButton is not displayed and enabled");
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void rediffLogoIsDisplayed() {
		HP_LandingPageTest landingPage = new HP_LandingPageTest(driver);
		landingPage.RediffLogo();
		softassert.assertTrue(landingPage.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
