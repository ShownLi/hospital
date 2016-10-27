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
	
	@RequestMapping(value = "/listByCustomerId.do",produces="application/json;charset=utf-8")
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
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		List<EntityList> withList = service.getParameterInfo(withwho);
		List<EntityList> hotelList = service.getParameterInfo(hotel);
		List<EntityList> mealList = service.getParameterInfo(meals);
		List<EntityList> guideList = service.getParameterInfo(guide);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> sourceList = service.getParameterInfo(source);
		List<EntityList> tailList = service.getParameterInfo(tailormade);
		List<EntityList> passList = service.getParameterInfo(passport);
		List<EntityList> visaList = service.getParameterInfo(visa);
		List<EntityList> flightList = service.getParameterInfo(flight);
		List<EntityList> customer = service.getCustomer();
		List<EntityList> user = service.getUser();
		List<EntityList> sales = service.getSales();
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		JSONArray withResult = JSONArray.fromObject(withList);
		JSONArray hotelResult = JSONArray.fromObject(hotelList);
		JSONArray mealsResult = JSONArray.fromObject(mealList);
		JSONArray guideResult = JSONArray.fromObject(guideList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		JSONArray tailormadeResult = JSONArray.fromObject(tailList);
		JSONArray passportResult = JSONArray.fromObject(passList);
		JSONArray visaResult = JSONArray.fromObject(visaList);
		JSONArray flightResult = JSONArray.fromObject(flightList);
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
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		JSONArray withResult = JSONArray.fromObject(withwhoList);
		JSONArray hotelResult = JSONArray.fromObject(hotelList);
		JSONArray mealsResult = JSONArray.fromObject(mealsList);
		JSONArray guideResult = JSONArray.fromObject(guideList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		JSONArray tailormadeResult = JSONArray.fromObject(tailormadeList);
		JSONArray passportResult = JSONArray.fromObject(passportList);
		JSONArray visaResult = JSONArray.fromObject(visaList);
		JSONArray flightResult = JSONArray.fromObject(flightList);
		JSONArray customerResult = JSONArray.fromObject(customerList);
		JSONArray userResult = JSONArray.fromObject(userList);
		JSONArray salesResult = JSONArray.fromObject(salesList);
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
		model.addAttribute("customerId",customerId);
		model.addAttribute("user",userResult);
		
		return "/case/add";
	}
	
	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {
		
		Json json = new Json();
		
		try {
			service.saveCase(crmcase);
			json.setObj(crmcase);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int caseId = Integer.parseInt(id);
			Case crmcase = service.getCaseById(caseId);
			//解决客人的要求换行符问题
			if(crmcase.getRequirement()!=null){			
				String[] splits= crmcase.getRequirement().split("\r\n");
				String realRequire="";
				for(String split:splits){
					realRequire+=split+"\\r\\n";
				}		
				crmcase.setRequirement(realRequire);
			}

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
			
			
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> languageList = service.getParameterInfo(language);
			List<EntityList> withwhoList = service.getParameterInfo(withwho);
			List<EntityList> hotelList = service.getParameterInfo(hotel);
			List<EntityList> mealsList = service.getParameterInfo(meals);
			List<EntityList> guideList = service.getParameterInfo(guide);
			List<EntityList> statusList = service.getParameterInfo(status);
			List<EntityList> sourceList = service.getParameterInfo(source);
			List<EntityList> tailList = service.getParameterInfo(tailormade);
			List<EntityList> passList = service.getParameterInfo(passport);
			List<EntityList> visaList = service.getParameterInfo(visa);
			List<EntityList> flightList = service.getParameterInfo(flight);
			List<EntityList> customer = service.getCustomer();
			List<EntityList> user = service.getUser();
			List<EntityList> sales = service.getSales();
			List<EntityList> levelList= service.getParameterInfo(level);
			List<EntityList> ageGroupList = service.getParameterInfo(ageGroup);

			
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray languageResult = JSONArray.fromObject(languageList);
			JSONArray withResult = JSONArray.fromObject(withwhoList);
			JSONArray hotelResult = JSONArray.fromObject(hotelList);
			JSONArray mealsResult = JSONArray.fromObject(mealsList);
			JSONArray guideResult = JSONArray.fromObject(guideList);
			JSONArray statusResult = JSONArray.fromObject(statusList);
			JSONArray sourceResult = JSONArray.fromObject(sourceList);
			JSONArray tailormadeResult = JSONArray.fromObject(tailList);
			JSONArray passportResult = JSONArray.fromObject(passList);
			JSONArray visaResult = JSONArray.fromObject(visaList);
			JSONArray flightResult = JSONArray.fromObject(flightList);
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
			List<EntityList> orderStatusList = service.getParameterInfo(orderStatus);
			JSONArray orderStatusResult = JSONArray.fromObject(orderStatusList);
			model.addAttribute("orderStatus",orderStatusResult);
		}
		return "/case/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {

		Json json = new Json();		
		try {
/*			System.out.println(crmcase.getRequirement());
			String replace = crmcase.getRequirement().replaceAll("\n", "<br/>");
			System.out.println(replace);
			crmcase.setRequirement(replace);
			System.out.println("存数据："+crmcase.getRequirement());*/
			
			service.updateCase(crmcase);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CaseController.doEdit() --> " + crmcase.toString() + "\n" + e.getMessage());
		}
		
		return json;
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

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int caseId = Integer.parseInt(id);
				service.deleteCaseById(caseId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CaseController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return json;
	}

}