package com.tourmade.crm.common.framework.bean;

import java.util.ArrayList;
import java.util.List;

public class QueryResult<T> implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private int draw;
	
	/**
	 * 查询结果List
	 */
	private List<T> data = new ArrayList<T>();

	/**
	 * 总记录数
	 */
	private long countTotal = 0l;
	
	private long countFiltered = 0l;
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(long countTotal) {
		this.countTotal = countTotal;
	}

	public long getCountFiltered() {
		return countFiltered;
	}

	public void setCountFiltered(long countFiltered) {
		this.countFiltered = countFiltered;
	}

	@Override
	public String toString() {
		return "QueryResult [draw=" + draw + ", data=" + data + ", countTotal=" + countTotal + ", countFiltered="
				+ countFiltered + "]";
	}

	
	
	
}
