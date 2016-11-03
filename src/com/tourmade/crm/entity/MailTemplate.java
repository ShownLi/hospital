package com.tourmade.crm.entity;

import java.util.Date;
import com.tourmade.crm.common.framework.BaseBean;

public class MailTemplate extends BaseBean<MailTemplate> {

	private static final long serialVersionUID = -2693268046526620058L;

	private String customerChineseName;
	private String customerEnglishName;
	private String salesChineseName;
	private String salesEnglishName;
	private String adult;
	private String children;
	private String baby;
	private String startTime;
	private Date startMonth;
	private String during;
	private Date startDate;
	private Date endDate;
	private String preferChineseLanguage;
	private String preferEnglishLanguage;	
	private String withwhoChinese;
	private String withwhoEnglish;
	private String hotelChinese;
	private String hotelEnglish;
	private String mealsChinese;
	private String mealsEnglish;
	private String guideChinese;
	private String guideEnglish;
	private String budget;
	private String destinationChinese;
	private String destinationEnglish;
	private String passportChinese;
	private String passportEnglish;
	private String visaChinese;
	private String visaEnglish;
	private String flightChinese;
	private String flightEnglish;
	private String tailormadeChinese;
	private String tailormadeEnglish;
	private String requirement;
	private String replyto;
	private String routeUrl;
	private String routeName;
	private Integer orderId;
	private String subject;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCustomerChineseName() {
		return customerChineseName;
	}
	public void setCustomerChineseName(String customerChineseName) {
		this.customerChineseName = customerChineseName;
	}
	public String getCustomerEnglishName() {
		return customerEnglishName;
	}
	public void setCustomerEnglishName(String customerEnglishName) {
		this.customerEnglishName = customerEnglishName;
	}
	public String getSalesChineseName() {
		return salesChineseName;
	}
	public void setSalesChineseName(String salesChineseName) {
		this.salesChineseName = salesChineseName;
	}
	public String getSalesEnglishName() {
		return salesEnglishName;
	}
	public void setSalesEnglishName(String salesEnglishName) {
		this.salesEnglishName = salesEnglishName;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getBaby() {
		return baby;
	}
	public void setBaby(String baby) {
		this.baby = baby;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Date getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
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
	public String getPreferChineseLanguage() {
		return preferChineseLanguage;
	}
	public void setPreferChineseLanguage(String preferChineseLanguage) {
		this.preferChineseLanguage = preferChineseLanguage;
	}
	public String getPreferEnglishLanguage() {
		return preferEnglishLanguage;
	}
	public void setPreferEnglishLanguage(String preferEnglishLanguage) {
		this.preferEnglishLanguage = preferEnglishLanguage;
	}
	public String getWithwhoChinese() {
		return withwhoChinese;
	}
	public void setWithwhoChinese(String withwhoChinese) {
		this.withwhoChinese = withwhoChinese;
	}
	public String getWithwhoEnglish() {
		return withwhoEnglish;
	}
	public void setWithwhoEnglish(String withwhoEnglish) {
		this.withwhoEnglish = withwhoEnglish;
	}
	public String getHotelChinese() {
		return hotelChinese;
	}
	public void setHotelChinese(String hotelChinese) {
		this.hotelChinese = hotelChinese;
	}
	public String getHotelEnglish() {
		return hotelEnglish;
	}
	public void setHotelEnglish(String hotelEnglish) {
		this.hotelEnglish = hotelEnglish;
	}
	public String getMealsChinese() {
		return mealsChinese;
	}
	public void setMealsChinese(String mealsChinese) {
		this.mealsChinese = mealsChinese;
	}
	public String getMealsEnglish() {
		return mealsEnglish;
	}
	public void setMealsEnglish(String mealsEnglish) {
		this.mealsEnglish = mealsEnglish;
	}
	public String getGuideChinese() {
		return guideChinese;
	}
	public void setGuideChinese(String guideChinese) {
		this.guideChinese = guideChinese;
	}
	public String getGuideEnglish() {
		return guideEnglish;
	}
	public void setGuideEnglish(String guideEnglish) {
		this.guideEnglish = guideEnglish;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getDestinationChinese() {
		return destinationChinese;
	}
	public void setDestinationChinese(String destinationChinese) {
		this.destinationChinese = destinationChinese;
	}
	public String getDestinationEnglish() {
		return destinationEnglish;
	}
	public void setDestinationEnglish(String destinationEnglish) {
		this.destinationEnglish = destinationEnglish;
	}
	public String getPassportChinese() {
		return passportChinese;
	}
	public void setPassportChinese(String passportChinese) {
		this.passportChinese = passportChinese;
	}
	public String getPassportEnglish() {
		return passportEnglish;
	}
	public void setPassportEnglish(String passportEnglish) {
		this.passportEnglish = passportEnglish;
	}
	public String getVisaChinese() {
		return visaChinese;
	}
	public void setVisaChinese(String visaChinese) {
		this.visaChinese = visaChinese;
	}
	public String getVisaEnglish() {
		return visaEnglish;
	}
	public void setVisaEnglish(String visaEnglish) {
		this.visaEnglish = visaEnglish;
	}
	public String getFlightChinese() {
		return flightChinese;
	}
	public void setFlightChinese(String flightChinese) {
		this.flightChinese = flightChinese;
	}
	public String getFlightEnglish() {
		return flightEnglish;
	}
	public void setFlightEnglish(String flightEnglish) {
		this.flightEnglish = flightEnglish;
	}
	public String getTailormadeChinese() {
		return tailormadeChinese;
	}
	public void setTailormadeChinese(String tailormadeChinese) {
		this.tailormadeChinese = tailormadeChinese;
	}
	public String getTailormadeEnglish() {
		return tailormadeEnglish;
	}
	public void setTailormadeEnglish(String tailormadeEnglish) {
		this.tailormadeEnglish = tailormadeEnglish;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getReplyto() {
		return replyto;
	}
	public void setReplyto(String replyto) {
		this.replyto = replyto;
	}
	public String getRouteUrl() {
		return routeUrl;
	}
	public void setRouteUrl(String routeUrl) {
		this.routeUrl = routeUrl;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MailTemplate [customerChineseName=" + customerChineseName
				+ ", customerEngliseName=" + customerEnglishName
				+ ", salesChineseName=" + salesChineseName
				+ ", salesEngliseName=" + salesEnglishName + ", adult=" + adult
				+ ", children=" + children + ", baby=" + baby + ", startTime="
				+ startTime + ", startMonth=" + startMonth + ", during="
				+ during + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", preferChineseLanguage=" + preferChineseLanguage
				+ ", preferEnglishLanguage=" + preferEnglishLanguage
				+ ", withwhoChinese=" + withwhoChinese + ", withwhoEnglish="
				+ withwhoEnglish + ", hotelChinese=" + hotelChinese
				+ ", hotelEnglish=" + hotelEnglish + ", mealsChinese="
				+ mealsChinese + ", mealsEnglish=" + mealsEnglish
				+ ", guideChinese=" + guideChinese + ", guideEnglish="
				+ guideEnglish + ", budget=" + budget + ", destinationChinese="
				+ destinationChinese + ", destinationEnglish="
				+ destinationEnglish + ", passportChinese=" + passportChinese
				+ ", passportEnglish=" + passportEnglish + ", visaChinese="
				+ visaChinese + ", visaEnglish=" + visaEnglish
				+ ", flightChinese=" + flightChinese + ", flightEnglish="
				+ flightEnglish + ", tailormadeChinese=" + tailormadeChinese
				+ ", tailormadeEnglish=" + tailormadeEnglish + ", requirement="
				+ requirement + ", replyto=" + replyto + ", routeUrl="
				+ routeUrl + ", routeName=" + routeName + ", orderId="
				+ orderId + "]";
	}
	
}

