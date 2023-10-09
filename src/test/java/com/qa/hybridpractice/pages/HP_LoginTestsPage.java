package com.qa.hybridpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_LoginTestsPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement SignInLink;
	
	@FindBy(css = "input#login1")
	private WebElement UsernameTextBox;
	
	@FindBy(css = "input#password")
	private WebElement PasswordTextBox;
	
	@FindBy(css = "input.signinbtn")
	private WebElement SignInButton;
	
	@FindBy(css = "span.rd_tp-rgt")
	private WebElement ProfileName;
	
	@FindBy(css = "div#div_login_error b")
	private WebElement invalidCredentialsErrorMessage;
	
	@FindBy(css = "div#div_login_error b")
	private WebElement invalidPasswordMessage;
	
	@FindBy(css = "div#div_login_error b")
	private WebElement invalidUsernameMessage;
	
	public HP_LoginTestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		SignInLink.click();
	}
	public void enterUsername(String usernameText) {
		UsernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(CharSequence passwordText) {
		PasswordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignInButton() {
		SignInButton.click();
	}
	public boolean profileNameIsDisplayed() {
		boolean displayStatus = ProfileName.isDisplayed();
		return displayStatus;
	}
	public boolean invalidCredentialsMessageIsDisplayed() {
		boolean displayStatus = invalidCredentialsErrorMessage.isDisplayed();
		return displayStatus;
	}
	public boolean invalidPasswordMessageIsDisplayed() {
		boolean displayStatus = invalidPasswordMessage.isDisplayed();
		return displayStatus;
	}
	public boolean invalidUsernameMessageIsDisplayed() {
		boolean displayStatus = invalidUsernameMessage.isDisplayed();
		return displayStatus;
	}
	public WebElement ProfileName() {
		return ProfileName;
	}
	public WebElement invalidCredentialsErrorMessage() {
		return invalidCredentialsErrorMessage;
	}
	public WebElement invalidPasswordMessage() {
		return invalidPasswordMessage;
	}
	public WebElement invalidUsernameMessage() {
		return invalidUsernameMessage;
	}
	
	}
	
		
	
	
	
	
	


