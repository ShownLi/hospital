package com.tourmade.crm.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class Order extends BaseBean<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer orderId;
	
	private Integer caseId;
	
	private Integer customerId;
	
	private String customerName;

	private Integer agencyId;
	
	private String agencyName;
	
	private Integer salesId;
	
	private String salesName;
	
	private String destination;
	
	private String budget;
	
	private String status;
	
	private String reason;
	
	private String currency;
	
	private Date groupTime;

	private String groupNumber;
	
	private String exchangeRate;
	
	private String customerEmailReal;
	
	private String customerEmailAlias;
	
	private String agencyEmailReal;
	
	private String agencyEmailAlias;
	
	private BigDecimal groupPrice;
	
	private BigDecimal rmbPrice;
	
	private Date lastResponse;
	
	private Date startDate;
	
	private Date endDate;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private String agencyReEmailAlias;
	
	private String agencySeEmailAlias;
	
	private String customerReEmailAlias;
	
	private String customerSeEmailAlias;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getGroupTime() {
		return groupTime;
	}

	public void setGroupTime(Date groupTime) {
		this.groupTime = groupTime;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getCustomerEmailReal() {
		return customerEmailReal;
	}

	public void setCustomerEmailReal(String customerEmailReal) {
		this.customerEmailReal = customerEmailReal;
	}

	public String getCustomerEmailAlias() {
		return customerEmailAlias;
	}

	public void setCustomerEmailAlias(String customerEmailAlias) {
		this.customerEmailAlias = customerEmailAlias;
	}

	public String getAgencyEmailReal() {
		return agencyEmailReal;
	}

	public void setAgencyEmailReal(String agencyEmailReal) {
		this.agencyEmailReal = agencyEmailReal;
	}

	public String getAgencyEmailAlias() {
		return agencyEmailAlias;
	}

	public void setAgencyEmailAlias(String agencyEmailAlias) {
		this.agencyEmailAlias = agencyEmailAlias;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public BigDecimal getRmbPrice() {
		return rmbPrice;
	}

	public void setRmbPrice(BigDecimal rmbPrice) {
		this.rmbPrice = rmbPrice;
	}

	public Date getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(Date lastResponse) {
		this.lastResponse = lastResponse;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", caseId=" + caseId
				+ ", customerId=" + customerId + ", customerName="
				+ customerName + ", agencyId=" + agencyId + ", agencyName="
				+ agencyName + ", salesId=" + salesId + ", salesName="
				+ salesName + ", destination=" + destination + ", budget="
				+ budget + ", status=" + status + ", reason=" + reason
				+ ", currency=" + currency + ", groupTime=" + groupTime
				+ ", groupNumber=" + groupNumber + ", exchangeRate="
				+ exchangeRate + ", customerEmailReal=" + customerEmailReal
				+ ", customerEmailAlias=" + customerEmailAlias
				+ ", agencyEmailReal=" + agencyEmailReal
				+ ", agencyEmailAlias=" + agencyEmailAlias + ", groupPrice="
				+ groupPrice + ", rmbPrice=" + rmbPrice + ", lastResponse="
				+ lastResponse + ", startDate=" + startDate + ", endDate="
				+ endDate + ", creatTime=" + creatTime + ", updateTime="
				+ updateTime + ", agencyReEmailAlias=" + agencyReEmailAlias
				+ ", agencySeEmailAlias=" + agencySeEmailAlias
				+ ", customerReEmailAlias=" + customerReEmailAlias
				+ ", customerSeEmailAlias=" + customerSeEmailAlias + "]";
	}

	

}
