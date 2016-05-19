package com.tourmade.crm.common.model.base.value.baseconfig;

import java.util.Map;

public class PageHelper implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int draw;
	
	/**
	 * 起始记录数（从0开始）
	 */
	private int start;
	
	/**
	 * 每页显示记录数
	 */
	private int length;
	
	private Map<String,String> search;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Map<String,String> getSearch() {
		return search;
	}

	public void setSearch(Map<String,String> search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "PageHelper [draw=" + draw + ", start=" + start + ", length=" + length + ", search=" + search + "]";
	}
	
	
	
	
	
	

}
