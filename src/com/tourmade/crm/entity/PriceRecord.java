package com.tourmade.crm.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;
/**
 * 收款单
 */
public class PriceRecord extends BaseBean<PriceRecord>{
	private static final long serialVersionUID = 3496065801778402624L;
	private Integer priceId;
	private String priceCode;
	private Integer orderId;
	private Integer paymentItem;
	private BigDecimal priceBudget;
	private Date deadline;
	private BigDecimal priceReal;
	private Integer account;
	private Date receivedTime;
	private String comment;
	private String summary;
	private Integer recorder;
	private BigDecimal priceAdjust;
	private Integer STATUS;
	private Date createTime;
	private Date updateTime;
	private Integer isdel;
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public String getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPaymentItem() {
		return paymentItem;
	}
	public void setPaymentItem(Integer paymentItem) {
		this.paymentItem = paymentItem;
	}
	public BigDecimal getPriceBudget() {
		return priceBudget;
	}
	public void setPriceBudget(BigDecimal priceBudget) {
		this.priceBudget = priceBudget;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public BigDecimal getPriceReal() {
		return priceReal;
	}
	public void setPriceReal(BigDecimal priceReal) {
		this.priceReal = priceReal;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public Date getReceivedTime() {
		return receivedTime;
	}
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
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
	public BigDecimal getPriceAdjust() {
		return priceAdjust;
	}
	public void setPriceAdjust(BigDecimal priceAdjust) {
		this.priceAdjust = priceAdjust;
	}
	public Integer getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
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
		return "PriceRecord [priceId=" + priceId + ", priceCode=" + priceCode + ", orderId=" + orderId
				+ ", paymentItem=" + paymentItem + ", priceBudget=" + priceBudget + ", deadline=" + deadline
				+ ", priceReal=" + priceReal + ", account=" + account + ", receivedTime=" + receivedTime + ", comment="
				+ comment + ", summary=" + summary + ", recorder=" + recorder + ", priceAdjust=" + priceAdjust
				+ ", STATUS=" + STATUS + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isdel="
				+ isdel + "]";
	}
	
	
}
