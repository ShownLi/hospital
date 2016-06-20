package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoOrder extends BaseBean<DemoOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int order_id;
	
	private String name;
	
	private Date creat_time;
	
	private Date update_time;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoOrder [order_id=" + order_id + ", name=" + name + ", creat_time=" + creat_time
				+ ", update_time=" + update_time + "]";
	}

}
