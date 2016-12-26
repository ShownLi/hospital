package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class SellerNotAskStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String country;
	
	private String destination;
	
	private String number;
	
	private String number_T;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getNumber_T() {
		return number_T;
	}

	public void setNumber_T(String number_T) {
		this.number_T = number_T;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "SellerNotAskStats [country=" + country + ", destination=" + destination + ", number=" + number
				+ ", number_T=" + number_T + ", searchStartTime=" + searchStartTime + ", searchEndTime=" + searchEndTime
				+ "]";
	}
}
