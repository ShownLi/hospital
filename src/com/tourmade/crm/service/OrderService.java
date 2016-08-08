package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
import com.tourmade.crm.mapper.order.DemoOrderMapper;
import com.tourmade.crm.model.DemoOrder;
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
	 * 验证
	 * 
	 * @param order
	 * @return
	 */
	public boolean validate(int id) {
		String e = orderMapper.validate(id);
		if(null == e | "".equals(e)){
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
	public void MailAlias(int orderid) {
		String domain = "tourmade.com.cn";
		String url = "http://123.56.77.206/axis2/services/AliasAdd/add";
		String param = "alias=customer"+orderid+"@&real=customer@&domain="+domain;
		String param1 = "alias=agency"+orderid+"@&real=customer@&domain="+domain;
		creatAlias(url, param);
		creatAlias(url, param1);
		
		//将别名存入order表中
		DemoOrder order = new DemoOrder();
		order.setOrderid(orderid);
		order.setAgencyemailalias("agency"+orderid+"@"+domain);
		order.setCustomeremailalias("customer"+orderid+"@"+domain);
		updateOrder(order);
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
		            // 设置通用的请求属性
		            connection.setRequestProperty("accept", "*/*");
		            connection.setRequestProperty("connection", "Keep-Alive");
		            connection.setRequestProperty("user-agent",
		                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		            // 建立实际的连接
		            connection.connect();
		            // 定义 BufferedReader输入流来读取URL的响应
		            in = new BufferedReader(new InputStreamReader(
		                    connection.getInputStream()));
		        } catch (Exception e) {
		        	
		        	creatAlias(url, param);
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
			u.setCustomeremailalias(order.getCustomeremailalias());
			u.setAgencyemailalias(order.getAgencyemailalias());
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