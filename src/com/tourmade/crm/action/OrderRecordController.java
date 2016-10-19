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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.OrderRecord;
import com.tourmade.crm.service.OrderRecordService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/record")
public class OrderRecordController extends BaseSimpleFormController {
	
	@Autowired
	private OrderRecordService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String country = "country";
		String language = "record.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		return "/record/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, OrderRecord record, Integer orderId, PageHelper page) {

		QueryResult<OrderRecord> orderRecord = service.queryOrderRecord(record, page, orderId ,request);
		//System.out.println("\nid = "+orderid);
		String result = JSONUtilS.object2json(orderRecord);
		return result;
	}

	@RequestMapping(value = "/list.case",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getData(HttpServletRequest request, HttpSession session, Model model, OrderRecord record, Integer caseId, PageHelper page) {

		QueryResult<OrderRecord> orderRecord = service.getOrderRecord(record, page, caseId ,request);
		String result = JSONUtilS.object2json(orderRecord);
		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "record.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray  languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		
		return "/record/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, OrderRecord record) {

		Json j = new Json();
		
		try {
			service.saveOrderRecord(record);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderRecordController.doAdd() --> " + record.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			OrderRecord record = service.getOrderRecordById(i);
			String country = "country";
			String language = "record.language";
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> languageList = service.getParameterInfo(language);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray languageResult = JSONArray.fromObject(languageList);
			model.addAttribute("country",countryResult);
			model.addAttribute("language",languageResult);
			model.addAttribute("record",record);
		}
		return "/record/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, OrderRecord record) {

		Json j = new Json();
		
		try {
			service.updateOrderRecord(record);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderRecordController.doEdit() --> " + record.toString() + "\n" + e.getMessage());
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
				service.deleteOrderRecordById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("OrderRecordController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}

}