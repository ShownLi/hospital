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
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.service.CaseService;
import com.tourmade.crm.service.EmailService;
import com.tourmade.crm.service.OrderService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseSimpleFormController {
	
	@Autowired
	private OrderService service;
	@Autowired
	EmailService emailservice = new EmailService();
	@Autowired
	CaseService caseservice;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String country = "country";
		String status = "order.status";
		String reason = "order.reason";
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> reasonLiat = service.getParameterInfo(reason);
		JSONArray countryResult = JSONArray.fromObject(statusList);
		JSONArray statusResult = JSONArray.fromObject(countryList);
		JSONArray reasonResult = JSONArray.fromObject(reasonLiat);
		model.addAttribute("orderStatus",statusResult);
		model.addAttribute("destination",countryResult);
		model.addAttribute("reason",reasonResult);
		return "/order/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Order order, PageHelper page) {
		
		System.out.println(order);
		
		QueryResult<Order> queryResult = service.queryOrder(order, page, request);
		String result = JSONUtilS.object2json(queryResult);

		return result;
	}

	/**
	 * 根据caseid获取相应订单
	 * @param request
	 * @param session
	 * @param model
	 * @param caseId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/listByCaseId.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, int caseId, PageHelper page) {

		QueryResult<Order> r = service.queryOrderByCaseId(caseId, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "order.country";
		String language = "order.language";
		List<EntityList> u = service.getParameterInfo(country);
		List<EntityList> v = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(u);
		JSONArray  languageresult = JSONArray.fromObject(v);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		
		return "/order/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Order order) {

		Json j = new Json();
		
		if(order.getCaseId()!=0){
		   Customer customer = service.getCustomerByCaseId(order.getCaseId());
		   order.setCustomerId(customer.getCustomerId());
		   
		}
		
		try {
			boolean is = service.validatemail(order.getCustomerId());
			//验证客人有邮箱
			if(is)
			{
				boolean portalid = service.validatePortalId(order.getCustomerId());
				if(!portalid){
					service.creatPortal(order.getCustomerId());
				}
				//客人状态设置为下单客人
				service.customerstatus(order.getCustomerId(),"2");
				//询单状态设置为下单
				caseservice.case2order(order.getCaseId());
				//补充order信息并存储该order
				order = service.saveOrder(order);

				//邮件别名操作（创建邮件别名并将其写入order表）
				service.MailAlias(order);	
				
				//生成给地接社的第一封邮件
				//DemoCustomer customer = service.getCustomerById(order.getCustomerid());
				Case crmcase = service.getCaseById(order.getCaseId());
				
				order = service.getOrderById(order.getOrderId());
				
				String result = emailservice.creatTemplate(crmcase, order);
				
				
				//生成待发送邮件
				order = service.getOrderById(order.getOrderId());
				emailservice.saveEmail(order,result);
				
				j.setSuccess(true);
			}
			else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("OrderController.doAdd() --> " + order.toString() + "\n" + e.getMessage());
		}	
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			Order u = service.getOrderById(i);
			String status = "order.status";
			String country = "country";
			String reason = "order.reason";
			List<EntityList> v1 = service.getParameterInfo(status);
			List<EntityList> v2 = service.getParameterInfo(country);
			List<EntityList> v3 = service.getParameterInfo(reason);
			JSONArray statusresult = JSONArray.fromObject(v1);
			JSONArray countryresult = JSONArray.fromObject(v2);
			JSONArray reasonresult = JSONArray.fromObject(v3);
			model.addAttribute("status",statusresult);
			model.addAttribute("order",u);
			model.addAttribute("country",countryresult);
			model.addAttribute("reason",reasonresult);
		}
		return "/order/edit";
	}

	@RequestMapping(value = "/orderDeal.do")
	@ResponseBody
	public Json orderDeal(HttpServletRequest request, HttpSession session, Model model, Order order) {

		Json j = new Json();
		Order order1 = service.getOrderById(order.getOrderId());
		Case crmcase = caseservice.getCaseById(order1.getCaseId());
		
		try {

			service.updateOrder(order);
				
				crmcase.setStatus("3");
				service.customerstatus(order1.getCustomerId(), "3");
				caseservice.updateCase(crmcase);
		
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	
	@RequestMapping(value = "/orderNoDeal.do")
	@ResponseBody
	public Json orderNoDeal(HttpServletRequest request, HttpSession session, Model model, Order order) {
		Json j = new Json();
		Order order1 = service.getOrderById(order.getOrderId());
		//DemoCase crmcase = caseservice.getCaseById(order1.getCaseid());
		
		Case crmcase = caseservice.getCaseByOrderId(order.getOrderId());
		try {
			service.updateOrder(order);
			int i = caseservice.casestatus(order.getCaseId());
			if(i==0){
				crmcase.setStatus("4");
				caseservice.updateCase(crmcase);
			}
			
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/updateDeal.do")
	@ResponseBody
	public Json doEdit1(Order order) {
		Json j = new Json();	
		try {
			service.updateOrder(order);	
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doEdit1() --> " + order.toString() + "\n" + e.getMessage());
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