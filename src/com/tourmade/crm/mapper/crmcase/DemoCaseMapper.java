package com.tourmade.crm.mapper.crmcase;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoList;

public interface DemoCaseMapper extends BaseMapper {
	
	public List<DemoCase> queryCase(Map<String, Object> params);
	
	public long countCase(DemoCase crmcase);
	
	public void saveCase(DemoCase crmcase);

	public void updateCase(DemoCase crmcase);

	public void deleteCaseById(int case_id);
	
	public DemoCase getCaseById(int case_id);
	
	public List<DemoList> getParameterInfo(String domain);
}