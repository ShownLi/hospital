package com.tourmade.crm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.service.FinanceService;
@Controller
@RequestMapping("/finance")
public class FinanceController extends BaseSimpleFormController {
	@Autowired
	private FinanceService financeService;
	@RequestMapping("/list.html")
	public String list(){
		
		return "/finance/list";
	}
	@RequestMapping("/edit.html")
	public String edit(){
		
		return "/finance/edit";
	}
}
