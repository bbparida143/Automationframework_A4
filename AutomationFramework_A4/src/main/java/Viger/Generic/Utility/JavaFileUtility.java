package Viger.Generic.Utility;

import java.util.Date;
import java.util.Random;

/**
 * this class provides all the java methods
 */
public class JavaFileUtility {
	/**
	 * this method is used to give the random numbers
	 */
	public int toGetRandomNumber() {
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		return RANDOM;
	}

	/**
	 * this method is used to give the system date
	 * 
	 * @return
	 */
	public String toGetSystemdate() {

		Date d = new Date();
		String date[] = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String finalDate = day + " " + month + " " + date1 + " " + time + " " + year;

		return finalDate;

	}

}
