package com.tourmade.crm.mapper.agency;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoAgency;
import com.tourmade.crm.model.DemoList;

public interface DemoAgencyMapper extends BaseMapper {
	
	public List<DemoAgency> queryAgency(Map<String, Object> params);
	
	public long countAgency(DemoAgency agency);
	
	public int saveAgency(DemoAgency agency);

	public void updateAgency(DemoAgency agency);

	public void deleteAgencyById(int agency_id);
	
	public DemoAgency getAgencyById(int agency_id);
	
	public List<DemoList> getParameterInfo(String domain);
}