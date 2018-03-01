package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.MFPayment;
import com.dbconnection;

public class DBverify {
	public WebDriver driver;
	MFPayment rd = new MFPayment();
	dbconnection obj = new dbconnection();
	
	@Test
	public void verifydbrecords() throws Exception {
		 obj.dbcheck();
		 String emailpassed = rd.passemail();
		 String namepassed = rd.passdetails();
		 System.out.println("Name in DB" +obj.myName);
		 System.out.println("Username in DB" +obj.myUsername);
		  
		 System.out.println("Name entered in front site" +namepassed);
		 System.out.println("Username in front site" +emailpassed); 
		  
		 if ((namepassed).equals(obj.myName) && (emailpassed).equals(obj.myUsername)) {
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
}
