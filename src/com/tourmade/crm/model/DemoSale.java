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

	private int sale_id;
	
	private int agency_id;
	
	private String sale_code;
	
	private String name;
	
	private String email;
	
	private String telephone;
	
	private String mobilephone;
	
	private String wechat;
	
	private String qq;
	
	private Date creat_time;
	
	private Date update_time;

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}

	public String getSale_code() {
		return sale_code;
	}

	public void setSale_code(String sale_code) {
		this.sale_code = sale_code;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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
		return "DemoSale [sale_id=" + sale_id + ", agency_id=" + agency_id + ", sale_code=" + sale_code + ", name="
				+ name + ", email=" + email + ", telephone=" + telephone + ", mobilephone=" + mobilephone + ", wechat="
				+ wechat + ", qq=" + qq + ", creat_time=" + creat_time + ", update_time=" + update_time + "]";
	}

}
