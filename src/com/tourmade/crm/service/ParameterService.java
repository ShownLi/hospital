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
import com.tourmade.crm.mapper.parameter.DemoParameterMapper;
import com.tourmade.crm.model.DemoParameter;

@Service
@Transactional(readOnly = false)
public class ParameterService extends BaseService {

	@Autowired
	private DemoParameterMapper parameterMapper;

	/**
	 * 查询系统参数数据，分页展示
	 * 
	 * @param parameter
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoParameter> queryParameter(DemoParameter parameter, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoParameter> r = new QueryResult<DemoParameter>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == parameter) {
				parameter = new DemoParameter();
			}
			parameter.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", parameter);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoParameter> data = parameterMapper.queryParameter(map);
		long count = parameterMapper.countParameter(parameter);
		
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);

		return r;
	}

	/**
	 * 新增系统参数
	 * 
	 * @param parameter
	 * @return
	 */
	public int saveParameter(DemoParameter parameter) {
		// parameter.setPwd("123456");
		// parameter.setPwd(MD5.MD5Encode("123456"));
		try {
			parameterMapper.saveParameter(parameter);
		} catch (Exception e) {
			logger.error("ParameterService.saveParameter() --> " + parameter + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return parameter.getParameterid();
	}

	/**
	 * 根据主键获取系统参数信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoParameter getParameterById(int id) {
		DemoParameter r = null;
		try {
			r = parameterMapper.getParameterById(id);
		} catch (Exception e) {
			logger.error("ParameterService.getParameterById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 更新系统参数信息(不修改密码)
	 * 
	 * @param parameter
	 * @return
	 */
	public boolean updateParameter(DemoParameter parameter) {

		boolean r = false;

		try {
			DemoParameter u = parameterMapper.getParameterById(parameter.getParameterid());
			if (u != null) {
				u.setDomain(parameter.getDomain());
				u.setValue(parameter.getValue());
				u.setChinese(parameter.getChinese());
				u.setEnglish(parameter.getEnglish());
				u.setDescribe(parameter.getDescribe());
				u.setSort(parameter.getSort());
				u.setIsdisplay(parameter.getIsdisplay());
				// u.setPwd(parameter.getPwd());
				parameterMapper.updateParameter(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("ParameterService.updateParameter() --> " + parameter + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除系统参数（假删除）
	 * 
	 * @param parameterid
	 * @return
	 */
	public boolean deleteParameterById(int parameterid) {

		boolean r = false;

		try {
			parameterMapper.deleteParameterById(parameterid);
			r = true;
		} catch (Exception e) {
			logger.error("ParameterService.deleteParameterById() --> " + parameterid + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}
}
