package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
		
	  Properties prop;
	  public  void getProperties(String propertyfilename)  {
		  File file = new File("C:\\AutomationTesting\\TestScriptJenkins\\Resource\\"+propertyfilename);
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }	
	  
	  public String getData(String ElementName) throws Exception {
			// Read value using the logical name as Key
			String data = prop.getProperty(ElementName);
			return data;
		
	  }
			
}