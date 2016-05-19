package com.tourmade.crm.common.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 日期工具类
 * @author WangKai
 * @since 2014-09-24
 */
public class DateUtils {
	
	/**
	 * 获取当月第一天时间
	 * @return
	 */
	public static Date getMonthFirstDay(Date date) {     
	    Calendar calendar = Calendar.getInstance(); 
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar     
	            .getActualMinimum(Calendar.DAY_OF_MONTH));     
	    
	    return calendar.getTime();     
	} 
	
	/**
	 * 获取当月最后一天时间
	 * @return
	 */
	public static Date getMonthLastDay(Date date) {     
	    Calendar calendar = Calendar.getInstance();  
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar     
	            .getActualMaximum(Calendar.DAY_OF_MONTH));     
	    return calendar.getTime();     
	}   
	
	/**
	 * 获取早于上线时的某个时间
	 * @return
	 * @throws ParseException 
	 */
	public static Date getFirstDate(Date date) throws ParseException {     
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
	    return sdf.parse("2014-01-01");     
	} 
	
	/**
	 * 获取3000年的时间
	 * @return
	 * @throws ParseException 
	 */
	public static Date getLastDate(Date date) throws ParseException {     
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.parse("3000-01-01");  
	}
	
	/**
	  * 得到本周周一起始时间
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get1OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 1);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}
	
	
	/**
	  * 得到本周周二
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get2OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 2);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}
	
	
	/**
	  * 得到本周周三
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get3OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 3);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}
	
	/**
	  * 得到本周周四
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get4OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 4);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}
	
	/**
	  * 得到本周周五
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get5OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 5);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}
	
	/**
	  * 得到本周周六
	  * 
	  * @return yyyy-MM-dd
	  */
	public static Date get6OfThisWeekFirst() {
		  Calendar c = Calendar.getInstance();
		  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (day_of_week == 0)
		   day_of_week = 7;
		  c.add(Calendar.DATE, -day_of_week + 2);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	}

	 /**
	  * 得到本周周日
	  * 
	  * @return yyyy-MM-dd
	  */
	 public static Date get7OfThisWeekFirst() {
	  Calendar c = Calendar.getInstance();
	  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
	  if (day_of_week == 0)
	   day_of_week = 7;
	  c.add(Calendar.DATE, -day_of_week + 7);
	  c.set(Calendar.HOUR_OF_DAY, 23);
	  c.set(Calendar.MINUTE, 59);
	  c.set(Calendar.SECOND, 59);
	  return c.getTime();
	 }
	 
	 public static Date getTodayLast() {
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.HOUR_OF_DAY, 23);
		  c.set(Calendar.MINUTE, 59);
		  c.set(Calendar.SECOND, 59);
		  return c.getTime();
	 }
	 
	 public static Date getToday_7First(int i) {
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - i);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return c.getTime();
	 }
	 
	 public static String getToday_7FirstStr(int i) {
		  SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		  Calendar c = Calendar.getInstance();
		  c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - i);
		  c.set(Calendar.HOUR_OF_DAY, 0);
		  c.set(Calendar.MINUTE, 0);
		  c.set(Calendar.SECOND, 0);
		  return sdf.format(c.getTime());
	 }
	 
	/**
	 * 获取当前月第一天
	 * 
	 * @return 日期
	 */
	public static Date getMonthFirst() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取当前月第一天String
	 * 
	 * @return 日期
	 */
	public static String getMonthFirstStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取当前月String
	 * 
	 * @return 日期
	 */
	public static String getMonthStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取当前月最后一天
	 * 
	 * @return 日期
	 */
	public static Date getMonthLast() {
		Calendar c = Calendar.getInstance();    
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 获取当前月最后一天String
	 * 
	 * @return 日期
	 */
	public static String getMonthLastString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Calendar c = Calendar.getInstance();    
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取本月所有日期String
	 * @return
	 */
	public static List<String> getAllTheDateOftheMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String today = sdf.format(new Date());
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		int month = cal.get(Calendar.MONTH);
		while (cal.get(Calendar.MONTH) == month) {
			
			if(sdf.format(cal.getTime()).compareTo(today) < 1) {
				list.add(sdf.format(cal.getTime()));
			}
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}
	
	/**
	 * 获取当年第一天
	 * 
	 * @return 日期
	 * @throws ParseException 
	 */
	public static Date getYearFirst() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = "20150101";
		Date date = sdf.parse(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取当年第一天String
	 * 
	 * @return 日期
	 * @throws ParseException 
	 */
	public static String getYearFirstStr() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = "20150101";
		Date date = sdf.parse(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取当年最后一天
	 * 
	 * @return 日期
	 * @throws ParseException 
	 */
	public static Date getYearLast() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = "20151231";
		Date date = sdf.parse(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 获取当年最后一天
	 * 
	 * @return 日期
	 * @throws ParseException 
	 */
	public static String getYearLastStr() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = "20151231";
		Date date = sdf.parse(str);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 获取当年yyyy
	 * 
	 * @return 日期
	 */
	public static String getYearStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
	
	/**
	 * 获取当年月份
	 * 
	 * @return 日期
	 */
	public static List<String> getYearMonthStr() {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		int num = Integer.parseInt(sdf.format(new Date()));
		
		for(int i = 1; i <= num; i ++) {
			if( i < 10) {
				list.add("0" + i);
			}else {
				list.add("" + i);
			}
		}
		
		return list;
	}
	
}
