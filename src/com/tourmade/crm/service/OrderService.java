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

@Service
@Transactional(readOnly = false)
public class OrderService extends BaseService {
	
	@Autowired
	private DemoOrderMapper orderMapper;

	/**
	 * 查询地接社数据，分页展示
	 * 
	 * @param order
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoOrder> queryOrder(DemoOrder order, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoOrder> r = new QueryResult<DemoOrder>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == order) {
				order = new DemoOrder();
			}
			order.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", order);
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
	 * 新增地接社
	 * 
	 * @param order
	 * @return
	 */
	public int saveOrder(DemoOrder order) {

		
		try {
			orderMapper.saveOrder(order);
		} catch (Exception e) {
			logger.error("OrderService.saveOrder() --> " + order + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return order.getOrder_id();
	}

	/**
	 * 根据主键获取地接社信息
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
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param order
	 * @return
	 */
	public boolean updateOrder(DemoOrder order) {

		boolean r = false;

		try {
			DemoOrder u = orderMapper.getOrderById(order.getOrder_id());
			if (u != null) {
				u.setName(order.getName());
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
	 * 删除地接社（假删除）
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