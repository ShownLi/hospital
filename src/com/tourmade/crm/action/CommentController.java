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
		List<EntityList> v = service.getParameterInfo(country);
		List<EntityList> w = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(v);
		JSONArray languageresult = JSONArray.fromObject(w);
		model.addAttribute("countryname",countryresult);
		model.addAttribute("language",languageresult);
		return "/comment/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Comment comment, String type,int id, PageHelper page) {

		QueryResult<Comment> r = service.queryComment(comment, page, type ,id ,request);
		//System.out.println("type = "+type+"\nid = "+id);
		String result = JSONUtilS.object2json(r);
		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "comment.language";
		List<EntityList> u = service.getParameterInfo(country);
		List<EntityList> v = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(u);
		JSONArray  languageresult = JSONArray.fromObject(v);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		
		return "/comment/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Comment comment) {

		Json j = new Json();
		try {
			if(comment.getContent() != ""){
				service.saveComment(comment);
				j.setSuccess(true);
			}
			else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CommentController.doAdd() --> " + comment.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			Comment u = service.getCommentById(i);
			String country = "country";
			String language = "comment.language";
			List<EntityList> v = service.getParameterInfo(country);
			List<EntityList> w = service.getParameterInfo(language);
			JSONArray countryresult = JSONArray.fromObject(v);
			JSONArray languageresult = JSONArray.fromObject(w);
			model.addAttribute("country",countryresult);
			model.addAttribute("language",languageresult);
			model.addAttribute("comment",u);
		}
		return "/comment/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Comment comment) {

		Json j = new Json();
		
		try {
			service.updateComment(comment);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CommentController.doEdit() --> " + comment.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json j = new Json();
		System.out.println("------>>>" + id);
		try {
			if (null != id && !"".equals(id)) {
				int i = Integer.parseInt(id);
				service.deleteCommentById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CommentController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}

}