package com.tourmade.crm.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.service.UserService;

@Controller
@RequestMapping("/")
public class MainController extends BaseSimpleFormController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
	public String In(Model model) {
		return "/";
	}
	
	@RequestMapping(value = "/validate.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void Validate(String table, String field, String filter_field, String filter_name, String name,HttpServletResponse response) {

		try{
			String result = service.Validate(table, field, filter_field, filter_name, name);
			if(name.equals(result)){
				response.getWriter().print(false);
			}
			else
				response.getWriter().print(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/blank.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/blank";
	}

	@RequestMapping(value = "/main.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String main(HttpServletRequest request, HttpSession session,Model model) {
		String roleID = (String) session.getAttribute("roleID");
		if(roleID==null||"".equals(roleID)){
			return "redirect:/signin.html";
		}else{
			if("5".equals(roleID)){
				return "redirect:/agency/list.html";
			}else{
				return "redirect:/case/list.html";
			}
		}
	}
}
