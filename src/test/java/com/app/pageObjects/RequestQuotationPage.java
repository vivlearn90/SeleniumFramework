package com.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestQuotationPage {
	
	WebDriver ldriver;
	
	public RequestQuotationPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}

	@FindBy(xpath="//li[@id='newquote']")
	WebElement requestQuotationTab;
	
	@FindBy(xpath="//label[@for='quotation_policyexcess']")
	WebElement policyExcessLabel;
	
	@FindBy(id="quotation_breakdowncover")
	WebElement breakdowncover;
	
	@FindBy(id="quotation_windscreenrepair_t")
	public WebElement screenRepairYes;
	
	@FindBy(id="quotation_windscreenrepair_f")
	public WebElement screenRepairNo;
	
	@FindBy(id="quotation_incidents")
	WebElement quoteIncidents;
	
	@FindBy(id="quotation_vehicle_attributes_registration")
	WebElement vehicleRegistration;
	
	@FindBy(id="quotation_vehicle_attributes_mileage")
	WebElement vehicleAttributes;
	
	@FindBy(id="quotation_vehicle_attributes_value")
	WebElement vehicleValue;
	
	@FindBy(id="quotation_vehicle_attributes_parkinglocation")
	WebElement parkingLocation;
	
	@FindBy(id="quotation_vehicle_attributes_policystart_1i")
	WebElement policyStartYear;
	
	@FindBy(id="quotation_vehicle_attributes_policystart_2i")
	WebElement policyStartMonth;
	
	@FindBy(id="quotation_vehicle_attributes_policystart_3i")
	WebElement policyStartDate;
	
	@FindBy(xpath="//input[@value='Calculate Premium']")
	public WebElement calculatePremium;
	
	@FindBy(id="resetquote")
	WebElement resetQuote;
	
	@FindBy(xpath="//input[@value='Save Quotation']")
	WebElement saveQuotation;
	
	@FindBy(id="calculatedpremium")
	public WebElement calculatedPremium;
	
	
	public void setIncident(String incident) {		
		quoteIncidents.sendKeys(incident);
	}
	
	public void setRegisteration(String regID) {
		vehicleRegistration.sendKeys(regID);
	}
	
	public void setMileage(String mileage) {
		vehicleAttributes.sendKeys(mileage);
	}
	
	public void setEstimatedValue(String value) {
		vehicleValue.sendKeys(value);
	}
	
	public void setParking(String location) {
		Select loc = new Select(parkingLocation);
		loc.selectByVisibleText(location);
	}
	
	public void setBreakdownCover(String type) {
		Select ty = new Select(breakdowncover);
		ty.selectByVisibleText(type);
	}
	
	public void setYear(String year) {
		Select yr = new Select(policyStartYear);
		yr.selectByVisibleText(year);
	}
	
	public void setMonth(String month) {
		Select yr = new Select(policyStartMonth);
		yr.selectByVisibleText(month);
	}
	
	public void setDate(String date) {
		Select yr = new Select(policyStartDate);
		yr.selectByVisibleText(date);
	}
	
	
	
	
}
