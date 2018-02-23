package com;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.ReadData;

public class Jenkinstestscript {
	public WebDriver driver;
	ReadData rd = new ReadData();
	@Test (priority =2)
	public void logininvanto() throws Exception {
		 // System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		 // WebDriver driver = new FirefoxDriver();
		 // driver.get("https://www.invanto.com/");
	 
		  driver.get("https://develop.invanto.net/signin");
		  String Expectedtitle = "Invanto Platform";
		  String Actualtitle = driver.getTitle();
		  System.out.println("Before Assertion " + Expectedtitle + Actualtitle);
		  Assert.assertEquals(Expectedtitle, Actualtitle);
		  System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
		  
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys("ramya@invanto.com");  
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys("invanto");
		  
		//  driver.findElement(By.xpath(".//*[@id='admin_login']/div/div[3]/button")).click();	
		  driver.findElement(By.xpath(rd.getData("loginbutton"))).click();
	}
	@Test(priority=0)
	public void signupinvanto() throws Exception {
		  driver.navigate().to("https://develop.invanto.net/apps");
		  driver.findElement(By.xpath(rd.getData("accessbutton"))).click();
		  
		 // driver.findElement(By.xpath("html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/a[1]")).click();
		  
	}

	@BeforeClass
	public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
		  driver = new ChromeDriver(); 
		  rd.getProperties("test.properties");
	}

	@AfterClass
	public void afterMethod() {
		  driver.close();
	}
}
