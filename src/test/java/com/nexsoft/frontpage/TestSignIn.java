package com.nexsoft.frontpage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSignIn {

	protected WebDriver driver;

	public String doScreenshoot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\ScreenshootSignInExam17Jun22\\" + waktu + ".png";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeMethod
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Catalog.action");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testSignInValid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("12", "12");

		assertEquals(home.getHomePageSymbol(),
				"Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		doScreenshoot();
		
		driver.close();
	}

	@Test(priority = 2)
	public void testSignInUserValidPassInvalid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("12", "1234");
		
		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 3)
	public void testSignInUserInvalidPassValid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("1234", "12");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 4)
	public void testSignInUserInvalidPassInvalid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("1234", "1234");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 5)
	public void testSignInUserValidNoPass() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("1234", "");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 6)
	public void testSignInUserInvalidNoPass() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("1234", "");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 7)
	public void testSignInNoUserPassValid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("", "12");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 8)
	public void testSignInNoUserPassInvalid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("", "1234");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}
	
	@Test(priority = 9)
	public void testSignInNoUserNoPass() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		SignInPage signInPage = home.clickSignIn();
		home = signInPage.loginValidUser("", "");

		doScreenshoot();
		
		assertEquals(signInPage.getErrorPassword(), "Invalid username or password. Signon failed.");

		driver.close();
	}

}
