package com.sevenrmatrtsupermarket.pages;


	
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.sevenrmatrtsupermarket.utilities.GeneralUtility;
import com.sevenrmatrtsupermarket.utilities.PageUtility;

	public class AdminUserPage {
		
		WebDriver driver;
		HomePage homepage;
		GeneralUtility generalutility=new GeneralUtility();
		PageUtility pageutility=new PageUtility(driver);
		@FindBy(xpath = "//a[@class='d-block']")
		WebElement profilename;
		@FindBy(xpath="//section//div[@class='container-fluid']//a")
		List <WebElement> homepagecards;
		@FindBy(xpath="//section//div[@class='container-fluid']//div//p")
		List<WebElement> cardnames;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
		WebElement adminusernewbutton;
		@FindBy(xpath="//label[@for='username']//following::input[@id='username']")
		WebElement adminusername;
		@FindBy(xpath="//label[@for='password']//following::input[@id='password']")
		WebElement adminpassword;
		@FindBy(xpath="//label[@for='user_type']//following::select[@id='user_type']")
		WebElement admindropdown;
		@FindBy(xpath="//div[@class='card-footer center']//following::button[@type='submit']")
		WebElement savebutton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		WebElement sucessalertbox;
		
		
		public AdminUserPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		public void clickOnNewButton()
		{
			adminusernewbutton.click();
		}
		public void enterUserName(String username)
		{
			adminusername.sendKeys(username);
			
		}
		public void enterPassword(String password)
		{
			adminpassword.sendKeys(password);
		}
		public void selectUserType(String value)
		{
			pageutility.selectTo_ByValue(admindropdown, value);
		}
		public void clickOnSaveButton()
		{
			savebutton.click();
		}
		public void createNewUser(String username, String password, String value)
		{
			enterUserName(username);
			enterPassword(password);
			selectUserType(value);
			clickOnSaveButton();
		}
		public String getSuccessAlertMessage()
		{
			return sucessalertbox.getText();
			}
		public boolean checkifSuccessTextIsPresent(String expecteddata)
		{
			return generalutility.isTextPresent(sucessalertbox, expecteddata);
		}
	}



