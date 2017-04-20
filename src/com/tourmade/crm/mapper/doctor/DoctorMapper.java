package com.tourmade.crm.mapper.doctor;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Doctor;
import com.tourmade.crm.entity.EntityList;

public interface DoctorMapper extends BaseMapper {

	public List<Doctor> queryDoctor(Map<String, Object> params);

	public long countDoctor(Doctor doctor);

	public void saveDoctor(Doctor doctor);

	public void updateDoctor(Doctor doctor);

	public void deleteDoctorById(int doctorId);

	public Doctor getDoctorById(int doctorId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public List<EntityList> queryDept();
	
	public String validate(@Param("table")String table, @Param("field")String field, 
			@Param("filter_field")String filter_field, @Param("filter_name")String filter_name,
			@Param("name")String name);

}
