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
	EmailService emailService = new EmailService();
	@Autowired
	CaseService caseService;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String currency="order.currency";		
		String country = "country";
		String status = "order.status";
		String reason = "order.reason";
		List<EntityList> currencyList = service.getParameterInfo(currency);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> reasonLiat = service.getParameterInfo(reason);
		JSONArray currencyResult = JSONArray.fromObject(currencyList);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray reasonResult = JSONArray.fromObject(reasonLiat);
		model.addAttribute("currency",currencyResult);
		model.addAttribute("orderStatus",statusResult);
		model.addAttribute("destination",countryResult);
		model.addAttribute("reason",reasonResult);
		return "/order/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Order order, PageHelper page) {

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

		QueryResult<Order> order = service.queryOrderByCaseId(caseId, page, request);
		String result = JSONUtilS.object2json(order);

		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "order.country";
		String language = "order.language";
		List<EntityList> countryList= service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray  languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		
		return "/order/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Order order) {
		
		System.out.println("&&&&"+order);
		Json json = new Json();
		
		if(order.getCaseId()!=0){
		   Customer customer = service.getCustomerByCaseId(order.getCaseId());
<<<<<<< HEAD
		   System.out.println("&&&"+customer.getEmail());
		   System.out.println("&&&"+customer.getEmail().equals(""));
		   System.out.println("&&&"+customer.getEmail()=="");
		   if(customer.getEmail().equals("")){
			   json.setSuccess(false);
			   return  json;
		   }
=======
>>>>>>> fc09c0e2c91d679b10e7804f201315e216e194a9
		   order.setCustomerId(customer.getCustomerId());		   
		}
		
		try {
/*			boolean is = service.validateEmail(order.getCustomerId());
			//验证客人有邮箱
			if(is)
			{*/
				boolean portalId = service.validatePortalId(order.getCustomerId());
				if(!portalId){
					service.creatPortal(order.getCustomerId());
				}
				//客人状态设置为下单客人
				service.customerStatus(order.getCustomerId(),"2");
				//询单状态设置为下单
				caseService.case2order(order.getCaseId());
				//补充order信息并存储该order
				order = service.saveOrder(order);
				
				//判断是否要发送邮件
				int isSendmail = service.selectAgencyBySaleId(order.getSalesId());
				if(isSendmail==0){
					json.setSuccess(true);
					return json;
				}else{
					//邮件别名操作（创建邮件别名并将其写入order表）
					service.MailAlias(order);	
					
					//生成给地接社的第一封邮件
					//DemoCustomer customer = service.getCustomerById(order.getCustomerid());
					Case crmcase = service.getCaseById(order.getCaseId());
					order = service.getOrderById(order.getOrderId());
					String result = emailService.creatTemplate(crmcase, order);
								
					//生成待发送邮件
					order = service.getOrderById(order.getOrderId());
					emailService.saveEmail(order,result);
					
					json.setSuccess(true);
				}
<<<<<<< HEAD
				/*			}
=======
			}
>>>>>>> fc09c0e2c91d679b10e7804f201315e216e194a9
			else{
				json.setSuccess(false);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("OrderController.doAdd() --> " + order.toString() + "\n" + e.getMessage());
		}	
		return json;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int orderId = Integer.parseInt(id);
			Order order = service.getOrderById(orderId);
			String currency="order.currency";
			String status = "order.status";
			String country = "country";
			String reason = "order.reason";
			List<EntityList> currencyList = service.getParameterInfo(currency);
			List<EntityList> statusList = service.getParameterInfo(status);
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> reasonList = service.getParameterInfo(reason);
			JSONArray currencyResult = JSONArray.fromObject(currencyList);
			JSONArray statusResult = JSONArray.fromObject(statusList);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray reasonResult = JSONArray.fromObject(reasonList);
			model.addAttribute("currency",currencyResult);
			model.addAttribute("orderStatus",statusResult);
			model.addAttribute("order",order);
			model.addAttribute("country",countryResult);
			model.addAttribute("reason",reasonResult);
		}
		return "/order/edit";
	}

	@RequestMapping(value = "/orderDeal.do")
	@ResponseBody
	public Json orderDeal(HttpServletRequest request, HttpSession session, Model model, Order order) {
		
		Json json = new Json();	
		System.out.println(order.getOrderId());
		Order oldOrder = service.getOrderById(order.getOrderId());
		Case crmcase = caseService.getCaseById(oldOrder.getCaseId());
		
		try {
			service.updateOrder(order);			
				crmcase.setStatus("3");
				service.customerStatus(oldOrder.getCustomerId(), "3");
				caseService.updateCase(crmcase);
		
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	
	@RequestMapping(value = "/orderNoDeal.do")
	@ResponseBody
	public Json orderNoDeal(HttpServletRequest request, HttpSession session, Model model, Order order) {

		Json json = new Json();
		
		Case crmcase = caseService.getCaseByOrderId(order.getOrderId());
		try {
			service.updateOrder(order);
			int i = caseService.caseStatus(crmcase.getCaseId());
			if(i==0){
				crmcase.setStatus("4");
				caseService.updateCase(crmcase);
			}
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value = "/updateDeal.do")
	@ResponseBody
	public Json doEdit1(Order order) {

		Json json = new Json();	
		try {
			service.updateOrder(order);	
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.doEdit1() --> " + order.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int orderId = Integer.parseInt(id);
				service.deleteOrderById(orderId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return json;
	}

}