package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class User_LandingPageObjects extends TestBase {

	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement user_FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']") 
	public WebElement user_lastName;
	
	@FindBy(xpath="//input[@placeholder='Last 4 digits of Account Number']")
	private WebElement lastFourDigitNumber;
	
	@FindBy(xpath="//select[@name='birthMonth']")
	private WebElement birthMonth;
	
	@FindBy(xpath="//select[@name='birthDay']")
	private WebElement birthDay;

	@FindBy(xpath="//select[@name='birthYear']")
	private WebElement birthYear;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	

	
	public void enterFirstName(String firstName){
		waitFor(user_lastName);
		user_FirstName.sendKeys(firstName);
	}
	public void enterLastName(String lastName){
		waitFor(user_lastName);
		user_lastName.sendKeys(lastName);
	}
	public void enterLastFourDigits(String fourDigits){
		waitFor(lastFourDigitNumber);
		lastFourDigitNumber.sendKeys(fourDigits);
	}
	public void enterMonth(String month){
		
		driver.findElement(By.xpath("//option[contains(text(),'"+month+"')]")).click();
		}
	public void enterDay(String day){
		driver.findElement(By.xpath("//option[contains(text(),'"+day+"')]")).click();
	}
	public void enterYear(String year){
		driver.findElement(By.xpath("//option[contains(text(),'"+year+"')]")).click();
	}
	
	public void clickOnLogin(){
		waitFor(loginButton);
		loginButton.click();
	}
	
}
