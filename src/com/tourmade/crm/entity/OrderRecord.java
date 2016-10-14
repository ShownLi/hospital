package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 订单记录model
 * 
 * @author lianzheng
 *
 */
public class OrderRecord extends BaseBean<OrderRecord> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private Integer orderRecordId;
	
	private Integer orderId;
	
	private String sender;
	
	private String senderEmail;
	
	private String senderName;
	
	private String content;
	
	private String fileUrl;
	
	private Date reqTime;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private Integer isdel;

	public Integer getOrderRecordId() {
		return orderRecordId;
	}

	public void setOrderRecordId(Integer orderRecordId) {
		this.orderRecordId = orderRecordId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
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

	public Date getReqTime() {
		return reqTime;
	}

	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
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

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderRecord [orderRecordId=" + orderRecordId + ", orderId="
				+ orderId + ", sender=" + sender + ", senderEmail="
				+ senderEmail + ", senderName=" + senderName + ", content="
				+ content + ", fileUrl=" + fileUrl + ", reqTime=" + reqTime
				+ ", creatTime=" + creatTime + ", updateTime=" + updateTime
				+ ", isdel=" + isdel + "]";
	}
}