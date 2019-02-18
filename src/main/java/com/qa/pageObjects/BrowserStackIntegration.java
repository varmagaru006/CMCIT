package com.qa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackIntegration {

  public static final String USERNAME = "ramakrishnadatla1";
  public static final String AUTOMATE_KEY = "TNF7nH7GJtpGpGN4ZrP9";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "71.0");
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "Mojave");
    caps.setCapability("resolution", "1024x768");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.github.com");
    //WebElement element = driver.findElement(By.name("q"));

    //element.sendKeys("BrowserStack");
    //element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}