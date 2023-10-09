package com.qa.hybridpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_LogOutPageTest {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInLink;
	
	@FindBy(css = "input#login1")
	private WebElement UsernameTextBox;
	
	@FindBy(css = "input#password")
	private WebElement PasswordTextBox;
	
	@FindBy(css = "input.signinbtn")
	private WebElement SignInButton;
	
	@FindBy(css = "a.rd_logout")
	private WebElement LogOutButton;
	
	@FindBy(css = "div.panel p")
	private WebElement LogOutMessage;
	
	public HP_LogOutPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		SignInLink.click();
	}
	public void enterUserName(String usernameText) {
		UsernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passwordText) {
		PasswordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		SignInButton.click();
	}
	public void clickOnLogOutButton() {
		LogOutButton.click();
	}
	public boolean logOutMessageIsDisplayed() {
		boolean displayStatus = LogOutMessage.isDisplayed();
		return displayStatus;
	}
	public WebElement logOutMessage() {
		return LogOutMessage;
		
	}
	

}
