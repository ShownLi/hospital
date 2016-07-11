package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.mapper.email.DemoEmailMapper;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.model.MailTemplate;

@Service
@Transactional(readOnly = false)
public class EmailService extends BaseService {
	
	@Autowired
	private DemoEmailMapper emailMapper;

	/**
	 * 查询地接社数据，分页展示
	 * 
	 * @param email
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoEmail> queryEmail(DemoEmail email, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoEmail> r = new QueryResult<DemoEmail>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoEmail> data = emailMapper.queryEmail(map);
		long count = emailMapper.countEmail(email);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}
	/**
	 * 根据模板生成邮件正文
	 * 
	 * @param template
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public String getMailContent(MailTemplate template) throws Exception {
		BufferedReader reader = null;
		String result = null;
		try {
			File f = new File(template.getTemplatepath());
			if (f.isFile()) {
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(f), "UTF-8");
				reader = new BufferedReader(isr);
				String tempString = null;
				StringBuffer str = new StringBuffer();
				int line = 1;
				while ((tempString = reader.readLine()) != null) {
					str.append(tempString + "\n");
					line++;
				}
				reader.close();
				result = str.toString();
				
				if (null != template) {
					if (null != template.getUsername()) {
						result = result.replace("${username}",
								template.getUsername());
					}
					if (null != template.getClientfirstname()) {
						result = result.replace("${clientfirstname}",
								template.getClientfirstname());
					}
					if (null != template.getClientlastname()) {
						result = result.replace("${clientlastname}",
								template.getClientlastname());
					}
					if (null != template.getClienttitle()) {
						result = result.replace("${clienttitle}",
								template.getClienttitle());
					}
					if (null != template.getNow()) {
						result = result.replace("${now}", template.getNow());
					}
					if (null != template.getArrivetime()) {
						result = result.replace("${arrivetime}",
								template.getArrivetime());
					}
					if (null != template.getGroupcode()) {
						result = result.replace("${groupcode}",
								template.getGroupcode());
					}
					if (null != template.getPlanvalue()) {
						result = result.replace("${planvalue}",
								template.getPlanvalue());
					}
					if (null != template.getClientemail()) {
						result = result.replace("${clientemail}",
								template.getClientemail());
					}
					if (null != template.getGroupid()) {
						result = result.replace("${groupid}",
								template.getGroupid());
					}
					
					if (null != template.getOrderlist()
							&& template.getOrderlist().size() > 0) {
						StringBuffer sb = new StringBuffer();
						sb.append("<ul>");
						Iterator<Object[]> it = template.getOrderlist()
								.iterator();
						while (it.hasNext()) {
							Object[] o = it.next();
							sb.append("<li>");
							sb.append(o[1]);
							sb.append(" | ");
							sb.append(o[3]);
							sb.append(" ");
							sb.append(o[4]);
							sb.append(" ");
							sb.append(o[5]);
							sb.append(" | ");
							sb.append(o[6]);
							sb.append("</li>");
						}
						sb.append("</ul>");
						result = result.replace("${orderlist}", sb.toString());
					}

				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return result;
	}
	/**
	 * 新增地接社
	 * 
	 * @param email
	 * @return
	 */
	public int saveEmail(DemoEmail email) {

		
		try {
			emailMapper.saveEmail(email);
		} catch (Exception e) {
			logger.error("EmailService.saveEmail() --> " + email + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return email.getEmail_id();
	}

	
	/**
	 * 根据主键获取地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoEmail getEmailById(int id) {
		DemoEmail r = null;
		try {
			r = emailMapper.getEmailById(id);
		} catch (Exception e) {
			logger.error("EmailService.getEmailById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<DemoList> getParameterInfo(String domain) {
		List<DemoList> r = null;
		try {
			r = emailMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("EmailService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param email
	 * @return
	 */
	public boolean updateEmail(DemoEmail email) {

		boolean r = false;

		try {
			DemoEmail u = emailMapper.getEmailById(email.getEmail_id());
			if (u != null) {
				u.setName(email.getName());
				u.setCountry(email.getCountry());
				u.setLanguage(email.getLanguage());
				emailMapper.updateEmail(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("EmailService.updateEmail() --> " + email + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param email_id
	 * @return
	 */
	public boolean deleteEmailById(int email_id) {

		boolean r = false;

		try {
			emailMapper.deleteEmailById(email_id);
			r = true;
		} catch (Exception e) {
			logger.error("EmailService.deleteEmailById() --> " + email_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}