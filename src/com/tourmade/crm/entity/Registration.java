package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

public class Registration extends BaseBean<Registration>{

	private static final long serialVersionUID = -2918306055035507981L;

	private int registrationId;
	
	private int patientId;
	
	private int deptId;
	
	private int doctorId;
	
	private Date createTime;
	
	private Date updateTime;
	
	private int isdel;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
		return "Registration [registrationId=" + registrationId + ", patientId=" + patientId + ", deptId=" + deptId
				+ ", doctorId=" + doctorId + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isdel="
				+ isdel + "]";
	}
}
