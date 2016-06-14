package com.tourmade.crm.mapper.parameter;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoParameter;

public interface DemoParameterMapper extends BaseMapper {
	
	public List<DemoParameter> queryParameter(Map<String, Object> params);
	
	public long countParameter(DemoParameter Parameter);
	
	public void saveParameter(DemoParameter Parameter);

	public void updateParameter(DemoParameter Parameter);

	public void deleteParameterById(int Parameterid);
	
	public DemoParameter getParameterById(int Parameterid);
	
	public DemoParameter getParameterInfo(String domain);
}