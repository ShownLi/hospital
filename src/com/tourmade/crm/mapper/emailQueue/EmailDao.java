package com.tourmade.crm.mapper.emailQueue;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EmailQueue;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.MailTepBoat;

public interface EmailDao extends BaseMapper {
	
	public List<EmailQueue> queryEmail(Map<String, Object> params);
	
	public long countEmail(EmailQueue email);
	
	public void saveEmail(EmailQueue email);

	public void updateEmail(EmailQueue email);

	public void deleteEmailById(int emailId);
	
	public EmailQueue getEmailById(int emailId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public String getRouteUrl();
	
	public MailTepBoat getZhEn(MailTepBoat boat);
	
	public MailTepBoat getCusZE(MailTepBoat boat);
	
	public MailTepBoat getSalesZE(MailTepBoat boat);
	
	public String getUrl(String domain);
	
}