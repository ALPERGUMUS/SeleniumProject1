package com.techpath.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techpath.utilities.ConfigReader;

public class LoginTest {

	WebDriver driver;

	ConfigReader reader = new ConfigReader();

	public static Logger logger;

	@BeforeClass
	public void setup() {

		logger = Logger.getLogger("techpath");
		PropertyConfigurator.configure("log4j.properties");

		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(reader.getWebURL());

		logger.info("The Website URL is up and running ");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	@Test
	public void Login() throws InterruptedException {

		WebElement myAcctButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		myAcctButton.click();

		logger.info("My Account button is clicked");

		WebElement loginButton1 = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		loginButton1.click();

		WebElement userNameTextField = driver.findElement(By.name("email"));
		userNameTextField.sendKeys(reader.getUserName());

		logger.info("Username is inserted");

		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.sendKeys(reader.getPassword());

		WebElement loginButton2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		loginButton2.click();
		
		
//		WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]/span"));
//		addtoCart.click();
//		
//		
//		WebElement checkAddtoCart1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
//		
//		checkAddtoCart1.click();
//		
//		WebElement checkAddtoCart2 = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[4]/td[2]"));
//		
//		System.out.println(checkAddtoCart2.getText());
//		
//		if (checkAddtoCart2.getText().contentEquals("$602.00")) {
//			
//			Assert.assertTrue(true);
//			
//			logger.info(checkAddtoCart2.getText() + " is the correct Amount");
//			
//			
//		} else {
//			
//			Assert.fail();
//		}
		
		

	      logger.trace("Trace Message!");
	      logger.debug("Debug Message!");
	      logger.info("Info Message!");
	      logger.warn("Warn Message!");
	      logger.error("Error Message!");
	      logger.fatal("Fatal Message!");
		
		
		System.out.println(driver.getTitle());
		AssertJUnit.assertEquals(driver.getTitle(), "My Account");
	
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}
}
