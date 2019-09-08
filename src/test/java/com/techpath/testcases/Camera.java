package com.techpath.testcases;

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
import com.techpath.utilities.ScreenShotTaker;

public class Camera {

	WebDriver driver;
	Logger logger;
	ConfigReader reader = new ConfigReader();

	@BeforeClass

	public void setup() {

		logger = logger.getLogger("HomePageTest");
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.get(reader.getWebURL());

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	@Test
	public void test1() {



		Assert.assertEquals(driver.getTitle(), "The Ninja Store");

		logger.info("User is navigated to the website successful");
	}

	@Test
	public void test2() throws Exception {

		driver.get(reader.getWebURL());
		
		
		WebElement cameraTab = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[7]/a"));
		Assert.assertTrue(cameraTab.isDisplayed());
		cameraTab.click();
		
		WebElement canonCamera = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[1]/h4/a"));
		Assert.assertTrue(canonCamera.isDisplayed());
		canonCamera.click();
		
		
		WebElement addtoCart = driver.findElement(By.xpath("//button[@id=\"button-cart\"][.='Add to Cart']"));
		addtoCart.click();
		
		Thread.sleep(3000);
		
		ScreenShotTaker.captureScreen(driver, "camera");


	}
}
