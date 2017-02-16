package com.tourmade.crm.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class Customer extends BaseBean<Customer> {

	private static final long serialVersionUID = 1423523863575074623L;

	private Integer customerId;
	
	private Integer portalId;
	
	private String chineseName;
	
	private String englishName;
	
	private String level;
	
	private String location;
	
	private String source;
	
	private String ageGroup;
	
	private String gender;
	
	private String telephone;
	
	private String mobilephone;
	
	private String wechat;
	
	private String qq;
	
	private String email;
	
	private Date birthday;
	
	private Date creatTime;
	
	private Date updateTime;

	private String searchStartTime;
	
	private String searchEndTime;
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
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

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", portalId=" + portalId + ", chineseName=" + chineseName
				+ ", englishName=" + englishName + ", level=" + level + ", location=" + location + ", source=" + source
				+ ", ageGroup=" + ageGroup + ", gender=" + gender + ", telephone=" + telephone + ", mobilephone="
				+ mobilephone + ", wechat=" + wechat + ", qq=" + qq + ", email=" + email + ", birthday=" + birthday
				+ ", creatTime=" + creatTime + ", updateTime=" + updateTime + ", searchStartTime=" + searchStartTime
				+ ", searchEndTime=" + searchEndTime + "]";
	}
}
