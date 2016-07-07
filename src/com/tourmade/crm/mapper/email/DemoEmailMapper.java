package com.tourmade.crm.mapper.email;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.model.DemoOrder;

public interface DemoEmailMapper extends BaseMapper {
	
	public List<DemoEmail> queryEmail(Map<String, Object> params);
	
	public long countEmail(DemoEmail email);
	
	public void saveEmail(DemoEmail email);
	
	public void updateAlias(int orderid,String cea,String aea);

	public void updateEmail(DemoEmail email);

	public void deleteEmailById(int email_id);
	
	public DemoCase getCaseById(int caseid);
	
	public DemoOrder getOrderById(int orderid);
	
	public DemoEmail getEmailById(int email_id);
	
	public String getCustomerEmail(int customerid);
	
	public String getSalesEmail(int salesid);
	
	public List<DemoList> getParameterInfo(String domain);
}