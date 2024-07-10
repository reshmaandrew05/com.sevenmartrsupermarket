package com.sevenrmatrtsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmatrtsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties=new Properties();

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	WebElement signinbutton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fis=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signinbutton.click();
	}
	public void login(String username, String password)
	{
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}
	public void login()
	{
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}
}
