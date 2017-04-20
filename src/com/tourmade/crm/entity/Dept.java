package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

public class Dept extends BaseBean<Dept>{

	private static final long serialVersionUID = 2624408765694168487L;

	private int deptId;
	
	private String name;
	
	private String area;
	
	private String phone;
	
	private String classify;
	
	private Date createTime;
	
	private Date updateTime;
	
	private int isdel;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", name=" + name + ", area=" + area + ", phone=" + phone + ", classify="
				+ classify + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isdel=" + isdel + "]";
	}
}
