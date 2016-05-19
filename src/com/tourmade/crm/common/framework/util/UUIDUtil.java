package com.tourmade.crm.common.framework.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author WangKai
 * @since 2015-06-03
 */
public class UUIDUtil {
	
	/**
	 * 获取当前UUID生成的主键串
	 * @return String
	 */
	public static String getUUID() {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		
		return id;
	}
}
