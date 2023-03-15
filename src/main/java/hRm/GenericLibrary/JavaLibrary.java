package hRm.GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(500);
		return value;
	}
	
	
	
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will return the current system date in a specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String month = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String dateInFormat = date+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
	}
}
