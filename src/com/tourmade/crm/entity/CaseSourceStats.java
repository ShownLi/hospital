package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CaseSourceStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String sourceName; 

	private Integer total;
	
	private Integer status0;
	
	private Integer status1;
	
	private Integer status2;
	
	private Integer status3;
	
	private Integer status4;
	
	private Integer status5;
	
	private Integer status6;
	
	private String rate;
	
	private String searchStartTime;
	
	private String searchEndTime;
	
	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Integer getStatus5() {
		return status5;
	}

	public void setStatus5(Integer status5) {
		this.status5 = status5;
	}

	public Integer getStatus6() {
		return status6;
	}

	public void setStatus6(Integer status6) {
		this.status6 = status6;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getStatus0() {
		return status0;
	}

	public void setStatus0(Integer status0) {
		this.status0 = status0;
	}

	public Integer getStatus1() {
		return status1;
	}

	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}

	public Integer getStatus2() {
		return status2;
	}

	public void setStatus2(Integer status2) {
		this.status2 = status2;
	}

	public Integer getStatus3() {
		return status3;
	}

	public void setStatus3(Integer status3) {
		this.status3 = status3;
	}

	public Integer getStatus4() {
		return status4;
	}

	public void setStatus4(Integer status4) {
		this.status4 = status4;
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "CaseSourceStats [sourceName=" + sourceName + ", total=" + total + ", status0=" + status0 + ", status1="
				+ status1 + ", status2=" + status2 + ", status3=" + status3 + ", status4=" + status4 + ", status5="
				+ status5 + ", status6=" + status6 + ", rate=" + rate + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
	@Override
	public String toCSVString() {
		return sourceName + ", " + total + ", " + status0 + ", " + status1 + ", " + status2 + ", " + status3 + ", "
				+ status4 + ", " + status5 + ", " + status6 + ", " + rate ;
	
	}
}
