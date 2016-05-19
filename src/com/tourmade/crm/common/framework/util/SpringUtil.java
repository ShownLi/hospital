package com.tourmade.crm.common.framework.util;

import org.springframework.context.ApplicationContext;

public final class SpringUtil {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtil.applicationContext = applicationContext;
	}
	
	public static Object getObject(String objectId){
		
		return SpringUtil.getApplicationContext().getBean(objectId);
	}
	
	
}
