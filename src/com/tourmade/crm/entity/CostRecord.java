package com.tourmade.crm.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 支付单
 */
public class CostRecord extends BaseBean<CostRecord> {
	private static final long serialVersionUID = 4301490538422487399L;
	private Integer costId;
	private Integer orderId;
	private Integer agencyId;
	private Integer paymentItem;
	private BigDecimal costBudget;
	private BigDecimal costReal;
	private Integer account;
	private Date payTime;
	private String comment;
	private String summary;
	private Integer recorder;
	private BigDecimal costAdjust;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	private Integer isdel;

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public Integer getPaymentItem() {
		return paymentItem;
	}

	public void setPaymentItem(Integer paymentItem) {
		this.paymentItem = paymentItem;
	}

	public BigDecimal getCostBudget() {
		return costBudget;
	}

	public void setCostBudget(BigDecimal costBudget) {
		this.costBudget = costBudget;
	}

	public BigDecimal getCostReal() {
		return costReal;
	}

	public void setCostReal(BigDecimal costReal) {
		this.costReal = costReal;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getRecorder() {
		return recorder;
	}

	public void setRecorder(Integer recorder) {
		this.recorder = recorder;
	}

	public BigDecimal getCostAdjust() {
		return costAdjust;
	}

	public void setCostAdjust(BigDecimal costAdjust) {
		this.costAdjust = costAdjust;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "CostRecord [costId=" + costId + ", orderId=" + orderId + ", agencyId=" + agencyId + ", paymentItem="
				+ paymentItem + ", costBudget=" + costBudget + ", costReal=" + costReal + ", account=" + account
				+ ", payTime=" + payTime + ", comment=" + comment + ", summary=" + summary + ", recorder=" + recorder
				+ ", costAdjust=" + costAdjust + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", isdel=" + isdel + "]";
	}

}
