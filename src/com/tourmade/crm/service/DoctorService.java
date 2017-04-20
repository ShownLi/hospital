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
import com.tourmade.crm.entity.Doctor;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.doctor.DoctorMapper;

@Service
@Transactional(readOnly = false)
public class DoctorService extends BaseService {

	@Autowired
	private DoctorMapper doctorMapper;

	/**
	 * 查询用户数据，分页展示
	 * @param dept
	 * @param ph
	 * @param request
	 */
	public QueryResult<Doctor> queryDoctor(Doctor doctor, PageHelper ph, HttpServletRequest request) {

		QueryResult<Doctor> result = new QueryResult<Doctor>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		if(doctor.getDoctorId()!=0){
			map.put("doctorId",doctor.getDoctorId());
		}
		if(doctor.getName()!=null){
			map.put("name",doctor.getName());
		}
		if(doctor.getDept()!=null){
			map.put("dept",doctor.getDept());
		}
		if(doctor.getLevel()!=null){
			map.put("level",doctor.getLevel());
		}
		
		List<Doctor> data = doctorMapper.queryDoctor(map);
		long count = doctorMapper.countDoctor(doctor);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);

		return result;
	}
	
	/**
	 * 新增医生
	 * @param doctor
	 * @return
	 */
	public int saveDoctor(Doctor doctor) {

		try {
			doctorMapper.saveDoctor(doctor);
		} catch (Exception e) {
			logger.error("doctorService.saveDoctor() --> " + doctor + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return doctor.getDoctorId();
	}

	/**
	 * 根据主键获取医生信息
	 * @param id
	 * @return
	 */
	public Doctor getDoctorById(int doctorId) {
		Doctor doctor = null;
		try {
			doctor = doctorMapper.getDoctorById(doctorId);
		} catch (Exception e) {
			logger.error("doctorService.getDoctorById() --> " + doctorId + "-->" + e.getMessage());
			doctor = null;
		}
		return doctor;
	}

	/**
	 * 更新医生信息
	 * @param doctor
	 * @return
	 */
	public void updateDoctor(Doctor doctor) {
		try {
			doctorMapper.updateDoctor(doctor);
		} catch (Exception e) {
			logger.error("doctorService.updateDoctor() --> " + doctor + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除医生（假删除）
	 * @param deptid
	 * @return
	 */
	public void deleteDoctorById(int doctorId) {
		try {
			doctorMapper.deleteDoctorById(doctorId);
		} catch (Exception e) {
			logger.error("doctorService.deleteDoctorById() --> " + doctorId + "-->" + e.getMessage());
		}
	}

	/**
	 * 根据作用域获得参数
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> doctorinfo = null;
		try {
			doctorinfo = doctorMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("doctorService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			doctorinfo = null;
		}
		return doctorinfo;
	}
	
	/**
	 * 获取科室名称
	 * @param 
	 * @return
	 */
	public List<EntityList> queryDept() {
		List<EntityList> deptinfo = null;
		try {
			deptinfo = doctorMapper.queryDept();
		} catch (Exception e) {
			logger.error("doctorService.getParameterInfo() --> " +  "-->" + e.getMessage());
			deptinfo = null;
		}
		return deptinfo;
	}
}
