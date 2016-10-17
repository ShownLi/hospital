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
		String country = "country";
		List<EntityList> userList = service.getAllUser();
		List<EntityList> customerList = service.getCustomer();
		List<EntityList> salesList = service.getSales();
		List<EntityList> sourceList = service.getParameterInfo(source);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> countryList = service.getParameterInfo(country);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray customerResult = JSONArray.fromObject(customerList);
		JSONArray userResult = JSONArray.fromObject(userList);
		JSONArray salesResult = JSONArray.fromObject(salesList);
		model.addAttribute("destination",countryResult);
		model.addAttribute("source",sourceResult);
		model.addAttribute("caseStatus",statusResult);
		model.addAttribute("customer",customerResult);
		model.addAttribute("user",userResult);
		model.addAttribute("sales",salesResult);
		return "/case/list";
	}
	
	@RequestMapping(value = "/listfromcustomer.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, int customerId , PageHelper page) {

		QueryResult<Case> caseResult = service.queryCaseFromCustomer(customerId ,page, request);
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Case crmcase, PageHelper page) {
	
		QueryResult<Case> casePage = service.queryCase(crmcase, page, request);
		
		String result = JSONUtilS.object2json(casePage);
		return result;
	}
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "case.preferlanguage";
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
		List<EntityList> v1 = service.getParameterInfo(country);
		List<EntityList> v2 = service.getParameterInfo(language);
		List<EntityList> v4 = service.getParameterInfo(withwho);
		List<EntityList> v5 = service.getParameterInfo(hotel);
		List<EntityList> v6 = service.getParameterInfo(meals);
		List<EntityList> v7 = service.getParameterInfo(guide);
		List<EntityList> v8 = service.getParameterInfo(status);
		List<EntityList> v9 = service.getParameterInfo(source);
		List<EntityList> v10 = service.getParameterInfo(tailormade);
		List<EntityList> v11 = service.getParameterInfo(passport);
		List<EntityList> v12 = service.getParameterInfo(visa);
		List<EntityList> v13 = service.getParameterInfo(flight);
		List<EntityList> customer = service.getCustomer();
		List<EntityList> user = service.getUser();
		List<EntityList> sales = service.getSales();
		JSONArray countryResult = JSONArray.fromObject(v1);
		JSONArray languageResult = JSONArray.fromObject(v2);
		JSONArray withResult = JSONArray.fromObject(v4);
		JSONArray hotelResult = JSONArray.fromObject(v5);
		JSONArray mealsResult = JSONArray.fromObject(v6);
		JSONArray guideResult = JSONArray.fromObject(v7);
		JSONArray statusResult = JSONArray.fromObject(v8);
		JSONArray sourceResult = JSONArray.fromObject(v9);
		JSONArray tailormadeResult = JSONArray.fromObject(v10);
		JSONArray passportResult = JSONArray.fromObject(v11);
		JSONArray visaResult = JSONArray.fromObject(v12);
		JSONArray flightResult = JSONArray.fromObject(v13);
		JSONArray customerResult = JSONArray.fromObject(customer);
		JSONArray userResult = JSONArray.fromObject(user);
		JSONArray salesResult = JSONArray.fromObject(sales);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		model.addAttribute("withwho",withResult);
		model.addAttribute("hotel",hotelResult);
		model.addAttribute("meals",mealsResult);
		model.addAttribute("guide",guideResult);
		model.addAttribute("status",statusResult);
		model.addAttribute("source",sourceResult);
		model.addAttribute("customer",customerResult);
		model.addAttribute("sales",salesResult);
		model.addAttribute("tailormade",tailormadeResult);
		model.addAttribute("passport",passportResult);
		model.addAttribute("visa",visaResult);
		model.addAttribute("flight",flightResult);
		model.addAttribute("user",userResult);
		
		return "/case/add";
	}
	
	/*
	 * 在客人编辑页面给客人添加询单
	 */
	@RequestMapping(value = "/addCase.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String addfromcustomer(Model model, int customerId) {
		
		String country = "country";
		String language = "case.preferlanguage";
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
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		List<EntityList> withwhoList = service.getParameterInfo(withwho);
		List<EntityList> hotelList = service.getParameterInfo(hotel);
		List<EntityList> mealsList = service.getParameterInfo(meals);
		List<EntityList> guideList = service.getParameterInfo(guide);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> sourceList = service.getParameterInfo(source);
		List<EntityList> tailormadeList = service.getParameterInfo(tailormade);
		List<EntityList> passportList = service.getParameterInfo(passport);
		List<EntityList> visaList = service.getParameterInfo(visa);
		List<EntityList> flightList = service.getParameterInfo(flight);
		List<EntityList> customerList = service.getCustomer();
		List<EntityList> userList = service.getUser();
		List<EntityList> salesList = service.getSales();
		JSONArray countryresult = JSONArray.fromObject(countryList);
		JSONArray languageresult = JSONArray.fromObject(languageList);
		JSONArray withresult = JSONArray.fromObject(withwhoList);
		JSONArray hotelresult = JSONArray.fromObject(hotelList);
		JSONArray mealsresult = JSONArray.fromObject(mealsList);
		JSONArray guideresult = JSONArray.fromObject(guideList);
		JSONArray statusresult = JSONArray.fromObject(statusList);
		JSONArray sourceresult = JSONArray.fromObject(sourceList);
		JSONArray tailormaderesult = JSONArray.fromObject(tailormadeList);
		JSONArray passportresult = JSONArray.fromObject(passportList);
		JSONArray visaresult = JSONArray.fromObject(visaList);
		JSONArray flightresult = JSONArray.fromObject(flightList);
		JSONArray customerresult = JSONArray.fromObject(customerList);
		JSONArray userresult = JSONArray.fromObject(userList);
		JSONArray salesresult = JSONArray.fromObject(salesList);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
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
		model.addAttribute("customerId",customerId);
		model.addAttribute("user",userresult);
		
		return "/case/add";
	}
	
	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {

		Json j = new Json();
		
		try {
			service.saveCase(crmcase);
			j.setObj(crmcase);
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
			int caseId = Integer.parseInt(id);
			Case crmcase = service.getCaseById(caseId);
			crmcase=service.validateStartTime(crmcase);
			Customer cus=service.getCustomerInfoById(crmcase.getCustomerId());
			String country = "country";
			String language = "case.preferlanguage";
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
			String level = "customer.level";
			String ageGroup = "customer.agegroup";
			
			
			List<EntityList> v1 = service.getParameterInfo(country);
			List<EntityList> v2 = service.getParameterInfo(language);
			List<EntityList> v4 = service.getParameterInfo(withwho);
			List<EntityList> v5 = service.getParameterInfo(hotel);
			List<EntityList> v6 = service.getParameterInfo(meals);
			List<EntityList> v7 = service.getParameterInfo(guide);
			List<EntityList> v8 = service.getParameterInfo(status);
			List<EntityList> v9 = service.getParameterInfo(source);
			List<EntityList> v10 = service.getParameterInfo(tailormade);
			List<EntityList> v11 = service.getParameterInfo(passport);
			List<EntityList> v12 = service.getParameterInfo(visa);
			List<EntityList> v13 = service.getParameterInfo(flight);
			List<EntityList> customer = service.getCustomer();
			List<EntityList> user = service.getUser();
			List<EntityList> sales = service.getSales();
			List<EntityList> levelList= service.getParameterInfo(level);
			List<EntityList> ageGroupList = service.getParameterInfo(ageGroup);

			
			JSONArray countryResult = JSONArray.fromObject(v1);
			JSONArray languageResult = JSONArray.fromObject(v2);
			JSONArray withResult = JSONArray.fromObject(v4);
			JSONArray hotelResult = JSONArray.fromObject(v5);
			JSONArray mealsResult = JSONArray.fromObject(v6);
			JSONArray guideResult = JSONArray.fromObject(v7);
			JSONArray statusResult = JSONArray.fromObject(v8);
			JSONArray sourceResult = JSONArray.fromObject(v9);
			JSONArray tailormadeResult = JSONArray.fromObject(v10);
			JSONArray passportResult = JSONArray.fromObject(v11);
			JSONArray visaResult = JSONArray.fromObject(v12);
			JSONArray flightResult = JSONArray.fromObject(v13);
			JSONArray customerResult = JSONArray.fromObject(customer);
			JSONArray userResult = JSONArray.fromObject(user);
			JSONArray salesResult = JSONArray.fromObject(sales);
			JSONArray levelResult = JSONArray.fromObject(levelList);
			JSONArray  ageGroupResult = JSONArray.fromObject(ageGroupList);
			
			model.addAttribute("country",countryResult);
			model.addAttribute("language",languageResult);
			model.addAttribute("withwho",withResult);
			model.addAttribute("hotel",hotelResult);
			model.addAttribute("meals",mealsResult);
			model.addAttribute("guide",guideResult);
			model.addAttribute("status",statusResult);
			model.addAttribute("source",sourceResult);
			model.addAttribute("customer",customerResult);
			model.addAttribute("sales",salesResult);
			model.addAttribute("tailormade",tailormadeResult);
			model.addAttribute("passport",passportResult);
			model.addAttribute("visa",visaResult);
			model.addAttribute("flight",flightResult);
			model.addAttribute("user",userResult);
			model.addAttribute("crmcase",crmcase);
			model.addAttribute("customerInfo",cus);
			
			model.addAttribute("level",levelResult);
			model.addAttribute("ageGroup",ageGroupResult);
			
			String orderStatus = "order.status";
			List<EntityList> w = service.getParameterInfo(orderStatus);
			JSONArray orderStatusResult = JSONArray.fromObject(w);
			model.addAttribute("orderStatus",orderStatusResult);
		}
		return "/case/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {

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
	
	//添加询单时 ，选择目的地及地接社，  目的地与销售联动
	@RequestMapping(value = "/getSales.do")
	@ResponseBody
	public List<EntityList> getSales(Model model, String destination) {
		
		List<EntityList> sales = service.getSalesByAgency(destination);
		return sales;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json j = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int caseId = Integer.parseInt(id);
				service.deleteCaseById(caseId);
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