package com.tourmade.crm.mapper.customer;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;

public interface CustomerMapper extends BaseMapper {
	
	public List<Customer> queryCustomer(Map<String, Object> params);
	
	public long countCustomer(Customer customer);
	
	public int saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomerById(int customerId);
	
	public Customer getCustomerById(int customerId);
	
	public List<EntityList> getParameterInfo(String domain);

	public Customer getCustomerByEmail(Customer customer);

	public void updateOrderEmail(Customer customer);

	
}