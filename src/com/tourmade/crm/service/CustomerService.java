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
	public QueryResult<Customer> queryCustomer(Customer customer, PageHelper ph, HttpServletRequest request) {

		QueryResult<Customer> r = new QueryResult<Customer>();
		Map<String, Object> map = new HashMap<String, Object>();
		

		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Customer> data = customerMapper.queryCustomer(map);
		long count = customerMapper.countCustomer(customer);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
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
		Customer r = null;
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
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> r = null;
		try {
			r = customerMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CustomerService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新客人信息(不修改密码)
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer) {

		boolean r = false;
		try {
			Customer u = customerMapper.getCustomerById(customer.getCustomerId());
			if (u != null) {
				u.setChineseName(customer.getChineseName());
				u.setEnglishName(customer.getEnglishName());
				u.setLocation(customer.getLocation());
				u.setSource(customer.getSource());
				u.setAgeGroup(customer.getAgeGroup());
				u.setGender(customer.getGender());
				u.setTelephone(customer.getTelephone());
				u.setMobilephone(customer.getMobilephone());
				u.setWechat(customer.getWechat());
				u.setQq(customer.getQq());
				u.setEmail(customer.getEmail());
				u.setBirthday(customer.getBirthday());
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
	 * 删除客人（假删除）
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