package com.tourmade.crm.common.framework.util;

public class Property {
	
	private String name;
	private String value;
	private String desc;
	private String note;
	
	public Property() {
	}
	
	public Property(String name, String value, String desc,String note) {
		this.name = name;
		this.value = value;
		this.desc = desc;
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
