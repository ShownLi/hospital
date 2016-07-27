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
import com.tourmade.crm.mapper.orderrecord.DemoOrderRecordMapper;
import com.tourmade.crm.model.DemoOrderRecord;
import com.tourmade.crm.model.DemoList;

@Service
@Transactional(readOnly = false)
public class OrderRecordService extends BaseService {
	
	@Autowired
	private DemoOrderRecordMapper orderrecordMapper;

	/**
	 * 查询订单记录数据，分页展示
	 * 
	 * @param orderrecord
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoOrderRecord> queryOrderRecord(DemoOrderRecord orderrecord, PageHelper ph, int orderid, HttpServletRequest request) {

		QueryResult<DemoOrderRecord> r = new QueryResult<DemoOrderRecord>();
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
		map.put("id", orderid);
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoOrderRecord> data = orderrecordMapper.queryOrderRecord(map);
		long count = orderrecordMapper.countOrderRecord(orderid);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}

	/**
	 * 查询订单记录数据，分页展示
	 * 
	 * @param orderrecord
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoOrderRecord> getOrderRecord(DemoOrderRecord orderrecord, PageHelper ph, int caseid, HttpServletRequest request) {

		QueryResult<DemoOrderRecord> r = new QueryResult<DemoOrderRecord>();
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
		map.put("id", caseid);
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoOrderRecord> data = orderrecordMapper.getOrderRecord(map);
		long count = orderrecordMapper.countOrderRecord(orderrecord);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}
	
	/**
	 * 新增订单记录
	 * 
	 * @param orderrecord
	 * @return
	 */
	public int saveOrderRecord(DemoOrderRecord orderrecord) {

		
		try {
			orderrecordMapper.saveOrderRecord(orderrecord);
		} catch (Exception e) {
			logger.error("OrderRecordService.saveOrderRecord() --> " + orderrecord + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return orderrecord.getOrderrecordid();
	}

	/**
	 * 根据主键获取订单记录信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoOrderRecord getOrderRecordById(int id) {
		DemoOrderRecord r = null;
		try {
			r = orderrecordMapper.getOrderRecordById(id);
		} catch (Exception e) {
			logger.error("OrderRecordService.getOrderRecordById() --> " + id + "-->" + e.getMessage());
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
			r = orderrecordMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("OrderRecordService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新订单记录信息(不修改密码)
	 * 
	 * @param orderrecord
	 * @return
	 */
	public boolean updateOrderRecord(DemoOrderRecord orderrecord) {

		boolean r = false;

		try {
			DemoOrderRecord u = orderrecordMapper.getOrderRecordById(orderrecord.getOrderrecordid());
			if (u != null) {
				//u.setName(orderrecord.getName());
				orderrecordMapper.updateOrderRecord(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("OrderRecordService.updateOrderRecord() --> " + orderrecord + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除订单记录（假删除）
	 * 
	 * @param orderrecord_id
	 * @return
	 */
	public boolean deleteOrderRecordById(int orderrecordid) {

		boolean r = false;

		try {
			orderrecordMapper.deleteOrderRecordById(orderrecordid);
			r = true;
		} catch (Exception e) {
			logger.error("OrderRecordService.deleteOrderRecordById() --> " + orderrecordid + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}