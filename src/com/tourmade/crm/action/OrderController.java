package com.tourmade.crm.action;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.tourmade.crm.entity.PriceRecord;
import com.tourmade.crm.entity.PriceRecordList;
import com.tourmade.crm.entity.Sale;
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
	public String list(Model model,String flag,HttpSession session) {
		String currency="order.currency";		
		String country = "country";
		String status = "order.status";
		String reason = "order.reason";
		String email = "order.email";
		
		List<EntityList> userList = caseService.getAllUser();
		List<EntityList> currencyList = service.getParameterInfo(currency);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> reasonLiat = service.getParameterInfo(reason);
		List<EntityList> emailList = service.getParameterInfo(email);
		JSONArray userResult = JSONArray.fromObject(userList);
		JSONArray currencyResult = JSONArray.fromObject(currencyList);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray reasonResult = JSONArray.fromObject(reasonLiat);
		JSONArray emailResult = JSONArray.fromObject(emailList);
		model.addAttribute("user",userResult);
		model.addAttribute("currency",currencyResult);
		model.addAttribute("orderStatus",statusResult);
		model.addAttribute("destination",countryResult);
		model.addAttribute("reason",reasonResult);
		model.addAttribute("email",emailResult);
		
		if ("".equals(flag) || flag == null) {
			model.addAttribute("flag", "restart");
			session.removeAttribute("searchOrder");
		} else
			model.addAttribute("flag", flag);
		return "/order/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(String flag,HttpServletRequest request, HttpSession session, Model model, Order order, PageHelper page) {

		if ("old".equals(flag)) {
			Order search = (Order) session.getAttribute("searchOrder");
			if(search==null)
				search=new Order();
			order = search;
		}else{
			session.setAttribute("searchOrder", order);
		}
		
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
	/*@RequestMapping(value = "/listByCaseId.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, int caseId, PageHelper page) {

		QueryResult<Order> order = service.queryOrderByCaseId(caseId, page, request);
		String result = JSONUtilS.object2json(order);

		return result;
	}*/
	/**
	 * 根据caseid获取相应订单,不使用分页
	 * @param request
	 * @param session
	 * @param model
	 * @param caseId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/listByCaseId.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, Model model, int caseId){
		QueryResult<Order> order = service.queryOrderByCaseId(caseId, request);
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
		
		Json json = new Json();

		if(order.getCaseId()!=0){
		   Customer customer = service.getCustomerByCaseId(order.getCaseId());
		   if(customer.getEmail().equals("")){

				json.setText("noCustomerEmail");
			   //客人状态设置为下单客人
			   service.customerStatus(order.getCustomerId(),"2");
			   //询单状态设置为“地接社设计中”
			   caseService.case2orderNoEmail(order.getCaseId());
			   //补充order信息并存储该order
			   order = service.saveOrder(order);
			   return json;
		   }
		   else{
			   Sale sale = service.getSaleBySalesId(order.getSalesId());
			   if(sale.getSalesEmail().equals("")){
				   json.setText("noSaleEmail");
				   //客人状态设置为下单客人
				   service.customerStatus(order.getCustomerId(),"2");
				   //询单状态设置为“地接社设计中”
				   caseService.case2orderNoEmail(order.getCaseId());
				   //补充order信息并存储该order
				   order = service.saveOrder(order);
				   return json;
			   }
			   order.setCustomerId(customer.getCustomerId());		   
			}
		
		try {
			//客人状态设置为下单客人
			service.customerStatus(order.getCustomerId(),"2");
			//询单状态设置为下单
			caseService.case2order(order.getCaseId());
			//补充order信息并存储该order
			order = service.saveOrder(order);
			//判断是否要发送邮件
			int isSendmail = service.selectAgencyBySaleId(order.getSalesId());
			if(isSendmail==0){
				json.setText("noSendmail");
				return json;
			}else{
				//邮件别名操作（创建邮件别名并将其写入order表）
				service.MailAlias(order);	
				//生成给地接社的第一封邮件
				Case crmcase = service.getCaseById(order.getCaseId());
				order = service.getOrderById(order.getOrderId());
				String result = emailService.creatTemplate(crmcase, order);
							
				//生成待发送邮件
				order = service.getOrderById(order.getOrderId());
				emailService.saveEmail(order,result);
				
				json.setSuccess(true);
			}
		}finally{}
		   order.setCustomerId(customer.getCustomerId());		   
		}
//		try {
//			放上面else代码
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("OrderController.doAdd() --> " + order.toString() + "\n" + e.getMessage());
//		}	
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
	public Json orderDeal(HttpServletRequest request, HttpSession session, Model model, Order order, PriceRecordList priceRecordList) {
		Enumeration<String> rgp = request.getParameterNames();
		String paraName,paraValue;
		String[] paraValues;
		while(rgp.hasMoreElements()){
			paraName = rgp.nextElement();
			paraValue = request.getParameter(paraName);
			paraValues = request.getParameterValues(paraName);     
			System.out.println("paraName:"+paraName+","+"paraValue:"+paraValue);
		}
		
		
		Json json = new Json();	
		Order oldOrder = service.getOrderById(order.getOrderId());
		Case crmcase = caseService.getCaseById(oldOrder.getCaseId());
		System.out.println(priceRecordList.getPaymentItem().size());
		System.out.println("---------");
		//System.out.println(priceRecordList==null);
		try {
			service.updateOrder(order);			
			crmcase.setStatus("3");
			service.customerStatus(oldOrder.getCustomerId(), "3");
			caseService.updateCaseStatus(crmcase);
		
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
				caseService.updateCaseStatus(crmcase);
			}
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value = "/orderSendEmail.do")
	@ResponseBody
	public Json orderSendEmail(HttpServletRequest request, HttpSession session, Model model, Integer orderId) {
		Json json = new Json();
		
		//判断是否要发送邮件
		Order order = service.getOrderById(orderId);
		int isSendmail = service.selectAgencyBySaleId(order.getSalesId());
		if(isSendmail==0){
			json.setSuccess(false);
			return json;
		}else{
			//邮件别名操作（创建邮件别名并将其写入order表）
			//service.MailAlias(order);	
			//生成给地接社的第一封邮件
			Case crmcase = service.getCaseById(order.getCaseId());
			String result = emailService.creatTemplate(crmcase, order);
			
			//生成待发送邮件
			emailService.saveEmail(order,result);
			json.setSuccess(true);
		}
		return json;
	}
	
	@RequestMapping(value = "/orderSendEmailNoAlias.do")
	@ResponseBody
	public Json orderSendEmailNoAlias(HttpServletRequest request, HttpSession session, Model model, Integer orderId) {
		Json json = new Json();
		
		//判断是否要发送邮件
		Order order = service.getOrderById(orderId);
		int isSendmail = service.selectAgencyBySaleId(order.getSalesId());
		if(isSendmail==0){
			json.setSuccess(false);
			return json;
		}else{
			//邮件别名操作（创建邮件别名并将其写入order表）
			service.MailAlias(order);	
			
			//生成给地接社的第一封邮件
			Case crmcase = service.getCaseById(order.getCaseId());
			String result = emailService.creatTemplate(crmcase, order);
			
			//获取更新了别名的最新订单
			order = service.getOrderById(order.getOrderId());
			
			//生成待发送邮件
			emailService.saveEmail(order,result);
			json.setSuccess(true);
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

	@RequestMapping(value="/addPriceRecord.do")
	@ResponseBody
	public Json addPriceRecord(HttpServletRequest request, @RequestParam("priceRecordList[]") List<PriceRecord> priceRecordList){
		Json json = new Json();
		try{
			System.out.println("-----");
			System.out.println(priceRecordList==null);
			System.out.println(priceRecordList);
			
			json.setSuccess(true);
		} catch(Exception e) {
			json.setSuccess(false);
			logger.error("OrderController.addPriceRecord() -->" + priceRecordList + "\n" +e.getMessage());
		}
		
		return json;
	}
}