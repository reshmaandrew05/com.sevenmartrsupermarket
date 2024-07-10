package com.sevenrmatrtsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmatrtsupermarket.constants.Constants;

public class ScreenshotCapture {
	TakesScreenshot takescreenshot;

	public void takeScreenshot(WebDriver driver, String imgname) {
		try {
			takescreenshot = (TakesScreenshot) driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//code for date and time
			String destination = Constants.SREENSHOT_FILE_PATH + imgname + "_" + timeStamp + ".png";
			File filePath = new File(destination);
			FileHandler.copy(screenshot, filePath);//captured screenshot copy here
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
