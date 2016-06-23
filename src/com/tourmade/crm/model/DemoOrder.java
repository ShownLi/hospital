package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoOrder extends BaseBean<DemoOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int orderid;
	
	private int customerid;
	
	private String customername;

	private int agencyid;
	
	private String agencyname;
	
	private int salesid;
	
	private String salesname;
	
	private String destination;
	
	private String budget;
	
	private String status;
	
	private String reason;
	
	private Date grouptime;

	private int groupnumber;
	
	private String rmbdate;
	
	private String exchangerate;	
	
	private Date lastresponse;
	
	private Date startdate;
	
	private Date enddate;
	
	private Date creattime;
	
	private Date updatetime;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public int getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(int agencyid) {
		this.agencyid = agencyid;
	}

	public String getAgencyname() {
		return agencyname;
	}

	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public String getSalesname() {
		return salesname;
	}

	public void setSalesname(String salesname) {
		this.salesname = salesname;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getGrouptime() {
		return grouptime;
	}

	public void setGrouptime(Date grouptime) {
		this.grouptime = grouptime;
	}

	public int getGroupnumber() {
		return groupnumber;
	}

	public void setGroupnumber(int groupnumber) {
		this.groupnumber = groupnumber;
	}

	public String getRmbdate() {
		return rmbdate;
	}

	public void setRmbdate(String rmbdate) {
		this.rmbdate = rmbdate;
	}

	public String getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(String exchangerate) {
		this.exchangerate = exchangerate;
	}

	public Date getLastresponse() {
		return lastresponse;
	}

	public void setLastresponse(Date lastresponse) {
		this.lastresponse = lastresponse;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoOrder [orderid=" + orderid + ", customerid=" + customerid + ", customername=" + customername
				+ ", agencyid=" + agencyid + ", agencyname=" + agencyname + ", salesid=" + salesid + ", salesname="
				+ salesname + ", destination=" + destination + ", budget=" + budget + ", status=" + status + ", reason="
				+ reason + ", grouptime=" + grouptime + ", groupnumber=" + groupnumber + ", rmbdate=" + rmbdate
				+ ", exchangerate=" + exchangerate + ", lastresponse=" + lastresponse + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", creattime=" + creattime + ", updatetime=" + updatetime + ", getOrderid()="
				+ getOrderid() + ", getCustomerid()=" + getCustomerid() + ", getCustomername()=" + getCustomername()
				+ ", getAgencyid()=" + getAgencyid() + ", getAgencyname()=" + getAgencyname() + ", getSalesid()="
				+ getSalesid() + ", getSalesname()=" + getSalesname() + ", getDestination()=" + getDestination()
				+ ", getBudget()=" + getBudget() + ", getStatus()=" + getStatus() + ", getReason()=" + getReason()
				+ ", getGrouptime()=" + getGrouptime() + ", getGroupnumber()=" + getGroupnumber() + ", getRmbdate()="
				+ getRmbdate() + ", getExchangerate()=" + getExchangerate() + ", getLastresponse()=" + getLastresponse()
				+ ", getStartdate()=" + getStartdate() + ", getEnddate()=" + getEnddate() + ", getCreattime()="
				+ getCreattime() + ", getUpdatetime()=" + getUpdatetime() + ", getMapperNameSpace()="
				+ getMapperNameSpace() + ", getSeachValue()=" + getSeachValue() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
