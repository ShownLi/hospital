package com.tourmade.crm.common.framework.util;


import java.security.MessageDigest;

public class MD5 {
	private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; ++i)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {

		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (java.lang.Exception md) {
		}
		return resultString;
	}

	public static  String jsbztz(String height,String tiz){
	    String result = "";
		Double bztz;
		bztz=Double.valueOf(tiz)-(Double.valueOf(height)-105);
		
		if(bztz>0){
			result="你超重了!";
		}else if(bztz==0)
		{
			result="你太标准了";
		}else if(bztz<0){
			result="你太瘦了！";
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.print(MD5Encode("123456"));
	}
}
