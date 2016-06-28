package com.tourmade.crm.mapper.comment;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoComment;
import com.tourmade.crm.model.DemoList;

public interface DemoCommentMapper extends BaseMapper {
	
	public List<DemoComment> queryComment(Map<String, Object> params);
	
	public long countComment(DemoComment comment);
	
	public void saveComment(DemoComment comment);

	public void updateComment(DemoComment comment);

	public void deleteCommentById(int comment_id);
	
	public DemoComment getCommentById(int comment_id);
	
	public List<DemoList> getParameterInfo(String domain);
}