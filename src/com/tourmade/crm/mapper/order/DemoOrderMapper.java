package com.tourmade.crm.mapper.order;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.DemoList;

public interface DemoOrderMapper extends BaseMapper {
	
	public List<DemoOrder> queryOrder(Map<String, Object> params);
	
	public long countOrder(DemoOrder order);
	
	public int saveOrder(DemoOrder order);

	public void updateOrder(DemoOrder order);

	public void deleteOrderById(int order_id);
	
	public int getAgencyId(int salesid);
	
	public String getCustomerName(int customerid);
	
	public String getAgencyName(int agencyid);
	
	public String getSalesName(int salesid);
	
	public DemoOrder getOrderById(int order_id);
	
	public List<DemoList> getParameterInfo(String domain);
}