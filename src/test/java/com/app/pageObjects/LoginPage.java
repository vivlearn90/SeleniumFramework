package com.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="email")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@value='Log out']")
	@CacheLookup
	WebElement logout;
	
	public void setUsername(String userID) {
		username.sendKeys(userID);
	}
	
	public void setPassword(String pwd)	{
		password.sendKeys(pwd);
	}

	public void Login() {
		loginBtn.click();
	}
	
	public void Logout() {
		logout.click();
	}
}
