package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class SellerNotAskStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String country;
	
	private String number;
	
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

	@Override
	public String toString() {
		return "SellerNotAskStats [country=" + country + ", number=" + number + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
	@Override
	public String toCSVString() {
		// TODO Auto-generated method stub
		return country + ", "  + number;
	}
}
