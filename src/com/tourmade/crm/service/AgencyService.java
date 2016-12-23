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
import com.tourmade.crm.entity.Agency;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.mapper.agency.AgencyMapper;

@Service
@Transactional(readOnly = false)
public class AgencyService extends BaseService {
	
	@Autowired
	private AgencyMapper agencyMapper;

	/**
	 * 查询地接社数据，分页展示
	 */
	public QueryResult<Agency> queryAgency(Agency agency, PageHelper pageHelper, HttpServletRequest request) {

		QueryResult<Agency> result = new QueryResult<Agency>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", pageHelper.getStart());
		map.put("length", pageHelper.getLength());
		
		if(agency.getName()!=null){
			map.put("name",agency.getName());
		}
			
		if(agency.getCountry()!=null){
		map.put("country", agency.getCountry());
		}
		
		if(agency.getDestination()!=null){
			map.put("destination", agency.getDestination());
		}
		List<Agency> data = agencyMapper.queryAgency(map);
		long count = agencyMapper.countAgency(agency);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	/**
	 * 新增地接社
	 */
	public int saveAgency(Agency agency) {

		try {
			agencyMapper.saveAgency(agency);
		} catch (Exception e) {
			logger.error("AgencyService.saveAgency() --> " + agency + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return agency.getAgencyId();
	}

	/**
	 * 根据主键获取地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public Agency getAgencyById(int agencyId) {
		Agency agency = null;
		try {
			agency = agencyMapper.getAgencyById(agencyId);
		} catch (Exception e) {
			logger.error("AgencyService.getAgencyById() --> " + agencyId + "-->" + e.getMessage());
			agency = null;
		}
		return agency;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> result = null;
		try {
			result = agencyMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("AgencyService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			result = null;
		}
		return result;
	}
	
	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param agency
	 * @return zyy 10-19
	 */
	public void updateAgency(Agency agency) {

		try {
			agencyMapper.updateAgency(agency);
		} catch (Exception e) {
			logger.error("AgencyService.updateAgency() --> " + agency + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param agency_id
	 * @return zyy 10-19
	 */
	public void deleteAgencyById(int agencyId) {
		try {
			agencyMapper.deleteAgencyById(agencyId);
		} catch (Exception e) {
			logger.error("AgencyService.deleteAgencyById() --> " + agencyId + "-->" + e.getMessage());
		}
	}

}