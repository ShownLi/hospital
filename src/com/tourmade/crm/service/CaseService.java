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
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Parameter;
import com.tourmade.crm.mapper.crmcase.CaseMapper;

@Service
@Transactional(readOnly = false)
public class CaseService extends BaseService {
	
	@Autowired
	private CaseMapper caseMapper;

	/**
	 * 查询询单数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Case> queryCase(Case crmcase, PageHelper ph, HttpServletRequest request) {

		QueryResult<Case> result = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", ph.getStart());
		map.put("length", ph.getLength());;
		
		if(crmcase!=null){
			map.put("customerId", crmcase.getCustomerId());
		}
		if(crmcase.getCaseId()!=null){
			map.put("caseId", crmcase.getCaseId());
		}
		if(crmcase.getBudget()!=null){
			map.put("budget", crmcase.getBudget());
		}
		if(crmcase.getDestination()!=null){
			map.put("destination", crmcase.getDestination());
		}
		if(crmcase.getSource()!=null){
			map.put("source", crmcase.getSource());
		}
		if(crmcase.getOperator()!=null){
			map.put("operator", crmcase.getOperator());
		}
		if(crmcase.getStatus()!=null){
			map.put("status", crmcase.getStatus());
		}
		
		List<Case> data = caseMapper.queryCase(map);
		long count = caseMapper.countCase(crmcase);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	/**
	 * 查询询单数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Case> queryCaseFromCustomer(int customerId, PageHelper ph, HttpServletRequest request) {

		QueryResult<Case> result = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();


		
		map.put("customerId", customerId);
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<Case> data = caseMapper.queryCasesByCustomerId(map);
		long count = caseMapper.countCaseFC(customerId);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}
	
	/**
	 * 新增询单
	 * 
	 * @param case
	 * @return
	 */
	public int saveCase(Case crmcase) {

		
		try {
//			Parameter parameter = caseMapper.getParameterByCountryChinese(crmcase.getDestination());
//			crmcase.setDestination(parameter.getChinese());
//			crmcase.setDestinationCode(parameter.getValue());
			crmcase.setStatus("0");
			caseMapper.saveCase(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.saveCase() --> " + crmcase + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return crmcase.getCaseId();
	}

	/**
	 * 根据主键获取询单信息
	 * 
	 * @param id
	 * @return
	 */
	public Case getCaseById(int id) {
		Case crmcase = null;
		try {
			crmcase = caseMapper.getCaseById(id);
		} catch (Exception e) {
			logger.error("CaseService.getCaseById() --> " + id + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> crmcase = null;
		try {
			crmcase = caseMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
	
	/**
	 * 获得客人信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getCustomer() {
		List<EntityList> customerList = null;
		try {
			customerList = caseMapper.getCustomer();
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			customerList = null;
		}
		return customerList;
	}
	
	/**
	 * 根据id获得客人简单信息
	 * @return
	 */
	public List<EntityList> getCustomerById(int customerId) {
		List<EntityList> customer = null;
		try {
			customer = caseMapper.getCustomerById(customerId);
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	/**
	 * 根据id获得客人基本信息
	 * @param i
	 * @return
	 */
	public Customer getCustomerInfoById(int customerId) {
		Customer customer = null;
		try{
			customer=caseMapper.getCustomerInfoById(customerId);
		} catch(Exception e) {
			logger.error("CaseService.getCustomerInfo() --> -->"+e.getMessage());
			customer = null;
		}
		return customer;
	}

	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getUser() {
		List<EntityList> userList = null;
		try {
			userList = caseMapper.getUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			userList = null;
		}
		return userList;
	}
	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getAllUser() {
		List<EntityList> users = null;
		try {
			users = caseMapper.getAllUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			users = null;
		}
		return users;
	}
	
	/**
	 * 获得销售信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSales() {
		List<EntityList> sales = null;
		try {
			sales = caseMapper.getSales();
		} catch (Exception e) {
			logger.error("CaseService.getSales() --> -->" + e.getMessage());
			sales = null;
		}
		return sales;
	}
	
	/**
	 * 获得地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSalesByAgency(String destination) {
		List<EntityList> agencys = null;
		try {
			agencys = caseMapper.getSalesByAgency(destination);
		} catch (Exception e) {
			logger.error("CaseService.getSalesByAgency() --> -->" + e.getMessage());
			agencys = null;
		}
		return agencys;
	}
	
	/**
	 * 更新询单信息
	 * 
	 * @param case
	 * @return zyy 10-19
	 */
	public void updateCase(Case crmcase) {

		try {
			caseMapper.updateCase(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + crmcase + "-->" + e.getMessage());
		}

	}

	/**
	 * 询单生成订单时更改询单状态
	 * 
	 * @param case
	 * @return
	 */
	public boolean case2order(int id) {

		boolean judge = false;

		try {
			Case  crmcase= caseMapper.getCaseById(id);
			if (crmcase != null) {
				crmcase.setStatus("2");
				caseMapper.updateCase(crmcase);
				judge = true;
			} else {
				judge = false;
			}
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + id + "-->" + e.getMessage());
			judge = false;
		}

		return judge;
	}
	
	/**
	 * 根据询单id查询order表中同一caseId下的order.status!=4的数量
	 * 
	 * @param case
	 * @return
	 */
	public int caseStatus(int caseId) {
		int sum = caseMapper.caseStatus(caseId);
		return sum;
	}
	/**
	 * 询单失效
	 * 
	 * @param case_id
	 * @return
	 */
	public boolean deleteCaseById(int caseId) {

		boolean judge = false;

		try {
			caseMapper.deleteCaseById(caseId);
			judge = true;
		} catch (Exception e) {
			logger.error("CaseService.deleteCaseById() --> " + caseId + "-->" + e.getMessage());
			judge = false;
		}

		return judge;
	}
	
	/*
	 * 出发时间0,1（未确定，已确定）
	 */
	public Case validateStartTime(Case crmcase){
		String startTime = crmcase.getStartTime();
		if(startTime==null||startTime.isEmpty()||Integer.parseInt(startTime)!=1){
			crmcase.setStartTime("0");
		}
		return crmcase;
	}

	public Case getCaseByOrderId(int orderId) {
		Case crmcase = null;
		try {
			crmcase = caseMapper.getCaseByOrderId(orderId);
		} catch (Exception e) {
			logger.error("CaseService.getCaseByOrderId() --> " + orderId + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}

}