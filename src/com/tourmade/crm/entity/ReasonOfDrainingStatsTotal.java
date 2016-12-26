package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class ReasonOfDrainingStatsTotal extends BaseBean<ReasonOfDrainingStatsTotal>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8945700958518367681L;
	/** 
	* 询单数量
	 */
	private int num_T;
	/**
	 * 占比（num/所有的询单数量，需要计算）
	 */
	private String percent_T;
	
	public int getNum_T() {
		return num_T;
	}
	public void setNum_T(int num_T) {
		this.num_T = num_T;
	}
	public String getPercent_T() {
		return percent_T;
	}
	public void setPercent_T(String percent_T) {
		this.percent_T = percent_T;
	}
	
	@Override
	public String toString() {
		return "ReasonOfDrainingStatsTotal [num_T=" + num_T + ", percent_T=" + percent_T + "]";
	}
}
