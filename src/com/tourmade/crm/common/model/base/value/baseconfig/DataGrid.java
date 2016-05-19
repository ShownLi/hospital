package com.tourmade.crm.common.model.base.value.baseconfig;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * 刘杰
 */
@SuppressWarnings("unchecked")
public class DataGrid implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long total = 0L;
	
	private List rows = new ArrayList();
	
	private Long iTotalRecords = 0L;
	private Long iTotalDisplayRecords= 0L;
	private String sEcho;
	
	private List aaData = new ArrayList();

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List getAaData() {
		return aaData;
	}

	public void setAaData(List aaData) {
		this.aaData = aaData;
	}

}
