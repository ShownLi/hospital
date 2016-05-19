package com.tourmade.crm.common.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void println(String msg){
		System.out.println(sdf.format(new Date())+"-------"+msg);
	}
}
