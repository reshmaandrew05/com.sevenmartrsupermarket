package com.sevenrmatrtsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmatrtsupermarket.base.Base;
import com.sevenrmatrtsupermarket.pages.HomePage;
import com.sevenrmatrtsupermarket.pages.LoginPage;
import com.sevenrmatrtsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(groups= {"smoke","sanity"})
	public void verifyLogin() {

		loginpage = new LoginPage(driver);
		excelreader.setExcelFile("Logindata", "credentials");
		String data = excelreader.getCellData(1, 0);
		String password = excelreader.getCellData(1, 1);
		loginpage.login(data, password);
		homepage = new HomePage(driver);
		String actualprofilename = homepage.getProfileName();
		System.out.println(actualprofilename);
		String expectedprofilename = "Admin";
		Assert.assertEquals(actualprofilename, expectedprofilename);
		homepage.navigateToCard("Category");

	}
	

	@Test(groups="smoke")
	public void dataRead() {

		excelreader.setExcelFile("Details", "persondetails");
		String data = excelreader.getCellData(0, 0);
		String password = excelreader.getCellData(0, 1);
		System.out.println(data);
		System.out.println(password);

	}

	
}
