package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

public class CustomerSourceLevelStats extends BaseBean<Agency>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private String source;
	
	private Integer level0;
	
	private Integer level1;
	
	private Integer level2;
	
	private Integer level3;
	
	private String rate;
	
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

	@Override
	public String toString() {
		return "CustomerSourceLevelStats [source=" + source + ", level0=" + level0 + ", level1=" + level1 + ", level2="
				+ level2 + ", level3=" + level3 + ", rate=" + rate + "]";
	}
}
