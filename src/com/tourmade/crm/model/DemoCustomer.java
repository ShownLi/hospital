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

	private int customerid;
	
	private int portalid;
	
	private String zname;
	
	private String ename;
	
	private String level;
	
	private String location;
	
	private String promote;
	
	private String agegroup;
	
	private String gender;
	
	private String telephone;
	
	private String mobilephone;
	
	private String wechat;
	
	private String qq;
	
	private String email;
	
	private Date birthday;
	
	private Date creat_time;
	
	private Date update_time;

	
	public int getPortalid() {
		return portalid;
	}

	public void setPortalid(int portalid) {
		this.portalid = portalid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getZname() {
		return zname;
	}

	public void setZname(String zname) {
		this.zname = zname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPromote() {
		return promote;
	}

	public void setPromote(String promote) {
		this.promote = promote;
	}


	public String getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
		return "DemoCustomer [customerid=" + customerid + ", portalid=" + portalid + ", zname=" + zname + ", ename="
				+ ename + ", level=" + level + ", location=" + location + ", promote=" + promote + ", agegroup="
				+ agegroup + ", gender=" + gender + ", telephone=" + telephone + ", mobilephone=" + mobilephone
				+ ", wechat=" + wechat + ", qq=" + qq + ", email=" + email + ", birthday=" + birthday + ", creat_time="
				+ creat_time + ", update_time=" + update_time + "]";
	}

}
