package com.tourmade.crm.model;

import java.util.List;
import com.tourmade.crm.common.framework.BaseBean;

public class MailTemplate extends BaseBean<MailTemplate> {

	private static final long serialVersionUID = -2693268046526620058L;

	// 客人姓、名、称谓；销售姓名（销售ID需要在客人表中增加）；当前日期；（注意同一客人的英文和法文的称谓不同，我看到数据库字典表中有此设计，但好像直接填文本就可以，因为同一客人一般只用英文或法文）

	private String templatepath;

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

}

