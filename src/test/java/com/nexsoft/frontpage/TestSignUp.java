package com.nexsoft.frontpage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSignUp {
  
	WebDriver driver;
	
	public String doScreenshoot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\ScreenshootExam17Jun22\\" + waktu + ".png";
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
		System.setProperty("url", "https://petstore.octoperf.com/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		boolean testAssert;
	}
	
	@Test(priority = 1)
	public void testSignUpValid() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asawwqusersdf", "passssss", "passssss", "stivvvv", "ventttt", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 2)
	public void testSignUpNoUserId() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("", "passssss", "passssss", "stivvvv", "ventttt", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
	
		driver.close();
	
	}
	
	@Test(priority = 3)
	public void testSignUpNoNewPass() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdf", "", "passssss", "stivvvv", "ventttt", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
		
	}
	
	@Test(priority = 4)
	public void testSignUpNoRepeatId() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfg", "passssss", "", "stivvvv", "ventttt", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 5)
	public void testSignUpNoFirstName() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfgh", "passssss", "passssss", "", "ventttt", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 6)
	public void testSignUpNoLastName() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghj", "passssss", "passssss", "stii", "", "stivvent@gmail.com", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 7)
	public void testSignUpNoEmail() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjk", "passssss", "passssss", "stiii", "ventttt", "", "08123456789104", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 8)
	public void testSignUpNoPhone() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjkl", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 9)
	public void testSignUpNoAddress1() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjkla", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "12343453", "", "Jalan jalan no 4b", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 10)
	public void testSignUpNoAddress2() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjklas", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "", "Tangsel4", "Banten4", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 11)
	public void testSignUpNoCity() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjklasd", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "", "Banten", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 12)
	public void testSignUpNoState() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjklasdf", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "", "54324", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		System.out.println("screenshot");
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 13)
	public void testSignUpNoZip() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjklasdfg", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "Banten", "", "Indonesiaa", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 14)
	public void testSignUpNoCountry() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("asdfghjklasdfgh", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "Banten", "12345", "", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 15)
	public void testSignUpPrefLangJapanese() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("zxcv", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "Banten", "12345", "Indonesia", "japanese", "reptiles", 0, 1);

		doScreenshoot();
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 16)
	public void testSignUpDogs() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("zxcvb", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "Banten", "12345", "Indonesia", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	
	@Test(priority = 16)
	public void testSignUpDuplicateUserID() {
		
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		HomePage home = landingPage.clickEnterHomePage();
		SignInPage signInPage = home.clickSignIn();
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage = signInPage.clickSignUp();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		home = signUpPage.registerUser("zxcvb", "passssss", "passssss", "stiii", "ventttt", "stivvent@gmail.com", "123344545", "Jalan jalan no 4", "Jalan jalan no 4b", "Tangsel", "Banten", "12345", "Indonesia", "english", "reptiles", 0, 1);

		doScreenshoot();
		
		assertEquals(home.getHomePageSymbol(), "Saltwater, Freshwater\n\nVarious Breeds\n\nVarious Breeds, Exotic Varieties\n\nLizards, Turtles, Snakes\n\nExotic Varieties");
		
		driver.close();
	}
	

}

