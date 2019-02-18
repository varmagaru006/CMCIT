package com.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.base.TestBase;
import com.qa.pageObjects.Agent_LandingPagePageObjects;
import com.qa.pageObjects.ConfigProperties;
import com.qa.pageObjects.User_AccountSummaryPageObjects;
import com.qa.pageObjects.User_LandingPageObjects;
import com.qa.pageObjects.User_ScheduleAppointmentsPageObjects;



public class ScheduleAppointmentsUseCase extends TestBase {

	User_LandingPageObjects user_LandingPage = null;
	User_AccountSummaryPageObjects user_AccountSummaryPage = null;
	User_ScheduleAppointmentsPageObjects user_ScheduleAppointments = null;
	 String b1="";

	@Parameters("browser")
	@BeforeTest
	public void initilizeAllPreRequsites(String browser) throws MalformedURLException
	{
		 driver = getWebdriverOf(browser);
		// System.setProperty("webdriver.gecko.driver",
			//		"/Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/resources/Drivers/geckodriver");
			//driver = new FirefoxDriver();
		 b1=browser;
		//initialization();
		//WebDriver driver=getDriver();
		

	}
	
	@BeforeMethod
	public void getBrowserSetUp() throws MalformedURLException{
		
		
		user_LandingPage=PageFactory.initElements(driver,User_LandingPageObjects.class);
		user_AccountSummaryPage=PageFactory.initElements(driver,User_AccountSummaryPageObjects.class);
		user_ScheduleAppointments=PageFactory.initElements(driver,User_ScheduleAppointmentsPageObjects.class);
	}
	

	@Test
	public void usernameUITest() throws InterruptedException
	{
		
		try {
			driver.get("https://tacqa.credagility.com/security/login");
			//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
			System.out.println("hi-------------->>>>");
//			if (b1.equalsIgnoreCase("chrome")) {
//				Assert.assertTrue(false);
//			}
			//LandingPage.validateUserNameField();
			//user_LandingPage.enterFirstName("Florian"); 
			user_LandingPage.enterFirstName(new String("Florian")); 

			user_LandingPage.enterLastName(new String("Boutellier"));
			user_LandingPage.enterLastFourDigits(new String("1727"));
			user_LandingPage.enterMonth("Dec");
			user_LandingPage.enterDay("27");
			user_LandingPage.enterYear("1992");
			user_LandingPage.clickOnLogin();
			

//			user_AccountSummaryPage.ClickOnScheduleAppointmentHyperlink();
//			Thread.sleep(5000);
//			String dateForAppointment=user_ScheduleAppointments.getADateFromAvailableDates();
//			user_ScheduleAppointments.enterAppointmentDate(dateForAppointment);
//			user_ScheduleAppointments.selectWorkPhone();
//			user_ScheduleAppointments.enterReasonsForCall("First Call");
//			user_ScheduleAppointments.clickOnContinue();
//			user_ScheduleAppointments.verify_appointmentGivenDate(dateForAppointment);
//			user_ScheduleAppointments.verify_appointmentCommentsGiven("First Call");
//			user_ScheduleAppointments.clickOnAppointmentSubmit();
//			user_ScheduleAppointments.verifyAppointmentSuccessMessage("Appointment Saved Successfully");
//			user_ScheduleAppointments.backToAppointmentHyperlink();
//			Thread.sleep(5000);
//			user_ScheduleAppointments.clickOnEditButtonOfScheduleAppointments();
//			user_ScheduleAppointments.clearReasonsForCallTextBox();
//			user_ScheduleAppointments.enterReasonsForCall("Edited Call");
//			user_ScheduleAppointments.clickOnContinue();
//			user_ScheduleAppointments.verify_appointmentCommentsGiven("Edited Call");
//			user_ScheduleAppointments.clickOnAppointmentSubmit();
//			user_ScheduleAppointments.backToAppointmentHyperlink();
//			Thread.sleep(5000);
//			user_ScheduleAppointments.clickOnDeleteButtonOfScheduleAppointments();
//			user_ScheduleAppointments.clickOnDeleteConfirmationYes();
			Thread.sleep(10000);
			user_AccountSummaryPage.LogoutFromUserPortal();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
}
