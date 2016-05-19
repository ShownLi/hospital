package com.tourmade.crm.common.action;

import com.tourmade.crm.common.framework.util.GenericSuperClassUtils;


public class BaseAction<T> {

	private T entity;
	
	//完成范类转换
	public BaseAction(){
		Class entityClass =GenericSuperClassUtils.getGenericSuperClass(this.getClass());
		try {
			entity = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
