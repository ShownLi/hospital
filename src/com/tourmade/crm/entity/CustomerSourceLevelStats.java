package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CustomerSourceLevelStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String source;
	
	private Integer level0;
	
	private Integer level0_T;
	
	private Integer level1;
	
	private Integer level1_T;
	
	private Integer level2;
	
	private Integer level2_T;
	
	private Integer level3;
	
	private Integer level3_T;
	
	private String rate;
	
	private String rate_T;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getLevel0() {
		return level0;
	}

	public void setLevel0(Integer level0) {
		this.level0 = level0;
	}

	public Integer getLevel1() {
		return level1;
	}

	public void setLevel1(Integer level1) {
		this.level1 = level1;
	}

	public Integer getLevel2() {
		return level2;
	}

	public void setLevel2(Integer level2) {
		this.level2 = level2;
	}

	public Integer getLevel3() {
		return level3;
	}

	public void setLevel3(Integer level3) {
		this.level3 = level3;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Integer getLevel0_T() {
		return level0_T;
	}

	public void setLevel0_T(Integer level0_T) {
		this.level0_T = level0_T;
	}

	public Integer getLevel1_T() {
		return level1_T;
	}

	public void setLevel1_T(Integer level1_T) {
		this.level1_T = level1_T;
	}

	public Integer getLevel2_T() {
		return level2_T;
	}

	public void setLevel2_T(Integer level2_T) {
		this.level2_T = level2_T;
	}

	public Integer getLevel3_T() {
		return level3_T;
	}

	public void setLevel3_T(Integer level3_T) {
		this.level3_T = level3_T;
	}

	public String getRate_T() {
		return rate_T;
	}

	public void setRate_T(String rate_T) {
		this.rate_T = rate_T;
	}

	@Override
	public String toString() {
		return "CustomerSourceLevelStats [source=" + source + ", level0=" + level0 + ", level0_T=" + level0_T
				+ ", level1=" + level1 + ", level1_T=" + level1_T + ", level2=" + level2 + ", level2_T=" + level2_T
				+ ", level3=" + level3 + ", level3_T=" + level3_T + ", rate=" + rate + ", rate_T=" + rate_T + "]";
	}
}
