package com.sevenrmatrtsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmatrtsupermarket.base.Base;
import com.sevenrmatrtsupermarket.listners.RetryAnalyser;
import com.sevenrmatrtsupermarket.pages.AdminUserPage;
import com.sevenrmatrtsupermarket.pages.HomePage;
import com.sevenrmatrtsupermarket.pages.LoginPage;
import com.sevenrmatrtsupermarket.utilities.ExcelReader;
import com.sevenrmatrtsupermarket.utilities.GeneralUtility;

public class AdminTest extends Base {
	
	HomePage homepage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;
	ExcelReader excelreader = new ExcelReader();
	
	
	@Test//(retryAnalyzer = RetryAnalyser.class)
	public void verifyNewAdminUserCreation()
	{
		
		excelreader.setExcelFile("Logindata", "credentials");
		String newUserName=excelreader.getCellData(1, 0)+" "+ GeneralUtility.get_RandomFirstName();//if we given exist name again to add admin user test case will fail to avoid that use generalutility.get_RandomFirstName used for random name automatically concatenate with already exist name to get a new name 
		String newPassword=excelreader.getCellData(1, 1);
		String newUserType=excelreader.getCellData(1, 2);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToCard("Admin Users");
		adminuserpage.clickOnNewButton();
		adminuserpage.createNewUser(newUserName, newPassword, newUserType);
		Assert.assertTrue(adminuserpage.checkifSuccessTextIsPresent("User Created Successfully"));
		
	}
	@Test
	public void verifyAdminUserHeader()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToCard("Admin Users");
		String headername=adminuserpage.adminHeaderName();
		String expectedname="Admin Users";
		Assert.assertEquals(headername, expectedname);
	}
	@Test
	public void adminUserNameSearch()
	{
		//ExcelReader excelreader=new ExcelReader();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login();
		homepage.navigateToCard("Admin Users");
		//String username=excelreader.getCellData(1, 0);
		//String usertype=excelreader.getCellData(1, 2);
		String username="admin Tommy";
		String usertype="admin";
		adminuserpage.searchAdminUser(username, usertype);
		Assert.assertTrue(adminuserpage.checkifSearchUserPresent("Active"));
	}
		
		
		
	
	
}
