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
import com.tourmade.crm.mapper.order.DemoOrderMapper;
import com.tourmade.crm.model.DemoOrder;

import net.sf.json.JSONObject;

import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoCustomer;
import com.tourmade.crm.model.DemoList;

@Service
@Transactional(readOnly = false)
public class OrderService extends BaseService {
	
	@Autowired
	private DemoOrderMapper orderMapper;

	/**
	 * 查询订单数据，分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoOrder> queryOrder(DemoOrder order, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoOrder> r = new QueryResult<DemoOrder>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoOrder> data = orderMapper.queryOrder(map);
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
	public QueryResult<DemoOrder> queryOrderByCaseid(int caseid, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoOrder> r = new QueryResult<DemoOrder>();
		Map<String, Object> map = new HashMap<String, Object>();
			
		map.put("id", caseid);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoOrder> data = orderMapper.queryOrderByCaseid(map);
		long count = orderMapper.countOrderByCaseid(caseid);
			
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
	public boolean validateportalid(int id) {
		String s = orderMapper.validateportalid(id);
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
	public DemoOrder saveOrder(DemoOrder order) {

		
		try {
			DemoOrder order1 = getInfo(order);
			order.setAgencyid(order1.getAgencyid());
			order.setAgencyname(order1.getAgencyname());
			order.setSalesname(order1.getSalesname());
			order.setAgencyemailreal(order1.getAgencyemailreal());
			order.setCustomername(order1.getCustomername());
			order.setCustomeremailreal(order1.getCustomeremailreal());
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
	public void MailAlias(DemoOrder order) {
		int orderid = order.getOrderid();
		
		String domain = orderMapper.geturl("mail.domain");
		String url = orderMapper.geturl("creatAlias.url");
		String real = orderMapper.geturl("mail.real");
		
		String cusReal = order.getCustomeremailreal();
		//cusReal = cusReal.replace("@tourmade.com", "");
		String agReal = order.getAgencyemailreal();
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
		DemoOrder upOrder = new DemoOrder();
		upOrder.setOrderid(orderid);
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
		DemoCustomer customer = orderMapper.getCustomerById(id);
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
			String param="customer_id="+customer.getCustomerid()
			+"&customer_name_zh="+URLEncoder.encode(customer.getZname(),"UTF-8")
			+"&customer_name_en="+customer.getEname()
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
            customer.setPortalid(result.getInt("portal_id"));
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
	public DemoOrder getInfo(DemoOrder order) {
		DemoOrder r = null;
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
	public DemoOrder getOrderById(int id) {
		DemoOrder r = null;
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
	public DemoCustomer getCustomerById(int id) {
		DemoCustomer r = null;
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
	public DemoCase getCaseById(int id) {
		DemoCase r = null;
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
	public List<DemoList> getParameterInfo(String domain) {
		List<DemoList> r = null;
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
	public boolean updateOrder(DemoOrder order) {

		boolean r = false;

		try {
			DemoOrder u = orderMapper.getOrderById(order.getOrderid());
			u.setAgencyReEmailAlias(order.getAgencyReEmailAlias());
			u.setAgencySeEmailAlias(order.getAgencySeEmailAlias());
			u.setCustomerReEmailAlias(order.getCustomerReEmailAlias());
			u.setCustomerSeEmailAlias(order.getCustomerSeEmailAlias());
			if(order.getStatus() != null){
				u.setStatus(order.getStatus());
			}
			if(order.getGroupnumber()!= null){
				u.setGrouptime(order.getGrouptime());
				u.setStartdate(order.getStartdate());
				u.setEnddate(order.getEnddate());
				u.setGroupnumber(order.getGroupnumber());
				u.setGroupprice(order.getGroupprice());
				u.setCurrency(order.getCurrency());
				u.setExchangerate(order.getExchangerate());
				u.setRmbprice(order.getRmbprice());
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
	

}