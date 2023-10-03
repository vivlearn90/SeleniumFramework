package com.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver ldriver;
	
	public Homepage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//li[@id='home']")
	@CacheLookup
	public WebElement hometab;
	
	@FindBy(id="newquote")
	@CacheLookup
	public WebElement requestQuote;
	
	public void hometab_link() {
		hometab.click();
	}
	

}
