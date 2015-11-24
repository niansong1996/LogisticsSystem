package edu.nju.lms.data.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtility {
	public static String Cal2String(Object cal){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(((Calendar)cal).getTime());
	}
}
