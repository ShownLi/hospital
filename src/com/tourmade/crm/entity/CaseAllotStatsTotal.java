package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CaseAllotStatsTotal extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private Integer total_T;

	private String web_form_T;
	
	private String mobile_form_T;
	
	private String direct_form_T;
	
	private String wechat_form_T;
	
	private String web_service_T;
	
	private String mobile_service_T;
	
	private String phone_service_T;
	
	private String wechat_service_T;
	
	private String offline_T;
	
	private String email_T;
	
	private String friends_T;
	
	private String customer_T;
	
	private String ctrip_T;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public Integer getTotal_T() {
		return total_T;
	}

	public void setTotal_T(Integer total_T) {
		this.total_T = total_T;
	}

	public String getWeb_form_T() {
		return web_form_T;
	}

	public void setWeb_form_T(String web_form_T) {
		this.web_form_T = web_form_T;
	}

	public String getMobile_form_T() {
		return mobile_form_T;
	}

	public void setMobile_form_T(String mobile_form_T) {
		this.mobile_form_T = mobile_form_T;
	}

	public String getDirect_form_T() {
		return direct_form_T;
	}

	public void setDirect_form_T(String direct_form_T) {
		this.direct_form_T = direct_form_T;
	}

	public String getWechat_form_T() {
		return wechat_form_T;
	}

	public void setWechat_form_T(String wechat_form_T) {
		this.wechat_form_T = wechat_form_T;
	}

	public String getWeb_service_T() {
		return web_service_T;
	}

	public void setWeb_service_T(String web_service_T) {
		this.web_service_T = web_service_T;
	}

	public String getMobile_service_T() {
		return mobile_service_T;
	}

	public void setMobile_service_T(String mobile_service_T) {
		this.mobile_service_T = mobile_service_T;
	}

	public String getPhone_service_T() {
		return phone_service_T;
	}

	public void setPhone_service_T(String phone_service_T) {
		this.phone_service_T = phone_service_T;
	}

	public String getWechat_service_T() {
		return wechat_service_T;
	}

	public void setWechat_service_T(String wechat_service_T) {
		this.wechat_service_T = wechat_service_T;
	}

	public String getOffline_T() {
		return offline_T;
	}

	public void setOffline_T(String offline_T) {
		this.offline_T = offline_T;
	}

	public String getEmail_T() {
		return email_T;
	}

	public void setEmail_T(String email_T) {
		this.email_T = email_T;
	}

	public String getFriends_T() {
		return friends_T;
	}

	public void setFriends_T(String friends_T) {
		this.friends_T = friends_T;
	}

	public String getCustomer_T() {
		return customer_T;
	}

	public void setCustomer_T(String customer_T) {
		this.customer_T = customer_T;
	}

	public String getCtrip_T() {
		return ctrip_T;
	}

	public void setCtrip_T(String ctrip_T) {
		this.ctrip_T = ctrip_T;
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

	@Override
	public String toString() {
		return "CaseAllotStatsTotal [total_T=" + total_T + ", web_form_T=" + web_form_T + ", mobile_form_T="
				+ mobile_form_T + ", direct_form_T=" + direct_form_T + ", wechat_form_T=" + wechat_form_T
				+ ", web_service_T=" + web_service_T + ", mobile_service_T=" + mobile_service_T + ", phone_service_T="
				+ phone_service_T + ", wechat_service_T=" + wechat_service_T + ", offline_T=" + offline_T + ", email_T="
				+ email_T + ", friends_T=" + friends_T + ", customer_T=" + customer_T + ", ctrip_T=" + ctrip_T
				+ ", searchStartTime=" + searchStartTime + ", searchEndTime=" + searchEndTime + "]";
	}
}
