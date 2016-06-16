package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 用户model
 * 
 * @author machao
 *
 */
public class DemoUser extends BaseBean<DemoUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int userid;

	private String name;

	private String loginname;

	private String pwd;
	
	private String email;
	
	private String mobilephone;
	
	private Date creattime;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoUser [userid=" + userid + ", name=" + name + ", loginname=" + loginname + ", pwd=" + pwd
				+ ", email=" + email + ", mobilephone=" + mobilephone + ", creattime=" + creattime + "]";
	}
	
}
