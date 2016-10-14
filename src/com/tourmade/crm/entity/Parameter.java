package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 系统参数model
 * 
 * @author lianzheng
 *
 */
public class Parameter extends BaseBean<Parameter> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer parameterId;
	
	private String domain;
	
	private String value;
	
	private String chinese;
	
	private String english;
	
	private String depict;
	
	private String sort;
	
	private Integer isdisplay;
	
	private Date creatTime;
	
	private Date updateTime;

	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
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

	public Integer getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Parameter [parameterId=" + parameterId + ", domain=" + domain
				+ ", value=" + value + ", chinese=" + chinese + ", english="
				+ english + ", depict=" + depict + ", sort=" + sort
				+ ", isdisplay=" + isdisplay + ", creatTime=" + creatTime
				+ ", updateTime=" + updateTime + "]";
	}

	

}
