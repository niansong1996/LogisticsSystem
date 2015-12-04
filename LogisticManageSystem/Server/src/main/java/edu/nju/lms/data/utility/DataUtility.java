package edu.nju.lms.data.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtility {
	public static String Cal2String(Object cal){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(((Calendar)cal).getTime());
	}
	
	public static Calendar String2Cal(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(s));
		} catch (ParseException e) {System.err.println("parse failed!!!");}
		return cal;
	}
}
