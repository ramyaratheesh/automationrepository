package com;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class newjunit {
	
	public WebDriver driver;
	   @Test
	   public void testSetup() {
		   
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get("https://www.invanto.com/");
		   driver.close();
	     // String str= "I am done with Junit setup";
	     // assertEquals("I am done with Junit setup",str);
	   }
}
