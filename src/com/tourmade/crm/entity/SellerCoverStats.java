package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class SellerCoverStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String country;
	
	private String countryTotal;
	
	private String number;
	
	private String numberTotal;

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

	public String getCountryTotal() {
		return countryTotal;
	}

	public void setCountryTotal(String countryTotal) {
		this.countryTotal = countryTotal;
	}

	public String getNumberTotal() {
		return numberTotal;
	}

	public void setNumberTotal(String numberTotal) {
		this.numberTotal = numberTotal;
	}

	@Override
	public String toString() {
		return "SellerCoverStats [country=" + country + ", countryTotal=" + countryTotal + ", number=" + number
				+ ", numberTotal=" + numberTotal + "]";
	}
}
