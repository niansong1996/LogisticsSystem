package edu.nju.lms.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateTime {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
	String time="";
	
	public String returnTime(){
		time=sdf.format(new Date());
		return time;
	}
	
	public Calendar changeToCal(String x){
		Calendar c=Calendar.getInstance();
		String[] temp=x.split("/");
		c.set(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		return c;
	}
	
	public String changeToString(Calendar c){
		return sdf.format(c);
	}
}
