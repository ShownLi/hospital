package com.tourmade.crm.mapper.registration;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Registration;
import com.tourmade.crm.entity.User;

public interface RegistrationMapper extends BaseMapper {

	public List<Registration> queryRegistration(Map<String, Object> params);

	public long countRegistration(Registration registration);

	public void saveRegistration(Registration registration);

	public void updateRegistration(Registration registration);

	public void deleteRegistrationById(int registrationId);

	public Registration getRegistrationById(int registrationId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public String validate(@Param("table")String table, @Param("field")String field, 
			@Param("filter_field")String filter_field, @Param("filter_name")String filter_name,
			@Param("name")String name);

}
