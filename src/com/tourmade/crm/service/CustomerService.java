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
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.customer.CustomerMapper;

@Service
@Transactional(readOnly = false)
public class CustomerService extends BaseService {
	
	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 查询客人数据，分页展示
	 * 
	 * @param customer
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Customer> queryCustomer(Customer customer, PageHelper pageHelper, HttpServletRequest request) {

		QueryResult<Customer> pageResult = new QueryResult<Customer>();
		Map<String, Object> map = new HashMap<String, Object>();
		

		map.put("start", pageHelper.getStart());
		map.put("length", pageHelper.getLength());

		List<Customer> data = customerMapper.queryCustomer(map);
		long count = customerMapper.countCustomer(customer);
			
		pageResult.setData(data);
		pageResult.setCountTotal(count);
		pageResult.setCountFiltered(count);
	
		return pageResult;
	}

	/**
	 * 新增客人
	 * 
	 * @param customer
	 * @return
	 */
	public int saveCustomer(Customer customer) {	
		try {
			customerMapper.saveCustomer(customer);
		} catch (Exception e) {
			logger.error("CustomerService.saveCustomer() --> " + customer + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return customer.getCustomerId();
	}

	/**
	 * 根据主键获取客人信息
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id) {
		Customer customer = null;
		try {
			customer = customerMapper.getCustomerById(id);
		} catch (Exception e) {
			logger.error("CustomerService.getCustomerById() --> " + id + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> parameterList = null;
		try {
			parameterList = customerMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CustomerService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			parameterList = null;
		}
		return parameterList;
	}
	
	/**
	 * 更新客人信息(不修改密码)
	 * 
	 * @param customer
	 * @return 10-19
	 */
	public void updateCustomer(Customer customer) {
		try {
			customerMapper.updateCustomer(customer);
		} catch (Exception e) {
			logger.error("CustomerService.updateCustomer() --> " + customer + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除客人（假删除）
	 * 
	 * @param customerId
	 * @return
	 */
	public void deleteCustomerById(int customerId) {
		try {
			customerMapper.deleteCustomerById(customerId);
		} catch (Exception e) {
			logger.error("CustomerService.deleteCustomerById() --> " + customerId + "-->" + e.getMessage());
		}
	}

}