package com.tourmade.crm.mapper.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.DemoList;

public interface DemoOrderMapper extends BaseMapper {
	
	public List<DemoOrder> queryOrder(Map<String, Object> params);
	
	public long countOrder(DemoOrder order);
	
	public int saveOrder(DemoOrder order);

	public void updateOrder(DemoOrder order);
	
	public int updateAlias(@Param("orderid")int orderid, @Param("customer")String customer, 
			@Param("agency")String agency);

	public void deleteOrderById(int orderid);
	
	public int getAgencyId(int salesid);
	
	public String getCustomerName(int customerid);
	
	public String getAgencyName(int agencyid);
	
	public String getSalesName(int salesid);
	
	public DemoOrder getOrderById(int orderid);
	
	public List<DemoList> getParameterInfo(String domain);
}