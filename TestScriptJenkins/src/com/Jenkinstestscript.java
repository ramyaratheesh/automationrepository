package com;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Jenkinstestscript {
@Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	
	  
	 // System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	 // WebDriver driver = new FirefoxDriver();
	 // driver.get("https://www.invanto.com/");
	 
	  driver.get("https://develop.invanto.net/signin");
	  String Expectedtitle = "Invanto Platform";
	  String Actualtitle = driver.getTitle();
	  System.out.println("Before Assertion " + Expectedtitle + Actualtitle);
	  Assert.assertEquals(Expectedtitle, Actualtitle);
	  System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


}
