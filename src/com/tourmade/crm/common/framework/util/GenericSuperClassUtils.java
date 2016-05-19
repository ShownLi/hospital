package com.tourmade.crm.common.framework.util;

import java.lang.reflect.ParameterizedType;

public class GenericSuperClassUtils {

	
	public static Class getGenericSuperClass(Class entity) {
		ParameterizedType type = (ParameterizedType) entity.getGenericSuperclass();
		Class entityClass = (Class) type.getActualTypeArguments()[0];
		return entityClass;
	}
}
