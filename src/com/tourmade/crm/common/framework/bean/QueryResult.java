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
	
	private long status0 = 0l;

	private long status1 = 0l;
	
	private long status2 = 0l;
	
	private long status3 = 0l;
	
	private long status4 = 0l;
	
	private long status5 = 0l;
	
	private long status6 = 0l;
	
	
	public long getStatus0() {
		return status0;
	}

	public void setStatus0(long status0) {
		this.status0 = status0;
	}

	public long getStatus1() {
		return status1;
	}

	public void setStatus1(long status1) {
		this.status1 = status1;
	}

	public long getStatus2() {
		return status2;
	}

	public void setStatus2(long status2) {
		this.status2 = status2;
	}

	public long getStatus3() {
		return status3;
	}

	public void setStatus3(long status3) {
		this.status3 = status3;
	}

	public long getStatus4() {
		return status4;
	}

	public void setStatus4(long status4) {
		this.status4 = status4;
	}

	public long getStatus5() {
		return status5;
	}

	public void setStatus5(long status5) {
		this.status5 = status5;
	}

	public long getStatus6() {
		return status6;
	}

	public void setStatus6(long status6) {
		this.status6 = status6;
	}

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
