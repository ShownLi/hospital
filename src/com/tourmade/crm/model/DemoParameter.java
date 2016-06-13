package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoParameter extends BaseBean<DemoAgency> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int parameter_id;
	
	private String key;
	
	private String value;
	
	private String chinese;
	
	private String english;
	
	private String sort;
	
	private Boolean isdisplay;
	
	private Date creat_time;
	
	private Date update_time;

	public int getParameter_id() {
		return parameter_id;
	}

	public void setParameter_id(int parameter_id) {
		this.parameter_id = parameter_id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Boolean getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Boolean isdisplay) {
		this.isdisplay = isdisplay;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoParameter [parameter_id=" + parameter_id + ", key=" + key + ", value=" + value + ", chinese="
				+ chinese + ", english=" + english + ", sort=" + sort + ", isdisplay=" + isdisplay + ", creat_time="
				+ creat_time + ", update_time=" + update_time + "]";
	}
	
}
