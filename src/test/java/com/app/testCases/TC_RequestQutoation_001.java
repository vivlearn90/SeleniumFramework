package com.app.testCases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pageObjects.Homepage;
import com.app.pageObjects.LoginPage;
import com.app.pageObjects.RequestQuotationPage;

public class TC_RequestQutoation_001 extends BaseClass {
	
	
	
	@Test
	public void requestQuotation() throws InterruptedException {
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.Login();
		logger.info("User logged in successfully");
		Thread.sleep(3000);
		
		Homepage hp = new Homepage(driver);
		hp.requestQuote.click();
		logger.info("Request Quotation navigated successfully");
		
		RequestQuotationPage rp = new RequestQuotationPage(driver);
		rp.setBreakdownCover("Roadside");
		rp.screenRepairNo.click();
		rp.setIncident("543WER");
		rp.setRegisteration("742");
		rp.setMileage("65");
		rp.setEstimatedValue("23459");
		rp.setParking("Locked Garage");
		rp.setYear("2021");
		rp.setMonth("November");
		rp.setDate("21");
		rp.calculatePremium.click();
		if(rp.calculatedPremium.isDisplayed()) {
			logger.info("Premium calculated");
			Assert.assertTrue(true);
		}
		
		
		
		
		
	}

}
