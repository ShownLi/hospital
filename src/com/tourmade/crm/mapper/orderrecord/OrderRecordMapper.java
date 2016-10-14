package com.tourmade.crm.mapper.orderrecord;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.OrderRecord;

public interface OrderRecordMapper extends BaseMapper {
	
	public List<OrderRecord> queryOrderRecord(Map<String, Object> params);
	
	public List<OrderRecord> getOrderRecord(Map<String, Object> params);
	
	public long countOrderRecord(OrderRecord orderRecord);
	
	public long countOrderRecordByCaseid(int id);
	
	public long countOrderRecordByOrderid(int id);
	
	public void saveOrderRecord(OrderRecord orderRecord);

	public void updateOrderRecord(OrderRecord orderRecord);

	public void deleteOrderRecordById(int orderRecordId);
	
	public OrderRecord getOrderRecordById(int orderRecordId);
	
	public List<EntityList> getParameterInfo(String domain);
}