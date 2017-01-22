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
	
	private String service;
	
	private String source;
	
	private String nameEn;
	
	private String website;
	
	private Date foundTime;
	
	private String location;
	
	private String introduction;
	
	private String account;
	
	private String currency;
	
	private String bank;
	
	private String payment;
	
	private String license;
	
	private String score;
	
	private String status;
	
	private String country;
	
	private String language;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private Integer isSendmail;
	
	private String destination;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", name=" + name + ", service=" + service + ", source=" + source
				+ ", nameEn=" + nameEn + ", website=" + website + ", foundTime=" + foundTime + ", location=" + location
				+ ", introduction=" + introduction + ", account=" + account + ", currency=" + currency + ", bank="
				+ bank + ", payment=" + payment + ", license=" + license + ", score=" + score + ", status=" + status
				+ ", country=" + country + ", language=" + language + ", creatTime=" + creatTime + ", updateTime="
				+ updateTime + ", isSendmail=" + isSendmail + ", destination=" + destination + "]";
	}
}
