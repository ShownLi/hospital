package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 订单记录model
 * 
 * @author lianzheng
 *
 */
public class DemoOrderRecord extends BaseBean<DemoOrderRecord> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;
	
	private int orderrecordid;
	
	private int orderid;
	
	private int senderid;
	
	private String sender;
	
	private String sendername;
	
	private String content;
	
	private String fileurl;
	
	private Date reqtime;
	
	private Date creattime;
	
	private Date updatetime;
	
	private int isdel;

	public int getOrderrecordid() {
		return orderrecordid;
	}

	public void setOrderrecordid(int orderrecordid) {
		this.orderrecordid = orderrecordid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getSenderid() {
		return senderid;
	}

	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
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

	public Date getReqtime() {
		return reqtime;
	}

	public void setReqtime(Date reqtime) {
		this.reqtime = reqtime;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoOrderRecord [orderrecordid=" + orderrecordid + ", orderid=" + orderid + ", senderid=" + senderid
				+ ", sender=" + sender + ", sendername=" + sendername + ", content=" + content + ", fileurl=" + fileurl
				+ ", reqtime=" + reqtime + ", creattime=" + creattime + ", updatetime=" + updatetime + ", isdel="
				+ isdel + "]";
	}
	
}