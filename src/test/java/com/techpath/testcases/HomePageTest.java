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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techpath.utilities.ConfigReader;

public class HomePageTest {

	WebDriver driver;
	Logger logger;
	ConfigReader reader = new ConfigReader();

	@BeforeClass

	public void setup() {

		logger = logger.getLogger("HomePageTest");
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");

		driver = new ChromeDriver();

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

		driver.get(reader.getWebURL());

		AssertJUnit.assertEquals(driver.getTitle(), "The Ninja Store");

		logger.info("User is navigated to the website successful");
	}

	@Test
	public void test2() {

		driver.get(reader.getWebURL());

		WebElement desktopIcon = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
		AssertJUnit.assertTrue(desktopIcon.isDisplayed());
		logger.info("desktopIcon.isDisplayed() passed!");

		desktopIcon.click();

		WebElement pcIcon = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]/a"));
		AssertJUnit.assertTrue(pcIcon.isDisplayed());
		logger.info("pcIcon.isDisplayed() passed!");

		pcIcon.click();

		AssertJUnit.assertTrue(driver.getTitle().contentEquals("PC"));

		WebElement icon = driver.findElement(By.xpath("//span[@id='cart-total'][.='0 item(s) - $0.00']"));
		AssertJUnit.assertTrue(icon.isDisplayed());
		icon.click();

		AssertJUnit.assertEquals(icon.getText(), "0 item(s) - $0.00");

		logger.info(icon.getText() + " is equal to 0 item(s) - $0.00");

	}

}
