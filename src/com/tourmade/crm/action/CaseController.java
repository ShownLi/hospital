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
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.service.CaseService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/case")
public class CaseController extends BaseSimpleFormController {
	
	@Autowired
	private CaseService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String source = "case.source";
		String status = "case.status";
		List<DemoList> user = service.getUser();
		List<DemoList> customer = service.getCustomer();
		List<DemoList> v = service.getParameterInfo(source);
		List<DemoList> w = service.getParameterInfo(status);
		JSONArray sourceresult = JSONArray.fromObject(v);
		JSONArray statusresult = JSONArray.fromObject(w);
		JSONArray cusresult = JSONArray.fromObject(customer);
		JSONArray userresult = JSONArray.fromObject(user);
		model.addAttribute("source",sourceresult);
		model.addAttribute("status",statusresult);
		model.addAttribute("customer",cusresult);
		model.addAttribute("user",userresult);
		return "/case/list";
	}
	
	@RequestMapping(value = "/listfromcustomer.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, int customerid ,DemoCase crmcase, PageHelper page) {

		//System.out.println(customerid);
		QueryResult<DemoCase> r = service.queryCaseFromCustomer(crmcase, customerid ,page, request);
		String result = JSONUtilS.object2json(r);

		return result;
	}

	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoCase crmcase, PageHelper page) {
	
		QueryResult<DemoCase> r = service.queryCase(crmcase, page, request);
		
		String result = JSONUtilS.object2json(r);
		//System.out.println(result);
		return result;
	}
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "case.language";
		String contacttype = "case.contacttype";
		String withwho = "case.withwho";
		String hotel = "case.hotel";
		String meals = "case.meals";
		String guide = "case.guide";
		String status = "case.status";
		String source = "case.source";
		String tailormade = "case.tailormade";
		String passport = "case.passport";
		String visa = "case.visa";
		String flight = "case.flight";
		List<DemoList> v1 = service.getParameterInfo(country);
		List<DemoList> v2 = service.getParameterInfo(language);
		List<DemoList> v3 = service.getParameterInfo(contacttype);
		List<DemoList> v4 = service.getParameterInfo(withwho);
		List<DemoList> v5 = service.getParameterInfo(hotel);
		List<DemoList> v6 = service.getParameterInfo(meals);
		List<DemoList> v7 = service.getParameterInfo(guide);
		List<DemoList> v8 = service.getParameterInfo(status);
		List<DemoList> v9 = service.getParameterInfo(source);
		List<DemoList> v10 = service.getParameterInfo(tailormade);
		List<DemoList> v11 = service.getParameterInfo(passport);
		List<DemoList> v12 = service.getParameterInfo(visa);
		List<DemoList> v13 = service.getParameterInfo(flight);
		List<DemoList> customer = service.getCustomer();
		List<DemoList> user = service.getUser();
		List<DemoList> sales = service.getSales();
		JSONArray countryresult = JSONArray.fromObject(v1);
		JSONArray languageresult = JSONArray.fromObject(v2);
		JSONArray contactresult = JSONArray.fromObject(v3);
		JSONArray withresult = JSONArray.fromObject(v4);
		JSONArray hotelresult = JSONArray.fromObject(v5);
		JSONArray mealsresult = JSONArray.fromObject(v6);
		JSONArray guideresult = JSONArray.fromObject(v7);
		JSONArray statusresult = JSONArray.fromObject(v8);
		JSONArray sourceresult = JSONArray.fromObject(v9);
		JSONArray tailormaderesult = JSONArray.fromObject(v10);
		JSONArray passportresult = JSONArray.fromObject(v11);
		JSONArray visaresult = JSONArray.fromObject(v12);
		JSONArray flightresult = JSONArray.fromObject(v13);
		JSONArray customerresult = JSONArray.fromObject(customer);
		JSONArray userresult = JSONArray.fromObject(user);
		JSONArray salesresult = JSONArray.fromObject(sales);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		model.addAttribute("contacttype",contactresult);
		model.addAttribute("withwho",withresult);
		model.addAttribute("hotel",hotelresult);
		model.addAttribute("meals",mealsresult);
		model.addAttribute("guide",guideresult);
		model.addAttribute("status",statusresult);
		model.addAttribute("source",sourceresult);
		model.addAttribute("customer",customerresult);
		model.addAttribute("sales",salesresult);
		model.addAttribute("tailormade",tailormaderesult);
		model.addAttribute("passport",passportresult);
		model.addAttribute("visa",visaresult);
		model.addAttribute("flight",flightresult);
		model.addAttribute("user",userresult);
		return "/case/add";
	}

	@RequestMapping(value = "/add1.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String addfromcustomer(Model model, int customerid) {
		
		String country = "country";
		String language = "case.language";
		String contacttype = "case.contacttype";
		String withwho = "case.withwho";
		String hotel = "case.hotel";
		String meals = "case.meals";
		String guide = "case.guide";
		String status = "case.status";
		String source = "case.source";
		String tailormade = "case.tailormade";
		String passport = "case.passport";
		String visa = "case.visa";
		String flight = "case.flight";
		List<DemoList> v1 = service.getParameterInfo(country);
		List<DemoList> v2 = service.getParameterInfo(language);
		List<DemoList> v3 = service.getParameterInfo(contacttype);
		List<DemoList> v4 = service.getParameterInfo(withwho);
		List<DemoList> v5 = service.getParameterInfo(hotel);
		List<DemoList> v6 = service.getParameterInfo(meals);
		List<DemoList> v7 = service.getParameterInfo(guide);
		List<DemoList> v8 = service.getParameterInfo(status);
		List<DemoList> v9 = service.getParameterInfo(source);
		List<DemoList> v10 = service.getParameterInfo(tailormade);
		List<DemoList> v11 = service.getParameterInfo(passport);
		List<DemoList> v12 = service.getParameterInfo(visa);
		List<DemoList> v13 = service.getParameterInfo(flight);
		List<DemoList> customer = service.getCustomer();
		List<DemoList> user = service.getUser();
		List<DemoList> sales = service.getSales();
		JSONArray countryresult = JSONArray.fromObject(v1);
		JSONArray languageresult = JSONArray.fromObject(v2);
		JSONArray contactresult = JSONArray.fromObject(v3);
		JSONArray withresult = JSONArray.fromObject(v4);
		JSONArray hotelresult = JSONArray.fromObject(v5);
		JSONArray mealsresult = JSONArray.fromObject(v6);
		JSONArray guideresult = JSONArray.fromObject(v7);
		JSONArray statusresult = JSONArray.fromObject(v8);
		JSONArray sourceresult = JSONArray.fromObject(v9);
		JSONArray tailormaderesult = JSONArray.fromObject(v10);
		JSONArray passportresult = JSONArray.fromObject(v11);
		JSONArray visaresult = JSONArray.fromObject(v12);
		JSONArray flightresult = JSONArray.fromObject(v13);
		JSONArray customerresult = JSONArray.fromObject(customer);
		JSONArray userresult = JSONArray.fromObject(user);
		JSONArray salesresult = JSONArray.fromObject(sales);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		model.addAttribute("contacttype",contactresult);
		model.addAttribute("withwho",withresult);
		model.addAttribute("hotel",hotelresult);
		model.addAttribute("meals",mealsresult);
		model.addAttribute("guide",guideresult);
		model.addAttribute("status",statusresult);
		model.addAttribute("source",sourceresult);
		model.addAttribute("customer",customerresult);
		model.addAttribute("sales",salesresult);
		model.addAttribute("tailormade",tailormaderesult);
		model.addAttribute("passport",passportresult);
		model.addAttribute("visa",visaresult);
		model.addAttribute("flight",flightresult);
		model.addAttribute("customerid",customerid);
		model.addAttribute("user",userresult);
		return "/case/add";
	}
	
	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, DemoCase crmcase) {

		Json j = new Json();
		
		try {
			//System.out.println(crmcase);
			service.saveCase(crmcase);		
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			DemoCase u = service.getCaseById(i);
			String country = "country";
			String language = "case.language";
			String contacttype = "case.contacttype";
			String withwho = "case.withwho";
			String hotel = "case.hotel";
			String meals = "case.meals";
			String guide = "case.guide";
			String status = "case.status";
			String source = "case.source";
			String tailormade = "case.tailormade";
			String passport = "case.passport";
			String visa = "case.visa";
			String flight = "case.flight";
			List<DemoList> v1 = service.getParameterInfo(country);
			List<DemoList> v2 = service.getParameterInfo(language);
			List<DemoList> v3 = service.getParameterInfo(contacttype);
			List<DemoList> v4 = service.getParameterInfo(withwho);
			List<DemoList> v5 = service.getParameterInfo(hotel);
			List<DemoList> v6 = service.getParameterInfo(meals);
			List<DemoList> v7 = service.getParameterInfo(guide);
			List<DemoList> v8 = service.getParameterInfo(status);
			List<DemoList> v9 = service.getParameterInfo(source);
			List<DemoList> v10 = service.getParameterInfo(tailormade);
			List<DemoList> v11 = service.getParameterInfo(passport);
			List<DemoList> v12 = service.getParameterInfo(visa);
			List<DemoList> v13 = service.getParameterInfo(flight);
			List<DemoList> customer = service.getCustomer();
			List<DemoList> user = service.getUser();
			List<DemoList> sales = service.getSales();
			JSONArray countryresult = JSONArray.fromObject(v1);
			JSONArray languageresult = JSONArray.fromObject(v2);
			JSONArray contactresult = JSONArray.fromObject(v3);
			JSONArray withresult = JSONArray.fromObject(v4);
			JSONArray hotelresult = JSONArray.fromObject(v5);
			JSONArray mealsresult = JSONArray.fromObject(v6);
			JSONArray guideresult = JSONArray.fromObject(v7);
			JSONArray statusresult = JSONArray.fromObject(v8);
			JSONArray sourceresult = JSONArray.fromObject(v9);
			JSONArray tailormaderesult = JSONArray.fromObject(v10);
			JSONArray passportresult = JSONArray.fromObject(v11);
			JSONArray visaresult = JSONArray.fromObject(v12);
			JSONArray flightresult = JSONArray.fromObject(v13);
			JSONArray customerresult = JSONArray.fromObject(customer);
			JSONArray userresult = JSONArray.fromObject(user);
			JSONArray salesresult = JSONArray.fromObject(sales);
			model.addAttribute("country",countryresult);
			model.addAttribute("language",languageresult);
			model.addAttribute("contacttype",contactresult);
			model.addAttribute("withwho",withresult);
			model.addAttribute("hotel",hotelresult);
			model.addAttribute("meals",mealsresult);
			model.addAttribute("guide",guideresult);
			model.addAttribute("status",statusresult);
			model.addAttribute("source",sourceresult);
			model.addAttribute("customer",customerresult);
			model.addAttribute("sales",salesresult);
			model.addAttribute("tailormade",tailormaderesult);
			model.addAttribute("passport",passportresult);
			model.addAttribute("visa",visaresult);
			model.addAttribute("flight",flightresult);
			model.addAttribute("user",userresult);
			model.addAttribute("crmcase",u);
		}
		return "/case/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, DemoCase crmcase) {

		Json j = new Json();
		
		try {
			service.updateCase(crmcase);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CaseController.doEdit() --> " + crmcase.toString() + "\n" + e.getMessage());
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
				service.deleteCaseById(i);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("CaseController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return j;
	}

}