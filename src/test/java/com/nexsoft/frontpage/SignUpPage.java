package com.nexsoft.frontpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

protected WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement newPassword;
	
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	private WebElement repeatPassword;
	
	@FindBy(xpath = "//input[@name='account.firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@name='account.lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='account.email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='account.phone']")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@name='account.address1']")
	private WebElement address1;
	
	@FindBy(xpath = "//input[@name='account.address2']")
	private WebElement address2;
	
	@FindBy(xpath = "//input[@name='account.city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@name='account.state']")
	private WebElement state;
	
	@FindBy(xpath = "//input[@name='account.zip']")
	private WebElement zip;
	
	@FindBy(xpath = "//input[@name='account.country']")
	private WebElement country;
	
	@FindBy(xpath = "//select[@name='account.languagePreference']")
	private WebElement languagePref;
	
	@FindBy(xpath = "//select[@name='account.favouriteCategoryId']")
	private WebElement favCategory;
	
	@FindBy(xpath = "//input[@name='account.listOption']")
	private WebElement enableMyList;
	
	@FindBy(xpath = "//input[@name='account.bannerOption']")
	private WebElement enableMyBanner;

	@FindBy(xpath = "//input[@name='newAccount']")
	private WebElement btnSave;
	
	@FindBy(xpath = "//h3[normalize-space()='User Information']")
	private WebElement signUpPageSymbol;
	
	@FindBy(css = "div[class='callout callout-error']")
	private WebElement errorPassword;
	
//	@FindBy(css = ".login-box-msg")
//	private WebElement forgetPasswordPrompt;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage registerUser(String user_name, String user_password, String repeat_password,
								String first_name, String last_name, String user_email,
								String user_phone, String user_address1, String user_address2,
								String user_city, String user_state, String user_zip,
								String user_country, String user_language, String user_category, int myList, int myBanner) {

		userId.sendKeys(user_name);
		newPassword.sendKeys(user_password);
		repeatPassword.sendKeys(repeat_password);
		firstName.sendKeys(first_name);
		lastName.sendKeys(last_name);
		email.sendKeys(user_email);
		phone.sendKeys(user_phone);
		address1.sendKeys(user_address1);
		address2.sendKeys(user_address2);
		city.sendKeys(user_city);
		state.sendKeys(user_state);
		zip.sendKeys(user_zip);
		country.sendKeys(user_country);
		Select dropdownLang = new Select(languagePref);  
		dropdownLang.selectByVisibleText(user_language.toLowerCase());
		favCategory.sendKeys(user_password);
		Select dropdownCategory = new Select(favCategory);  
		dropdownCategory.selectByVisibleText(user_category.toUpperCase());
		if (myList == 1) {
			enableMyList.click();
		}
		if (myBanner == 1) {
			enableMyBanner.click();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnSave.click();

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		return homePage;

	}
	
	public String getSignUpPageSymbol() {
		
		return signUpPageSymbol.getText();
	}
	
}
