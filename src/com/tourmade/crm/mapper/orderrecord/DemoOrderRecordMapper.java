package com.tourmade.crm.mapper.orderrecord;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoOrderRecord;
import com.tourmade.crm.model.DemoList;

public interface DemoOrderRecordMapper extends BaseMapper {
	
	public List<DemoOrderRecord> queryOrderRecord(Map<String, Object> params);
	
	public List<DemoOrderRecord> getOrderRecord(Map<String, Object> params);
	
	public long countOrderRecord(DemoOrderRecord orderrecord);
	
	public long countOrderRecordByCaseid(int id);
	
	public long countOrderRecordByOrderid(int id);
	
	public void saveOrderRecord(DemoOrderRecord orderrecord);

	public void updateOrderRecord(DemoOrderRecord orderrecord);

	public void deleteOrderRecordById(int orderrecord_id);
	
	public DemoOrderRecord getOrderRecordById(int orderrecord_id);
	
	public List<DemoList> getParameterInfo(String domain);
}