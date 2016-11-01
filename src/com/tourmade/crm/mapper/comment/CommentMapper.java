package com.tourmade.crm.mapper.comment;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Comment;
import com.tourmade.crm.entity.EntityList;

public interface CommentMapper extends BaseMapper {
	
	public List<Comment> queryComment(Map<String, Object> params);
	
	public long countComment(Comment comment);
	
	public void saveComment(Comment comment);

	public void updateComment(Comment comment);
	
	public void updateCaseComment(Comment comment);

	public void deleteCommentById(int commentId);
	
	public Comment getCommentById(int commentId);
	
	public List<EntityList> getParameterInfo(String domain);
}