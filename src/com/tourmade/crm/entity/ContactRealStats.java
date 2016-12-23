package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class ContactRealStats extends BaseBean<UserAchievement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1235274712661460706L;
	/**
	 * 沟通方式名称
	 */
	private String contactName;
	/**
	 * 询单总数
	 */
	private int total;
	/**
	 * 待处理询单数量
	 */
	private int pendingNum;
	/**
	 * 沟通中询单数量
	 */
	private int communicatingNum;
	/**
	 * 地接设计中询单数量
	 */
	private int agencyDesigningNum;
	/**
	 * 成行询单数量
	 */
	private int dealNum;
	/**
	 * 未成行询单数量
	 */
	private int noDealNum;
	/**
	 * 无效询单数量
	 */
	private int invalidNum;
	/**
	 * 已付款询单数量
	 */
	private int paidNum;
	/**
	 * 成交率
	 */
	private String dealPercent;
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPendingNum() {
		return pendingNum;
	}
	public void setPendingNum(int pendingNum) {
		this.pendingNum = pendingNum;
	}
	public int getCommunicatingNum() {
		return communicatingNum;
	}
	public void setCommunicatingNum(int communicatingNum) {
		this.communicatingNum = communicatingNum;
	}
	public int getAgencyDesigningNum() {
		return agencyDesigningNum;
	}
	public void setAgencyDesigningNum(int agencyDesigningNum) {
		this.agencyDesigningNum = agencyDesigningNum;
	}
	public int getDealNum() {
		return dealNum;
	}
	public void setDealNum(int dealNum) {
		this.dealNum = dealNum;
	}
	public int getNoDealNum() {
		return noDealNum;
	}
	public void setNoDealNum(int noDealNum) {
		this.noDealNum = noDealNum;
	}
	public int getInvalidNum() {
		return invalidNum;
	}
	public void setInvalidNum(int invalidNum) {
		this.invalidNum = invalidNum;
	}
	public int getPaidNum() {
		return paidNum;
	}
	public void setPaidNum(int paidNum) {
		this.paidNum = paidNum;
	}
	public String getDealPercent() {
		return dealPercent;
	}
	public void setDealPercent(String dealPercent) {
		this.dealPercent = dealPercent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ContactRealStats(String contactName, int total, int pendingNum, int communicatingNum, int agencyDesigningNum,
			int dealNum, int noDealNum, int invalidNum, int paidNum, String dealPercent) {
		super();
		this.contactName = contactName;
		this.total = total;
		this.pendingNum = pendingNum;
		this.communicatingNum = communicatingNum;
		this.agencyDesigningNum = agencyDesigningNum;
		this.dealNum = dealNum;
		this.noDealNum = noDealNum;
		this.invalidNum = invalidNum;
		this.paidNum = paidNum;
		this.dealPercent = dealPercent;
	}
	public ContactRealStats() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ContactRealStats [contactName=" + contactName + ", total=" + total + ", pendingNum=" + pendingNum
				+ ", communicatingNum=" + communicatingNum + ", agencyDesigningNum=" + agencyDesigningNum + ", dealNum="
				+ dealNum + ", noDealNum=" + noDealNum + ", invalidNum=" + invalidNum + ", paidNum=" + paidNum
				+ ", dealPercent=" + dealPercent + "]";
	}
	
}
