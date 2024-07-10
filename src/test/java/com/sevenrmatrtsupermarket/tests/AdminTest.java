package com.sevenrmatrtsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmatrtsupermarket.base.Base;
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
	
	
	@Test
	public void verifyNewAdminUserCreation()
	{
		
		excelreader.setExcelFile("Logindata", "credentials");
		String newUserName=excelreader.getCellData(1, 0)+" "+ GeneralUtility.get_RandomFirstName();
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
		
		
		
	
	
}
