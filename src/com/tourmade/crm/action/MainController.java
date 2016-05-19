package com.tourmade.crm.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tourmade.crm.common.action.BaseSimpleFormController;

@Controller
@RequestMapping("/")
public class MainController extends BaseSimpleFormController {

	@RequestMapping(value = "/blank.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/blank";
	}

	@RequestMapping(value = "/main.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String main(Model model) {
		return "redirect:/user/list.html";
	}
	
}
