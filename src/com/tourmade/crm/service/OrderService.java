package com.tourmade.crm.service;

import java.io.InputStream;
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
	 * 新增订单
	 * 
	 * @param order
	 * @return
	 */
	public int saveOrder(DemoOrder order) {

		
		try {
			String customername = orderMapper.getCustomerName(order.getCustomerid());
			order.setAgencyid(orderMapper.getAgencyId(order.getSalesid()));
			String agencyname = orderMapper.getAgencyName(order.getAgencyid());
			String salesname = orderMapper.getSalesName(order.getSalesid());
			order.setAgencyname(agencyname);
			order.setSalesname(salesname);
			order.setCustomername(customername);
			//System.out.println(order);
			orderMapper.saveOrder(order);
		} catch (Exception e) {
			logger.error("OrderService.saveOrder() --> " + order + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return order.getOrderid();
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
		String customer_url = "http://123.56.77.206/axis2/services/AliasAdd/add?"+"alias="+customer_alias_pre+"&real=customer@"+"&domain="+domain;
		String agency_url = "http://123.56.77.206/axis2/services/AliasAdd/add?"+"alias="+agency_alias_pre+"&real=agency@"+"&domain"+domain;
		try {
			
			URL customer = new URL(customer_url);
			URL agency = new URL(agency_url);
			URLConnection connection = customer.openConnection();  
			connection.connect();
			InputStream is =connection.getInputStream();
			is.close();
			InputStream is1 =agency.openStream();
			is1.close();
			//System.out.println("订单ID："+orderid+"\n客人别名："+customer_alias_pre+domain+"\n地接社别名："+agency_alias_pre+domain);
			orderMapper.updateAlias(orderid,customer_alias_pre+domain,agency_alias_pre+domain);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 给地接社发送第一封下单邮件
	 * 
	 * @param order
	 * @return
	 */
	public void orderEmailToAgency(int orderid) {

		try {
			//EmailService Eservice = new EmailService();
			//Eservice.creatAlias(orderid);
			//Eservice.orderEmailToAgency(order.getCaseid(), order.getOrderid());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * 更新订单信息
	 * 
	 * @param order
	 * @return
	 */
	public boolean updateOrder(DemoOrder order) {

		boolean r = false;

		try {
			DemoOrder u = orderMapper.getOrderById(order.getOrderid());
			if (u != null) {
				if(order.getStatus() != null){
					u.setStatus(order.getStatus());
				}
				if(order.getGroupnumber()!= null){
					u.setGroupnumber(order.getGroupnumber());
					u.setStatus("1");
				}
				if(order.getReason() != null){
					u.setReason(order.getReason());
					u.setStatus("2");
				}
				orderMapper.updateOrder(u);
				r = true;
			} else {
				r = false;
			}
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