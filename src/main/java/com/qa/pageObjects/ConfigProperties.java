package com.qa.pageObjects;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
  private static Properties properties = new Properties();

  static {
    try {
      InputStream fileInput = ConfigProperties.class.getClassLoader().getSystemResourceAsStream("Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/java/com/crm/qa/config/config.properties");
      properties.load(fileInput);
      fileInput.close();

    } catch (FileNotFoundException e) {
      System.err.println("Unable to find config.properties file - FileNotFoundException: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("Exception on loading stream file to properties object: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public ConfigProperties() {
  }

  public String getPropertyValue(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }
  
  public String getBrowser(){
    return properties.getProperty("defaultBrowser");
  }
  
  public String getWaitTime(){
    return properties.getProperty("wait");
  }
  
  
  public String getGGUserID(){
    return properties.getProperty("userID");
  }
  
  public String getGGPwd(){
    return properties.getProperty("pwd");
  }

  public String getURL(){
	    return properties.getProperty("URL");
	  }
  
  public String getchromeDriverPath(){
	    return properties.getProperty("chromeDriverPath");
	  }
  
  public String getedgeDriverPath(){
	    return properties.getProperty("edgeDriverPath");
	  }
  
  public String getfirefoxDrierPath(){
	    return properties.getProperty("firefoxDrierPath");
	  }

}
