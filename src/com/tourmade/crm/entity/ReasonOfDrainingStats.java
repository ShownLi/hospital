package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class ReasonOfDrainingStats extends BaseBean<ReasonOfDrainingStats>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8945700958518367681L;
	/**
	 * 流失原因名称
	 */
	private String reasonOfDrainingName;
	/**
	 * 询单数量
	 */
	private int num;
	/**
	 * 占比（num/所有的询单数量，需要计算）
	 */
	private String percent;
	
	public String getReasonOfDrainingName() {
		return reasonOfDrainingName;
	}
	public void setReasonOfDrainingName(String reasonOfDrainingName) {
		this.reasonOfDrainingName = reasonOfDrainingName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public ReasonOfDrainingStats(String reasonOfDrainingName, int num, String percent) {
		super();
		this.reasonOfDrainingName = reasonOfDrainingName;
		this.num = num;
		this.percent = percent;
	}
	public ReasonOfDrainingStats() {
		super();
	}
	@Override
	public String toString() {
		return "ReasonOfDrainingStats [reasonOfDrainingName=" + reasonOfDrainingName + ", num=" + num + ", percent="
				+ percent + "]";
	}
}
