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
import com.tourmade.crm.mapper.comment.DemoCommentMapper;
import com.tourmade.crm.model.DemoComment;
import com.tourmade.crm.model.DemoList;

@Service
@Transactional(readOnly = false)
public class CommentService extends BaseService {
	
	@Autowired
	private DemoCommentMapper commentMapper;

	/**
	 * 查询注释数据，分页展示
	 * 
	 * @param comment
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoComment> queryComment(DemoComment comment, PageHelper ph, String type, int id, HttpServletRequest request) {

		QueryResult<DemoComment> r = new QueryResult<DemoComment>();
		Map<String, Object> map = new HashMap<String, Object>();
		
			
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
		map.put("type", type);
		map.put("id", id);
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoComment> data = commentMapper.queryComment(map);
		comment.setCommenttype(type);
		comment.setObjectid(id);
		long count = commentMapper.countComment(comment);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}

	/**
	 * 新增注释
	 * 
	 * @param comment
	 * @return
	 */
	public int saveComment(DemoComment comment) {

		
		try {
			commentMapper.saveComment(comment);
		} catch (Exception e) {
			logger.error("CommentService.saveComment() --> " + comment + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return comment.getCommentid();
	}

	/**
	 * 根据主键获取注释信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoComment getCommentById(int id) {
		DemoComment r = null;
		try {
			r = commentMapper.getCommentById(id);
		} catch (Exception e) {
			logger.error("CommentService.getCommentById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<DemoList> getParameterInfo(String domain) {
		List<DemoList> r = null;
		try {
			r = commentMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CommentService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新注释信息(不修改密码)
	 * 
	 * @param comment
	 * @return
	 */
	public boolean updateComment(DemoComment comment) {

		boolean r = false;

		try {
			DemoComment u = commentMapper.getCommentById(comment.getCommentid());
			if (u != null) {
				//u.setName(comment.getName());
				commentMapper.updateComment(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("CommentService.updateComment() --> " + comment + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除注释（假删除）
	 * 
	 * @param comment_id
	 * @return
	 */
	public boolean deleteCommentById(int comment_id) {

		boolean r = false;

		try {
			commentMapper.deleteCommentById(comment_id);
			r = true;
		} catch (Exception e) {
			logger.error("CommentService.deleteCommentById() --> " + comment_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}