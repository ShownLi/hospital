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
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.customer.CustomerMapper;

import net.sf.json.JSONObject;

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
		
		if(customer.getChineseName()!=null){
		map.put("chineseName",customer.getChineseName());
		}
		
		if(customer.getCustomerId()!=null){
			map.put("customerId",customer.getCustomerId());
		}
		
		if(customer.getEnglishName()!=null){
			map.put("englishName",customer.getEnglishName());
		}
		
		if(customer.getMobilephone()!=null){
			map.put("mobilephone",customer.getMobilephone());
		}
		
		if(customer.getEmail()!=null){
			map.put("email",customer.getEmail());
		}
		
		if(customer.getLocation()!=null){
			map.put("location",customer.getLocation());
		}
		
		if(customer.getLevel()!=null){
			map.put("level",customer.getLevel());
		}
		
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
			int kk = customerMapper.saveCustomer(customer);
		} catch (Exception e) {
			logger.error("CustomerService.saveCustomer() --> " + customer + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
//		return customer.getCustomerId();
		return 0;
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
	
	/**
	 * 根据Json信息校验必填字段 注册
	 * 
	 * @param 
	 * @return
	 */
	public Json validateAdd(JSONObject jsonobject, Json j) {
		try {
    		if(!jsonobject.has("customer_name_zh") || jsonobject.getString("customer_name_zh").equals("")){j.setMsg("客人验证失败");}
    		else if(!jsonobject.has("email") || jsonobject.getString("email").equals("")){j.setMsg("客人验证失败");}
    		else if(!jsonobject.has("portal_id") || jsonobject.getString("portal_id").equals("")){j.setMsg("客人验证失败");}
    		else{
    			j.setSuccess(true);
    		}
			}catch (Exception e) {
				e.getMessage();
		}
		return j;
	}
	
	/**
	 * 根据Json信息校验必填字段 更新客人信息
	 * 
	 * @param 
	 * @return
	 */
	public Json validateUpdate(JSONObject jsonobject, Json j) {
		try {
    		if(!jsonobject.has("customer_id") || jsonobject.getString("customer_id").equals("")){j.setMsg("客人验证失败");}
    		else if(!jsonobject.has("customer_name_zh") || jsonobject.getString("customer_name_zh").equals("")){j.setMsg("客人验证失败");}
    		else if(!jsonobject.has("email") || jsonobject.getString("email").equals("")){j.setMsg("客人验证失败");}
    		
    		else{
    			j.setSuccess(true);
    		}
			}catch (Exception e) {
				e.getMessage();
		}
		return j;
	}
	
	/**
	 * 根据Json信息生成客人
	 * 
	 * @param 
	 * @return
	 */
	public Customer Json2customer(JSONObject jsoncustomer) {
		Customer customer = new Customer();
		try {
				if(jsoncustomer.has("customer_id") && !jsoncustomer.getString("customer_id").equals("")){customer.setCustomerId(Integer.parseInt(jsoncustomer.getString("customer_id")));}
	    		if(jsoncustomer.has("portal_id") && !jsoncustomer.getString("portal_id").equals("")){customer.setPortalId(Integer.valueOf(jsoncustomer.getString("portal_id")));}
	    		if(jsoncustomer.has("email") && !jsoncustomer.getString("email").equals("")){customer.setEmail(jsoncustomer.getString("email"));}
	    		if(jsoncustomer.has("customer_name_zh") && !jsoncustomer.getString("customer_name_zh").equals("")){customer.setChineseName(jsoncustomer.getString("customer_name_zh"));}
	    		if(jsoncustomer.has("customer_name_en") && !jsoncustomer.getString("customer_name_en").equals("")){customer.setEnglishName(jsoncustomer.getString("customer_name_en"));}
	    		if(jsoncustomer.has("mobilephone") && !jsoncustomer.getString("mobilephone").equals("")){customer.setMobilephone(jsoncustomer.getString("mobilephone"));}
	    		if(jsoncustomer.has("wechat") && !jsoncustomer.getString("wechat").equals("")){customer.setWechat(jsoncustomer.getString("wechat"));}
	    		if(jsoncustomer.has("qq") && !jsoncustomer.getString("qq").equals("")){customer.setQq(jsoncustomer.getString("qq"));}
	    		if(jsoncustomer.has("promote_code") && !jsoncustomer.getString("promote_code").equals("")){customer.setSource(jsoncustomer.getString("promote_code"));}
		}catch (Exception e) {
			logger.error("CustomerService.Json2customer() --> " + customer.getCustomerId() + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	public boolean isRegular(Customer customer){
		Customer regular = customerMapper.getCustomerByEmail(customer);
		if(regular != null) {
			return true;
		}
		else { return false;}
	}
	
	public void bindRegular(Customer customer){
		Customer regular = customerMapper.getCustomerByEmail(customer);
		if(customer.getChineseName()!=null && !"".equals(customer.getChineseName())){
			regular.setChineseName(customer.getChineseName());
		}
		if(customer.getEnglishName()!=null && !"".equals(customer.getEnglishName())){
			regular.setEnglishName(customer.getEnglishName());
		}
		if(customer.getMobilephone()!=null && !"".equals(customer.getMobilephone())){
			regular.setMobilephone(customer.getMobilephone());
		}
		if(customer.getWechat()!=null && !"".equals(customer.getWechat())){
			regular.setWechat(customer.getWechat());
		}
		if(customer.getQq()!=null && !"".equals(customer.getQq())){
			regular.setQq(customer.getQq());
		}
		
		customerMapper.updateCustomer(regular);
		
	}
	
	/**
	 * 网站更新用户信息，从而更新客人信息(不修改密码)
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomerAPI(Customer customer) {

		boolean result = false;
		try {
			Customer lastCustomer = customerMapper.getCustomerById(customer.getCustomerId());
			if (lastCustomer != null) {
				if(customer.getPortalId() != null){lastCustomer.setPortalId(customer.getPortalId());}
				if(customer.getChineseName() != null){lastCustomer.setChineseName(customer.getChineseName());}
				if(customer.getEnglishName() != null){lastCustomer.setEnglishName(customer.getEnglishName());}
				if(customer.getMobilephone() != null){lastCustomer.setMobilephone(customer.getMobilephone());}
				if(customer.getWechat() != null){lastCustomer.setWechat(customer.getWechat());}
				if(customer.getQq() != null){lastCustomer.setQq(customer.getQq());}
				if(customer.getEmail() != null){lastCustomer.setEmail(customer.getEmail());}
				customerMapper.updateCustomer(lastCustomer);
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			logger.error("CustomerService.updateCustomerAPI() --> " + customer + "-->" + e.getMessage());
			result = false;
		}
		
		return result;
	}

	public void updateOrderEmail(Customer customer) {
		customerMapper.updateOrderEmail(customer);
	}

}