package com.tourmade.crm.model;

import java.util.Date;
import java.util.List;
import com.tourmade.crm.common.framework.BaseBean;

public class MailTemplate extends BaseBean<MailTemplate> {

	private static final long serialVersionUID = -2693268046526620058L;

	// 客人姓、名、称谓；销售姓名（销售ID需要在客人表中增加）；当前日期；（注意同一客人的英文和法文的称谓不同，我看到数据库字典表中有此设计，但好像直接填文本就可以，因为同一客人一般只用英文或法文）

	private String templatepath;

	private String clientname_zh;
	private String clientname_en;
	private String salesname;
	private String adult;
	private String children;
	private String baby;
	private Date start_date;
	private String during;
	private String hotel_zh;
	private String hotel_en;
	private String guide_zh;
	private String guide_en;
	private String budget;
	private String destination_zh;
	private String destination_en;
	private String requirement;
	
	private String clientfirstname;
	private String clientlastname;
	private String clienttitle;
	private String username;
	private String now;

	private String lang;

	private List<Object[]> orderlist;
	private String arrivetime;
	private String groupcode;
	private String planvalue;

	private String clientemail;
	private String groupid;

	public String getTemplatepath() {
		return templatepath;
	}

	public void setTemplatepath(String templatepath) {
		this.templatepath = templatepath;
	}

	public String getClientfirstname() {
		return clientfirstname;
	}

	public void setClientfirstname(String clientfirstname) {
		this.clientfirstname = clientfirstname;
	}

	public String getClientlastname() {
		return clientlastname;
	}

	public void setClientlastname(String clientlastname) {
		this.clientlastname = clientlastname;
	}

	public String getClienttitle() {
		return clienttitle;
	}

	public void setClienttitle(String clienttitle) {
		this.clienttitle = clienttitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<Object[]> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Object[]> orderlist) {
		this.orderlist = orderlist;
	}

	public String getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}

	public String getPlanvalue() {
		return planvalue;
	}

	public void setPlanvalue(String planvalue) {
		this.planvalue = planvalue;
	}

	public String getClientemail() {
		return clientemail;
	}

	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getClientname_zh() {
		return clientname_zh;
	}

	public void setClientname_zh(String clientname_zh) {
		this.clientname_zh = clientname_zh;
	}

	public String getClientname_en() {
		return clientname_en;
	}

	public void setClientname_en(String clientname_en) {
		this.clientname_en = clientname_en;
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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getDuring() {
		return during;
	}

	public void setDuring(String during) {
		this.during = during;
	}

	public String getHotel_zh() {
		return hotel_zh;
	}

	public void setHotel_zh(String hotel_zh) {
		this.hotel_zh = hotel_zh;
	}

	public String getHotel_en() {
		return hotel_en;
	}

	public void setHotel_en(String hotel_en) {
		this.hotel_en = hotel_en;
	}

	public String getGuide_zh() {
		return guide_zh;
	}

	public void setGuide_zh(String guide_zh) {
		this.guide_zh = guide_zh;
	}

	public String getGuide_en() {
		return guide_en;
	}

	public void setGuide_en(String guide_en) {
		this.guide_en = guide_en;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDestination_zh() {
		return destination_zh;
	}

	public void setDestination_zh(String destination_zh) {
		this.destination_zh = destination_zh;
	}

	public String getDestination_en() {
		return destination_en;
	}

	public void setDestination_en(String destination_en) {
		this.destination_en = destination_en;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSalesname() {
		return salesname;
	}

	public void setSalesname(String salesname) {
		this.salesname = salesname;
	}

}

