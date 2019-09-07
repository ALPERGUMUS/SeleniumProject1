package com.techpath.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotTaker {

	public static void captureScreen(WebDriver webdriver, String tname) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(SrcFile, DestFile);

		System.out.println("Screenshot is taken");

		/*
		 * 
		 * <dependency> <groupId>org.apache.directory.studio</groupId>
		 * <artifactId>org.apache.commons.io</artifactId> <version>2.4</version>
		 * </dependency>
		 */

	}

}
