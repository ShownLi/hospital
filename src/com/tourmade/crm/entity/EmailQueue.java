package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class EmailQueue extends BaseBean<EmailQueue> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer orderId;
	
	private String mailType;
	
	private String acount;
	
	private String sendName;
	
	private String recieveName;
	
	private String sender;

	private String reciever;
	
	private String subject;
	
	private String content;
	
	private String fileUrl;
	
	private String mailstatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getRecieveName() {
		return recieveName;
	}

	public void setRecieveName(String recieveName) {
		this.recieveName = recieveName;
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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
		return "EmailQueue [orderId=" + orderId + ", mailType=" + mailType
				+ ", acount=" + acount + ", sendName=" + sendName
				+ ", recieveName=" + recieveName + ", sender=" + sender
				+ ", reciever=" + reciever + ", subject=" + subject
				+ ", content=" + content + ", fileUrl=" + fileUrl
				+ ", mailstatus=" + mailstatus + "]";
	}

	
	
}
