package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.TestBase;

public class User_AccountSummaryPageObjects extends TestBase {

	
	@FindBy(xpath = "//span[@class='page-header-stuffix']")
	public WebElement AccountSummary_LastFourDigits;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement LogoutLink;
	
	@FindBy(xpath = "//a[contains(text(),'Schedule Appointment')]")
	public WebElement Schedule_Appointment_Hyperlink;
	

	
	public String getLastFourDigits(){
		waitFor(AccountSummary_LastFourDigits);
		return AccountSummary_LastFourDigits.getText();
	}
	
	public void LogoutFromUserPortal(){
		waitFor(LogoutLink);
		LogoutLink.click();
	}
	
	public void ClickOnScheduleAppointmentHyperlink(){
		waitFor(Schedule_Appointment_Hyperlink);
		Schedule_Appointment_Hyperlink.click();
	}
}
