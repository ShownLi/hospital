package com.tourmade.crm.service;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
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
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.model.DemoOrder;

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
	 * 创建订单别名
	 * 
	 * @param email
	 * @return
	 */
	public void creatAlias(int orderid) {

		String domain = "tourmade.com.cn";
		String customer_alias_pre = "customer_"+orderid+"@";
		String agency_alias_pre = "agency_"+orderid+"@";
		String customer_url = "http://123.56.77.206/axis2/services/AliasAdd?"+"alias="+customer_alias_pre+"&real=customer@"+"&domain="+domain;
		String agency_url = "http://123.56.77.206/axis2/services/AliasAdd?"+"alias="+agency_alias_pre+"&real=agency@"+"&domain"+domain;
		try {
			
			URL customer = new URL(customer_url);
			URL agency = new URL(agency_url);
			URLConnection connection = customer.openConnection();  
			connection.connect(); 
			URLConnection connection1 = agency.openConnection();  
			connection1.connect();
			System.out.println("订单ID："+orderid+"\n客人别名："+customer_alias_pre+domain+"\n地接社别名："+agency_alias_pre+domain);
			int count = emailMapper.updateAlias(orderid,customer_alias_pre+domain,agency_alias_pre+domain);
			System.out.println("受影响和行数为："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 给地接社发送第一封下单邮件
	 * 
	 * @param email
	 * @return
	 */
	public void orderEmailToAgency(int caseid, int orderid) {

		
		try {
			DemoCase Case = emailMapper.getCaseById(caseid);
			System.out.println(Case);
			DemoOrder Order = emailMapper.getOrderById(orderid);
			System.out.println(Order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据主键获取邮件信息
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
	
}