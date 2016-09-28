package com.tourmade.crm.model;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoEmail extends BaseBean<DemoEmail> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int orderid;
	
	private String mailtype;
	
	private String acount;
	
	private String sendname;
	
	private String recievename;
	
	private String sender;

	private String reciever;
	
	private String subject;
	
	private String content;
	
	private String fileurl;
	
	private String mailstatus;

	public String getRecievename() {
		return recievename;
	}

	public void setRecievename(String recievename) {
		this.recievename = recievename;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getMailtype() {
		return mailtype;
	}

	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getMailstatus() {
		return mailstatus;
	}

	public void setMailstatus(String mailstatus) {
		this.mailstatus = mailstatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoEmail [orderid=" + orderid + ", mailtype=" + mailtype + ", acount=" + acount + ", sendname="
				+ sendname + ", sender=" + sender + ", reciever=" + reciever + ", subject=" + subject + ", content="
				+ content + ", fileurl=" + fileurl + ", mailstatus=" + mailstatus + "]";
	}
	
}
