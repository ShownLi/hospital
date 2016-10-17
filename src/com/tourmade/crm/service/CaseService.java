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

		QueryResult<Case> r = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();


		
//		map.put("customerid", customerid);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Case> data = caseMapper.queryCase(map);
		long count = caseMapper.countCase(crmcase);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
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

		QueryResult<Case> r = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();


		
		map.put("customerId", customerId);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Case> data = caseMapper.queryCaseFC(map);
		long count = caseMapper.countCaseFC(customerId);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}
	
	/**
	 * 新增询单
	 * 
	 * @param case
	 * @return
	 */
	public int saveCase(Case crmcase) {

		
		try {
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
		Case r = null;
		try {
			r = caseMapper.getCaseById(id);
		} catch (Exception e) {
			logger.error("CaseService.getCaseById() --> " + id + "-->" + e.getMessage());
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
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> r = null;
		try {
			r = caseMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 获得客人信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getCustomer() {
		List<EntityList> r = null;
		try {
			r = caseMapper.getCustomer();
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据id获得客人信息
	 * @return
	 */
	public List<EntityList> getCustomerById(int customerId) {
		List<EntityList> r = null;
		try {
			r = caseMapper.getCustomerById(customerId);
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 根据id获得客人基本信息
	 * @param i
	 * @return
	 */
	public Customer getCustomerInfoById(int customerId) {
		Customer cus = null;
		try{
			cus=caseMapper.getCustomerInfoById(customerId);
		} catch(Exception e) {
			logger.error("CaseService.getCustomerInfo() --> -->"+e.getMessage());
			cus = null;
		}
		return cus;
	}

	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getUser() {
		List<EntityList> r = null;
		try {
			r = caseMapper.getUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getAllUser() {
		List<EntityList> r = null;
		try {
			r = caseMapper.getAllUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 获得销售信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSales() {
		List<EntityList> r = null;
		try {
			r = caseMapper.getSales();
		} catch (Exception e) {
			logger.error("CaseService.getSales() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 获得地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSalesByAgency(String destination) {
		List<EntityList> r = null;
		try {
			r = caseMapper.getSalesByAgency(destination);
		} catch (Exception e) {
			logger.error("CaseService.getSalesByAgency() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新询单信息
	 * 
	 * @param case
	 * @return
	 */
	public boolean updateCase(Case crmcase) {

		boolean r = false;

		try {
			Case u = caseMapper.getCaseById(crmcase.getCaseId());
			if (u != null) {
				u.setOperator(crmcase.getOperator());
				u.setAdult(crmcase.getAdult());
				u.setBaby(crmcase.getBaby());
				u.setBudget(crmcase.getBudget());
				u.setChildren(crmcase.getChildren());
				u.setContactType(crmcase.getContactType());
				u.setDestination(crmcase.getDestination());
				u.setDuring(crmcase.getDuring());
				u.setFlight(crmcase.getFlight());
				u.setGuide(crmcase.getGuide());
				u.setHotel(crmcase.getHotel());
				u.setIpAddress(crmcase.getIpAddress());
				u.setMeals(crmcase.getMeals());
				u.setPassport(crmcase.getPassport());
				u.setPreferLanguage(crmcase.getPreferLanguage());
				u.setRequirement(crmcase.getRequirement());
				u.setRoute(crmcase.getRoute());
				u.setSalesId(crmcase.getSalesId());
				u.setSource(crmcase.getSource());				
				u.setSubmitType(crmcase.getSubmitType());
				u.setTailormade(crmcase.getTailormade());
				u.setStatus(crmcase.getStatus());
				u.setVisa(crmcase.getVisa());
				u.setWithwho(crmcase.getWithwho());
				u.setStartTime(crmcase.getStartTime());
				if(crmcase.getStartTime().equals("1")){
					u.setStartDate(crmcase.getStartDate());
					u.setEndDate(crmcase.getEndDate());
				}
				if(crmcase.getStartTime().equals("0")){
					u.setStartMonth(crmcase.getStartMonth());
					u.setDuring(crmcase.getDuring());
				}
				caseMapper.updateCase(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + crmcase + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 询单生成订单时更改询单状态
	 * 
	 * @param case
	 * @return
	 */
	public boolean case2order(int id) {

		boolean r = false;

		try {
			Case u = caseMapper.getCaseById(id);
			if (u != null) {
				u.setStatus("2");
				caseMapper.updateCase(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}
	
	/**
	 * 新增询单
	 * 
	 * @param case
	 * @return
	 */
	public int casestatus(int id) {
		int i = caseMapper.caseStatus(id);
		return i;
	}
	/**
	 * 询单失效
	 * 
	 * @param case_id
	 * @return
	 */
	public boolean deleteCaseById(int caseid) {

		boolean r = false;

		try {
			caseMapper.deleteCaseById(caseid);
			r = true;
		} catch (Exception e) {
			logger.error("CaseService.deleteCaseById() --> " + caseid + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}
	
	public Case validateStartTime(Case u){
		String startTime = u.getStartTime();
		if(startTime==null||startTime.isEmpty()||Integer.parseInt(startTime)!=1){
			u.setStartTime("0");
		}
		return u;
	}

	public Case getCaseByOrderId(int orderid) {
		Case r = null;
		try {
			r = caseMapper.getCaseByOrderId(orderid);
		} catch (Exception e) {
			logger.error("CaseService.getCaseByOrderId() --> " + orderid + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

}