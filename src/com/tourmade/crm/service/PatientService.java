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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Patient;
import com.tourmade.crm.mapper.patient.PatientMapper;

@Service
@Transactional(readOnly = false)
public class PatientService extends BaseService {

	@Autowired
	private PatientMapper patientMapper;

	/**
	 * 查询患者数据，分页展示
	 * 
	 * @param dept
	 * @param ph
	 * @param request
	 */
	public QueryResult<Patient> queryPatient(Patient patient, PageHelper ph, HttpServletRequest request) {

		QueryResult<Patient> result = new QueryResult<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		if(patient.getPatientId()!=0){
			map.put("patientId",patient.getPatientId());
		}
		if(patient.getName()!=null){
			map.put("name",patient.getName());
		}
		if(patient.getPhone()!=null){
			map.put("phone",patient.getPhone());
		}

		List<Patient> data = patientMapper.queryPatient(map);
		long count = patientMapper.countPatient(patient);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}
	
	/**
	 * 新增患者
	 * 
	 * @param patient
	 * @return
	 */
	public int savePatient(Patient patient) {

		try {
			patientMapper.savePatient(patient);
		} catch (Exception e) {
			logger.error("patientService.savePatient() --> " + patient + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return patient.getPatientId();
	}

	/**
	 * 根据主键获取患者信息
	 * 
	 * @param id
	 * @return
	 */
	public Patient getPatientById(int patientId) {
		Patient patient = null;
		try {
			patient = patientMapper.getPatientById(patientId);
		} catch (Exception e) {
			logger.error("patientService.getPatientById() --> " + patientId + "-->" + e.getMessage());
			patient = null;
		}
		return patient;
	}

	/**
	 * 更新患者息
	 * 
	 * @param Patient
	 * @return
	 */
	public void updatePatient(Patient patient) {
		try {
			patientMapper.updatePatient(patient);
		} catch (Exception e) {
			logger.error("patientService.updateDoctor() --> " + patient + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除患者（假删除）
	 * 
	 * @param patientid
	 * @return
	 */
	public void deletePatientById(int patientId) {
		try {
			patientMapper.deletePatientById(patientId);
		} catch (Exception e) {
			logger.error("patientService.deletePatientById() --> " + patientId + "-->" + e.getMessage());
		}
	}

	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> patientinfo = null;
		try {
			patientinfo = patientMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("doctorService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			patientinfo = null;
		}
		return patientinfo;
	}
}
