package com.tourmade.crm.mapper.crmcase;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;

public interface CaseMapper extends BaseMapper {
	
	public List<Case> queryCase(Map<String, Object> params);
	
	public List<Case> queryCaseFC(Map<String, Object> params);
	
	public long countCase(Case crmcase);
	
	public long countCaseFC(int customerId);
	
	public int saveCase(Case crmcase);

	public void updateCase(Case crmcase);

	public int caseStatus(int id);
	
	public void deleteCaseById(int caseid);
	
	public Case getCaseById(int caseid);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public List<EntityList> getCustomer();
	
	public List<EntityList> getCustomerById(int customerId);
	
	public Customer getCustomerInfoById(int customerId);
	
	public List<EntityList> getUser();
	
	public List<EntityList> getAllUser();
	
	public List<EntityList> getSales();
	
	public List<EntityList> getSalesByAgency(String destination);

	public Case getCaseByOrderId(int orderId);

}