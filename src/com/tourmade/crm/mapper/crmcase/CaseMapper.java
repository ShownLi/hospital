package com.tourmade.crm.mapper.crmcase;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Parameter;
import com.tourmade.crm.entity.CaseStatus;

public interface CaseMapper extends BaseMapper {
	
	public List<Case> queryCase(Map<String, Object> params);
	
	public List<Case> queryCasesByCustomerId(Map<String, Object> params);
	
	public long countCase(Case crmcase);
	
	public long countCaseFC(int customerId);
	
	public int saveCase(Case crmcase);

	public void updateCase(Case crmcase);

	public int caseStatus(int caseId);
	
	public void deleteCaseById(int caseId);
	public int deleteCaseNodealById(Map<String,Object> map);
	
	public Case getCaseById(int caseId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public Parameter getParameterByCountryChinese(String value);
	
	public List<EntityList> getCustomer();
	
	public List<EntityList> getCustomerById(int customerId);
	
	public Customer getCustomerInfoById(int customerId);
	
	public List<EntityList> getUser();
	
	public List<EntityList> getAllUser();
	
	public List<EntityList> getSales();
	
	public List<EntityList> getSalesByAgency(List<String> sList);

	public Case getCaseByOrderId(int orderId);
	
	public List<Customer> getCustomerByCommunication(Case crmcase);
	
	public void updateCustomer(Customer customer);

	public Customer getCustomerByPortalId(int portalId);

	public List<Customer> queryCusByComm(Map<String, Object> map);

	public long countCusByComm(Map<String, Object> map);

	public Customer getCustomerByCusId(Integer customerId);

	public int saveCustomer(Customer cus);

	public List<CaseStatus> countCaseByStatus(Case crmcase);

}