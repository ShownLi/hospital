package com.tourmade.crm.model;

import java.math.BigDecimal;
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
	
	private int caseid;
	
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
	
	private String currency;
	
	private Date grouptime;

	private String groupnumber;
	
	private String exchangerate;
	
	private String customeremailreal;
	
	private String customeremailalias;
	
	private String agencyemailreal;
	
	private String agencyemailalias;
	
	private BigDecimal groupprice;
	
	private BigDecimal rmbprice;
	
	private Date lastresponse;
	
	private Date startdate;
	
	private Date enddate;
	
	private Date creattime;
	
	private Date updatetime;
	
	private String agencyReEmailAlias;
	
	private String agencySeEmailAlias;
	
	private String customerReEmailAlias;
	
	private String customerSeEmailAlias;

	
	public String getAgencyReEmailAlias() {
		return agencyReEmailAlias;
	}

	public void setAgencyReEmailAlias(String agencyReEmailAlias) {
		this.agencyReEmailAlias = agencyReEmailAlias;
	}

	public String getAgencySeEmailAlias() {
		return agencySeEmailAlias;
	}

	public void setAgencySeEmailAlias(String agencySeEmailAlias) {
		this.agencySeEmailAlias = agencySeEmailAlias;
	}

	public String getCustomerReEmailAlias() {
		return customerReEmailAlias;
	}

	public void setCustomerReEmailAlias(String customerReEmailAlias) {
		this.customerReEmailAlias = customerReEmailAlias;
	}

	public String getCustomerSeEmailAlias() {
		return customerSeEmailAlias;
	}

	public void setCustomerSeEmailAlias(String customerSeEmailAlias) {
		this.customerSeEmailAlias = customerSeEmailAlias;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
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

	public String getGroupnumber() {
		return groupnumber;
	}

	public void setGroupnumber(String groupnumber) {
		this.groupnumber = groupnumber;
	}

	public String getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(String exchangerate) {
		this.exchangerate = exchangerate;
	}

	public BigDecimal getGroupprice() {
		return groupprice;
	}

	public void setGroupprice(BigDecimal groupprice) {
		this.groupprice = groupprice;
	}

	public BigDecimal getRmbprice() {
		return rmbprice;
	}

	public void setRmbprice(BigDecimal rmbprice) {
		this.rmbprice = rmbprice;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currecy) {
		this.currency = currecy;
	}

	public String getCustomeremailreal() {
		return customeremailreal;
	}

	public void setCustomeremailreal(String customeremailreal) {
		this.customeremailreal = customeremailreal;
	}

	public String getCustomeremailalias() {
		return customeremailalias;
	}

	public void setCustomeremailalias(String customeremailalias) {
		this.customeremailalias = customeremailalias;
	}

	public String getAgencyemailreal() {
		return agencyemailreal;
	}

	public void setAgencyemailreal(String agencyemailreal) {
		this.agencyemailreal = agencyemailreal;
	}

	public String getAgencyemailalias() {
		return agencyemailalias;
	}

	public void setAgencyemailalias(String agencyemailalias) {
		this.agencyemailalias = agencyemailalias;
	}

	@Override
	public String toString() {
		return "DemoOrder [orderid=" + orderid + ", caseid=" + caseid + ", customerid=" + customerid + ", customername="
				+ customername + ", agencyid=" + agencyid + ", agencyname=" + agencyname + ", salesid=" + salesid
				+ ", salesname=" + salesname + ", destination=" + destination + ", budget=" + budget + ", status="
				+ status + ", reason=" + reason + ", currency=" + currency + ", grouptime=" + grouptime
				+ ", groupnumber=" + groupnumber + ", exchangerate=" + exchangerate + ", customeremailreal="
				+ customeremailreal + ", customeremailalias=" + customeremailalias + ", agencyemailreal="
				+ agencyemailreal + ", agencyemailalias=" + agencyemailalias + ", groupprice=" + groupprice
				+ ", rmbprice=" + rmbprice + ", lastresponse=" + lastresponse + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", creattime=" + creattime + ", updatetime=" + updatetime + "]";
	}

}
