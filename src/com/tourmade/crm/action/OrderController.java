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
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.MailTemplate;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.service.EmailService;
import com.tourmade.crm.service.OrderService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseSimpleFormController {
	
	@Autowired
	private OrderService service;
	

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/order/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoOrder order, PageHelper page) {

		QueryResult<DemoOrder> r = service.queryOrder(order, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "order.country";
		String language = "order.language";
		List<DemoList> u = service.getParameterInfo(country);
		List<DemoList> v = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(u);
		JSONArray  languageresult = JSONArray.fromObject(v);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		
		return "/order/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, DemoOrder order) {

		Json j = new Json();
		EmailService emailservice = new EmailService();
		MailTemplate template = new MailTemplate();
		DemoEmail email = new DemoEmail();
		
		try {
			String domain = "tourmade.com.cn";
			DemoOrder order1 = service.getAgencyBySales(order.getSalesid());
			String customerEmailReal = service.getCustomerEmailReal(order.getCustomerid());
			order.setAgencyid(order1.getAgencyid());
			order.setAgencyname(order1.getAgencyname());
			order.setSalesname(order1.getSalesname());
			order.setAgencyEmailReal(order1.getAgencyEmailReal());
			order.setCustomerEmailReal(customerEmailReal);
			service.saveOrder(order);
			
			String url = "http://123.56.77.206/axis2/services/AliasAdd/add";
			String param = "alias=customer"+order.getOrderid()+"@&real=customer@&domain="+domain;
			String param1 = "alias=agency"+order.getOrderid()+"@&real=customer@&domain="+domain;
			service.creatAlias(url, param);
			service.creatAlias(url, param1);
			order.setAgencyEmailAlias("agency"+order.getOrderid()+"@"+domain);
			order.setCustomerEmailAlias("customer"+order.getOrderid()+"@"+domain);
			service.updateOrder(order);
			
			template.setTemplatepath("D:/clientwelcome.html");
			template.setClientfirstname("lian");
			template.setClientlastname("zheng");
			String result = emailservice.getMailContent(template);
			
			
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doAdd() --> " + order.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			DemoOrder u = service.getOrderById(i);
			String country = "order.status";
			List<DemoList> v = service.getParameterInfo(country);
			JSONArray statusresult = JSONArray.fromObject(v);
			model.addAttribute("status",statusresult);
			model.addAttribute("order",u);
		}
		return "/order/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, DemoOrder order) {

		Json j = new Json();
		System.out.println(order);
		try {
			service.updateOrder(order);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
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
				service.deleteOrderById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}

}