package com.tourmade.crm.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tourmade.crm.entity.Email;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.OrderRecord;
import com.tourmade.crm.mapper.orderrecord.OrderRecordMapper;


import net.sf.json.JSONObject;

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
	
	/**
	 * 生成订单沟通记录对象
	 * 
	 * @param 
	 * @return
	 * @throws ParseException 
	 */
	public OrderRecord Json2orderRecord(JSONObject obj_orderRecord){
		
		OrderRecord orderRecord = new OrderRecord();
		try {
			if(obj_orderRecord.has("order_id") && !obj_orderRecord.getString("order_id").equals("")){
				orderRecord.setOrderId(
						obj_orderRecord.getInt("order_id"));
				}
			if(obj_orderRecord.has("subject") && !obj_orderRecord.getString("subject").equals("")){
				orderRecord.setSubject(
						obj_orderRecord.getString("subject"));
				}
			if(obj_orderRecord.has("content") && !obj_orderRecord.getString("content").equals("")){
				
				orderRecord.setContent(
						processMail(obj_orderRecord.getString("content")));
				}
			if(obj_orderRecord.has("sendername") && !obj_orderRecord.getString("sendername").equals("")){
				orderRecord.setSenderName(
						obj_orderRecord.getString("sendername"));
				}
			if(obj_orderRecord.has("senderemail") && !obj_orderRecord.getString("senderemail").equals("")){
				orderRecord.setSenderEmail(
						obj_orderRecord.getString("senderemail"));
				}
			if(obj_orderRecord.has("recievername") && !obj_orderRecord.getString("recievername").equals("")){
				orderRecord.setRecieverName(
						obj_orderRecord.getString("recievername"));
				}
			if(obj_orderRecord.has("recieveremail") && !obj_orderRecord.getString("recieveremail").equals("")){
				orderRecord.setRecieverEmail(
						obj_orderRecord.getString("recieveremail"));
				}
			if(obj_orderRecord.has("fileurl") && !obj_orderRecord.getString("fileurl").equals("")){
				orderRecord.setFileUrl(
						obj_orderRecord.getString("fileurl"));
				}
			if(obj_orderRecord.has("reqtime") && !obj_orderRecord.getString("reqtime").equals("")){
			      DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			      Date reqtime = format.parse(obj_orderRecord.getString("reqtime"));
			      orderRecord.setReqTime(reqtime);
				}    
		}catch (ParseException e) {
			e.printStackTrace();
		}

		return orderRecord;
	}
	
	/**
	 * 截取邮件正文
	 * @param mailContent
	 * @return
	 */
	public String processMail(String mailContent){
			
			StringBuffer str = new StringBuffer(mailContent);
			
			int start = str.indexOf("<div id=\"tourmade-order\"></div>");
			int end = str.indexOf("<div id=\"tourmade-order\"></div>",start+1);
				
			//System.out.println("start:"+start+"\n"+"end:"+end);
			
			if(start>0&&end>0){
				str.replace(start, end, "");	
			}
			
	
			return str.toString();
		}
	
	/**
	 * 验证orderRecord是否有标题
	 * @param orderRecord
	 */
	public void validateOrderRecord(OrderRecord orderRecord){
		if(orderRecord.getSubject()==null && "".equals(orderRecord.getSubject())){
			orderRecord.setSubject("（无标题）");
		}
	}
	
	/**
	 * 生成待发送邮件对象
	 * 
	 * @param 
	 * @return
	 * @throws ParseException 
	 */
	public Email orderRecord2email(OrderRecord orderRecord){
		
		Email email = new Email();


		email.setOrderId(orderRecord.getOrderId());
		email.setAcount("order");
		email.setSubject(orderRecord.getSubject());
		email.setContent(orderRecord.getContent());
		email.setFileUrl(orderRecord.getFileUrl());
		
		return email;
	}
}