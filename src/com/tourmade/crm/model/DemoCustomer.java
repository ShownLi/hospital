package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoCustomer extends BaseBean<DemoCustomer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int customer_id;
	
	private String name;
	
	private Date creat_time;
	
	private Date update_time;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
		return "DemoCustomer [customer_id=" + customer_id + ", name=" + name + ", creat_time=" + creat_time
				+ ", update_time=" + update_time + "]";
	}

}
