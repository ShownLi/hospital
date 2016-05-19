package com.tourmade.crm.common.framework;

import java.util.ArrayList;
import java.util.List;

public class PageList<T extends BaseBean> {
	private int curPage;
	private int pageSize;
	private List<T> listData = new ArrayList<T>();
	private long count=0;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
 
}
