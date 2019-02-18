package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitFor(WebElement webElement){
		(new WebDriverWait(driver, 30))
		  .until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public WebDriver getWebdriverOf(String browserType) throws MalformedURLException {
		
		// ramakrishnadatla1   TNF7nH7GJtpGpGN4ZrP9
		//  nandyala1    6kBxicBdVnZybNVRbEiC
		//final String USERNAME = "ramakrishnadatla1";
		//final String AUTOMATE_KEY = "TNF7nH7GJtpGpGN4ZrP9";
		
		final String USERNAME = "nandyala1";
		final String AUTOMATE_KEY = "6kBxicBdVnZybNVRbEiC";
		
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		String browser = browserType.trim();
		
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("crome") || browser.equalsIgnoreCase("c")
				|| browser.equalsIgnoreCase("CHROME")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "71.0");
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mojave");
			caps.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL(URL), caps);
		} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("FireFox")
				|| browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("FIREFOX")
				|| browser.equalsIgnoreCase("FF")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Firefox");
		    caps.setCapability("browser_version", "58.0");
		    caps.setCapability("os", "OS X");
		    caps.setCapability("os_version", "Mojave");
		    caps.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL(URL), caps);

		} else if (browser.equalsIgnoreCase("iphone") || browser.equalsIgnoreCase("IPHONE")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserName", "iPad");
		    caps.setCapability("device", "iPad Pro 12.9 2017");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "11");
			driver = new RemoteWebDriver(new URL(URL), caps);

		} else if (browser.equalsIgnoreCase("safari") || browser.equalsIgnoreCase("Safari")
				|| browser.equalsIgnoreCase("SAFARI")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "12.0");
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mojave");
			caps.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL(URL), caps);
		} else if (browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("ie")
				|| browser.equalsIgnoreCase("internetexplorer") || browser.equalsIgnoreCase("INTERNETEXPLORER")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "11.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL(URL), caps);
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		return driver;

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		System.out.println("browser name>>>>>>>>>>>" + browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/resources/Drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/resources/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		/// Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/java/com/crm/qa/config/config.properties

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	public void OpenURL(String URL) {
		driver.get(URL);

	}

	public WebDriver getDriver() {
		return driver;

	}

}
