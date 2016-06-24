package com.tourmade.crm.mapper.email;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoList;

public interface DemoEmailMapper extends BaseMapper {
	
	public List<DemoEmail> queryEmail(Map<String, Object> params);
	
	public long countEmail(DemoEmail email);
	
	public void saveEmail(DemoEmail email);

	public void updateEmail(DemoEmail email);

	public void deleteEmailById(int email_id);
	
	public DemoEmail getEmailById(int email_id);
	
	public List<DemoList> getParameterInfo(String domain);
}