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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.OrderRecord;
import com.tourmade.crm.mapper.orderrecord.OrderRecordMapper;

@Service
@Transactional(readOnly = false)
public class OrderRecordService extends BaseService {
	
	@Autowired
	private OrderRecordMapper orderrecordMapper;

	/**
	 * 查询订单记录数据，分页展示
	 * 
	 * @param orderrecord
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<OrderRecord> queryOrderRecord(OrderRecord orderrecord, PageHelper ph, int orderid, HttpServletRequest request) {

		QueryResult<OrderRecord> result = new QueryResult<OrderRecord>();
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		map.put("orderId", orderid);

		List<OrderRecord> data = orderrecordMapper.queryOrderRecord(map);
		long count = orderrecordMapper.countOrderRecordByOrderid(orderid);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	/**
	 * 查询订单记录数据，分页展示
	 * 
	 * @param orderrecord
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<OrderRecord> getOrderRecord(OrderRecord orderRecord, PageHelper ph, int caseId, HttpServletRequest request) {

		QueryResult<OrderRecord> result = new QueryResult<OrderRecord>();
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		map.put("caseId", caseId);

		List<OrderRecord> data = orderrecordMapper.getOrderRecord(map);
		long count = orderrecordMapper.countOrderRecordByCaseid(caseId);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}
	
	/**
	 * 新增订单记录
	 * 
	 * @param orderrecord
	 * @return
	 */
	public int saveOrderRecord(OrderRecord orderrecord) {

		
		try {
			orderrecordMapper.saveOrderRecord(orderrecord);
		} catch (Exception e) {
			logger.error("OrderRecordService.saveOrderRecord() --> " + orderrecord + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return orderrecord.getOrderRecordId();
	}

	/**
	 * 根据主键获取订单记录信息
	 * 
	 * @param id
	 * @return
	 */
	public OrderRecord getOrderRecordById(int id) {
		OrderRecord orderRecord = null;
		try {
			orderRecord = orderrecordMapper.getOrderRecordById(id);
		} catch (Exception e) {
			logger.error("OrderRecordService.getOrderRecordById() --> " + id + "-->" + e.getMessage());
			orderRecord = null;
		}
		return orderRecord;
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
			parameters = orderrecordMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("OrderRecordService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			parameters = null;
		}
		return parameters;
	}
	
	/**
	 * 更新订单记录信息(不修改密码)
	 * 
	 * @param orderrecord
	 * @return 10-19
	 */
	public void updateOrderRecord(OrderRecord orderRecord) {

		try {
			orderrecordMapper.updateOrderRecord(orderRecord);
		} catch (Exception e) {
			logger.error("OrderRecordService.updateOrderRecord() --> " + orderRecord + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除订单记录（假删除）
	 * 
	 * @param orderrecord_id
	 * @return
	 */
	public void deleteOrderRecordById(int orderRecordId) {
		try {
			orderrecordMapper.deleteOrderRecordById(orderRecordId);
		} catch (Exception e) {
			logger.error("OrderRecordService.deleteOrderRecordById() --> " + orderRecordId + "-->" + e.getMessage());
		}
	}

}