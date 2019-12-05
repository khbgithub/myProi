package com.jdbc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToStr(Date date){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String format = sdf.format(date);
	
		return format;
	}
}
