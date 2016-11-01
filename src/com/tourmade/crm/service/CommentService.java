package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Comment;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.comment.CommentMapper;

@Service
@Transactional(readOnly = false)
public class CommentService extends BaseService {
	
	@Autowired
	private CommentMapper commentMapper;

	/**
	 * 查询注释数据，分页展示
	 * 
	 * @param comment
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Comment> queryComment(Comment comment, PageHelper ph, String type, int id, HttpServletRequest request) {

		QueryResult<Comment> result = new QueryResult<Comment>();
		Map<String, Object> map = new HashMap<String, Object>();
		
			
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		map.put("commentType", type);
		map.put("objectId", id);

		List<Comment> data = commentMapper.queryComment(map);
		comment.setCommentType(type);
		comment.setObjectId(id);
		long count = commentMapper.countComment(comment);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	/**
	 * 新增注释
	 * 
	 * @param comment
	 * @return
	 */
	public int saveComment(Comment comment) {

		
		try {
			commentMapper.saveComment(comment);
		} catch (Exception e) {
			logger.error("CommentService.saveComment() --> " + comment + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return comment.getCommentId();
	}

	/**
	 * 根据主键获取注释信息
	 * 
	 * @param id
	 * @return
	 */
	public Comment getCommentById(int commentId) {
		Comment comment = null;
		try {
			comment = commentMapper.getCommentById(commentId);
		} catch (Exception e) {
			logger.error("CommentService.getCommentById() --> " + commentId + "-->" + e.getMessage());
			comment = null;
		}
		return comment;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> parameterList = null;
		try {
			parameterList = commentMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CommentService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			parameterList = null;
		}
		return parameterList;
	}
	
	/**
	 * 更新注释信息(不修改密码)
	 * 
	 * @param comment
	 * @return
	 */
	public void updateComment(Comment comment) {
		try {
			commentMapper.updateComment(comment);

		} catch (Exception e) {
			logger.error("CommentService.updateComment() --> " + comment + "-->" + e.getMessage());

		}
	}
	
	public void updateCaseComment(Comment comment) {
		try{
			commentMapper.updateCaseComment(comment);
		} catch(Exception e) {
			logger.error("CommentService.updateCaseCommment() --> "+comment+ "-->" + e.getMessage());
			
		}
	}

	/**
	 * 删除注释（假删除）
	 * 
	 * @param commentId
	 * @return 10-19
	 */
	public void deleteCommentById(int commentId) {

		try {
			commentMapper.deleteCommentById(commentId);
		} catch (Exception e) {
			logger.error("CommentService.deleteCommentById() --> " + commentId + "-->" + e.getMessage());
		}
	}

}