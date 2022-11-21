package com.hrm.hr.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	
	/**
	 * This method is used to read the data from property file
	 * @author ABHISHEK
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String CommonDataFromProperty(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IPath_Constants.FilePath);
		
		Properties obj = new Properties();
		
		obj.load(fis);
		
		String value= obj.getProperty(key);
		return value;

	}

}
