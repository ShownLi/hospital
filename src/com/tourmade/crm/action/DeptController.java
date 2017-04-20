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
import com.tourmade.crm.entity.Dept;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.service.DeptService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/dept")
public class DeptController extends BaseSimpleFormController {

	@Autowired
	private DeptService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		String area = "dept.area";
		String classify = "dept.classify";
		List<EntityList> areaList = service.getParameterInfo(area);
		List<EntityList> classifyList = service.getParameterInfo(classify);
		JSONArray areaResult = JSONArray.fromObject(areaList);
		JSONArray classifyResult = JSONArray.fromObject(classifyList);
		model.addAttribute("area", areaResult);
		model.addAttribute("classify", classifyResult);
		return "/dept/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Dept dept, PageHelper page) {
		QueryResult<Dept> pageResult = service.queryDept(dept, page, request);
		String result = JSONUtilS.object2json(pageResult);
		return result;
	}
	

	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model) {
		String area = "dept.area";
		String classify = "dept.classify";
		List<EntityList> areaList = service.getParameterInfo(area);
		List<EntityList> classifyList = service.getParameterInfo(classify);
		JSONArray areaResult = JSONArray.fromObject(areaList);
		JSONArray classifyResult = JSONArray.fromObject(classifyList);
		model.addAttribute("area", areaResult);
		model.addAttribute("classify", classifyResult);
		return "/dept/add";
	}

	@RequestMapping(value = "/add.do")
	@ResponseBody
	public Json doAdd(HttpServletRequest request, HttpSession session, Model model, Dept dept) {

		Json json = new Json();		
		try {
			service.saveDept(dept);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DeptController.doAdd() --> " + dept.toString() + "\n" + e.getMessage());
		}
		return json;
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		String area = "dept.area";
		String classify = "dept.classify";
		List<EntityList> areaList = service.getParameterInfo(area);
		List<EntityList> classifyList = service.getParameterInfo(classify);
		JSONArray areaResult = JSONArray.fromObject(areaList);
		JSONArray classifyResult = JSONArray.fromObject(classifyList);
		model.addAttribute("area", areaResult);
		model.addAttribute("classify", classifyResult);
		
		if (null != id && !"".equals(id)) {
			int deptId = Integer.parseInt(id);
			Dept dept = service.getDeptById(deptId);
			model.addAttribute("dept",dept);
		}	
		return "/dept/edit";
	}

	@RequestMapping(value = "/edit.do")
	@ResponseBody
	public Json doEdit(HttpServletRequest request, HttpSession session, Model model, Dept dept) {

		Json json = new Json();
		
		try {
			System.out.println(dept);
			service.updateDept(dept);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DeptController.doEdit() --> " + dept.toString() + "\n" + e.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int deptId = Integer.parseInt(id);
				service.deleteDeptById(deptId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("DeptController.doDel() --> " + id + "\n" + e.getMessage());
		}
		return json;
	}
	
}
