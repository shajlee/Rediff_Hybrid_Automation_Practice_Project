package com.qa.hybridpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_LandingPageTest {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement RediffLogo;
	
	public HP_LandingPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean signInButtonIsDisplayed() {
		boolean displayStatus = SignInButton.isDisplayed();
		return displayStatus;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = RediffLogo.isDisplayed();
		return displayStatus;
	}
	public WebElement SignInButton() {
		return SignInButton;
	}
	public WebElement RediffLogo() {
		return RediffLogo;
		
		
	}
	
	

}
