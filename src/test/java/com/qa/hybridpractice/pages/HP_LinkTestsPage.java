package com.qa.hybridpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_LinkTestsPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Rediffmail")
	private WebElement rediffMailLink;
	
	@FindBy(className = "logtext")
	private WebElement redifMailLogo;
	
	@FindBy(linkText = "Money")
	private WebElement rediffMoneyLink;
	
	@FindBy(linkText = "Rediff Moneywiz")
	private WebElement rediffMoneyLogo;
	
	@FindBy(linkText =  "Business Email")
	private WebElement rediffBusinessEmailLink;
	
	@FindBy(className = "logo")
	private WebElement rediffBusinessEmailLogo;
	
	@FindBy(linkText = "Videos")
	private WebElement rediffVideosLink;
	
	@FindBy(css = "div.logo-wrapper a+span+a")
	private WebElement rediffVideosLogo;
	
	@FindBy(linkText = "Shopping")
	private WebElement rediffShoppingLink;
	
	@FindBy(css = "div.logocell h1 a")
	private WebElement rediffShoppingLogo;
	
	public HP_LinkTestsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRediffMailLink() {
		rediffMailLink.click();
	}
	public WebElement rediffMailLogo() {
		return redifMailLogo;
	}
	public boolean rediffMailLogoIsDisplayed() {
		boolean displayStatus = redifMailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffMoneyLink() {
		rediffMoneyLink.click();
	}
	public WebElement rediffMoneyLogo() {
		return rediffMoneyLogo;
	}
	public boolean rediffMoneyLogoIsDisplayed() {
		boolean displayStatus = rediffMoneyLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffBusinessEmailLink() {
		rediffBusinessEmailLink.click();
	}
	public WebElement rediffBusinessEmailLogo() {
		return rediffBusinessEmailLogo;
	}
	public boolean rediffBusinessEmailLogoIsDisplayed() {
		boolean displayStatus = rediffBusinessEmailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffVideosLink() {
		rediffVideosLink.click();
	}
	public WebElement rediffVideosLogo() {
		return rediffVideosLogo;
	}
	public boolean rediffVideosLogoIsDisplayed() {
		boolean displayStatus = rediffVideosLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffShoppingLink() {
		rediffShoppingLink.click();
	}
	public WebElement rediffShoppingLogo() {
		return rediffShoppingLogo;
	}
	public boolean rediffShoppingLogoIsDisplayed() {
		boolean displayStatus = rediffShoppingLogo.isDisplayed();
		return displayStatus;
	}
	public WebElement rediffMoneyLink() {
		return rediffMoneyLink;
	}
	public WebElement rediffBusinessEmailLink() {
		return rediffBusinessEmailLink;
	}
	public WebElement rediffVideosLink() {
		return rediffVideosLink;
	}
	public WebElement rediffShoppingLink() {
		return rediffShoppingLink;
	
		
		
	
		
	}


	

}
