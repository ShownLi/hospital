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
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.mapper.order.OrderMapper;

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

		QueryResult<Order> r = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Order> data = orderMapper.queryOrder(map);
		long count = orderMapper.countOrder(order);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}

	/**
	 * 查询订单数据，分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Order> queryOrderByCaseId(int caseId, PageHelper ph, HttpServletRequest request) {

		QueryResult<Order> r = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("id", caseId);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Order> data = orderMapper.queryOrderByCaseId(map);
		long count = orderMapper.countOrderByCaseId(caseId);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}
	
	/**
	 * 验证客人是否有邮箱
	 * 
	 * @param order
	 * @return
	 */
	public boolean validatemail(int id) {
		String e = orderMapper.validatemail(id);
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
	public boolean validatePortalId(int id) {
		String s = orderMapper.validatePortalId(id);
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
	public void customerstatus(int id,String status) {
		orderMapper.customerstatus(id, status);
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
	public void creatPortal(int id) {
		Customer customer = orderMapper.getCustomerById(id);
		String url = orderMapper.geturl("creatPortal.url");
		/*String param="customer_id="+customer.getCustomerid()
						+"&customer_name_zh="+customer.getZname()
						+"&customer_name_en="+customer.getEname()
						+"&email="+customer.getEmail()
						+"&mobilephone="+customer.getMobilephone()
						+"&wechat="+customer.getWechat()
						+"&qq"+customer.getQq(); */
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
	
	/**
	 * 根据订单获取完整订单信息
	 * 
	 * @param id
	 * @return
	 */
	public Order getInfo(Order order) {
		Order r = null;
		try {
			r = orderMapper.getInfo(order);
		} catch (Exception e) {
			logger.error("OrderService.getInfo() --> " + order + "-->" + e.getMessage());
			r = null;
		}
		return r;
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
	public Order getOrderById(int id) {
		Order r = null;
		try {
			r = orderMapper.getOrderById(id);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
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
			r = orderMapper.getCustomerById(id);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据主键获取询单信息
	 * 
	 * @param id
	 * @return
	 */
	public Case getCaseById(int id) {
		Case r = null;
		try {
			r = orderMapper.getCaseById(id);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + id + "-->" + e.getMessage());
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
			r = orderMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("OrderService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新订单信息(不修改密码)
	 * 
	 * @param order
	 * @return
	 */
	public boolean updateOrder(Order order) {

		boolean r = false;

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
			r = true;
		} catch (Exception e) {
			logger.error("OrderService.updateOrder() --> " + order + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除订单（假删除）
	 * 
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrderById(int order_id) {

		boolean r = false;

		try {
			orderMapper.deleteOrderById(order_id);
			r = true;
		} catch (Exception e) {
			logger.error("OrderService.deleteOrderById() --> " + order_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	public Customer getCustomerByCaseId(int caseid) {
		Customer r = null;
		try {
			r = orderMapper.getCustomerByCaseId(caseid);
		} catch (Exception e) {
			logger.error("OrderService.getOrderById() --> " + caseid + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	

}