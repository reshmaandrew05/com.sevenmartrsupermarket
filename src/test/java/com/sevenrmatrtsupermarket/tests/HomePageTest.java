package com.sevenrmatrtsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmatrtsupermarket.base.Base;
import com.sevenrmatrtsupermarket.pages.HomePage;
import com.sevenrmatrtsupermarket.pages.LoginPage;
import com.sevenrmatrtsupermarket.utilities.ExcelReader;

public class HomePageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(groups="sanity")
	public void verifyDasBoardCardsClickable() {
		loginpage = new LoginPage(driver);
		loginpage.login("annamol", "12434");
		homepage = new HomePage(driver);
		homepage.navigateToCard("Manage Pages");
		
		
		
	}
	@Test(groups="smoke")
	public void verifyDashBoardCardsCategory() {
		loginpage = new LoginPage(driver);
		loginpage.login("annamol", "12434");
		homepage = new HomePage(driver);
		homepage.navigateToCard("Category");
	}
	
	
	
}
