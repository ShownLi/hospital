package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 销售model
 * 
 * @author lianzheng
 *
 */
public class DemoSale extends BaseBean<DemoSale> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int saleid;
	
	private int agency;
	
	private String code;
	
	private String name;
	
	private String email;
	
	private Date update_time;

	public int getSaleid() {
		return saleid;
	}

	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "DemoSale [saleid=" + saleid + ", agency=" + agency + ", code=" + code + ", name=" + name + ", email="
				+ email + ", update_time=" + update_time + "]";
	}

}
