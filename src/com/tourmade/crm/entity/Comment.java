package com.tourmade.crm.entity;

import java.util.Date;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 地接社model
 * 
 * @author lianzheng
 *
 */
public class Comment extends BaseBean<Comment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer commentId;
	
	private Integer objectId;
	
	private Integer userId;
	
	private String commentType;
	
	private String userName;
	
	private String content;
	
	private Date creatTime;
	
	private Date updateTime;
	
	private Integer isdel;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Comment [commentId=" + commentId + ", objectId=" + objectId
				+ ", userId=" + userId + ", commentType=" + commentType
				+ ", userName=" + userName + ", content=" + content
				+ ", creatTime=" + creatTime + ", updateTime=" + updateTime
				+ ", isdel=" + isdel + "]";
	}

		
}
