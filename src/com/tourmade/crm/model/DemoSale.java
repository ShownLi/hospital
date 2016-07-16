package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 销售model
 * 
 * @author lianzheng
 *
 */
public class DemoSale extends BaseBean<DemoSale> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int salesid;
	
	private int agencyid;
	
	private String salesportalid;
	
	private String wxunionid;
	
	private String wxopenid;
	
	private String salesname;
	
	private String salesemail;

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public int getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(int agencyid) {
		this.agencyid = agencyid;
	}

	public String getSalesportalid() {
		return salesportalid;
	}

	public void setSalesportalid(String salesportalid) {
		this.salesportalid = salesportalid;
	}

	public String getWxunionid() {
		return wxunionid;
	}

	public void setWxunionid(String wxunionid) {
		this.wxunionid = wxunionid;
	}

	public String getWxopenid() {
		return wxopenid;
	}

	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}

	public String getSalesname() {
		return salesname;
	}

	public void setSalesname(String salesname) {
		this.salesname = salesname;
	}

	public String getSalesemail() {
		return salesemail;
	}

	public void setSalesemail(String salesemail) {
		this.salesemail = salesemail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoSale [salesid=" + salesid + ", agencyid=" + agencyid + ", salesportalid=" + salesportalid
				+ ", wxunionid=" + wxunionid + ", wxopenid=" + wxopenid + ", salesname=" + salesname + ", salesemail="
				+ salesemail + "]";
	}

}
