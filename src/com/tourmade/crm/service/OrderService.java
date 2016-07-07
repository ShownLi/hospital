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
import com.tourmade.crm.mapper.order.DemoOrderMapper;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.DemoList;

import com.tourmade.crm.service.EmailService;

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
			System.out.println(order.getOrderid());
		} catch (Exception e) {
			logger.error("OrderService.saveOrder() --> " + order + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	/**
	 * 给地接社发送第一封下单邮件
	 * 
	 * @param order
	 * @return
	 */
	public void orderEmailToAgency(int orderid) {

		try {
			System.out.println(orderid);
			EmailService Eservice = new EmailService();
			Eservice.creatAlias(orderid);
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