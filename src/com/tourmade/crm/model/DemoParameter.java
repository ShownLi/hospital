package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 系统参数model
 * 
 * @author lianzheng
 *
 */
public class DemoParameter extends BaseBean<DemoParameter> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int parameterid;
	
	private String domain;
	
	private String value;
	
	private String chinese;
	
	private String english;
	
	private String depict;
	
	private String sort;
	
	private int isdisplay;
	
	private Date creat_time;
	
	private Date update_time;

	public int getParameterid() {
		return parameterid;
	}

	public void setParameterid(int parameterid) {
		this.parameterid = parameterid;
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

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(int isdisplay) {
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
		return "DemoParameter [parameterid=" + parameterid + ", domain=" + domain + ", value=" + value + ", chinese="
				+ chinese + ", english=" + english + ", depict=" + depict + ", sort=" + sort + ", isdisplay="
				+ isdisplay + ", creat_time=" + creat_time + ", update_time=" + update_time + "]";
	}

}
