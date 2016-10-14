package com.tourmade.crm.mapper.parameter;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Parameter;

public interface ParameterMapper extends BaseMapper {
	
	public List<Parameter> queryParameter(Map<String, Object> params);
	
	public long countParameter(Parameter Parameter);
	
	public void saveParameter(Parameter Parameter);

	public void updateParameter(Parameter Parameter);

	public void deleteParameterById(int ParameterId);
	
	public Parameter getParameterById(int ParameterId);
}