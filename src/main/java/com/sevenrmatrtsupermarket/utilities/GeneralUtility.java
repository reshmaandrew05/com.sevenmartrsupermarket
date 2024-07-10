package com.sevenrmatrtsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Atribute(WebElement element, String atribute) {
		return element.getAttribute(atribute);
	}

	public void dateonDatePicker(WebElement ele)

	{
		ele.sendKeys("27/07/2024");
	}

	public String get_AtributeCssalue(WebElement element, String cssvalue) {
		return element.getCssValue(cssvalue);
	}

	public List<String> getTextOfElements(List<WebElement> element) {
		List<String> data = new ArrayList<String>();
		for (WebElement ele : element) {
			data.add(ele.getText());
		}
		return data;
	}
	public static String get_RandomFirstName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	public boolean isTextPresent(WebElement element, String expecteddata)
	{
		return element.getText().contains(expecteddata);
	}

}
