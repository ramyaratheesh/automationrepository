package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.MFPayment;
import com.dbconnection;

public class DBverify {
	MFPayment rd = new MFPayment();
	dbconnection obj = new dbconnection();

	
  @Test
  public void verifydbrecords() {
	  
	  String name = "Rams";
	  String username = "ram@invanto.com";
	  
	//  System.out.println("Name in DB" +obj.myName);
	//  System.out.println("Username in DB" +obj.myUsername);
	  
	  if ((name.equals(obj.myName) && username.equals(obj.myUsername))) {
			System.out.println("Entered name and username exists in database");
		} 
		else {
			System.out.println("Record doesn't exists in Database");
		}
	  
  }
  @BeforeClass
  public void beforeClass() throws Exception {
	  obj.dbcheck();
  }

  @AfterClass
  public void afterClass() {
  }

}
