package com.tourmade.crm.common.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class StringToDateUtils {

	/**日期类型转换成String类型，格式yyyy-MM-dd HH:mm:ss*/
	public static String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormat.format(date);
		return dateString;
	}
	
	/**String类型转换成日期类型*/
	public static Date stringToDate(String sDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String datetoString(String strDate,String type ){
		 Calendar now = Calendar.getInstance();
		 if(StringUtils.isNotBlank(strDate)){
			 Date startTime = StringToDateUtils.stringToDate(strDate); 
			 now.setTime(startTime);
		 }else{
			 now.setTime(new Date());
		 }
			if(type.equals("1")){				  
				now.add(Calendar.DATE,-7);
				int year = now.get(Calendar.YEAR);  
				int month=now.get(Calendar.MONTH) + 1;
				int day=now.get(Calendar.DAY_OF_MONTH);
				strDate= year+"/"+month+"/"+day+" 00:00:00";	
			}else{
				 int year = now.get(Calendar.YEAR);  
				 int month=now.get(Calendar.MONTH) + 1;
				 int day=now.get(Calendar.DAY_OF_MONTH);
				strDate=year+"/"+month+"/"+day+" 23:59:59";
			} 
		return strDate;
	}
	
	public static String datetoStringNew(String type ){
		 Calendar now = Calendar.getInstance();
		 String strDate=null;
			 now.setTime(new Date());
			if(type.equals("1")){				  
				now.add(Calendar.DATE,-7);
				int year = now.get(Calendar.YEAR);  
				int month=now.get(Calendar.MONTH) + 1;
				int day=now.get(Calendar.DAY_OF_MONTH);
				strDate= year+"/"+month+"/"+day+" 00:00:00";	
			}else if(type.equals("2")){
				now.add(Calendar.DATE,-30);
				int year = now.get(Calendar.YEAR);  
				int month=now.get(Calendar.MONTH) + 1;
				int day=now.get(Calendar.DAY_OF_MONTH);
				strDate= year+"/"+month+"/"+day+" 00:00:00";	
			}else if(type.equals("3")){
				now.add(Calendar.DATE,-90);
				int year = now.get(Calendar.YEAR);  
				int month=now.get(Calendar.MONTH) + 1;
				int day=now.get(Calendar.DAY_OF_MONTH);
				strDate= year+"/"+month+"/"+day+" 00:00:00";	
			}else{
				 int year = now.get(Calendar.YEAR);  
				 int month=now.get(Calendar.MONTH) + 1;
				 int day=now.get(Calendar.DAY_OF_MONTH);
				strDate=year+"/"+month+"/"+day+" 23:59:59";
			} 
		return strDate;
	}
	     public static String getLastDayOfMonth(int year, int month) {     
		         Calendar cal = Calendar.getInstance();     
		         cal.set(Calendar.YEAR, year);     
		        cal.set(Calendar.MONTH, month-1);     
		         cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
		         String s=new   SimpleDateFormat( "yyyy/MM/dd ").format(cal.getTime())+" 23:59:59";
	        return  s;  
		    }   
		public static String getFirstDayOfMonth(int year, int month) {     
		         Calendar cal = Calendar.getInstance();     
		         cal.set(Calendar.YEAR, year);     
		         cal.set(Calendar.MONTH, month-1);  
		         cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE)); 
		        String s=new   SimpleDateFormat( "yyyy/MM/dd ").format(cal.getTime())+" 00:00:00";
		        return  s ; 
	   }   

		//根据出生日期计算年龄
		public static int getCurrentAgeByBirthdate(String brithday)

				   throws ParseException, Exception {

				  try {

				   Calendar calendar = Calendar.getInstance();
				   SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
				  // SimpleDateFormat formatDate = new SimpleDateFormat(FORMATE_DATE_STR);

				   String currentTime = formatDate.format(calendar.getTime());

				   Date today = formatDate.parse(currentTime);

				   Date brithDay = formatDate.parse(brithday);

				 

				   return today.getYear() - brithDay.getYear();

				  } catch (Exception e) {

				   return 0;

				  }

				 }

}
