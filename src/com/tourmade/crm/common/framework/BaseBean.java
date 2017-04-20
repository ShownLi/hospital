package com.tourmade.crm.common.framework;

import java.io.Serializable;

public class BaseBean<T> implements Serializable,Cloneable{
	
	private static final long serialVersionUID = -1710030123175600297L;
	private String mapperNameSpace;
	private String seachValue;
	
	public String getMapperNameSpace() {
		return mapperNameSpace;
	}

	public void setMapperNameSpace(String mapperNameSpace) {
		this.mapperNameSpace = mapperNameSpace;
	}

	public String getSeachValue() {
		
		if(seachValue != null && seachValue.trim().length() > 0) {
			seachValue = seachValue.trim();
			seachValue = seachValue.replaceAll("'", "");
		}else {
			seachValue = "";
		}
		
		return seachValue;
	}

	public void setSeachValue(String seachValue) {
		this.seachValue = seachValue;
	}

	@Override
	public T clone() throws CloneNotSupportedException {
		return (T)super.clone();
	}
	
	public String toCSVString(){
		return "";
	}
	
}
