package com.sevenrmatrtsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profilename;
	@FindBy(xpath="//section//div[@class='container-fluid']//a")
	private List <WebElement> homepagecards;
	@FindBy(xpath="//section//div[@class='container-fluid']//div//p")
	private List<WebElement> cardnames;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getProfileName()
	{
		
		return profilename.getText();
	}

	public void navigateToCard(String name)
	{
	int index=0;
		for(index=0;index<cardnames.size();index++)
		{
			String infoname=cardnames.get(index).getText();
			System.out.println(infoname);
			
			if(infoname.equalsIgnoreCase(name))
			{
				break;
			}
			
	}
		 homepagecards.get(index).click();
}
	
}
