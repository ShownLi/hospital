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
import com.tourmade.crm.model.DemoCustomer;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.service.CustomerService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseSimpleFormController {
	
	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String agegroup = "customer.agegroup";
		String level = "customer.level";
		List<DemoList> v = service.getParameterInfo(agegroup);
		List<DemoList> w = service.getParameterInfo(level);
		JSONArray agegroupresult = JSONArray.fromObject(v);
		JSONArray levelresult = JSONArray.fromObject(w);
		model.addAttribute("agegroup",agegroupresult);
		model.addAttribute("level",levelresult);
		return "/customer/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoCustomer customer, PageHelper page) {

		QueryResult<DemoCustomer> r = service.queryCustomer(customer, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String level = "customer.level";
		String promote = "customer.promote";
		String agegroup = "customer.agegroup";
		List<DemoList> u = service.getParameterInfo(level);
		List<DemoList> v = service.getParameterInfo(promote);
		List<DemoList> w = service.getParameterInfo(agegroup);
		JSONArray levelresult = JSONArray.fromObject(u);
		JSONArray  promoteresult = JSONArray.fromObject(v);
		JSONArray  agegroupresult = JSONArray.fromObject(w);
		model.addAttribute("level",levelresult);
		model.addAttribute("promote",promoteresult);
		model.addAttribute("agegroup",agegroupresult);
		
		return "/customer/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, DemoCustomer customer) {

		Json j = new Json();
		
		try {
			service.saveCustomer(customer);
			j.setObj(customer);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CustomerController.doAdd() --> " + customer.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			DemoCustomer customer = service.getCustomerById(i);
			String level = "customer.level";
			String promote = "customer.promote";
			String agegroup = "customer.agegroup";
			List<DemoList> u = service.getParameterInfo(level);
			List<DemoList> v = service.getParameterInfo(promote);
			List<DemoList> w = service.getParameterInfo(agegroup);
			JSONArray levelresult = JSONArray.fromObject(u);
			JSONArray  promoteresult = JSONArray.fromObject(v);
			JSONArray  agegroupresult = JSONArray.fromObject(w);
			model.addAttribute("level",levelresult);
			model.addAttribute("promote",promoteresult);
			model.addAttribute("agegroup",agegroupresult);
			model.addAttribute("customer",customer);
		}
		return "/customer/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, DemoCustomer customer) {

		Json j = new Json();
		try {
			service.updateCustomer(customer);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CustomerController.doEdit() --> " + customer.toString() + "\n" + e.getMessage());
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
				service.deleteCustomerById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CustomerController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}

}