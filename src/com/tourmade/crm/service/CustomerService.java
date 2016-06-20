package com.tourmade.crm.service;

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
import com.tourmade.crm.mapper.customer.DemoCustomerMapper;
import com.tourmade.crm.model.DemoCustomer;
import com.tourmade.crm.model.DemoList;

@Service
@Transactional(readOnly = false)
public class CustomerService extends BaseService {
	
	@Autowired
	private DemoCustomerMapper customerMapper;

	/**
	 * 查询地接社数据，分页展示
	 * 
	 * @param customer
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoCustomer> queryCustomer(DemoCustomer customer, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoCustomer> r = new QueryResult<DemoCustomer>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == customer) {
				customer = new DemoCustomer();
			}
			customer.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", customer);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoCustomer> data = customerMapper.queryCustomer(map);
		long count = customerMapper.countCustomer(customer);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}

	/**
	 * 新增地接社
	 * 
	 * @param customer
	 * @return
	 */
	public int saveCustomer(DemoCustomer customer) {

		
		try {
			customerMapper.saveCustomer(customer);
		} catch (Exception e) {
			logger.error("CustomerService.saveCustomer() --> " + customer + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return customer.getCustomer_id();
	}

	/**
	 * 根据主键获取地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoCustomer getCustomerById(int id) {
		DemoCustomer r = null;
		try {
			r = customerMapper.getCustomerById(id);
		} catch (Exception e) {
			logger.error("CustomerService.getCustomerById() --> " + id + "-->" + e.getMessage());
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
			r = customerMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CustomerService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(DemoCustomer customer) {

		boolean r = false;

		try {
			DemoCustomer u = customerMapper.getCustomerById(customer.getCustomer_id());
			if (u != null) {
				u.setName(customer.getName());
				customerMapper.updateCustomer(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("CustomerService.updateCustomer() --> " + customer + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param customer_id
	 * @return
	 */
	public boolean deleteCustomerById(int customer_id) {

		boolean r = false;

		try {
			customerMapper.deleteCustomerById(customer_id);
			r = true;
		} catch (Exception e) {
			logger.error("CustomerService.deleteCustomerById() --> " + customer_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}