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

	private float exchangeRate;

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

	private Integer operator;

	private String orderCode;
	private BigDecimal costBudget;
	private BigDecimal costBudgetRmb;
	private BigDecimal costReal;
	private BigDecimal priceReal;
	private BigDecimal costAdjust;
	private BigDecimal priceAdjust;
	private Integer financeStatus;
	private Integer costReceiver;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public BigDecimal getCostBudget() {
		return costBudget;
	}

	public void setCostBudget(BigDecimal costBudget) {
		this.costBudget = costBudget;
	}

	public BigDecimal getCostBudgetRmb() {
		return costBudgetRmb;
	}

	public void setCostBudgetRmb(BigDecimal costBudgetRmb) {
		this.costBudgetRmb = costBudgetRmb;
	}

	public BigDecimal getCostReal() {
		return costReal;
	}

	public void setCostReal(BigDecimal costReal) {
		this.costReal = costReal;
	}

	public BigDecimal getPriceReal() {
		return priceReal;
	}

	public void setPriceReal(BigDecimal priceReal) {
		this.priceReal = priceReal;
	}

	public BigDecimal getCostAdjust() {
		return costAdjust;
	}

	public void setCostAdjust(BigDecimal costAdjust) {
		this.costAdjust = costAdjust;
	}

	public BigDecimal getPriceAdjust() {
		return priceAdjust;
	}

	public void setPriceAdjust(BigDecimal priceAdjust) {
		this.priceAdjust = priceAdjust;
	}

	public Integer getFinanceStatus() {
		return financeStatus;
	}

	public void setFinanceStatus(Integer financeStatus) {
		this.financeStatus = financeStatus;
	}

	public Integer getCostReceiver() {
		return costReceiver;
	}

	public void setCostReceiver(Integer costReceiver) {
		this.costReceiver = costReceiver;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public Integer getSalesId() {
		return salesId;
	}

	public String getSalesName() {
		return salesName;
	}

	public String getDestination() {
		return destination;
	}

	public String getBudget() {
		return budget;
	}

	public String getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

	public String getCurrency() {
		return currency;
	}

	public Date getGroupTime() {
		return groupTime;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public float getExchangeRate() {
		return exchangeRate;
	}

	public String getCustomerEmailReal() {
		return customerEmailReal;
	}

	public String getCustomerEmailAlias() {
		return customerEmailAlias;
	}

	public String getAgencyEmailReal() {
		return agencyEmailReal;
	}

	public String getAgencyEmailAlias() {
		return agencyEmailAlias;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public BigDecimal getRmbPrice() {
		return rmbPrice;
	}

	public Date getLastResponse() {
		return lastResponse;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getAgencyReEmailAlias() {
		return agencyReEmailAlias;
	}

	public String getAgencySeEmailAlias() {
		return agencySeEmailAlias;
	}

	public String getCustomerReEmailAlias() {
		return customerReEmailAlias;
	}

	public String getCustomerSeEmailAlias() {
		return customerSeEmailAlias;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setGroupTime(Date groupTime) {
		this.groupTime = groupTime;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public void setCustomerEmailReal(String customerEmailReal) {
		this.customerEmailReal = customerEmailReal;
	}

	public void setCustomerEmailAlias(String customerEmailAlias) {
		this.customerEmailAlias = customerEmailAlias;
	}

	public void setAgencyEmailReal(String agencyEmailReal) {
		this.agencyEmailReal = agencyEmailReal;
	}

	public void setAgencyEmailAlias(String agencyEmailAlias) {
		this.agencyEmailAlias = agencyEmailAlias;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public void setRmbPrice(BigDecimal rmbPrice) {
		this.rmbPrice = rmbPrice;
	}

	public void setLastResponse(Date lastResponse) {
		this.lastResponse = lastResponse;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setAgencyReEmailAlias(String agencyReEmailAlias) {
		this.agencyReEmailAlias = agencyReEmailAlias;
	}

	public void setAgencySeEmailAlias(String agencySeEmailAlias) {
		this.agencySeEmailAlias = agencySeEmailAlias;
	}

	public void setCustomerReEmailAlias(String customerReEmailAlias) {
		this.customerReEmailAlias = customerReEmailAlias;
	}

	public void setCustomerSeEmailAlias(String customerSeEmailAlias) {
		this.customerSeEmailAlias = customerSeEmailAlias;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", caseId=" + caseId + ", customerId=" + customerId + ", customerName="
				+ customerName + ", agencyId=" + agencyId + ", agencyName=" + agencyName + ", salesId=" + salesId
				+ ", salesName=" + salesName + ", destination=" + destination + ", budget=" + budget + ", status="
				+ status + ", reason=" + reason + ", currency=" + currency + ", groupTime=" + groupTime
				+ ", groupNumber=" + groupNumber + ", exchangeRate=" + exchangeRate + ", customerEmailReal="
				+ customerEmailReal + ", customerEmailAlias=" + customerEmailAlias + ", agencyEmailReal="
				+ agencyEmailReal + ", agencyEmailAlias=" + agencyEmailAlias + ", groupPrice=" + groupPrice
				+ ", rmbPrice=" + rmbPrice + ", lastResponse=" + lastResponse + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", creatTime=" + creatTime + ", updateTime=" + updateTime
				+ ", agencyReEmailAlias=" + agencyReEmailAlias + ", agencySeEmailAlias=" + agencySeEmailAlias
				+ ", customerReEmailAlias=" + customerReEmailAlias + ", customerSeEmailAlias=" + customerSeEmailAlias
				+ ", operator=" + operator + ", orderCode=" + orderCode + ", costBudget=" + costBudget
				+ ", costBudgetRmb=" + costBudgetRmb + ", costReal=" + costReal + ", priceReal=" + priceReal
				+ ", costAdjust=" + costAdjust + ", priceAdjust=" + priceAdjust + ", financeStatus=" + financeStatus
				+ ", costReceiver=" + costReceiver + "]";
	}
}
