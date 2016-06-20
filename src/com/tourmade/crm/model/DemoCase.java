package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 询单model
 * 
 * @author lianzheng
 *
 */
public class DemoCase extends BaseBean<DemoCase> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int case_id;
	
	private String name;
	
	private String country;
	
	private String language;
	
	private Date creat_time;
	
	private Date update_time;
	

	public int getCase_id() {
		return case_id;
	}


	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Date getCreat_time() {
		return creat_time;
	}


	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}


	@Override
	public String toString() {
		return "DemoCase [case_id=" + case_id + ", name=" + name + ", country=" + country + ", language="
				+ language + ", creat_time=" + creat_time + ", update_time=" + update_time + "]";
	}

}
