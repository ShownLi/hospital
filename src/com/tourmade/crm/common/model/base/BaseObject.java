package com.tourmade.crm.common.model.base;

import java.io.Serializable;

public class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

