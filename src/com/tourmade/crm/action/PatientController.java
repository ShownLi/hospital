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
import com.tourmade.crm.entity.Patient;
import com.tourmade.crm.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController extends BaseSimpleFormController {

	@Autowired
	private PatientService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/patient/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Patient patient, PageHelper page) {
		QueryResult<Patient> pageResult = service.queryPatient(patient, page, request);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		return "/patient/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Patient patient) {
		Json json = new Json();		
		try {
			service.savePatient(patient);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("PatientController.doAdd() --> " + patient.toString() + "\n" + e.getMessage());
		}
		return json;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		if (null != id && !"".equals(id)) {
			int patientId = Integer.parseInt(id);
			Patient patient = service.getPatientById(patientId);
			model.addAttribute("patient",patient);
		}	
		return "/patient/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Patient patient) {
		Json json = new Json();
		try {
			service.updatePatient(patient);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("PatientController.doEdit() --> " + patient.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {
		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int patientId = Integer.parseInt(id);
				service.deletePatientById(patientId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("PatientController.doDel() --> " + id + "\n" + e.getMessage());
		}
		return json;
	}
	
}
