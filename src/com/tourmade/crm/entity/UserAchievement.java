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
	private int total_T;
	/**
	 * 待处理询单数量
	 */
	private int pendingNum;
	private int pendingNum_T;
	/**
	 * 沟通中询单数量
	 */
	private int communicatingNum;
	private int communicatingNum_T;
	/**
	 * 地接设计中询单数量
	 */
	private int agencyDesigningNum;
	private int agencyDesigningNum_T;
	/**
	 * 成行询单数量
	 */
	private int dealNum;
	private int dealNum_T;
	/**
	 * 未成行询单数量
	 */
	private int noDealNum;
	private int noDealNum_T;
	/**
	 * 无效询单数量
	 */
	private int invalidNum;
	private int invalidNum_T;
	/**
	 * 已付款询单数量
	 */
	private int paidNum;
	private int paidNum_T;
	/**
	 * 成交总金额
	 */
	private int totalDealMoney;
	private int totalDealMoney_T;
	/**
	 * 已付款总金额
	 */
	private int totalPaidMoney;
	private int totalPaidMoney_T;
	/**
	 * 成交率
	 */
	private String dealPercent;
	private String dealPercent_T;
	
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
	
	public int getTotal_T() {
		return total_T;
	}
	public void setTotal_T(int total_T) {
		this.total_T = total_T;
	}
	public int getPendingNum_T() {
		return pendingNum_T;
	}
	public void setPendingNum_T(int pendingNum_T) {
		this.pendingNum_T = pendingNum_T;
	}
	public int getCommunicatingNum_T() {
		return communicatingNum_T;
	}
	public void setCommunicatingNum_T(int communicatingNum_T) {
		this.communicatingNum_T = communicatingNum_T;
	}
	public int getAgencyDesigningNum_T() {
		return agencyDesigningNum_T;
	}
	public void setAgencyDesigningNum_T(int agencyDesigningNum_T) {
		this.agencyDesigningNum_T = agencyDesigningNum_T;
	}
	public int getDealNum_T() {
		return dealNum_T;
	}
	public void setDealNum_T(int dealNum_T) {
		this.dealNum_T = dealNum_T;
	}
	public int getNoDealNum_T() {
		return noDealNum_T;
	}
	public void setNoDealNum_T(int noDealNum_T) {
		this.noDealNum_T = noDealNum_T;
	}
	public int getInvalidNum_T() {
		return invalidNum_T;
	}
	public void setInvalidNum_T(int invalidNum_T) {
		this.invalidNum_T = invalidNum_T;
	}
	public int getPaidNum_T() {
		return paidNum_T;
	}
	public void setPaidNum_T(int paidNum_T) {
		this.paidNum_T = paidNum_T;
	}
	public String getDealPercent_T() {
		return dealPercent_T;
	}
	public void setDealPercent_T(String dealPercent_T) {
		this.dealPercent_T = dealPercent_T;
	}
	public UserAchievement(String userName, int total, int pendingNum, int communicatingNum, int agencyDesigningNum,
			int dealNum, int noDealNum, int invalidNum, int paidNum, int totalDealMoney, int totalPaidMoney,
			String dealPercent) {
		super();
		this.userName = userName;
		this.total = total;
		this.pendingNum = pendingNum;
		this.communicatingNum = communicatingNum;
		this.agencyDesigningNum = agencyDesigningNum;
		this.dealNum = dealNum;
		this.noDealNum = noDealNum;
		this.invalidNum = invalidNum;
		this.paidNum = paidNum;
		this.totalDealMoney = totalDealMoney;
		this.totalPaidMoney = totalPaidMoney;
		this.dealPercent = dealPercent;
	}
	@Override
	public String toString() {
		return "UserAchievement [userName=" + userName + ", total=" + total + ", total_T=" + total_T + ", pendingNum="
				+ pendingNum + ", pendingNum_T=" + pendingNum_T + ", communicatingNum=" + communicatingNum
				+ ", communicatingNum_T=" + communicatingNum_T + ", agencyDesigningNum=" + agencyDesigningNum
				+ ", agencyDesigningNum_T=" + agencyDesigningNum_T + ", dealNum=" + dealNum + ", dealNum_T=" + dealNum_T
				+ ", noDealNum=" + noDealNum + ", noDealNum_T=" + noDealNum_T + ", invalidNum=" + invalidNum
				+ ", invalidNum_T=" + invalidNum_T + ", paidNum=" + paidNum + ", paidNum_T=" + paidNum_T
				+ ", totalDealMoney=" + totalDealMoney + ", totalDealMoney_T=" + totalDealMoney_T + ", totalPaidMoney="
				+ totalPaidMoney + ", totalPaidMoney_T=" + totalPaidMoney_T + ", dealPercent=" + dealPercent
				+ ", dealPercent_T=" + dealPercent_T + "]";
	}
}
