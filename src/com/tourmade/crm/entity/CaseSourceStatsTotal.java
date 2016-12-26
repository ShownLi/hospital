package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CaseSourceStatsTotal extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private Integer total_T;
	
	private Integer status0_T;
	
	private Integer status1_T;
	
	private Integer status2_T;
	
	private Integer status3_T;
	
	private Integer status4_T;
	
	private Integer status5_T;
	
	private Integer status6_T;
	
	private String rate_T;
	
	private String searchStartTime;
	
	private String searchEndTime;

	public Integer getTotal_T() {
		return total_T;
	}

	public void setTotal_T(Integer total_T) {
		this.total_T = total_T;
	}

	public Integer getStatus0_T() {
		return status0_T;
	}

	public void setStatus0_T(Integer status0_T) {
		this.status0_T = status0_T;
	}

	public Integer getStatus1_T() {
		return status1_T;
	}

	public void setStatus1_T(Integer status1_T) {
		this.status1_T = status1_T;
	}

	public Integer getStatus2_T() {
		return status2_T;
	}

	public void setStatus2_T(Integer status2_T) {
		this.status2_T = status2_T;
	}

	public Integer getStatus3_T() {
		return status3_T;
	}

	public void setStatus3_T(Integer status3_T) {
		this.status3_T = status3_T;
	}

	public Integer getStatus4_T() {
		return status4_T;
	}

	public void setStatus4_T(Integer status4_T) {
		this.status4_T = status4_T;
	}

	public Integer getStatus5_T() {
		return status5_T;
	}

	public void setStatus5_T(Integer status5_T) {
		this.status5_T = status5_T;
	}

	public Integer getStatus6_T() {
		return status6_T;
	}

	public void setStatus6_T(Integer status6_T) {
		this.status6_T = status6_T;
	}

	public String getRate_T() {
		return rate_T;
	}

	public void setRate_T(String rate_T) {
		this.rate_T = rate_T;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	@Override
	public String toString() {
		return "CaseSourceStatsTotal [total_T=" + total_T + ", status0_T=" + status0_T + ", status1_T=" + status1_T
				+ ", status2_T=" + status2_T + ", status3_T=" + status3_T + ", status4_T=" + status4_T + ", status5_T="
				+ status5_T + ", status6_T=" + status6_T + ", rate_T=" + rate_T + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
}
