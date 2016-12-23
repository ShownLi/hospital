package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class SellerNotAskStatsD extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String country;
	
	private String destination;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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
		return "SellerNotAskStatsD [country=" + country + ", destination=" + destination + ", searchStartTime="
				+ searchStartTime + ", searchEndTime=" + searchEndTime + "]";
	}
}
