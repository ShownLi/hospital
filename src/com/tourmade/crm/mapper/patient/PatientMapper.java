package com.tourmade.crm.mapper.patient;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Patient;
import com.tourmade.crm.entity.User;

public interface PatientMapper extends BaseMapper {

	public List<Patient> queryPatient(Map<String, Object> params);

	public long countPatient(Patient patient);

	public void savePatient(Patient patient);

	public void updatePatient(Patient patient);

	public void deletePatientById(int patientId);

	public Patient getPatientById(int patientId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public String validate(@Param("table")String table, @Param("field")String field, 
			@Param("filter_field")String filter_field, @Param("filter_name")String filter_name,
			@Param("name")String name);

}
