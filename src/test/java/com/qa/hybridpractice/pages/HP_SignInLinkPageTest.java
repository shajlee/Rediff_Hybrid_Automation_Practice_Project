package com.qa.hybridpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_SignInLinkPageTest {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInLink;
	
	@FindBy(css = "div.logtext")
	private WebElement rediffMailLogo;
	
	public HP_SignInLinkPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		SignInLink.click();
	}
	public WebElement SignInLink() {
		return SignInLink;
	}
	public boolean rediffMailLogoIsDisplayed() {
		boolean displayStatus = rediffMailLogo.isDisplayed();
		return displayStatus;
	}
	public WebElement rediffMailLogo() {
		return rediffMailLogo;
		
	}

}
