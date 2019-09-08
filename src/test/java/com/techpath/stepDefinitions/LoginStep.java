package com.techpath.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techpath.utilities.ConfigReader;
import com.techpath.utilities.ScreenShotTaker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {

	WebDriver driver;
	ConfigReader reader = new ConfigReader();
	public static Logger logger;

	@Given("^open browser$")
	public void open_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", reader.getChromePath());
		driver = new ChromeDriver();
	}

	@When("^enter URL$")
	public void enter_URL() throws Throwable {
		driver.get(reader.getWebURL());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	@When("^Click on My Account Tab$")
	public void click_on_My_Account_Tab() throws Throwable {
		WebElement myAcctButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		myAcctButton.click();
		WebElement loginButton1 = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		loginButton1.click();
	}

	@When("^Enter Username$")
	public void enter_Username() throws Throwable {
		WebElement userNameTextField = driver.findElement(By.name("email"));
		userNameTextField.sendKeys(reader.getUserName());
	}

	@When("^Enter Password$")
	public void enter_Password() throws Throwable {
		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.sendKeys(reader.getPassword());
	}

	@When("^Click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		WebElement loginButton2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		loginButton2.click();
	}

	@Then("^user succesfully logins to My Account$")
	public void user_succesfully_logins_to_My_Account() throws Throwable {
		if (driver.getTitle().contentEquals("My Account")) {
		} else {
			ScreenShotTaker.captureScreen(driver, "Login");
		}
		ScreenShotTaker.captureScreen(driver, "Login");
		Thread.sleep(5000);
	}
}
