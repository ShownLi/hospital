package com.tourmade.crm.common.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
@SuppressWarnings({"serial","unchecked","unused","deprecation"})
public class BeanUtil {

	public static void copyObject(Object from, Object to) {

		try {
			BeanUtils.copyProperties(to, from);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static Object invoke(String methodName, Object obj)throws Exception, Throwable{
		return invoke(methodName, obj, null);
	}
	
	public static Object invoke(String methodName, Object obj,  Object... paramValue)throws Exception, Throwable{
		Method findMethod = null;
		Method[] methods = obj.getClass().getMethods();
		for (int iLoop = 0; iLoop < methods.length; iLoop ++){
			if (methods[iLoop].getName().equals(methodName)){
				findMethod = methods[iLoop];
			}
		}
		
		if (paramValue == null){
			paramValue = new Object[0];
		}
		
		return  findMethod.invoke(obj, paramValue);
	}
	
	public static Object invoke(String methodName, Object obj, Class[] parameType, Object... paramValue)throws Exception, Throwable{
		Method method = obj.getClass().getMethod(methodName, parameType);
		return  method.invoke(obj, paramValue);
	}
	
	
	private static Field[] getAllField(Class cl, Field[] fields){
		if (fields == null) return fields;		
		
		Field[] childrenFields = cl.getDeclaredFields();		
		//save 
		Field[] tempFields = new Field[fields.length];
		
		if (fields.length > 0)
			System.arraycopy(fields, 0, tempFields, 0, fields.length);
		
		int totalLen = tempFields.length + childrenFields.length;
		
		fields = new Field[totalLen];	
		if (totalLen > 0){		
			int offset = 0;
			if (tempFields.length > 0)
				System.arraycopy(tempFields, 0, fields, offset, tempFields.length);
			
			offset += tempFields.length;
			
			if (childrenFields.length > 0)
				System.arraycopy(childrenFields, 0, fields, offset, childrenFields.length);
		}
		
		
		Class parent = cl.getSuperclass();
		if (parent != null){
			return getAllField(parent, fields);
		}else{
			return fields;
		}
		
		
	}
	
	public static Field[] getAllField(Class cl){
		return getAllField(cl, new Field[0]);
		
	}
	
	public static void setObjectValue(Object obj, Field[] fields, String propertyName,
			Object value, Class[] parameType) throws Exception, SecurityException,
			IllegalAccessException, NoSuchFieldException {

		if (obj == null || (propertyName == null || propertyName.equals(""))
				|| value == null) {
			return;
		}
		
		
		if (fields != null && fields.length > 0) {

			for (int iLoop = 0; iLoop < fields.length; iLoop++) {
				String findPropertyName = fields[iLoop].getName();

				if (findPropertyName.equals(propertyName)) {
					String setMethodName = "set"
							+ propertyName.toUpperCase().charAt(0)
							+ propertyName.substring(1);
					//Class parameType = java.lang.String.class;

					
					/*int jLoop = 0;
					Method[] methods = obj.getClass().getMethods();
					while (jLoop < methods.length){
						if (methods[jLoop].getName().equals(setMethodName)){
							
							
							//Class[] classT = methods[jLoop].getParameterTypes();
							
							//TypeVariable[] tv = classT[0].getTypeParameters();
							
							
							
							methods[jLoop].invoke(obj, value);
							break;
						}
						jLoop ++;
					}*/
					
					
					
					Method method = obj.getClass().getMethod(setMethodName,parameType);
					method.invoke(obj, value);
				}
			}
		}
	}
}
