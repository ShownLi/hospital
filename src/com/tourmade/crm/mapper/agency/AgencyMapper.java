package com.tourmade.crm.mapper.agency;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Agency;
import com.tourmade.crm.entity.EntityList;

public interface AgencyMapper extends BaseMapper {
	
	public List<Agency> queryAgency(Map<String, Object> params);
	
	public long countAgency(Agency agency);
	
	public int saveAgency(Agency agency);

	public void updateAgency(Agency agency);

	public void deleteAgencyById(int agencyId);
	
	public Agency getAgencyById(int agencyId);
	
	public List<EntityList> getParameterInfo(String domain);
}