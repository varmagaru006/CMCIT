package com.qa.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class User_ScheduleAppointmentsPageObjects extends TestBase  {
	
	@FindBy(xpath = "//h1[@class='text-transform']")
	public WebElement ScheduleAppointmentsPageHeading;
	
	@FindBy(xpath = "//input[@id='appointmentDate']")
	public WebElement appointmentDate;
	
	@FindBy(xpath = "//input[@id='byWorkPhoneBox']")
	public WebElement byWorkPhoneBox;
	
	@FindBy(xpath = "//input[@id='byOtherPhoneBox']")
	public WebElement byOtherPhoneBox;
	
	@FindBy(xpath = "//textarea[@id='comments']")
	public WebElement comments;
	
	@FindBy(xpath = "//input[@id='confirmBtn']")
	public WebElement continueButton;
	
	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath = "//h1[@class='text-transform']")
	public WebElement appointmentConfirmationDraftHeading;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[1]")
	public WebElement appointmentDateGiven;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[11]/div[2]/div[1]/p[1]")
	public WebElement appointmentCommentsGiven;
	
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElement appointmentConfirmation_SubmitButton;
	

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElement appointmentConfirmation_CancelButton;
	

	@FindBy(xpath = "//input[@value='Edit']")
	public WebElement appointmentConfirmation_EditButton;
	
	
	@FindBy(xpath = "//p[@class='vertical']")
	public WebElement appointment_Success_Message;
	
	@FindBy(xpath = "//a[contains(text(),'Back to Appointment List')]")
	public WebElement backToAppointmentHyperlink;
	
	
	@FindBy(xpath = "//span[contains(text(),'DELETE')]")
	public WebElement scheduledAppointments_DeleteButton;
	
	
	@FindBy(xpath = "//a[contains(text(),'EDIT')]")
	public WebElement scheduledAppointments_EditButton;
	
	@FindBy(xpath = "//a[contains(text(),'Do Not Delete Appointment')]")
	public WebElement deleteConfirmationNo;
	
	@FindBy(xpath = "//a[@class='vertical']")
	public WebElement deleteConfirmationYes;
	
	
	
	public void enterAppointmentDate(String date) throws InterruptedException{
		((JavascriptExecutor)driver).executeScript ("document.getElementById('appointmentDate').removeAttribute('readonly',0);"); // Enables the from date box
		Thread.sleep(2000);
		appointmentDate.sendKeys(date);
	}
	
	public String getADateFromAvailableDates(){
		return appointmentDate.getAttribute("availabledays").split(";")[1];
	}
	
	public void selectWorkPhone(){
		byWorkPhoneBox.click();
	}
	
	public void enterReasonsForCall(String reasons){
		comments.sendKeys(reasons);
	}
	
	public void clickOnContinue(){
		continueButton.click();
	}
	
	public void verifyAppointmentGivendate(String text){
		appointmentDateGiven.getText().equalsIgnoreCase(text);
	}
	
	public void verifyAppointmentComments(String text){
		appointmentCommentsGiven.getText().equalsIgnoreCase(text);
	}
	
	public void clickOnAppointmentSubmit(){
		appointmentConfirmation_SubmitButton.click();
	}
	
	public void verifyAppointmentSuccessMessage(String text){
		appointment_Success_Message.getText().equalsIgnoreCase(text);
	}
	
	public void verify_appointmentGivenDate(String text){
		appointmentDateGiven.getText().equalsIgnoreCase(text);
	}
	
	public void verify_appointmentCommentsGiven(String text){
		appointmentCommentsGiven.getText().equalsIgnoreCase(text);
	}
	
	public void appointmentConfirmation_SubmitButton(){
		appointmentConfirmation_SubmitButton.click();
	}
	
	public void appointment_Success_Message(String text){
		appointment_Success_Message.getText().equalsIgnoreCase(text);
	}
	public void backToAppointmentHyperlink(){
		backToAppointmentHyperlink.click();
	}
	
	public void clickOnEditButtonOfScheduleAppointments(){
		scheduledAppointments_EditButton.click();
	}
	public void clickOnDeleteButtonOfScheduleAppointments(){
		scheduledAppointments_DeleteButton.click();
	}
	
	public void clearReasonsForCallTextBox(){
		comments.clear();
	}
	
	public void clickOnDeleteConfirmationYes(){
		deleteConfirmationYes.click();
	}
}

