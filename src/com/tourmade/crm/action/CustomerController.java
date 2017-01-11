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

import com.itextpdf.text.log.SysoLogger;
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
	private CustomerService customerService;
	@Autowired
	private CaseService caseService;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model,String flag,HttpSession session) {
		String ageGroup = "customer.agegroup";
		String level = "customer.level";
		List<EntityList> ageGroupList = customerService.getParameterInfo(ageGroup);
		List<EntityList> levelList = customerService.getParameterInfo(level);
		JSONArray ageGroupResult = JSONArray.fromObject(ageGroupList);
		JSONArray levelResult = JSONArray.fromObject(levelList);
		model.addAttribute("ageGroup",ageGroupResult);
		model.addAttribute("level",levelResult);
		
			//没有传递flag参数时，表示时从侧边栏访问的
				if ("".equals(flag) || flag == null) {
					model.addAttribute("flag", "restart");
					session.removeAttribute("searchCustomer");
				} else
					model.addAttribute("flag", flag);
					
		return "/customer/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(String flag,HttpServletRequest request, HttpSession session, Model model, Customer customer, PageHelper page) {
		if ("old".equals(flag)) {
			Customer search = (Customer) session.getAttribute("searchCustomer");
			if(search==null)
				search=new Customer();
			customer = search;
		}else{
			session.setAttribute("searchCustomer", customer);
		}
		QueryResult<Customer> pageCustomer = customerService.queryCustomer(customer, page, request);
		String result = JSONUtilS.object2json(pageCustomer);

		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String level = "customer.level";
		String source = "customer.source";
		String ageGroup = "customer.agegroup";
		List<EntityList> levelList = customerService.getParameterInfo(level);
		List<EntityList> sourceList = customerService.getParameterInfo(source);
		List<EntityList> ageGroupList = customerService.getParameterInfo(ageGroup);
		JSONArray levelResult = JSONArray.fromObject(levelList);
		JSONArray  sourceResult = JSONArray.fromObject(sourceList);
		JSONArray  ageGroupResult = JSONArray.fromObject(ageGroupList);
		model.addAttribute("level",levelResult);
		model.addAttribute("source",sourceResult);
		model.addAttribute("ageGroup",ageGroupResult);
		
		return "/customer/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Customer customer) {

		Json j = new Json();
		try {
			//设置客人级别为普通客人
			customer.setLevel("0");
			
			customerService.saveCustomer(customer);
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
			int customerId = Integer.parseInt(id);
			Customer customer = customerService.getCustomerById(customerId);
			String level = "customer.level";
			String promote = "customer.source";
			String ageGroup = "customer.agegroup";
			String country = "country";
			List<EntityList> levelList = customerService.getParameterInfo(level);
			List<EntityList> promoteList = customerService.getParameterInfo(promote);
			List<EntityList> ageGroupList = customerService.getParameterInfo(ageGroup);
			List<EntityList> countryList = customerService.getParameterInfo(country);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray levelResult = JSONArray.fromObject(levelList);
			JSONArray  promoteResult = JSONArray.fromObject(promoteList);
			JSONArray  ageGroupResult = JSONArray.fromObject(ageGroupList);
			model.addAttribute("destination",countryResult);
			model.addAttribute("level",levelResult);
			model.addAttribute("promote",promoteResult);
			model.addAttribute("ageGroup",ageGroupResult);
			model.addAttribute("customer",customer);
			
			String source = "case.source";
			String status = "case.status";
			List<EntityList> userList = caseService.getUser();
			List<EntityList> customerList = caseService.getCustomer();
			List<EntityList> sourceList = caseService.getParameterInfo(source);
			List<EntityList> statusList = caseService.getParameterInfo(status);
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
			//如果邮箱不为空，找到该客人对应的没有保存邮箱的订单，更新邮箱
			if(customer.getEmail()!=""&&customer.getEmail()!=null){
				customerService.updateOrderEmail(customer);
			}
			customerService.updateCustomer(customer);
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
				int customerId = Integer.parseInt(id);
				customerService.deleteCustomerById(customerId);
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