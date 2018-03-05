package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.ReadData;

/*
 
� Name of the person who created the testscript: Ramya Nair
� Date: 05 March 2018
� Version:
� Changed function/event: Added screenshot function - aftermethod
� Change description:
 
 */

public class MFPayment {
	public WebDriver driver;
	ReadData read = new ReadData ();
	String name = "InvantoUser";
	String email = "in";
	
/*	public String getName() {
		System.out.println("Name: ");
	    Scanner scan1 = new Scanner(System.in);
	    name = scan1.nextLine();
	    System.out.println(name);
	    return name;
	 }
	
	public String getEmail() {
	    System.out.println("Email: ");
	    Scanner scan2 = new Scanner(System.in);
	    email = scan2.nextLine();
	    System.out.println(email);
	    return name;
	}
	
	public String passdetails() {
		name1 = this.name;
	//	String email1 = this.email;
		System.out.println("Name passed:" +name1);
		return name1;
	}
	public String passemail() {	
		email1 = this.email;
		System.out.println("Email passed:" +email1);
		return email1;
	} */
	
	public void checkoutprocess() throws Exception {
	//	String testname, testemail;
		driver.get("http://testsiterplan.membership.invanto.net/welcome");
		WebElement element = driver.findElement(By.xpath(read.getData("membershipmenu")));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		WebElement subElement = driver.findElement(By.xpath(read.getData("firstplan")));
		action.moveToElement(subElement);
		
		action.click();
		action.perform();
		     
		driver.findElement(By.xpath(read.getData("planunlockbutton"))).click(); 
		 // driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS); 
		//  driver.get("https://developcheckout.invanto.net/app_dev.php/checkout/order/1778");
		  
	/*	getName();
		getEmail(); */
		
		Thread.sleep(3000);
		  
		driver.findElement(By.xpath(read.getData("payeename"))).clear();
		driver.findElement(By.xpath(read.getData("payeename"))).sendKeys(name);
	//	driver.findElement(By.xpath(read.getData("payeename"))).sendKeys("RRe");
		    
		driver.findElement(By.xpath(read.getData("payeeemail"))).clear();
		driver.findElement(By.xpath(read.getData("payeeemail"))).sendKeys(email);
	//	driver.findElement(By.xpath(read.getData("payeeemail"))).sendKeys("rre@tmail.com");
		  
		Thread.sleep(3000);
		  
		  /* JavascriptExecutor jse = (JavascriptExecutor)driver;
		   jse.executeScript("window.scrollBy(0,250)", "");
		   jse.executeScript("window.scrollBy(0,250)", ""); */
		 	
		      
	//	  driver.get("https://developcheckout.invanto.net/app_dev.php/checkout/order/1778");
		List<WebElement> phonenumber = driver.findElements(By.xpath(read.getData("phonenumber")));
		
		if(phonenumber.size()>0) {
			System.out.println("Phone number is enabled for this plan");
			driver.findElement(By.xpath(read.getData("phonenumber"))).clear();
			driver.findElement(By.xpath(read.getData("phonenumber"))).sendKeys("9999999999");
		}else{
		    System.out.println("Phone number in checkout page is disabled for this plan");
		}
		  
		Thread.sleep(2000);
		List<WebElement> address = driver.findElements(By.xpath(read.getData("address")));
		
		if(address.size()>0){
		//  if(driver.findElement(By.xpath(read.getData("address")))!= null){
			System.out.println("Address is enabled for this plan");
			driver.findElement(By.xpath(read.getData("address"))).clear();
			driver.findElement(By.xpath(read.getData("address"))).sendKeys("Wakad");
			  
		    driver.findElement(By.xpath(read.getData("city"))).clear();
		    driver.findElement(By.xpath(read.getData("city"))).sendKeys("Pune");
		      
		    driver.findElement(By.xpath(read.getData("state"))).clear();
		    driver.findElement(By.xpath(read.getData("state"))).sendKeys("Maharashtra");
		      
		      
		    driver.findElement(By.xpath(read.getData("zipcode"))).clear();
		    driver.findElement(By.xpath(read.getData("zipcode"))).sendKeys("411057");
		      
		    Select country = new Select(driver.findElement(By.xpath(read.getData("country"))));
		    country.selectByVisibleText("India");
		}else{
			System.out.println("Address in checkout page is disabled for this plan"); 
		}
		 
		driver.findElement(By.xpath(read.getData("creditcardnumber"))).clear();
		driver.findElement(By.xpath(read.getData("creditcardnumber"))).sendKeys("4242424242424242");
		  
		Select expmonth = new Select(driver.findElement(By.xpath(read.getData("expirationmonth"))));
		expmonth.selectByVisibleText("3");
		  
		Select expyear = new Select(driver.findElement(By.xpath(read.getData("expirationyear"))));
		expyear.selectByVisibleText("2021");
		  
		driver.findElement(By.xpath(read.getData("cvvcode"))).clear();
		driver.findElement(By.xpath(read.getData("cvvcode"))).sendKeys("213");
		  
		driver.findElement(By.xpath(read.getData("checkoutbutton"))).click();
		  
		//  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(read.getData("continuebutton"))).click();    	       
	 }
	  
	@Test
	public void testrun1() throws Exception {
	//	passdetails();
	//	passemail();
		checkoutprocess();
	}
	@BeforeClass
	public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver(); 
	  driver.manage().window().maximize();
	  read.getProperties("mfpayment.properties");
	}
	
	@AfterClass
	public void afterClass() {
	//  driver.close();
	}
	
	@AfterMethod
	public void screenShot(ITestResult result) {
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		System.out.println("Result:"+result.getStatus());
		System.out.println("ITResult"  +ITestResult.FAILURE);
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("C:\\AutomationTesting\\TestScriptJenkins\\Screenshots\\"+result.getName()+".jpeg"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
	}
}
