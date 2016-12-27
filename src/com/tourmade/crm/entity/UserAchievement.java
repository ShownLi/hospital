package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class UserAchievement extends BaseBean<UserAchievement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1389087928282698385L;
	/**
	 * 跟单员姓名
	 */
	private String userName;
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
	 * 成交总金额
	 */
	private int totalDealMoney;
	/**
	 * 已付款总金额
	 */
	private int totalPaidMoney;
	/**
	 * 成交率
	 */
	private String dealPercent;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getTotalDealMoney() {
		return totalDealMoney;
	}
	public void setTotalDealMoney(int totalDealMoney) {
		this.totalDealMoney = totalDealMoney;
	}
	public int getTotalPaidMoney() {
		return totalPaidMoney;
	}
	public void setTotalPaidMoney(int totalPaidMoney) {
		this.totalPaidMoney = totalPaidMoney;
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
	
	public UserAchievement() {
	}
	
	@Override
	public String toString() {
		return "UserAchievement [userName=" + userName + ", total=" + total + ", pendingNum=" + pendingNum
				+ ", communicatingNum=" + communicatingNum + ", agencyDesigningNum=" + agencyDesigningNum + ", dealNum="
				+ dealNum + ", noDealNum=" + noDealNum + ", invalidNum=" + invalidNum + ", paidNum=" + paidNum
				+ ", totalDealMoney=" + totalDealMoney + ", totalPaidMoney=" + totalPaidMoney + ", dealPercent="
				+ dealPercent + "]";
	}
}
