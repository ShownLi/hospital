package com.tourmade.crm.common.framework.util;

import java.util.Random;

public class RandomNum {
	private static char ch[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
		'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
		'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z', '0', '1' };
	
	private static Random random = new Random();

	public static synchronized String createRandomString(int length) {
		if (length > 0) {
			int index = 0;
			char[] temp = new char[length];
			int num = random.nextInt();
			for (int i = 0; i < length % 5; i++) {
				temp[index++] = ch[num & 63];
				num >>= 6;
			}
			for (int i = 0; i < length / 5; i++) {
				num = random.nextInt();
				for (int j = 0; j < 5; j++) {
					temp[index++] = ch[num & 63];
					num >>= 6;
				}
			}
			return new String(temp, 0, length);
		} else if (length == 0) {
			return "";
		} else {
        	throw new IllegalArgumentException();
		}
	}
	
	public static double rateOfRepeat(int number){
		int repeat=0;
		String[] str=new String[number];
		for(int i=0;i<number;i++){
			str[i]=RandomNum.createRandomString(10);
		}
		for(int i=0;i<number;i++){
			for(int j=i+1;j<number-1;j++){
				if(str[i].equals(str[j]))
					repeat++;
			}
		}
		return ((double)repeat)/number;
	}
	
	public static void main(String[] args) {
		System.out.println(RandomNum.createRandomString(4));
		double rate=RandomNum.rateOfRepeat(10000);
		System.out.println(rate);
	}
}