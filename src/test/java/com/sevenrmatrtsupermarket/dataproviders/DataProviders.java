package com.sevenrmatrtsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmatrtsupermarket.utilities.ExcelReader;


public class DataProviders {
	ExcelReader excelreader=new ExcelReader();
	@DataProvider(name="login")
	public Object[][] verifyLoginDetails()
	{
		excelreader.setExcelFile("Logindata", "credentials");
		return excelreader.getMultidimentionalData(4, 3);
	}
}
