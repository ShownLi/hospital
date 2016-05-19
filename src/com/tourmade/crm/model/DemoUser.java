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
	
	private Date upttime;
	
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

	public Date getUpttime() {
		return upttime;
	}

	public void setUpttime(Date upttime) {
		this.upttime = upttime;
	}

	@Override
	public String toString() {
		return "DemoUser [userid=" + userid + ", name=" + name + ", loginname=" + loginname + ", pwd=" + pwd
				+ ", upttime=" + upttime + "]";
	}


	

}
