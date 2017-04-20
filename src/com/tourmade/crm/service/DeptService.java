package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Dept;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.dept.DeptMapper;

@Service
@Transactional(readOnly = false)
public class DeptService extends BaseService {

	@Autowired
	private DeptMapper deptMapper;

	/**
	 * 查询用户数据，分页展示
	 * 
	 * @param dept
	 * @param ph
	 * @param request
	 */
	public QueryResult<Dept> queryDept(Dept dept, PageHelper ph, HttpServletRequest request) {

		QueryResult<Dept> result = new QueryResult<Dept>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		if(dept.getName()!=null){
			map.put("name",dept.getName());
		}
		if(dept.getArea()!=null){
			map.put("area",dept.getArea());
		}
		if(dept.getClassify()!=null){
			map.put("classify",dept.getClassify());
		}
		
		List<Dept> data = deptMapper.queryDept(map);
		long count = deptMapper.countDept(dept);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);

		return result;
	}
	
	/**
	 * 新增科室
	 * 
	 * @param dept
	 * @return
	 */
	public int saveDept(Dept dept) {

		try {
			deptMapper.saveDept(dept);
		} catch (Exception e) {
			logger.error("deptService.saveDept() --> " + dept + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return dept.getDeptId();
	}

	/**
	 * 根据主键获取科室信息
	 * 
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int deptId) {
		Dept dept = null;
		try {
			dept = deptMapper.getDeptById(deptId);
		} catch (Exception e) {
			logger.error("deptService.getDeptById() --> " + deptId + "-->" + e.getMessage());
			dept = null;
		}
		return dept;
	}

	/**
	 * 更新科室信息
	 * 
	 * @param dept
	 * @return
	 */
	public void updateDept(Dept dept) {
		try {
			deptMapper.updateDept(dept);
		} catch (Exception e) {
			logger.error("deptService.updateDept() --> " + dept + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除用户（假删除）
	 * 
	 * @param deptid
	 * @return
	 */
	public void deleteDeptById(int deptId) {
		try {
			deptMapper.deleteDeptById(deptId);
		} catch (Exception e) {
			logger.error("deptService.deleteDeptById() --> " + deptId + "-->" + e.getMessage());
		}
	}

	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> deptinfo = null;
		try {
			deptinfo = deptMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			deptinfo = null;
		}
		return deptinfo;
	}
}
