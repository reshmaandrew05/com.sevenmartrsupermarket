package com.sevenrmatrtsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmatrtsupermarket.constants.Constants;
import com.sevenrmatrtsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties=new Properties();
	ScreenshotCapture capture=new ScreenshotCapture();
			
	/**constructor declaring**/
	public Base() {
		try {
			FileInputStream fis=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**Initializing browsers**/
	public void intialize(String browser, String url) {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		

	}
@Parameters("browser")
	
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser)
	{
		String url=properties.getProperty("url");
		intialize(browser,url);
		
	}
	@BeforeMethod(enabled=true, alwaysRun = true)
	public void launchBrowser()
	{
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		intialize(browser,url);
		
	}
	@AfterMethod(alwaysRun=true)//can run in any group of testing like regression, sanity,smoke etc given alwaystrue
	public void terminateBrowser(ITestResult itestresult)//ITestResult used to check a test case is passed failed or skipped
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)//if working only if test case fail
		{
			capture.takeScreenshot(driver, itestresult.getName());// screenshot captured this moment
		}
		driver.close();	}

}
