package com.tourmade.crm.model;

public class MailTepBoat {

	private String chinese;
	
	private String english;
	
	private String domain;
	
	private String value;
	
	private String id;

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MailTepBoat [chinese=" + chinese + ", english=" + english + ", domain=" + domain + ", value=" + value
				+ ", id=" + id + "]";
	}
	
}
