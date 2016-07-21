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
import com.tourmade.crm.model.MailTemplate;

@Service
@Transactional(readOnly = false)
public class EmailService extends BaseService {
	
	@Autowired
	private DemoEmailMapper emailMapper;

	/**
	 * 查询邮件数据，分页展示
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
					if (null != template.getSalesname()) {
						result = result.replace("${salesname}",
								template.getSalesname());
					}
					if (null != template.getClientname_zh()) {
						result = result.replace("${clientname_zh}",
								template.getClientname_zh());
					}
					if (null != template.getClientname_en()) {
						result = result.replace("${clientname_en}",
								template.getClientname_en());
					}
					if (null != template.getStart_date()) {
						result = result.replace("${start_date}",
								template.getStart_date().toString());
					}
					if (null != template.getNow()) {
						result = result.replace("${now}", template.getNow());
					}
					if (null != template.getBudget()) {
						result = result.replace("${budget}",
								template.getBudget());
					}
					if (null != template.getRequirement()) {
						result = result.replace("${requirement}",
								template.getRequirement());
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
	 * 新增邮件
	 * 
	 * @param email
	 * @return
	 */
	public void saveEmail(DemoEmail email) {
		DemoEmail obj = email;
		try {
			emailMapper.saveEmail(obj);
		} catch (Exception e) {
			logger.error("EmailService.saveEmail() --> " + obj + "-->" + e.getMessage());
			e.printStackTrace();
		}
	}

}