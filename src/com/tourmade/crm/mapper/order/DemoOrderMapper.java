package com.tourmade.crm.mapper.order;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoCustomer;
import com.tourmade.crm.model.DemoList;

public interface DemoOrderMapper extends BaseMapper {
	
	public List<DemoOrder> queryOrder(Map<String, Object> params);
	
	public List<DemoOrder> queryOrderByCaseid(Map<String, Object> params);
	
	public long countOrder(DemoOrder order);
	
	public long countOrderByCaseid(int id);
	
	public void saveOrder(DemoOrder order);

	public void updateOrder(DemoOrder order);

	public void deleteOrderById(int orderid);
	
	public DemoOrder getInfo(DemoOrder order);
	
	public DemoOrder getOrderById(int orderid);
	
	public DemoCustomer getCustomerById(int id);
	
	public DemoCase getCaseById(int id);
	
	public DemoOrder getAgencyBySales(int salesid);
	
	public String getCustomerEmailReal(int customerid);
	
	public List<DemoList> getParameterInfo(String domain);
}