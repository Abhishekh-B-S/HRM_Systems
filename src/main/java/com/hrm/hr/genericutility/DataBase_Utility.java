package com.hrm.hr.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utility {
	
	/**
	 * This method is used to register and get connection from database
	 * @author ABHISHEK
	 * @throws Throwable
	 */
	Connection con=null;
	public void connectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection(IPath_Constants.dbURL, IPath_Constants.dbUN, IPath_Constants.dbPWD);
		
		
	}
	
	/**
	 * This method is used to execute query and get data
	 * @author ABHISHEK
	 * @param query
	 * @param columnIndex
	 * @param expdata
	 * @param data
	 * @return
	 * @throws Throwable 
	 */
	
	public String executeQueryAndgetData(String query, int columnIndex, String expdata,String data) throws Throwable {
		
	
		boolean flag=false;
		ResultSet result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(columnIndex);
			if (data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+"-------->data verified");
			return expdata;
		}
		else
		{
			System.out.println(data+"------->data not verified");
			return"";
		}
	}
	
	/**
	 * This method is used to close the database
	 * @author ABHISHEK
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
		
}
	
	
	
	
