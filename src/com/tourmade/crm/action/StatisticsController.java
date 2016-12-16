package com.tourmade.crm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tourmade.crm.common.action.BaseSimpleFormController;

@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseSimpleFormController{
	@RequestMapping("/test.html")
	public String table(){
		return "/statistics/list";
	}

}
