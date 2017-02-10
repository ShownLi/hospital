package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 销售model
 * 
 * @author lianzheng
 *
 */
public class Sale extends BaseBean<Sale> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer salesId;
	
	private Integer agencyId;
	
	private String salesPortalId;
	
	private String wxUnionId;
	
	private String wxOpenId;
	
	private String salesName;
	
	private String salesEmail;
	
	private String title;
	
	private String telephone;
	
	private String mobilephone;
	
	private String fax;
	
	private String qq;
	
	private String skype;
	
	private String wechat;
	
	private String skill;
	
	private String introduction;
	
	private String address;
	
	private String photo;
	
	private String namecard;
	
	private String photoPath;
	
	private String nameCardPath;

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getSalesPortalId() {
		return salesPortalId;
	}

	public void setSalesPortalId(String salesPortalId) {
		this.salesPortalId = salesPortalId;
	}

	public String getWxUnionId() {
		return wxUnionId;
	}

	public void setWxUnionId(String wxUnionId) {
		this.wxUnionId = wxUnionId;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getSalesEmail() {
		return salesEmail;
	}

	public void setSalesEmail(String salesEmail) {
		this.salesEmail = salesEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNamecard() {
		return namecard;
	}

	public void setNamecard(String namecard) {
		this.namecard = namecard;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getNameCardPath() {
		return nameCardPath;
	}

	public void setNameCardPath(String nameCardPath) {
		this.nameCardPath = nameCardPath;
	}

	@Override
	public String toString() {
		return "Sale [salesId=" + salesId + ", agencyId=" + agencyId + ", salesPortalId=" + salesPortalId
				+ ", wxUnionId=" + wxUnionId + ", wxOpenId=" + wxOpenId + ", salesName=" + salesName
				+ ", salesEmail=" + salesEmail + ", title=" + title
				+ ", telephone=" + telephone + ", mobilephone=" + mobilephone + ", fax=" + fax + ", qq=" + qq
				+ ", skype=" + skype + ", wechat=" + wechat + ", skill=" + skill + ", introduction=" + introduction
				+ ", address=" + address + ", photo=" + photo + ", namecard=" + namecard + ", photoPath=" + photoPath
				+ ", nameCardPath=" + nameCardPath + "]";
	}
}
