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
import com.tourmade.crm.model.DemoAgency;
import com.tourmade.crm.model.DemoList;
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
		List<DemoList> v = service.getParameterInfo(country);
		List<DemoList> w = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(v);
		JSONArray languageresult = JSONArray.fromObject(w);
		model.addAttribute("countryname",countryresult);
		model.addAttribute("language",languageresult);
		return "/agency/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, DemoAgency agency, PageHelper page) {

		QueryResult<DemoAgency> r = service.queryAgency(agency, page, request);
		String result = JSONUtilS.object2json(r);
		return result;
	}

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		
		String country = "country";
		String language = "agency.language";
		List<DemoList> u = service.getParameterInfo(country);
		List<DemoList> v = service.getParameterInfo(language);
		JSONArray countryresult = JSONArray.fromObject(u);
		JSONArray  languageresult = JSONArray.fromObject(v);
		model.addAttribute("country",countryresult);
		model.addAttribute("language",languageresult);
		
		return "/agency/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, DemoAgency agency) {

		Json j = new Json();
		
		try {
			service.saveAgency(agency);
			//System.out.println(agency);
			j.setObj(agency);
			j.setSuccess(true);
			System.out.println(j);
		} catch (Exception e) {
			j.setSuccess(false);
			logger.error("AgencyController.doAdd() --> " + agency.toString() + "\n" + e.getMessage());
		}
		
		return j;
	}
	
	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			DemoAgency u = service.getAgencyById(i);
			String country = "country";
			String language = "agency.language";
			List<DemoList> v = service.getParameterInfo(country);
			List<DemoList> w = service.getParameterInfo(language);
			JSONArray countryresult = JSONArray.fromObject(v);
			JSONArray languageresult = JSONArray.fromObject(w);
			model.addAttribute("country",countryresult);
			model.addAttribute("language",languageresult);
			model.addAttribute("agency",u);
		}
		return "/agency/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, DemoAgency agency) {

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
		System.out.println("------>>>" + id);
		try {
			if (null != id && !"".equals(id)) {
				int i = Integer.parseInt(id);
				service.deleteAgencyById(i);
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