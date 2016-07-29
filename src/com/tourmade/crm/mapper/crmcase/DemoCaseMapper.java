package com.tourmade.crm.mapper.crmcase;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoList;

public interface DemoCaseMapper extends BaseMapper {
	
	public List<DemoCase> queryCase(Map<String, Object> params);
	
	public List<DemoCase> queryCaseFC(Map<String, Object> params);
	
	public long countCase(DemoCase crmcase);
	
	public int saveCase(DemoCase crmcase);

	public void updateCase(DemoCase crmcase);

	public int caseStatus(int id);
	
	public void deleteCaseById(int caseid);
	
	public DemoCase getCaseById(int caseid);
	
	public List<DemoList> getParameterInfo(String domain);
	
	public List<DemoList> getCustomer();
	
	public List<DemoList> getUser();
	
	public List<DemoList> getAllUser();
	
	public List<DemoList> getSales();
	
	public List<DemoList> getSalesByAgency(String destination);
}