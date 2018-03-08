package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class newjunit {
	
	public static void main (String args[]) {
		WebDriver driver;
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
		driver.get("http://google.com");
		
	}

	
}
