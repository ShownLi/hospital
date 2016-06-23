package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 询单model
 * 
 * @author lianzheng
 *
 */
public class DemoCase extends BaseBean<DemoCase> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int caseid;
	
	private String customerid;
	
	private String preferlanguage;
	
	private String withwho;
	
	private int adult;
	
	private int children;
	
	private String starttime;
	
	private String during;
	
	private Date startdate;
	
	private Date enddate;
	
	private String hotel;
	
	private String meals;
	
	private String requirement;
	
	private String guide;
	
	private int budget;
	
	private String customername;
	
	private String contacttype;
	
	private String salescode;
	
	private String salesname;
	
	private String destination;
	
	private String route;
	
	private String submittype;
	
	private int submitid;
	
	private String source;
	
	private String status;
	
	private Date startmonth;
	
	private Date creat_time;
	
	private Date update_time;

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getPreferlanguage() {
		return preferlanguage;
	}

	public void setPreferlanguage(String preferlanguage) {
		this.preferlanguage = preferlanguage;
	}

	public String getWithwho() {
		return withwho;
	}

	public void setWithwho(String withwho) {
		this.withwho = withwho;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getDuring() {
		return during;
	}

	public void setDuring(String during) {
		this.during = during;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getContacttype() {
		return contacttype;
	}

	public void setContacttype(String contacttype) {
		this.contacttype = contacttype;
	}

	public String getSalescode() {
		return salescode;
	}

	public void setSalescode(String salescode) {
		this.salescode = salescode;
	}

	public String getSalesname() {
		return salesname;
	}

	public void setSalesname(String salesname) {
		this.salesname = salesname;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getSubmittype() {
		return submittype;
	}

	public void setSubmittype(String submittype) {
		this.submittype = submittype;
	}

	public int getSubmitid() {
		return submitid;
	}

	public void setSubmitid(int submitid) {
		this.submitid = submitid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartmonth() {
		return startmonth;
	}

	public void setStartmonth(Date startmonth) {
		this.startmonth = startmonth;
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
		return "DemoCase [caseid=" + caseid + ", customerid=" + customerid + ", preferlanguage=" + preferlanguage
				+ ", withwho=" + withwho + ", adult=" + adult + ", children=" + children + ", starttime=" + starttime
				+ ", during=" + during + ", startdate=" + startdate + ", enddate=" + enddate + ", hotel=" + hotel
				+ ", meals=" + meals + ", requirement=" + requirement + ", guide=" + guide + ", budget=" + budget
				+ ", customername=" + customername + ", contacttype=" + contacttype + ", salescode=" + salescode
				+ ", salesname=" + salesname + ", destination=" + destination + ", route=" + route + ", submittype="
				+ submittype + ", submitid=" + submitid + ", source=" + source + ", status=" + status + ", startmonth="
				+ startmonth + ", creat_time=" + creat_time + ", update_time=" + update_time + "]";
	}
	
	
}
