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
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.service.CaseService;
import com.tourmade.crm.service.CustomerService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseSimpleFormController {
	
	@Autowired
	private CustomerService service;
	@Autowired
	private CaseService caseservice;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String agegroup = "customer.agegroup";
		String level = "customer.level";
		List<EntityList> v = service.getParameterInfo(agegroup);
		List<EntityList> w = service.getParameterInfo(level);
		JSONArray agegroupresult = JSONArray.fromObject(v);
		JSONArray levelresult = JSONArray.fromObject(w);
		model.addAttribute("ageGroup",agegroupresult);
		model.addAttribute("level",levelresult);
		return "/customer/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Customer customer, PageHelper page) {
		System.out.println("********");
		QueryResult<Customer> r = service.queryCustomer(customer, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String level = "customer.level";
		String promote = "customer.promote";
		String agegroup = "customer.agegroup";
		List<EntityList> u = service.getParameterInfo(level);
		List<EntityList> v = service.getParameterInfo(promote);
		List<EntityList> w = service.getParameterInfo(agegroup);
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
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Customer customer) {

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
			Customer customer = service.getCustomerById(i);
			String level = "customer.level";
			String promote = "customer.promote";
			String agegroup = "customer.agegroup";
			List<EntityList> u = service.getParameterInfo(level);
			List<EntityList> v = service.getParameterInfo(promote);
			List<EntityList> w = service.getParameterInfo(agegroup);
			JSONArray levelresult = JSONArray.fromObject(u);
			JSONArray  promoteresult = JSONArray.fromObject(v);
			JSONArray  agegroupresult = JSONArray.fromObject(w);
			model.addAttribute("level",levelresult);
			model.addAttribute("promote",promoteresult);
			model.addAttribute("agegroup",agegroupresult);
			model.addAttribute("customer",customer);
			
			String source = "case.source";
			String status = "case.status";
			List<EntityList> userList = caseservice.getUser();
			List<EntityList> customerList = caseservice.getCustomer();
			List<EntityList> sourceList = caseservice.getParameterInfo(source);
			List<EntityList> statusList = caseservice.getParameterInfo(status);
			JSONArray userResult = JSONArray.fromObject(userList);
			JSONArray customerResult = JSONArray.fromObject(customerList);
			JSONArray sourceResult = JSONArray.fromObject(sourceList);
			JSONArray statusResult = JSONArray.fromObject(statusList);
			model.addAttribute("user",userResult);
			model.addAttribute("customerList",customerResult);
			model.addAttribute("source",sourceResult);
			model.addAttribute("status",statusResult);
		}
		return "/customer/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Customer customer) {

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