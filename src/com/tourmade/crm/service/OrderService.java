package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.mapper.order.OrderMapper;
import com.tourmade.crm.entity.PortalOrder;

import net.sf.json.JSONObject;


@Service
@Transactional(readOnly = false)
public class OrderService extends BaseService {
	
	@Autowired
	private OrderMapper orderMapper;

	/**
	 * 查询订单数据，分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Order> queryOrder(Order order, PageHelper ph, HttpServletRequest request) {

		QueryResult<Order> length = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		if(order.getCustomerName()!=null){
		map.put("customerName",order.getCustomerName());
		}
		
		if(order.getOrderId()!=null){
		map.put("orderId", order.getOrderId());
		}
		
		if(order.getAgencyName()!=null){
			map.put("agencyName", order.getAgencyName());
		}
		
		if(order.getSalesName()!=null){
			map.put("salesName", order.getSalesName());
		}
		
		if(order.getDestination()!=null){
			map.put("destination", order.getDestination());
		}
		
		if(order.getBudget()!=null){
			map.put("budget", order.getBudget());
		}

		if(order.getOperator()!=null){
			map.put("operator", order.getOperator());
		}
		
		if(order.getStatus()!=null){
			map.put("status", order.getStatus());
		}
		if(order.getCustomerEmailReal()!=null){
			map.put("email", order.getCustomerEmailReal());
		}
		List<Order> data = orderMapper.queryOrder(map);
		long count = orderMapper.countOrder(order);
			
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
	
		return length;
	}

	/**
	 * 查询订单数据，分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
/*	public QueryResult<Order> queryOrderByCaseId(int caseId, PageHelper ph, HttpServletRequest request) {

		QueryResult<Order> result = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("caseId", caseId);
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<Order> data = orderMapper.queryOrderByCaseId(map);
		long count = orderMapper.countOrderByCaseId(caseId);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}*/
	/**
	 * 查询订单数据，不分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Order> queryOrderByCaseId(int caseId, HttpServletRequest request) {

		QueryResult<Order> result = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("caseId", caseId);
		/*map.put("start", ph.getStart());
		map.put("length", ph.getLength());*/

		List<Order> data = orderMapper.queryOrderByCaseId(map);
		long count = orderMapper.countOrderByCaseId(caseId);
			
		result.setData(data);
		
		result.setCountTotal(count);
		
		result.setCountFiltered(count);
	
		return result;
	}
	
	/**
	 * 验证客人是否有邮箱
	 * 
	 * @param order
	 * @return
	 */
	public boolean validateEmail(int customerId) {
		String e = orderMapper.validateEmail(customerId);
		if(null == e | "".equals(e)){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * 验证客人是否在官网注册
	 * 
	 * @param order
	 * @return
	 */
	public boolean validatePortalId(int customerId) {
		String s = orderMapper.validatePortalId(customerId);
		if(null == s || "".equals(s) || "null".equals(s)){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * 更改客人级别
	 * 
	 * @param order
	 * @return
	 */
	public void customerStatus(int id,String status) {
		orderMapper.customerStatus(id, status);
	}
	
	/**
	 * 新增订单
	 * 
	 * @param order
	 * @return
	 */
	public Order saveOrder(Order order) {
		
		try {
			Order orderInfo = getInfo(order);
			order.setAgencyId(orderInfo.getAgencyId());
			order.setAgencyName(orderInfo.getAgencyName());
			order.setSalesName(orderInfo.getSalesName());
			order.setAgencyEmailReal(orderInfo.getAgencyEmailReal());
			order.setCustomerName(orderInfo.getCustomerName());
			order.setCustomerEmailReal(orderInfo.getCustomerEmailReal());
			order.setStatus("1");
			orderMapper.saveOrder(order);
		} catch (Exception e) {
			logger.error("OrderService.saveOrder() --> " + order + "-->" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return order;
	}

	/**
	 * 新建别名
	 * 
	 * @param email
	 * @return
	 */
	public void MailAlias(Order order) {
		int orderid = order.getOrderId();
		
		String domain = orderMapper.geturl("mail.domain");
		String url = orderMapper.geturl("creatAlias.url");
		String real = orderMapper.geturl("mail.real");
		
		String cusReal = order.getCustomerEmailReal();
		//cusReal = cusReal.replace("@tourmade.com", "");
		String agReal = order.getAgencyEmailReal();
		//agReal = agReal.replace("@tourmade.com", "");
		
		String pattern="0000000";
		java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
		String formatedOrderid = df.format(orderid);
		
		String cusReParam = "alias=cr"+formatedOrderid+"@&real="+real+"@&domain="+domain;
		String cusSeParam = "alias=cs"+formatedOrderid+"@&real="+cusReal+"&domain="+domain;
		String agReParam = "alias=ar"+formatedOrderid+"@&real="+real+"@&domain="+domain;
		String agSeParam = "alias=as"+formatedOrderid+"@&real="+agReal+"&domain="+domain;
		
		creatAlias(url, cusReParam);
		creatAlias(url, cusReParam);
		creatAlias(url, cusSeParam);
		creatAlias(url, agReParam);
		creatAlias(url, agSeParam);
		
/*		String param = "alias=customer"+orderid+"@&real="+real+"@&domain="+domain;
		String param1 = "alias=agency"+orderid+"@&real="+real+"@&domain="+domain;*/
		//creatAlias(url, param);
		//creatAlias(url, param1);
		
		/*creatAlias(url, param1);
		creatAlias(url, param1);
		creatAlias(url, param);*/
		
		
		//将别名存入order表中
		Order upOrder = new Order();
		upOrder.setOrderId(orderid);
		upOrder.setAgencyReEmailAlias("ar"+formatedOrderid+"@"+domain);
		upOrder.setAgencySeEmailAlias("as"+formatedOrderid+"@"+domain);
		upOrder.setCustomerReEmailAlias("cr"+formatedOrderid+"@"+domain);
		upOrder.setCustomerSeEmailAlias("cs"+formatedOrderid+"@"+domain);
		//System.out.println(upOrder);
		updateOrder(upOrder);
	}
	
	/**
	 * 新建别名
	 * 
	 * @param email
	 * @return
	 */
	public void creatAlias(String url, String param) {

		        BufferedReader in = null;
		        try {
		            String urlNameString = url + "?" + param;
		            URL realUrl = new URL(urlNameString);
		            // 打开和URL之间的连接
		            URLConnection connection = realUrl.openConnection();
		            // 建立实际的连接
		            connection.connect();
		            // 定义 BufferedReader输入流来读取URL的响应
		            in = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream()));
		        } catch (Exception e) {
		        	
		        }
		        // 使用finally块来关闭输入流
		        finally {
		            try {
		                if (in != null) {
		                    in.close();
		                }
		            } catch (Exception e2) {
		                e2.printStackTrace();
		            }
		        }
	}
	
	/**
	 * 注册官网用户
	 * 
	 * @param email
	 * @return
	 */
	/*public void creatPortal(int id) {
		Customer customer = orderMapper.getCustomerById(id);
		String url = orderMapper.geturl("creatPortal.url");
		String param="customer_id="+customer.getCustomerid()
						+"&customer_name_zh="+customer.getZname()
						+"&customer_name_en="+customer.getEname()
						+"&email="+customer.getEmail()
						+"&mobilephone="+customer.getMobilephone()
						+"&wechat="+customer.getWechat()
						+"&qq"+customer.getQq(); 
		BufferedReader in = null;
		
		try {
			String param="customer_id="+customer.getCustomerId()
			+"&customer_name_zh="+URLEncoder.encode(customer.getChineseName(),"UTF-8")
			+"&customer_name_en="+customer.getEnglishName()
			+"&email="+customer.getEmail()
			+"&mobilephone="+customer.getMobilephone()
			+"&wechat="+customer.getWechat()
			+"&qq"+customer.getQq();
			
			//String urlNameString = url + "?" + param;
			//URL realUrl = new URL(urlNameString);
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String str = null;    
			StringBuffer sb = new StringBuffer(); 
            while((str = in.readLine()) != null) {    
             sb.append( str ); 
            }
            JSONObject result = JSONObject.fromObject(sb.toString());
            customer.setPortalId(result.getInt("portal_id"));
            orderMapper.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	*/
	/**
	 * 根据订单获取完整订单信息
	 * 
	 * @param id
	 * @return
	 */
	public Order getInfo(Order order) {
		Order oldOrder = null;
		try {
			oldOrder = orderMapper.getInfo(order);
		} catch (Exception e) {
			logger.error("OrderService.getInfo() --> " + order + "-->" + e.getMessage());
			oldOrder = null;
		}
		return oldOrder;
	}
	
	/**
	 * 根据客人ID获得客人邮箱地址
	 * 
	 * @param id
	 * @return
	 */
	public String getCustomerEmailReal(int id) {
		String r = "";
		try {
			r = orderMapper.getCustomerEmailReal(id);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据主键获取订单信息
	 * 
	 * @param id
	 * @return
	 */
	public Order getOrderById(int orderId) {
		Order oldOrder = null;
		try {
			oldOrder = orderMapper.getOrderById(orderId);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + orderId + "-->" + e.getMessage());
			oldOrder = null;
		}
		return oldOrder;
	}
	
	/**
	 * 根据主键获取客人信息
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int customerId) {
		Customer customer = null;
		try {
			customer = orderMapper.getCustomerById(customerId);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + customerId + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	/**
	 * 根据主键获取询单信息
	 * 
	 * @param id
	 * @return
	 */
	public Case getCaseById(int caseId) {
		Case crmcase = null;
		try {
			crmcase = orderMapper.getCaseById(caseId);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + caseId+ "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> parameters = null;
		try {
			parameters = orderMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("OrderService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			parameters = null;
		}
		return parameters;
	}
	
	/**
	 * 更新订单信息(不修改密码)
	 * 
	 * @param order
	 * @return 10-19
	 */
	public void updateOrder(Order order) {

		try {
			Order u = orderMapper.getOrderById(order.getOrderId());
			u.setAgencyReEmailAlias(order.getAgencyReEmailAlias());
			u.setAgencySeEmailAlias(order.getAgencySeEmailAlias());
			u.setCustomerReEmailAlias(order.getCustomerReEmailAlias());
			u.setCustomerSeEmailAlias(order.getCustomerSeEmailAlias());
			if(order.getStatus() != null){
				u.setStatus(order.getStatus());
			}
			if(order.getGroupNumber()!= null){
				u.setGroupTime(order.getGroupTime());
				u.setStartDate(order.getStartDate());
				u.setEndDate(order.getEndDate());
				u.setGroupNumber(order.getGroupNumber());
				u.setGroupPrice(order.getGroupPrice());
				u.setCurrency(order.getCurrency());
				u.setExchangeRate(order.getExchangeRate());
				u.setRmbPrice(order.getRmbPrice());
				u.setStatus("2");	
			}
			if(order.getReason() != null){
				u.setReason(order.getReason());
				u.setStatus("3");
			}
			orderMapper.updateOrder(u);
		} catch (Exception e) {
			logger.error("OrderService.updateOrder() --> " + order + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除订单（假删除）
	 * 
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrderById(int orderId) {

		boolean judge = false;

		try {
			orderMapper.deleteOrderById(orderId);
			judge = true;
		} catch (Exception e) {
			logger.error("OrderService.deleteOrderById() --> " + orderId + "-->" + e.getMessage());
			judge = false;
		}

		return judge;
	}

	public Customer getCustomerByCaseId(int caseId) {
		Customer customer = null;
		try {
			customer = orderMapper.getCustomerByCaseId(caseId);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + caseId + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	//根据saleId获得agency的sendmail值，决定是否发邮件
	public int selectAgencyBySaleId(int saleId){
		int isSendmail=0;
		try{
			isSendmail= orderMapper.selectAgencyBySaleId(saleId);
		}catch(Exception e){
			logger.error("OrderService.selectAgencyBySaleId() --> " + isSendmail + "-->" + e.getMessage());
		}
		return isSendmail;
	}
	
	/**
	 * 根据Json信息校验必填字段
	 * @param jsonobject
	 * @param j
	 * @return
	 */
	public Json validate(JSONObject jsonobject, Json j) {

    		if(!jsonobject.has("customer_id") || jsonobject.getString("customer_id").equals("")){j.setDesc("订单查询验证失败，客人ID不存在");}
    		else{
    			j.setSuccess(true);
    		}

		return j;
	}
	
	/**
	 * 从API查询订单数据
	 * @param customerId
	 * @return
	 */
	public QueryResult<PortalOrder> queryOrder(int customerId) {
	
		QueryResult<PortalOrder> result = new QueryResult<PortalOrder>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("customerId", customerId);
		
		List<PortalOrder> data = orderMapper.queryPortalOrder(map);
		long count = orderMapper.countPortalOrder(customerId);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}
	
	/**
	 * 根据邮箱地址获取订单信息
	 * @param recieverEmail
	 * @return
	 */
	public Order getOrderByEmail(String recieverEmail) {
		Order result = new Order();
		try {
			result = orderMapper.getOrderByEmail(recieverEmail);
		} catch (Exception e) {
			logger.error("OrderRecordService.getOrderId()-->" + e.getMessage());
			result = null;
		}
		return result;
	}
	/**
	 * 将订单的状态设置为未成行
	 * @param map
	 */
	public boolean deleteOrderNodealByCaseId(Map<String, Object> map) {
		boolean judge = false;

		try {
			int res = orderMapper.deleteOrderNodealByCaseId(map);
			if(res>0)
				judge = true;
			else
				judge = false;
		} catch (Exception e) {
			logger.error("OrderService.deleteOrderNodealByCaseId() --> " + map.get("caseId")+ "-->" + e.getMessage());
			judge = false;
		}

		return judge;
	}

}