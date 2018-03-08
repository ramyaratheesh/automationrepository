package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		


public class NewTest {
  private WebDriver driver;	
  @Test
  public void f() {
	  
	  driver.get("https://www.invanto.com/");  
	  String title = driver.getTitle();				 
	  Assert.assertTrue(title.contains("Invanto")); 		
	  
  }
  @BeforeTest
  public void beforeTest() {
	  public void beforeTest() {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  }

}
