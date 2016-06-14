package com.tourmade.crm.action;

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
import com.tourmade.crm.model.DemoSale;
import com.tourmade.crm.service.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController extends BaseSimpleFormController {

	@Autowired
	private SaleService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/sale/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoSale sale, PageHelper page) {

		QueryResult<DemoSale> r = service.querySale(sale, page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		return "/sale/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, DemoSale sale) {

		Json j = new Json();
		
		try {
			service.saveSale(sale);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("SaleController.doAdd() --> " + sale.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			DemoSale u = service.getSaleById(i);
			model.addAttribute("sale",u);
		}
		
		
		return "/sale/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, DemoSale sale) {

		Json j = new Json();
		
		try {
			service.updateSale(sale);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("SaleController.doEdit() --> " + sale.toString() + "\n" + e.getMessage());
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
				service.deleteSaleById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("SaleController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}
	
}
