package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.PriceRecord;
import com.tourmade.crm.mapper.finance.FinanceMapper;
import com.tourmade.crm.mapper.order.OrderMapper;
@Service
@Transactional(readOnly = false)
public class FinanceService extends BaseService{
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	FinanceMapper financeMapper;
	
	public QueryResult<Order> queryOrder(Order order, PageHelper ph) {

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
		if(order.getOrderCode()!=null){
			map.put("orderCode", order.getOrderCode());
		}
		if(order.getSearchStartTime()!=null){
			map.put("searchStartTime", order.getSearchStartTime());
		}
		if(order.getSearchEndTime()!=null){
			map.put("searchEndTime", order.getSearchEndTime());
		}
		List<Order> data = orderMapper.queryOrder(map);
		long count = orderMapper.countOrder(order);
			
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
	
		return length;
	}
	public QueryResult<CostRecord> getCostRecordListByOrderId(Integer id) {
		List<CostRecord> costRecordList = financeMapper.getCostRecordListByOrderId(id);
		QueryResult<CostRecord> result = new QueryResult<>();
		result.setData(costRecordList);
		return result;
	}
	public QueryResult<PriceRecord> getPriceRecordListByOrderId(Integer id) {
		
		List<PriceRecord> priceRecordList = financeMapper.getPriceRecordListByOrderId(id);
		QueryResult<PriceRecord> result = new QueryResult<>();
		result.setData(priceRecordList);
		return result;
	}
}

