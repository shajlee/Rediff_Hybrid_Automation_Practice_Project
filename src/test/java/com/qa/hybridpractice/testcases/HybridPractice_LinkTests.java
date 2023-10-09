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
import com.qa.hybridpractice.pages.HP_LinkTestsPage;

public class HybridPractice_LinkTests extends Hybrid_Practice_TestBase {
	public HybridPractice_LinkTests() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName1"));
		
	}
	@Test
	public void linkTests(){
		HP_LinkTestsPage linkTests = new HP_LinkTestsPage(driver);
		linkTests.clickOnRediffMailLink();
		WebElement rediffMailLogo = linkTests.rediffMailLogo();
		softassert.assertTrue(linkTests.rediffMailLogoIsDisplayed(), "rediffMailLogo is not displayed");
		softassert.assertAll();
		
		if(rediffMailLogo.isDisplayed()) {
			System.out.println("Rediff Mail link is functional");
		}else {
			System.out.println("Rediff Mail link is not functional");
		}
		driver.navigate().back();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rediffMoneyLink = wait.until(ExpectedConditions.elementToBeClickable(linkTests.rediffMoneyLink()));
		rediffMoneyLink.click();
		WebElement rediffMoneyLogo = linkTests.rediffMoneyLogo();
		softassert.assertTrue(linkTests.rediffMoneyLogoIsDisplayed(), "rediffMoneyLogo is not displayed");
		
		if(rediffMoneyLogo.isDisplayed()) {
			System.out.println("Rediff Money link is functional");
		}else {
			System.out.println("Rediff Money link is not functional");
		}
		driver.navigate().back();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rediffBusinessMailLink = wait1.until(ExpectedConditions.elementToBeClickable(linkTests.rediffBusinessEmailLink()));
		rediffBusinessMailLink.click();
		WebElement rediffBusinessMaillogo = linkTests.rediffBusinessEmailLogo();
        softassert.assertTrue(linkTests.rediffBusinessEmailLogoIsDisplayed(),"rediffBusinessMaillogo is not displayed");
		
		if(rediffBusinessMaillogo.isDisplayed()) {
			System.out.println("Rediff Business Mail link is functional");
		}else {
			System.out.println("Rediff Business Mail link is not functional");
		}
		driver.navigate().back();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rediffVideosLink = wait2.until(ExpectedConditions.elementToBeClickable(linkTests.rediffVideosLink()));
		rediffVideosLink.click();
		WebElement rediffVideoLogo = linkTests.rediffVideosLogo();
        softassert.assertTrue(linkTests.rediffVideosLogoIsDisplayed(), "rediffVideoLogo is not displayed");
		
		if(rediffVideoLogo.isDisplayed()) {
			System.out.println("Rediff Videos link is functional");
		}else {
			System.out.println("Rediff Videos link is not functional");
		}
		driver.navigate().back();
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rediffShoppingLink = wait3.until(ExpectedConditions.elementToBeClickable(linkTests.rediffShoppingLink()));
		rediffShoppingLink.click();
		WebElement rediffShoppingLogo = linkTests.rediffShoppingLogo();
        softassert.assertTrue(linkTests.rediffShoppingLogoIsDisplayed(), "rediffShoppingLogo is not displayed");
		
		if(rediffShoppingLogo.isDisplayed()) {
			System.out.println("Rediff Shopping link is functional");
		}else {
			System.out.println("Rediff shopping link is not functional");
		}
		driver.navigate().back();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	
	}

}
