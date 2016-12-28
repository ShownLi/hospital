package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CaseAllotStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String userName; 
	
	private Integer total;

	private String web_form;
	
	private String mobile_form;
	
	private String direct_form;
	
	private String wechat_form;
	
	private String web_service;
	
	private String mobile_service;
	
	private String phone_service;
	
	private String wechat_service;
	
	private String offline;
	
	private String email;
	
	private String friends;
	
	private String customer;
	
	private String ctrip;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWeb_form() {
		return web_form;
	}

	public void setWeb_form(String web_form) {
		this.web_form = web_form;
	}

	public String getMobile_form() {
		return mobile_form;
	}

	public void setMobile_form(String mobile_form) {
		this.mobile_form = mobile_form;
	}

	public String getDirect_form() {
		return direct_form;
	}

	public void setDirect_form(String direct_form) {
		this.direct_form = direct_form;
	}

	public String getWechat_form() {
		return wechat_form;
	}

	public void setWechat_form(String wechat_form) {
		this.wechat_form = wechat_form;
	}

	public String getWeb_service() {
		return web_service;
	}

	public void setWeb_service(String web_service) {
		this.web_service = web_service;
	}

	public String getMobile_service() {
		return mobile_service;
	}

	public void setMobile_service(String mobile_service) {
		this.mobile_service = mobile_service;
	}

	public String getPhone_service() {
		return phone_service;
	}

	public void setPhone_service(String phone_service) {
		this.phone_service = phone_service;
	}

	public String getWechat_service() {
		return wechat_service;
	}

	public void setWechat_service(String wechat_service) {
		this.wechat_service = wechat_service;
	}

	public String getOffline() {
		return offline;
	}

	public void setOffline(String offline) {
		this.offline = offline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCtrip() {
		return ctrip;
	}

	public void setCtrip(String ctrip) {
		this.ctrip = ctrip;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CaseAllotStats [userName=" + userName + ", total=" + total + ", web_form=" + web_form + ", mobile_form="
				+ mobile_form + ", direct_form=" + direct_form + ", wechat_form=" + wechat_form + ", web_service="
				+ web_service + ", mobile_service=" + mobile_service + ", phone_service=" + phone_service
				+ ", wechat_service=" + wechat_service + ", offline=" + offline + ", email=" + email + ", friends="
				+ friends + ", customer=" + customer + ", ctrip=" + ctrip + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
	@Override
	public String toCSVString() {
		return userName + "," + total + "," + web_form + "," + mobile_form + "," + direct_form + "," + wechat_form
				+ "," + web_service + "," + mobile_service + "," + phone_service + "," + wechat_service + ","
				+ offline + "," + email + "," + friends + "," + customer + "," + ctrip 	;
	}
}
