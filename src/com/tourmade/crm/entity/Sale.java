package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 销售model
 * 
 * @author lianzheng
 *
 */
public class Sale extends BaseBean<Sale> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer salesId;
	
	private Integer agencyId;
	
	private String salesPortalId;
	
	private String wxUnionId;
	
	private String wxOpenId;
	
	private String salesName;
	
	private String salesEnglishName;
	
	private String salesEmail;

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getSalesPortalId() {
		return salesPortalId;
	}

	public void setSalesPortalId(String salesPortalId) {
		this.salesPortalId = salesPortalId;
	}

	public String getWxUnionId() {
		return wxUnionId;
	}

	public void setWxUnionId(String wxUnionId) {
		this.wxUnionId = wxUnionId;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getSalesEnglishName() {
		return salesEnglishName;
	}

	public void setSalesEnglishName(String salesEnglishName) {
		this.salesEnglishName = salesEnglishName;
	}

	public String getSalesEmail() {
		return salesEmail;
	}

	public void setSalesEmail(String salesEmail) {
		this.salesEmail = salesEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Sale [salesId=" + salesId + ", agencyId=" + agencyId
				+ ", salesPortalId=" + salesPortalId + ", wxUnionId="
				+ wxUnionId + ", wxOpenId=" + wxOpenId + ", salesName="
				+ salesName + ", salesEnglishName=" + salesEnglishName
				+ ", salesEmail=" + salesEmail + "]";
	}

	
}
