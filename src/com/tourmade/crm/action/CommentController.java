package com.tourmade.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.framework.util.JSONUtilS;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Comment;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.service.CommentService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/comment")
public class CommentController extends BaseSimpleFormController {
	
	@Autowired
	private CommentService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String country = "country";
		String language = "comment.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("countryname",countryResult);
		model.addAttribute("language",languageResult);
		return "/comment/list";
	}
	/**
	 * 获取注释信息，不分页
	 * @param request
	 * @param session
	 * @param model
	 * @param comment
	 * @param type
	 * @param id
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Comment comment, String type,int id, PageHelper page) {

		QueryResult<Comment> pageResult = service.queryComment(comment, type ,id ,request);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "comment.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray  languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		
		return "/comment/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Comment comment) {
		Json json = new Json();
		try {
			if(comment.getCommentType().equals("case")){
				service.updateCaseComment(comment);
			}
			if(comment.getContent() != ""){
				service.saveComment(comment);
				json.setSuccess(true);
			}
			else{
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CommentController.doAdd() --> " + comment.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int commentId = Integer.parseInt(id);
			Comment comment = service.getCommentById(commentId);
			String country = "country";
			String language = "comment.language";
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> languageList = service.getParameterInfo(language);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray languageResult = JSONArray.fromObject(languageList);
			model.addAttribute("country",countryResult);
			model.addAttribute("language",languageResult);
			model.addAttribute("comment",comment);
		}
		return "/comment/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Comment comment) {

		Json json = new Json();
		
		try {
			service.updateComment(comment);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CommentController.doEdit() --> " + comment.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int commentId = Integer.parseInt(id);
				service.deleteCommentById(commentId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CommentController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return json;
	}

}