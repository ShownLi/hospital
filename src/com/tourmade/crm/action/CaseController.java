package com.tourmade.crm.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tourmade.crm.service.OrderService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/case")
public class CaseController extends BaseSimpleFormController {
	
	@Autowired
	private CaseService service;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String source = "case.source";
		String status = "case.status";
		String country = "country";
		String reason = "case.reason";
		
		List<EntityList> userList = service.getAllUser();
		List<EntityList> customerList = service.getCustomer();
		List<EntityList> salesList = service.getSales();
		List<EntityList> sourceList = service.getParameterInfo(source);
		List<EntityList> statusList = service.getParameterInfo(status);
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> reasonList = service.getParameterInfo(reason);
		
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		JSONArray customerResult = JSONArray.fromObject(customerList);
		JSONArray userResult = JSONArray.fromObject(userList);
		JSONArray salesResult = JSONArray.fromObject(salesList);
		JSONArray reasonResult = JSONArray.fromObject(reasonList);
		
		model.addAttribute("destination",countryResult);
		model.addAttribute("source",sourceResult);
		model.addAttribute("caseStatus",statusResult);
		model.addAttribute("customer",customerResult);
		model.addAttribute("user",userResult);
		model.addAttribute("sales",salesResult);
		model.addAttribute("reason", reasonResult);
		
		//添加未成行
		String reasonNodeal ="case.reasonnodeal";
		List<EntityList> reasonNodealList = service.getParameterInfo(reasonNodeal);
		JSONArray reasonNodealResult = JSONArray.fromObject(reasonNodealList);
		model.addAttribute("reasonNodeal", reasonNodealResult);
		
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
	
		//根据分页条件，获取caseList
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
		String level = "customer.level";
		String ageGroup = "customer.agegroup";
		
		String contact ="case.contact";
		
		List<EntityList> levelList = service.getParameterInfo(level);
		List<EntityList> ageGroupList = service.getParameterInfo(ageGroup);
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
		//获取联系方式
		List<EntityList> contactList=service.getParameterInfo(contact);
		
		List<EntityList> customer = service.getCustomer();
		List<EntityList> user = service.getUser();
		List<EntityList> sales = service.getSales();
		
		JSONArray levelResult = JSONArray.fromObject(levelList);
		JSONArray  ageGroupResult = JSONArray.fromObject(ageGroupList);
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
		//转换成Json字符串
		JSONArray contactResult=JSONArray.fromObject(contactList);
		
		model.addAttribute("level",levelResult);
		model.addAttribute("ageGroup",ageGroupResult);
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
		model.addAttribute("contact", contactResult);
		return "/case/add";
	}
	
	/*
	 * 在客人编辑页面给客人添加询单
	 */
	@RequestMapping(value = "/addCase.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String addfromcustomer(Model model, int customerId) {
		
		Customer cus=service.getCustomerInfoById(customerId);
		
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
		String contact ="case.contact";
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
		//获取联系方式
		List<EntityList> contactList=service.getParameterInfo(contact);
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
		//转换成Json字符串
		JSONArray contactResult=JSONArray.fromObject(contactList);
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
		model.addAttribute("customerInfo", cus);
		model.addAttribute("contact", contactResult);
		return "/case/addCase";
	}
	
	//map形式，在table里追加,直接生成询单再操作
	/*@RequestMapping(value = "/add.do")
	@ResponseBody

	public Map doAdd(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {
				
		Map<String,Object> customerMap =new HashMap<String,Object>();
		Map<String,String> map =new HashMap();

		try {
			//判断是否有老客人,(添加询单)
			List judgeCustomer = service.judgeCustomer(crmcase);
			if(judgeCustomer.size()>0){
				customerMap.put("cust", judgeCustomer);
				service.saveCase(crmcase);
				customerMap.put("cid",crmcase.getCaseId());
				return customerMap;
			//没有老客人，添加客人和询单
			}else{
				service.saveCustomer(crmcase);
				crmcase.setCustomerId(crmcase.getCustomerId());
				service.saveCase(crmcase);				
				map.put("ok","ok");
				return map;
			}
			
		} catch (Exception e) {
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
			map.put("error", "error");
			return map;
		}		
	}*/
	
	//map形式，在table里追加,先判断联系方式是否已存在，然后选择是否绑定再保存询单
	@RequestMapping(value = "/add.do")
	@ResponseBody
	
	public Map doAdd(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {
		
		Map<String,Object> customerMap =new HashMap<String,Object>();
		Map<String,String> map =new HashMap<>();
		
		try {
			//判断是否有老客人,通过联系方式和portalId判断(添加询单)
			List<Customer> judgeCustomer = service.judgeCustomer(crmcase);
			if(judgeCustomer.size()>0){
				crmcase.setStatus("1");
				customerMap.put("cust", judgeCustomer);
				service.saveCase(crmcase);
				customerMap.put("cid",crmcase.getCaseId());
				customerMap.put("success", true);
				return customerMap;
				//没有老客人，添加客人和询单
			}else{
				service.saveCustomer(crmcase);
				crmcase.setCustomerId(crmcase.getCustomerId());
				crmcase.setStatus("1");
				service.saveCase(crmcase);				
				map.put("ok","ok");
				return map;
			}
			
		} catch (Exception e) {
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
			map.put("error", "error");
			return map;
		}		
	}
	
	//datatables形式
	/*@RequestMapping(value = "/add.do",produces="application/json;charset=utf-8")
	@ResponseBody

	public String doAdd(HttpServletRequest request, HttpSession session, Model model,PageHelper page, Case crmcase) {
		System.out.println(crmcase);
		QueryResult<Customer> casePage = service.queryCusByComm(crmcase, page, request);
		String result = null;
		System.out.println(casePage.getData());
		try {
			//判断是否有老客人,( 添加询单)
			if(casePage.getData().size()>0){
				result = JSONUtilS.object2json(casePage);
				return result;
			}
			else{
				return result;
			}
	
			
			
		} catch (Exception e) {
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
			return result;
		}		
	}*/
	
	@RequestMapping(value = "/bindCustomer.do")
//	@ResponseBody
	public String bindCustomer(HttpServletRequest request, HttpSession session, Case crmcase, String[] customerId, String isJudge) {
			int id = 0;
			id= Integer.parseInt(customerId[0]);
			Case realCase = service.getCaseById(crmcase.getCaseId());
			
		try {
			//新建客人
			if(isJudge.equals("0")){	
				service.saveCustomer(realCase);
				crmcase.setCustomerId(realCase.getCustomerId());
				realCase.setStatus("1");
				service.updateCase(realCase);
			}else{
			//绑定客人,添加询单
				realCase.setCustomerId(id);
				realCase.setStatus("1");
				service.updateCustomer(realCase);
				service.updateCase(realCase);
			}
			
			return "redirect:/case/list.html";
		} catch (Exception e) {
			logger.error("CaseController.bindCustomer() --> "  + "\n" + e.getMessage());
			//可以添加一个错误页面，来提示没有存储成功。
			return "error";
		}		
	
	}
	
	@RequestMapping(value = "/bindCustomer2.do")
	@ResponseBody
	public String bindCustomer2(HttpServletRequest request, HttpSession session, Case crmcase, String[] customerId, String judgeCustomer) {
			int id = 0;
			id= Integer.parseInt(customerId[0]);
		try {
			//新建客人
			if(judgeCustomer.equals("0")){
				service.saveCustomer(crmcase);
				crmcase.setCustomerId(crmcase.getCustomerId());
				service.saveCase(crmcase);	
			}else{
			//绑定客人,添加询单
				crmcase.setCustomerId(id);
				service.updateCustomer(crmcase);
				service.saveCase(crmcase);
			}
			
			return "/case/list.jsp";
		} catch (Exception e) {
			logger.error("CaseController.bindCustomer() --> "  + "\n" + e.getMessage());
			return "error";
		}		
	
	}
	
	@RequestMapping(value = "/handle.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String handle(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int caseId = Integer.parseInt(id);
			Case crmcase = service.getCaseById(caseId);
			
			//解决客人的要求换行符问题
			if(crmcase.getRequirement()!=null){
				crmcase.setRequirement(crmcase.getRequirement().replaceAll("\r", ""));
				String[] splits= crmcase.getRequirement().split("\n");
				String realRequire="";
				for(int i=0;i<splits.length;i++){
					if(i==splits.length-1){
						realRequire+=splits[i];
					}
					else{
						realRequire+=splits[i]+"\\r\\n";					
					}
				}					
				crmcase.setRequirement(realRequire);
			}
			
			
			crmcase=service.validateStartTime(crmcase);
			Customer cus = null;
			if(crmcase.getCustomerId()!=null && 
					"".equals(crmcase.getCustomerId()) && 
					crmcase.getCustomerId()!=0){
				cus = service.getCustomerInfoById(crmcase.getCustomerId());
			}
			
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
			String reason = "case.reason";
			
			String contact ="case.contact";
			String reasonNodeal ="case.reasonnodeal";
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
			List<EntityList> reasonList = service.getParameterInfo(reason);
			//获取联系方式
			List<EntityList> contactList=service.getParameterInfo(contact);
			List<EntityList> reasonNodealList=service.getParameterInfo(reasonNodeal);
			
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
			JSONArray ageGroupResult = JSONArray.fromObject(ageGroupList);
			JSONArray reasonResult = JSONArray.fromObject(reasonList);
			
			//转换成Json字符串
			JSONArray contactResult=JSONArray.fromObject(contactList);
			JSONArray reasonNodealResult=JSONArray.fromObject(reasonNodealList);
			
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
			model.addAttribute("reason", reasonResult);
			model.addAttribute("contact", contactResult);
			model.addAttribute("reasonNodeal", reasonNodealResult);
			
			String orderStatus = "order.status";
			List<EntityList> orderStatusList = service.getParameterInfo(orderStatus);
			JSONArray orderStatusResult = JSONArray.fromObject(orderStatusList);
			model.addAttribute("orderStatus",orderStatusResult);
		}
		return "/case/handle";
	}
	
	@RequestMapping(value = "/handle.do")
	@ResponseBody
	public Map doHandle(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {

		Map<String,Object> customerMap =new HashMap<String, Object>();
		Map<String,String> map =new HashMap();
		
		
		
		try {
			//判断是否有portalId
			if( crmcase.getPortalId()!=null && crmcase.getPortalId()!=0) {
				Customer regular = service.getCustomerByPortalId(crmcase.getPortalId());
				crmcase.setCustomerId(regular.getCustomerId());
				crmcase.setStatus("1");
				service.updateCustomer(crmcase);
				service.updateCase(crmcase);
				map.put("ok", "ok");
				return map;
			}
			else{
				//判断是否有老客人
				List judgeCustomer = service.judgeCustomer(crmcase);
				if(judgeCustomer.size()>0){
					
					service.updateCase(crmcase);
					customerMap.put("cust", judgeCustomer);
//					service.saveCase(crmcase);
					customerMap.put("cid",crmcase.getCaseId());
					return customerMap;
				//没有老客人，添加客人,修改询单
				}else{
					service.saveCustomer(crmcase);
					crmcase.setCustomerId(crmcase.getCustomerId());
					crmcase.setStatus("1");
					service.updateCase(crmcase);		
					map.put("ok","ok");
					return map;
				}
			}
				
		} catch (Exception e) {
			logger.error("CaseController.doAdd() --> " + crmcase.toString() + "\n" + e.getMessage());
			map.put("error", "error");
			return map;
		}	
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int caseId = Integer.parseInt(id);
			Case crmcase = service.getCaseById(caseId);
			
			//解决客人的要求换行符问题
			if(crmcase.getRequirement()!=null){		
				crmcase.setRequirement(crmcase.getRequirement().replaceAll("\r", ""));
				String[] splits= crmcase.getRequirement().split("\n");
				String realRequire="";
				for(int i=0;i<splits.length;i++){
					if(i==splits.length-1){
						realRequire+=splits[i];
					}
					else{
						realRequire+=splits[i]+"\\r\\n";					
					}
				}

				crmcase.setRequirement(realRequire);
			}
			
			crmcase=service.validateStartTime(crmcase);
			Customer cus = null;
			if(crmcase.getCustomerId()!=null && 
					"".equals(crmcase.getCustomerId()) && 
					crmcase.getCustomerId()!=0){
				cus = service.getCustomerInfoById(crmcase.getCustomerId());
			}

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
			String reason = "case.reason";
			String destination = "case.destination";
			
			String orderStatus = "order.status";
			
			String contact="case.contact";
			String reasonNodeal ="case.reasonnodeal";
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
			List<EntityList> reasonList = service.getParameterInfo(reason);
			List<EntityList> destinationList = service.getParameterInfo(destination);
			List<EntityList> orderStatusList = service.getParameterInfo(orderStatus);
			//获取联系方式
			List<EntityList> contactList=service.getParameterInfo(contact);
			List<EntityList> reasonNodealList=service.getParameterInfo(reasonNodeal);
			
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
			JSONArray ageGroupResult = JSONArray.fromObject(ageGroupList);
			JSONArray reasonResult = JSONArray.fromObject(reasonList);
			JSONArray destinationResult = JSONArray.fromObject(destinationList);
			JSONArray orderStatusResult = JSONArray.fromObject(orderStatusList);
			//转换成Json字符串
			JSONArray contactResult=JSONArray.fromObject(contactList);
			JSONArray reasonNodealResult=JSONArray.fromObject(reasonNodealList);
			
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
			model.addAttribute("reason", reasonResult);
			model.addAttribute("contact", contactResult);
			model.addAttribute("destinations", destinationResult);
			model.addAttribute("orderStatus",orderStatusResult);
			model.addAttribute("contact", contactResult);
			model.addAttribute("reasonNodeal", reasonNodealResult);
			
		}
		return "/case/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Case crmcase) {

		Json json = new Json();		
		try {			
			service.updateCase(crmcase);
			service.updateCustomer(crmcase);
			
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
		String[] dStr = destination.split(",");
		List<String> destinationList = new ArrayList<String>();
		for(int i=0; i<dStr.length; i++){
			destinationList.add(dStr[i]);
		}
		List<EntityList> sales = service.getSalesByAgency(destinationList);
		return sales;
	}
	
	//设置询单无效
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id,Case crmcase) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int caseId = Integer.parseInt(id);
				service.deleteCaseById(caseId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
			Case upCase = service.getCaseById(crmcase.getCaseId());
		
			upCase.setReason(crmcase.getReason());
			
			service.updateCase(upCase);
			
			service.deleteCaseById(crmcase.getCaseId());
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CaseController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	//设置询单未成行
	@RequestMapping(value = "/nodeal.do")
	@ResponseBody
	public Json doNoDeal(HttpServletRequest request, HttpSession session, Model model, String caseId,String reasonNodeal ) {

		Json json = new Json();
		try {
			if (null != caseId && !"".equals(caseId)) {
				int caseId2 = Integer.parseInt(caseId);
				Map<String,Object> map=new HashMap<>();
				map.put("reasonNodeal", reasonNodeal);
				map.put("caseId", caseId2);
				service.deleteCaseNodealById(map);
				orderService.deleteOrderNodealByCaseId(map);
				//如果询单修改成功，则修改询单下的订单
				/*if(res){
					boolean result = orderService.deleteOrderNodealByCaseId(map);
					System.out.println("result="+result);
					json.setSuccess(result);
				}*/
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("CaseController.doNoDeal() --> " + caseId + "\n" + e.getMessage());
		}
	
		return json;
	}
}