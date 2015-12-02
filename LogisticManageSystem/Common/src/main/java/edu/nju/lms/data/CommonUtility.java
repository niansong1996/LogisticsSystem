package edu.nju.lms.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommonUtility {
	public static String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String Cal2String(Object cal){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(((Calendar)cal).getTime());
	}
	
	public static Calendar String2Cal(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(s));
		} catch (ParseException e) {System.out.println("parse failed!!!");}
		return cal;
	}
	
	public static void String2Array(ArrayList<String> list,String s){
		String tmp = s.replace("[", "").replace("]", "");
		if(!tmp.equals("")){
		String array[] = tmp.split(", ");
		for(String t : array) list.add(t);
		}
	}
	public static boolean Calequals(Calendar cal1,Calendar cal2){
		if(cal1.getTime().getYear()==cal2.getTime().getYear())
			if(cal1.getTime().getMonth()==cal2.getTime().getMonth())
				if(cal1.getTime().getDay()==cal2.getTime().getDay())
					return true;
		return false;
		
	}
}
