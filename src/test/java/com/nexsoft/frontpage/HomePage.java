package com.nexsoft.frontpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement signIn;

	@FindBy(xpath = "//div[@id='SidebarContent']")
	private WebElement homePageSymbol;

	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement btnLogout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage clickSignIn() {
		signIn.click();

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);

		return signInPage;
	}

	public void logout() {
		
		btnLogout.click();
		
	}
	
	public String getHomePageSymbol() {
		
		return homePageSymbol.getText();
		
	}
	
}
