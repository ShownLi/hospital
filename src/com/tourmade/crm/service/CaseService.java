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
	 * 查询地接社数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoCase> queryCase(DemoCase crmcase, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoCase> r = new QueryResult<DemoCase>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == crmcase) {
				crmcase = new DemoCase();
			}
			crmcase.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", crmcase);
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
	 * 新增地接社
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
	 * 根据主键获取地接社信息
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
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param case
	 * @return
	 */
	public boolean updateCase(DemoCase crmcase) {

		boolean r = false;

		try {
			DemoCase u = caseMapper.getCaseById(crmcase.getCaseid());
			if (u != null) {
				u.setStatus(crmcase.getStatus());
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
	 * 删除地接社（假删除）
	 * 
	 * @param case_id
	 * @return
	 */
	public boolean deleteCaseById(int case_id) {

		boolean r = false;

		try {
			caseMapper.deleteCaseById(case_id);
			r = true;
		} catch (Exception e) {
			logger.error("CaseService.deleteCaseById() --> " + case_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}