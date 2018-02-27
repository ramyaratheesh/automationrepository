package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ReadData;
//import org.openqa.selenium.lift.find.InputFinder;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class dbconnection {
	public WebDriver driver;
	ReadData read = new ReadData ();
	String myName, myUsername;
	   
@Test
	public void dbcheck () throws  Exception {	
	 read.getProperties("databasetesting.properties");
			
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
            String dbUrl = read.getData("DBConnectionString");					

			//Database Username		
			String username = read.getData("username");	
            
			//Database Password		
			String password = read.getData("password");				

			//Query to Execute		
			String query = read.getData("query");	
            
     	    //Load mysql jdbc driver		
       	    Class.forName("com.mysql.jdbc.Driver");			
       
       		//Create Connection to DB		
        	Connection con = (Connection) DriverManager.getConnection(dbUrl, username, password);
      
      		//Create Statement Object		
    	    Statement stmt = (Statement) con.createStatement();					
   
   			// Execute the SQL Query. Store results in ResultSet		
     		ResultSet rs=  (ResultSet) stmt.executeQuery(query);							
     
     		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		myName = rs.getString(1);								        
                        myUsername = rs.getString(2);					                               
                        System. out.println("Name: "+myName+"  "+"Username: "+myUsername);		
                }		
  			 // closing DB Connection		
  			con.close();			
	}
/*	public String getname(){
		return myName;
	}
	public String getusername(){
		return myUsername;
	} */
 
  @BeforeClass
  public void beforeClass() {
	//  read.getProperties("databasetesting.properties");
  }

  @AfterClass
  public void afterClass() {
  }

}
