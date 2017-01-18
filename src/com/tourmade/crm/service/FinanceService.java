package com.tourmade.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;

import java.text.SimpleDateFormat;
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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.PriceRecord;
import com.tourmade.crm.mapper.finance.FinanceMapper;
import com.tourmade.crm.mapper.order.OrderMapper;

@Service
@Transactional(readOnly = false)
public class FinanceService extends BaseService {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	FinanceMapper financeMapper;

	public QueryResult<Order> queryOrder(Order order, PageHelper ph) {

		QueryResult<Order> length = new QueryResult<Order>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		if (order.getOrderCode() != null) {
			map.put("orderCode", order.getOrderCode());
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (order.getSearchStartTime() != null) {
			map.put("searchStartTime", format.format(order.getSearchStartTime()) + " 00:00:00");
			System.out.println(map.get("searchStartTime"));
		}
		if (order.getSearchEndTime() != null) {
			map.put("searchEndTime", format.format(order.getSearchEndTime()) + " 23:59:59");
			System.out.println(map.get("searchEndTime"));
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

	public int updatePriceRecord(PriceRecord priceRecord) {
		// 先更新所修改的收款单
		financeMapper.updatePriceRecord(priceRecord);
		// 获取最新的收款单数据
		PriceRecord sumPriceRecord = financeMapper.getAllSumPriceRecord(priceRecord.getOrderId());
		sumPriceRecord.setOrderId(priceRecord.getOrderId());
		// 修改订单信息

		return financeMapper.updateOrderAfterUpdatePriceRecord(sumPriceRecord);

	}

	public void orderBalance(int orderId) {
		// 通过订单id结算订单
		financeMapper.balanceOrderByOrderId(orderId);
		// 通过订单id结算收款记录
		financeMapper.balancePriceRecordByOrderId(orderId);
		// 通过订单id结算 付款记录
		financeMapper.balanceCostRecordByOrderId(orderId);
	}

	public int priceAdjustMethod(PriceRecord priceRecord) {
		// 更新收款记录的收款金额
		financeMapper.priceAdjustMethod(priceRecord);
		// 更新对应的订单信息
		PriceRecord sumPriceRecord = financeMapper.getAllSumPriceRecord(priceRecord.getOrderId());
		sumPriceRecord.setOrderId(priceRecord.getOrderId());
		// 修改订单信息
		return financeMapper.updateOrderAfterUpdatePriceRecord(sumPriceRecord);
	}

	public int costAdjustMethod(CostRecord costRecord) {

		financeMapper.costAdjustMethod(costRecord);
		// 更新对应的订单信息
		CostRecord sumCostRecord = financeMapper.getAllSumCostRecord(costRecord.getOrderId());
		sumCostRecord.setOrderId(costRecord.getOrderId());
		// 修改订单信息
		return financeMapper.updateOrderAfterUpdateCostRecord(sumCostRecord);
	}

	
	public int savePriceRecord(PriceRecord priceRecord){
		
		financeMapper.savePriceRecord(priceRecord);
		
		return priceRecord.getPriceId();
	}

	public boolean updatePriceRecordPriceCode(PriceRecord priceRecord) {
		if(priceRecord.getPriceId()!=null&&priceRecord.getOrderId()!=null){
			String priceCode = priceRecord.getOrderId()+"-"+priceRecord.getPriceId();
			priceRecord.setPriceCode(priceCode);
			financeMapper.updatePriceRecordPriceCode(priceRecord);
			return true;
		}
		else return false;
		
	}
	



	public int updateCostRecord(CostRecord costRecord) {
		// 先更新所修改的收款单
		financeMapper.updateCostRecord(costRecord);
		// 获取最新的收款单数据
		CostRecord sumCostRecord = financeMapper.getAllSumCostRecord(costRecord.getOrderId());

		sumCostRecord.setOrderId(costRecord.getOrderId());
		// 修改订单信息
		return financeMapper.updateOrderAfterUpdateCostRecord(sumCostRecord);

	}

	public List<EntityList> getAllUser() {

		return financeMapper.getAllUser();
	}

	public List<EntityList> getAllAgency() {
		// TODO Auto-generated method stub
		return financeMapper.getAllAgency();
	}

	public void delPriceRecordByPriceId(Integer id) {
		
		financeMapper.delPriceRecordByPriceId(id);
		
	}

	public void saveCostRecord(CostRecord costRecord) {
		
		financeMapper.saveCostRecord(costRecord);
	}

	public void updateCostRecordOrder(CostRecord costRecord) {
		
		financeMapper.updateCostRecordOrder(costRecord);
	}

	public void updatePriceRecordOrder(PriceRecord priceRecord) {
		
		financeMapper.updatePriceRecordOrder(priceRecord);
	}

	public void delCostRecordByCostId(Integer id) {
		
		financeMapper.delCostRecordByCostId(id);
	}
}
