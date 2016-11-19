package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 询单model
 * 
 * @author 
 *
 */
public class Case extends BaseBean<Case> {

	private static final long serialVersionUID = 1423523863575074623L;

	private Integer caseId;
	
	private Integer customerId;
	
	private String chineseName;
	
	private String englishName;
	
	private String telephone;
	
	private String mobile;
	
	private String email;
	
	private String wechat;

	private String qq;
	
	private String level;
	
	private Date birthday;
	
	private String ageGroup;
	
	private String gender;
	
	private String location;
	
	private Integer operator;
	
	private String preferLanguage;
	
	private String withwho;
	
	private Integer adult;
	
	private Integer children;
	
	private Integer baby;
	
	private String startTime;
	
	private String during;
	
	private Date startDate;
	
	private Date endDate;
	
	private String hotel;
	
	private String meals;
	
	private String requirement;
	
	private String guide;
	
	private Integer budget;
	
	private String contactType;
	
	private Integer salesId;
	
	private String salesName;
	
	private String destination;
	
	private String destinationCode;
	
	private String route;
	
	private String routeId;
	
	private String tailormade;
	
	private String passport;
	
	private String visa;
	
	private String flight;
	
	private String submitType;
	
	private String ipAddress;
	
	private String source;
	
	private String promoteCode;
	
	private String status;
	
	private Date startMonth;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private String reason;
	
	private Integer portalId;
	
	private String comment;
	
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getPreferLanguage() {
		return preferLanguage;
	}

	public void setPreferLanguage(String preferLanguage) {
		this.preferLanguage = preferLanguage;
	}

	public String getWithwho() {
		return withwho;
	}

	public void setWithwho(String withwho) {
		this.withwho = withwho;
	}

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Integer getBaby() {
		return baby;
	}

	public void setBaby(Integer baby) {
		this.baby = baby;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDuring() {
		return during;
	}

	public void setDuring(String during) {
		this.during = during;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getTailormade() {
		return tailormade;
	}

	public void setTailormade(String tailormade) {
		this.tailormade = tailormade;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPromoteCode() {
		return promoteCode;
	}

	public void setPromoteCode(String promoteCode) {
		this.promoteCode = promoteCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Case [caseId=" + caseId + ", customerId=" + customerId
				+ ", chineseName=" + chineseName + ", englishName="
				+ englishName + ", telephone=" + telephone + ", mobile="
				+ mobile + ", email=" + email + ", wechat=" + wechat
				+ ", qq=" + qq + ", level=" + level + ", birthday=" + birthday
				+ ", ageGroup=" + ageGroup + ", gender=" + gender
				+ ", location=" + location + ", operator=" + operator
				+ ", preferLanguage=" + preferLanguage + ", withwho=" + withwho
				+ ", adult=" + adult + ", children=" + children + ", baby="
				+ baby + ", startTime=" + startTime + ", during=" + during
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", hotel=" + hotel + ", meals=" + meals + ", requirement="
				+ requirement + ", guide=" + guide + ", budget=" + budget
				+ ", contactType=" + contactType + ", salesId=" + salesId
				+ ", salesName=" + salesName + ", destination=" + destination
				+ ", destinationCode=" + destinationCode + ", route=" + route
				+ ", routeId=" + routeId + ", tailormade=" + tailormade
				+ ", passport=" + passport + ", visa=" + visa + ", flight="
				+ flight + ", submitType=" + submitType + ", ipAddress="
				+ ipAddress + ", source=" + source + ", promoteCode="
				+ promoteCode + ", status=" + status + ", startMonth="
				+ startMonth + ", creatTime=" + creatTime + ", updateTime="
				+ updateTime + ", reason=" + reason + ", portalId=" + portalId
				+ ", comment=" + comment + "]";
	}

	
	
}
