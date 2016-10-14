package com.tourmade.crm.action;

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
import com.tourmade.crm.entity.User;
import com.tourmade.crm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseSimpleFormController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/user/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, User user, PageHelper page) {

		QueryResult<User> r = service.queryUser(user, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}
	

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		return "/user/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, User user) {

		Json j = new Json();
		
		try {
			service.saveUser(user);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("UserController.doAdd() --> " + user.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			User u = service.getUserById(i);
			model.addAttribute("user",u);
		}
		
		
		return "/user/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, User user) {

		Json j = new Json();
		
		try {
			service.updateUser(user);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("UserController.doEdit() --> " + user.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json j = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int i = Integer.parseInt(id);
				service.deleteUserById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("UserController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}
	
}
