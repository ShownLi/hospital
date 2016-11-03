package com.tourmade.crm.mapper.emailQueue;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.Email;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.MailTepBoat;
import com.tourmade.crm.entity.Order;

public interface EmailMapper extends BaseMapper {
	
	public List<Email> queryEmail(Map<String, Object> params);
	
	public long countEmail(Email email);
	
	public void saveEmail(Email email);

	public void updateEmail(Email email);

	public void deleteEmailById(int emailId);
	
	public Email getEmailById(int emailId);
	
	public List<EntityList> getParameterInfo(String domain);
	
	public String getRouteUrl();
	
	public MailTepBoat getZhEn(MailTepBoat boat);
	
	public MailTepBoat getCusZE(MailTepBoat boat);
	
	public MailTepBoat getSalesZE(MailTepBoat boat);
	
	public String getUrl(String domain);
	
	public Email getBccEmail(int operator);
}