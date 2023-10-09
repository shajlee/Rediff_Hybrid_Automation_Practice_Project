package com.qa.hybridpractice.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hybridpractice.base.Hybrid_Practice_TestBase;
import com.qa.hybridpractice.pages.HP_LoginTestsPage;
import com.qa.hybridpractice.testdata.Supply_Hybrid_Practice_TestData;
import com.qa.hybridpractice.utilities.Hybrid_Practice_Utilities;

public class HybridPractice_LoginTests extends Hybrid_Practice_TestBase {
	public HybridPractice_LoginTests() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.clickOnSignInLink();
		
	}

	@Test(priority = 1, dataProvider = "RediffDataProviderSupply", dataProviderClass = Supply_Hybrid_Practice_TestData.class)
	public void logInWithValidCredentialsUsingDataProvider(String Username, String Password) throws Exception {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername(Username);
		loginPage.enterPassword(Password);
		loginPage.clickOnSignInButton();
		WebElement profileName = loginPage.ProfileName();
		softassert.assertTrue(loginPage.profileNameIsDisplayed(), "profileName is not displayed");
		softassert.assertAll();

		if (profileName.isDisplayed()) {
			System.out.println("Log In with Valid Credentials is Functional");
		} else {
			System.out.println("Log In with Valid Credentials is not Functional");
		}
	}

	@Test(priority = 2, dataProvider = "RediffExcelDataWithDataProvider", dataProviderClass = Supply_Hybrid_Practice_TestData.class)
	public void logInWithValidCredentialsUsingDataProviderExcelSheet(String Username, String Password) throws Exception {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername(Username);
		loginPage.enterPassword(Password);
		loginPage.clickOnSignInButton();
		Thread.sleep(1000);
		WebElement profileName = loginPage.ProfileName();
		softassert.assertTrue(loginPage.profileNameIsDisplayed(), "profileName is not displayed");
		softassert.assertAll();

		if (profileName.isDisplayed()) {
			System.out.println("Log In with Valid Credentials is Functional");
		} else {
			System.out.println("Log In with Valid Credentials is not Functional");
		}

	}

	@Test(priority = 3)
	public void logInWithInvalidCredentials() {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername(Hybrid_Practice_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(Hybrid_Practice_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();
		WebElement errorMessage = loginPage.invalidCredentialsErrorMessage();
		softassert.assertTrue(loginPage.invalidCredentialsMessageIsDisplayed(), "errorMessage is not displayed");
		softassert.assertAll();

		if (errorMessage.isDisplayed()) {
			System.out.println("Log In with Invalid Credentials is behaving as expected");
		} else {
			System.out.println("Log In with Invalid Credentials is not behaving as expected");
		}
	}

	@Test(priority = 4)
	public void loginWithValidUsernameInvalidPassword() {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername(prop.getProperty("validUsername"));
		loginPage.enterPassword(Hybrid_Practice_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();
		WebElement wrongCombinationMessage = loginPage.invalidPasswordMessage();
		softassert.assertTrue(loginPage.invalidPasswordMessageIsDisplayed(), "wrongCombinationMessage is not displayed");
		softassert.assertAll();

		if (wrongCombinationMessage.isDisplayed()) {
			System.out.println("Log in with valid username and invalid password is behaving as expected");
		} else {
			System.out.println("Log in with valid username and invalid password is  not behaving as expected");
		}
	}

	@Test(priority = 5)
	public void logInWithInvalidUsernameValidPassword() {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername(Hybrid_Practice_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnSignInButton();
		WebElement wrongCombinationMessage1 = loginPage.invalidUsernameMessage();
		softassert.assertTrue(loginPage.invalidUsernameMessageIsDisplayed(), "wrongCombinationMessage is not displayed");
		softassert.assertAll();

		if (wrongCombinationMessage1.isDisplayed()) {
			System.out.println("Log in with invalid username and valid password is behaving as expected");
		} else {
			System.out.println("Log in with invalid username and valid password is  not behaving as expected");
		}
	}

	@Test(priority = 6)
	public void logInWithNotCredentials() {
		HP_LoginTestsPage loginPage = new HP_LoginTestsPage(driver);
		loginPage.enterUsername("");
		loginPage.enterPassword("");
		loginPage.clickOnSignInButton();
		
        Alert alert = driver.switchTo().alert();
		String actualNoCredentialsAlertText = prop.getProperty("NoCredentialsAlertText");
		String expectedNoCredentialsAlertText = alert.getText();

		softassert.assertEquals(actualNoCredentialsAlertText, expectedNoCredentialsAlertText);
		if (actualNoCredentialsAlertText.equals(expectedNoCredentialsAlertText)) {
			alert.accept();
			System.out.println("Log in with no credentials is behaving as expected");
		} else {
			alert.dismiss();
			System.out.println("Log in with no credentials is not behaving as expected");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
