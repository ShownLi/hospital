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
	 * 
	 * @param agency
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Agency> queryAgency(Agency agency, PageHelper ph, HttpServletRequest request) {

		QueryResult<Agency> r = new QueryResult<Agency>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Agency> data = agencyMapper.queryAgency(map);
		long count = agencyMapper.countAgency(agency);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}

	/**
	 * 新增地接社
	 * 
	 * @param agency
	 * @return
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
	public Agency getAgencyById(int id) {
		Agency r = null;
		try {
			r = agencyMapper.getAgencyById(id);
		} catch (Exception e) {
			logger.error("AgencyService.getAgencyById() --> " + id + "-->" + e.getMessage());
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
			r = agencyMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("AgencyService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param agency
	 * @return
	 */
	public boolean updateAgency(Agency agency) {

		boolean r = false;

		try {
			Agency u = agencyMapper.getAgencyById(agency.getAgencyId());
			if (u != null) {
				u.setName(agency.getName());
				u.setCountry(agency.getCountry());
				u.setLanguage(agency.getLanguage());
				agencyMapper.updateAgency(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("AgencyService.updateAgency() --> " + agency + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param agency_id
	 * @return
	 */
	public boolean deleteAgencyById(int agency_id) {

		boolean r = false;

		try {
			agencyMapper.deleteAgencyById(agency_id);
			r = true;
		} catch (Exception e) {
			logger.error("AgencyService.deleteAgencyById() --> " + agency_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}