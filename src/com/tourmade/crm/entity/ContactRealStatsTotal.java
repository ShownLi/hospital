package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class ContactRealStatsTotal extends BaseBean<UserAchievement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1235274712661460706L;
	/**
	 * 询单总数
	 */
	private int total_T;
	/**
	 * 待处理询单数量
	 */
	private int pendingNum_T;
	/**
	 * 沟通中询单数量
	 */
	private int communicatingNum_T;
	/**
	 * 地接设计中询单数量
	 */
	private int agencyDesigningNum_T;
	/**
	 * 成行询单数量
	 */
	private int dealNum_T;
	/**
	 * 未成行询单数量
	 */
	private int noDealNum_T;
	/**
	 * 无效询单数量
	 */
	private int invalidNum_T;
	/**
	 * 已付款询单数量
	 */
	private int paidNum_T;
	/**
	 * 成交率
	 */
	private String dealPercent_T;
	
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
	
	@Override
	public String toString() {
		return "ContactRealStatsTotal [total_T=" + total_T + ", pendingNum_T=" + pendingNum_T + ", communicatingNum_T="
				+ communicatingNum_T + ", agencyDesigningNum_T=" + agencyDesigningNum_T + ", dealNum_T=" + dealNum_T
				+ ", noDealNum_T=" + noDealNum_T + ", invalidNum_T=" + invalidNum_T + ", paidNum_T=" + paidNum_T
				+ ", dealPercent_T=" + dealPercent_T + "]";
	}
}
