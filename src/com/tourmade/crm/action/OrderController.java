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
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoList;
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
		List<DemoList> w = service.getParameterInfo(status);
		List<DemoList> v = service.getParameterInfo(country);
		JSONArray countryresult = JSONArray.fromObject(v);
		JSONArray statusresult = JSONArray.fromObject(w);
		model.addAttribute("orderstatus",statusresult);
		model.addAttribute("destination",countryresult);
		return "/order/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoOrder order, PageHelper page) {

		QueryResult<DemoOrder> r = service.queryOrder(order, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}

	@RequestMapping(value = "/list1.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, int caseid, PageHelper page) {

		QueryResult<DemoOrder> r = service.queryOrderByCaseid(caseid, page, request);
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
		
		try {
			boolean is = service.validatemail(order.getCustomerid());
			//验证客人有邮箱
			if(is)
			{
				boolean portalid = service.validateportalid(order.getCustomerid());
				if(!portalid){
					service.creatPortal(order.getCustomerid());
				}
				//客人状态设置为下单客人
				service.customerstatus(order.getCustomerid(),"2");
				
				//询单状态设置为下单
				caseservice.case2order(order.getCaseid());
				
				//补充order信息并存储该order
				order = service.saveOrder(order);
				
				//邮件别名操作（创建邮件别名并将其写入order表）
				service.MailAlias(order.getOrderid());
				
				//生成给地接社的第一封邮件
				//DemoCustomer customer = service.getCustomerById(order.getCustomerid());
				DemoCase crmcase = service.getCaseById(order.getCaseid());
				String result = emailservice.creatTemplate(crmcase, order);
				
				//生成待发送邮件
				order = service.getOrderById(order.getOrderid());
				emailservice.saveEmail(order,result);
				
				j.setSuccess(true);
			}
			else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			e.printStackTrace();
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
		DemoCase crmcase = caseservice.getCaseById(order.getCaseid());
		
		try {

			service.updateOrder(order);
			
			if(order.getGroupnumber()!= null){				
				crmcase.setStatus("3");
				service.customerstatus(order.getCustomerid(), "3");
				caseservice.updateCase(crmcase);
			}
			if(order.getReason() != null){
				int i = caseservice.casestatus(order.getCaseid());
				if(i==0){
					crmcase.setStatus("4");
					caseservice.updateCase(crmcase);
				}
			}
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderController.doEdit() --> " + order.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit1.do")
	@ResponseBody
	public Json doEdit1(DemoOrder order) {

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