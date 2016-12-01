package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 *
 *
 */
public class Agency extends BaseBean<Agency> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer agencyId;
	
	private String name;
	
	private String country;
	
	private String language;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private Integer isSendmail;

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
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

	public Integer getIsSendmail() {
		return isSendmail;
	}

	public void setIsSendmail(Integer isSendmail) {
		this.isSendmail = isSendmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", name=" + name + ", country="
				+ country + ", language=" + language + ", creatTime="
				+ creatTime + ", updateTime=" + updateTime + ", isSendmail="
				+ isSendmail + "]";
	}



}
