package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageObjects.Agent_LandingPagePageObjects;
import com.qa.pageObjects.ConfigProperties;



public class AgentLoginLogout extends TestBase {

	Agent_LandingPagePageObjects LandingPage = null;
	//ConfigProperties conf= new ConfigProperties();
	
	@BeforeTest
	public void browseGmail()
	{
		initialization();
		 driver=getDriver();
		OpenURL("https://tacqa.credagility.com/agent/security/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		LandingPage=PageFactory.initElements(driver,Agent_LandingPagePageObjects.class);
	}
	
	
	@Test
	public void usernameUITest() throws InterruptedException
	{
		
		try {
			System.out.println("hi-------------->>>>");
			//LandingPage.validateUserNameField();
			LandingPage.enterUsename("Ramki");
			LandingPage.validatePasswordField();
			LandingPage.enterPassword("Test1234");
			LandingPage.loginButtonClick(driver);
			LandingPage.verifySuccessfulLogin(driver);
			LandingPage.clickLogout(driver);
			LandingPage.verifyLogout(driver);
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
