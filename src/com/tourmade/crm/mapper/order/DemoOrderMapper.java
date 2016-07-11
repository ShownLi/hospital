package com.tourmade.crm.mapper.order;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.DemoList;

public interface DemoOrderMapper extends BaseMapper {
	
	public List<DemoOrder> queryOrder(Map<String, Object> params);
	
	public long countOrder(DemoOrder order);
	
	public void saveOrder(DemoOrder order);

	public void updateOrder(DemoOrder order);

	public void deleteOrderById(int order_id);
	
	public DemoOrder getOrderById(int order_id);
	
	public DemoOrder getAgencyBySales(int salesid);
	
	public List<DemoList> getParameterInfo(String domain);
}