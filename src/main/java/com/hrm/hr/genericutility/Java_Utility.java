package com.hrm.hr.genericutility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to get random number
	 * @author ABHISHEK
	 * @return
	 */

	public int getRandomNumber()
	{
		Random ran=new Random();
		int random=ran.nextInt(10000);
		return random;
	}
	
	/**
	 * This method is used to get system date
	 * @author ABHISHEK
	 * @return
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		String Sysdate=date.toString();
		return Sysdate;
				
	}

	/**
	 * This method is used to get system date and date in format
	 * @author ABHISHEK
	 * @return
	 */
	public String getSystemDateAndTimeInFormat()
	{
		SimpleDateFormat simdate = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
		Date Systdate=new Date();		
		String getDateAndTime=simdate.format(Systdate);
		return getDateAndTime.replaceAll(":", "-");
	}
}


