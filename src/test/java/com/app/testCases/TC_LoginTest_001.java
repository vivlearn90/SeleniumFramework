package com.app.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.app.pageObjects.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TC_LoginTest_001 extends BaseClass {
	
	



	@Test
	public void loginTest() throws  IOException {
		
		
		logger.info("Website opened");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.Login();
		logger.info("Logged In successfully");
		
		
		
		if(driver.getTitle().equals("Insurance Broker System")) {
			
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "Login Test");
			Assert.assertTrue(false);
			logger.info("login test failed");
			
		}
		
		
	}
}
