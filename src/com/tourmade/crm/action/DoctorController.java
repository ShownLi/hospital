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
import com.tourmade.crm.entity.Doctor;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.service.DoctorService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/doctor")
public class DoctorController extends BaseSimpleFormController {

	@Autowired
	private DoctorService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String level = "doctor.level";
		List<EntityList> levelList = service.getParameterInfo(level);
		List<EntityList> deptList = service.queryDept();
		JSONArray levelResult = JSONArray.fromObject(levelList);
		JSONArray deptResult = JSONArray.fromObject(deptList);
		model.addAttribute("level", levelResult);
		model.addAttribute("dept", deptResult);
		return "/doctor/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Doctor doctor, PageHelper page) {
		QueryResult<Doctor> pageResult = service.queryDoctor(doctor, page, request);
		System.out.println(pageResult);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		String level = "doctor.level";
		List<EntityList> levelList = service.getParameterInfo(level);
		List<EntityList> deptList = service.queryDept();
		JSONArray levelResult = JSONArray.fromObject(levelList);
		JSONArray deptResult = JSONArray.fromObject(deptList);
		model.addAttribute("level", levelResult);
		model.addAttribute("dept", deptResult);
		return "/doctor/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Doctor doctor) {

		Json json = new Json();		
		try {
			service.saveDoctor(doctor);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DoctorController.doAdd() --> " + doctor.toString() + "\n" + e.getMessage());
		}
		return json;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		String level = "doctor.level";
		List<EntityList> levelList = service.getParameterInfo(level);
		List<EntityList> deptList = service.queryDept();
		JSONArray levelResult = JSONArray.fromObject(levelList);
		JSONArray deptResult = JSONArray.fromObject(deptList);
		model.addAttribute("level", levelResult);
		model.addAttribute("dept", deptResult);
		
		if (null != id && !"".equals(id)) {
			int doctorId = Integer.parseInt(id);
			Doctor doctor = service.getDoctorById(doctorId);
			System.out.println(doctor);
			model.addAttribute("doctor",doctor);
		}	
		return "/doctor/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Doctor doctor) {

		Json json = new Json();
		
		try {
			service.updateDoctor(doctor);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DoctorController.doEdit() --> " + doctor.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int doctorId = Integer.parseInt(id);
				service.deleteDoctorById(doctorId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DoctorController.doDel() --> " + id + "\n" + e.getMessage());
		}
		return json;
	}
	
}
