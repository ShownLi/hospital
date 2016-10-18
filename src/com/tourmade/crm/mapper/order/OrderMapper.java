package com.tourmade.crm.mapper.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;

public interface OrderMapper extends BaseMapper {
	
	public List<Order> queryOrder(Map<String, Object> params);
	
	public List<Order> queryOrderByCaseId(Map<String, Object> params);
	
	public long countOrder(Order order);
	
	public long countOrderByCaseId(int id);
	
	public String validatemail(int customerId);
	
	public String geturl(String domain);
	
	public String validatePortalId(int customerId);
	
	public void customerstatus(@Param("id")int id, @Param("status")String status);
	
	public int saveOrder(Order order);

	public void updateOrder(Order order);

	public void updateCustomer(Customer customer);
	
	public void deleteOrderById(int orderId);
	
	public Order getInfo(Order order);
	
	public Order getOrderById(int orderId);
	
	public Customer getCustomerById(int id);
	
	public Case getCaseById(int id);
	
	public Order getAgencyBySales(int salesid);
	
	public String getCustomerEmailReal(int customerId);
	
	public List<EntityList> getParameterInfo(String domain);

	public Customer getCustomerByCaseId(int caseId);
}