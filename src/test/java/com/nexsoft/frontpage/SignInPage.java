package com.nexsoft.frontpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='signon']")
	private WebElement btnSignIn;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]")
	private WebElement errorPassword;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement btnSignUp;
	
//	@FindBy(css = ".login-box-msg")
//	private WebElement forgetPasswordPrompt;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage loginValidUser(String user_name, String user_password) {

		username.clear();
		username.sendKeys(user_name);
		password.clear();
		password.sendKeys(user_password);
		btnSignIn.click();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		return homePage;

	}
	
	public SignUpPage clickSignUp() {
		btnSignUp.click();

		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

		return signUpPage;
	}
	
	public String getErrorPassword() {
		
		return errorPassword.getText();
		
	}
}
