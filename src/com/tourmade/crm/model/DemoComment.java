package com.tourmade.crm.model;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class DemoComment extends BaseBean<DemoComment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private int commentid;
	
	private int objectid;
	
	private int userid;
	
	private String commenttype;
	
	private String username;
	
	private String content;
	
	private Date creattime;
	
	private Date updatetime;
	
	private int isdel;

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getObjectid() {
		return objectid;
	}

	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCommenttype() {
		return commenttype;
	}

	public void setCommenttype(String commenttype) {
		this.commenttype = commenttype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "DemoComment [commentid=" + commentid + ", objectid=" + objectid + ", userid=" + userid
				+ ", commenttype=" + commenttype + ", username=" + username + ", content=" + content + ", creattime="
				+ creattime + ", updatetime=" + updatetime + ", isdel=" + isdel + "]";
	}
	
}
