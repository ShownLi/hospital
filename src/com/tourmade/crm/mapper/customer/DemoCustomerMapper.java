package com.tourmade.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoCustomer;
import com.tourmade.crm.model.DemoList;

public interface DemoCustomerMapper extends BaseMapper {
	
	public List<DemoCustomer> queryCustomer(Map<String, Object> params);
	
	public long countCustomer(DemoCustomer customer);
	
	public void saveCustomer(DemoCustomer customer);

	public void updateCustomer(DemoCustomer customer);

	public void deleteCustomerById(int customerid);
	
	public DemoCustomer getCustomerById(int customerid);
	
	public List<DemoList> getParameterInfo(String domain);
}