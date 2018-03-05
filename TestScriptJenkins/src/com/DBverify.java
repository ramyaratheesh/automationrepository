package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.MFPayment;
import com.dbconnection;

public class DBverify {
	public WebDriver driver;
	MFPayment rd = new MFPayment();
	dbconnection obj = new dbconnection();
	
	@Test
	public void verifydbrecords() throws Exception {
		 obj.dbcheck();
	//	 String emailpassed= rd.passemail();
	//	 String namepassed = rd.passdetails();
		 System.out.println("Name in DB" +obj.myName);
		 System.out.println("Username in DB" +obj.myUsername);
		  
		 System.out.println("Name entered in front site" +rd.name);
		 System.out.println("Username in front site" +rd.email); 
		  
		 if ((rd.name).equals(obj.myName) && (rd.email).equals(obj.myUsername)) {
			System.out.println("Entered name and username exists in database");
		  }else {
			System.out.println("Record doesn't exists in Database");
		  }  
	}
	@BeforeClass
	public void beforeClass(){
		
	}
	
	@AfterClass
	public void afterClass() {
	}
	
	@AfterMethod
	public void screenShot(ITestResult result) {
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
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
