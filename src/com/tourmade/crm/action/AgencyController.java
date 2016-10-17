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
	public String list(Model model) {
		String country = "country";
		String language = "agency.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		return "/agency/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Agency agency, PageHelper page) {
		
		QueryResult<Agency> agencyPage = service.queryAgency(agency, page, request);
		String result = JSONUtilS.object2json(agencyPage);
		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "agency.language";
		List<EntityList> countryList = service.getParameterInfo(country);
		List<EntityList> languageList = service.getParameterInfo(language);
		JSONArray countryResult = JSONArray.fromObject(countryList);
		JSONArray  languageResult = JSONArray.fromObject(languageList);
		model.addAttribute("country",countryResult);
		model.addAttribute("language",languageResult);
		
		return "/agency/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Agency agency) {
		
		Json j = new Json();
		
		try {
			service.saveAgency(agency);
			j.setObj(agency);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("AgencyController.doAdd() --> " + agency.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		System.out.println(id+"^^^");
		if (null != id && !"".equals(id)) {
			int agencyId = Integer.parseInt(id);
			Agency agency = service.getAgencyById(agencyId);
			String country = "country";
			String language = "agency.language";
			List<EntityList> countryList = service.getParameterInfo(country);
			List<EntityList> languageList= service.getParameterInfo(language);
			JSONArray countryResult = JSONArray.fromObject(countryList);
			JSONArray languageResult = JSONArray.fromObject(languageList);
			model.addAttribute("country",countryResult);
			model.addAttribute("language",languageResult);
			model.addAttribute("agency",agency);
		}
		return "/agency/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Agency agency) {

		Json j = new Json();		
		try {
			service.updateAgency(agency);
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("AgencyController.doEdit() --> " + agency.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json j = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int agencyId = Integer.parseInt(id);
				service.deleteAgencyById(agencyId);
				j.setSuccess(true);
			} else {
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("AgencyController.doDel() --> " + id + "\n" + e.getMessage());
		}		
		return j;
	}

}