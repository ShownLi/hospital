package com.tourmade.crm.action;

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
	
	@RequestMapping(value = "/validate", method = { RequestMethod.POST, RequestMethod.GET })
	public String Validate(String table, String field, String name) {
		String result = service.Validate(table, field, name);
		System.out.println(result);
		return "yes";
	}
	
	@RequestMapping(value = "/blank.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/blank";
	}

	@RequestMapping(value = "/main.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String main(Model model) {
		return "redirect:/agency/list.html";
	}
	
}
