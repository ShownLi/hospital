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
import com.tourmade.crm.entity.Agency;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.service.AgencyService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/agency")
public class AgencyController extends BaseSimpleFormController {

	@Autowired
	private AgencyService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model, String flag, HttpSession session) {
		String country = "country";
		String language = "agency.language";
		String destination = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		List<EntityList> destinationList = service.getParameterInfo(destination);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		JSONArray destinationResult = JSONArray.fromObject(destinationList);
		model.addAttribute("country", countryResult);
		model.addAttribute("language", languageResult);
		model.addAttribute("destination", destinationResult);
		//没有传递flag参数时，表示时从侧边栏访问的
		if ("".equals(flag) || flag == null) {
			model.addAttribute("flag", "restart");
			session.removeAttribute("searchAgency");
		} else
			model.addAttribute("flag", flag);
		return "/agency/list";
	}

	@RequestMapping(value = "/list.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(String flag, HttpServletRequest request, HttpSession session, Model model,
			 Agency agency, PageHelper page) {
		if ("old".equals(flag)) {
			Agency search = (Agency) session.getAttribute("searchAgency");
			if(search==null)
				search=new Agency();
			agency = search;
		}else{
			session.setAttribute("searchAgency", agency);
		}
		QueryResult<Agency> agencyPage = service.queryAgency(agency, page, request);
		String result = JSONUtilS.object2json(agencyPage);
		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {

		String country = "country";
		String language = "agency.language";
		String agencyService = "agency.service";
		String source = "agency.source";
		String currency = "order.currency";
		String payment = "agency.payment";
		String status = "agency.status";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		List<EntityList> agencyServiceList = service.getParameterInfo(agencyService);
		List<EntityList> sourceList = service.getParameterInfo(source);
		List<EntityList> currencyList = service.getParameterInfo(currency);
		List<EntityList> paymentList = service.getParameterInfo(payment);
		List<EntityList> statusList = service.getParameterInfo(status);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		JSONArray agencyServiceResult = JSONArray.fromObject(agencyServiceList);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		JSONArray currencyResult = JSONArray.fromObject(currencyList);
		JSONArray paymentResult = JSONArray.fromObject(paymentList);
		JSONArray statusResult = JSONArray.fromObject(statusList);
		model.addAttribute("country", countryResult);
		model.addAttribute("language", languageResult);
		model.addAttribute("agencyService", agencyServiceResult);
		model.addAttribute("source", sourceResult);
		model.addAttribute("currency", currencyResult);
		model.addAttribute("payment", paymentResult);
		model.addAttribute("status", statusResult);

		return "/agency/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Agency agency) {

		Json json = new Json();
		try {
			service.saveAgency(agency);
			json.setObj(agency);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("AgencyController.doAdd() --> " + agency.toString() + "\n" + e.getMessage());
		}

		return json;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int agencyId = Integer.parseInt(id);
			Agency agency = service.getAgencyById(agencyId);
			String country = "country";
			String language = "agency.language";
			String agencyService = "agency.service";
			String source = "agency.source";
			String currency = "order.currency";
			String payment = "agency.payment";
			String status = "agency.status";
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> languageList = service.getParameterInfo(language);
			List<EntityList> agencyServiceList = service.getParameterInfo(agencyService);
			List<EntityList> sourceList = service.getParameterInfo(source);
			List<EntityList> currencyList = service.getParameterInfo(currency);
			List<EntityList> paymentList = service.getParameterInfo(payment);
			List<EntityList> statusList = service.getParameterInfo(status);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray languageResult = JSONArray.fromObject(languageList);
			JSONArray agencyServiceResult = JSONArray.fromObject(agencyServiceList);
			JSONArray sourceResult = JSONArray.fromObject(sourceList);
			JSONArray currencyResult = JSONArray.fromObject(currencyList);
			JSONArray paymentResult = JSONArray.fromObject(paymentList);
			JSONArray statusResult = JSONArray.fromObject(statusList);
			JSONArray sendmailResult = JSONArray.fromObject(agency.getIsSendmail());
			model.addAttribute("country", countryResult);
			model.addAttribute("language", languageResult);
			model.addAttribute("agencyService", agencyServiceResult);
			model.addAttribute("source", sourceResult);
			model.addAttribute("currency", currencyResult);
			model.addAttribute("payment", paymentResult);
			model.addAttribute("status", statusResult);
			model.addAttribute("agency", agency);
			model.addAttribute("sendmail", sendmailResult);
		}
		return "/agency/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Agency agency) {

		Json json = new Json();
		try {
			service.updateAgency(agency);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("AgencyController.doEdit() --> " + agency.toString() + "\n" + e.getMessage());
		}

		return json;
	}

	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int agencyId = Integer.parseInt(id);
				service.deleteAgencyById(agencyId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("AgencyController.doDel() --> " + id + "\n" + e.getMessage());
		}
		return json;
	}

	// 校验地接社是否有订单
	@RequestMapping(value = "/checkDel.do")
	@ResponseBody
	public Json doCheckDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int agencyId = Integer.parseInt(id);
				String agencyId2 = service.checkAgencyHaveOrder(agencyId);
				if (null != agencyId2) {
					json.setSuccess(true);
				} else {
					json.setSuccess(false);
				}
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("AgencyController.doDel() --> " + id + "\n" + e.getMessage());
		}
		return json;
	}
}