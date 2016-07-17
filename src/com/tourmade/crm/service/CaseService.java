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
import com.tourmade.crm.mapper.crmcase.DemoCaseMapper;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoList;

@Service
@Transactional(readOnly = false)
public class CaseService extends BaseService {
	
	@Autowired
	private DemoCaseMapper caseMapper;

	/**
	 * 查询询单数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoCase> queryCase(DemoCase crmcase, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoCase> r = new QueryResult<DemoCase>();
		Map<String, Object> map = new HashMap<String, Object>();


		
//		map.put("customerid", customerid);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoCase> data = caseMapper.queryCase(map);
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
	public QueryResult<DemoCase> queryCaseFromCustomer(DemoCase crmcase, int customerid, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoCase> r = new QueryResult<DemoCase>();
		Map<String, Object> map = new HashMap<String, Object>();


		
		map.put("customerid", customerid);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoCase> data = caseMapper.queryCase(map);
		long count = caseMapper.countCase(crmcase);
			
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
	public int saveCase(DemoCase crmcase) {

		
		try {
			caseMapper.saveCase(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.saveCase() --> " + crmcase + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return crmcase.getCaseid();
	}

	/**
	 * 根据主键获取询单信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoCase getCaseById(int id) {
		DemoCase r = null;
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
	public List<DemoList> getParameterInfo(String domain) {
		List<DemoList> r = null;
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
	public List<DemoList> getCustomer() {
		List<DemoList> r = null;
		try {
			r = caseMapper.getCustomer();
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 获得用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<DemoList> getUser() {
		List<DemoList> r = null;
		try {
			r = caseMapper.getUser();
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
	public List<DemoList> getSales() {
		List<DemoList> r = null;
		try {
			r = caseMapper.getSales();
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新询单信息(不修改密码)
	 * 
	 * @param case
	 * @return
	 */
	public boolean updateCase(DemoCase crmcase) {

		boolean r = false;

		try {
			DemoCase u = caseMapper.getCaseById(crmcase.getCaseid());
			if (u != null) {
				u.setAdult(crmcase.getAdult());
				u.setBaby(crmcase.getBaby());
				u.setBudget(crmcase.getBudget());
				u.setChildren(crmcase.getChildren());
				u.setContacttype(crmcase.getContacttype());
				u.setDestination(crmcase.getDestination());
				u.setDuring(crmcase.getDuring());
				u.setFlight(crmcase.getFlight());
				u.setGuide(crmcase.getGuide());
				u.setHotel(crmcase.getHotel());
				u.setIpaddress(crmcase.getIpaddress());
				u.setMeals(crmcase.getMeals());
				u.setPassport(crmcase.getPassport());
				u.setPreferlanguage(crmcase.getPreferlanguage());
				u.setRequirement(crmcase.getRequirement());
				u.setRoute(crmcase.getRoute());
				u.setSalesid(crmcase.getSalesid());
				u.setSource(crmcase.getSource());				
				u.setSubmittype(crmcase.getSubmittype());
				u.setTailormade(crmcase.getTailormade());
				u.setStatus(crmcase.getStatus());
				u.setVisa(crmcase.getVisa());
				u.setWithwho(crmcase.getWithwho());
				u.setStarttime(crmcase.getStarttime());
				if(crmcase.getStarttime().equals("1")){
					u.setStartdate(crmcase.getStartdate());
					u.setEnddate(crmcase.getEnddate());
				}
				if(crmcase.getStarttime().equals("0")){
					u.setStartmonth(crmcase.getStartmonth());
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
	 * 更新询单信息(不修改密码)
	 * 
	 * @param case
	 * @return
	 */
	public boolean case2order(int id) {

		boolean r = false;

		try {
			DemoCase u = caseMapper.getCaseById(id);
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

}