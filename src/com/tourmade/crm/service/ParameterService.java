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
	private DemoParameterMapper ParameterMapper;

	/**
	 * 查询地接社数据，分页展示
	 * 
	 * @param Parameter
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoParameter> queryParameter(DemoParameter Parameter, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoParameter> r = new QueryResult<DemoParameter>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == Parameter) {
				Parameter = new DemoParameter();
			}
			Parameter.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", Parameter);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoParameter> data = ParameterMapper.queryParameter(map);
		long count = ParameterMapper.countParameter(Parameter);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);

		
		
		return r;
	}

	/**
	 * 新增地接社
	 * 
	 * @param Parameter
	 * @return
	 */
	public int saveParameter(DemoParameter Parameter) {

		try {
			ParameterMapper.saveParameter(Parameter);
		} catch (Exception e) {
			logger.error("ParameterService.saveParameter() --> " + Parameter + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return Parameter.getParameter_id();
	}

	/**
	 * 根据主键获取地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoParameter getParameterById(int id) {
		DemoParameter r = null;
		try {
			r = ParameterMapper.getParameterById(id);
		} catch (Exception e) {
			logger.error("ParameterService.getParameterById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param Parameter
	 * @return
	 */
	public boolean updateParameter(DemoParameter Parameter) {

		boolean r = false;

		try {
			DemoParameter u = ParameterMapper.getParameterById(Parameter.getParameter_id());
			if (u != null) {
				ParameterMapper.updateParameter(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("ParameterService.updateParameter() --> " + Parameter + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param Parameter_id
	 * @return
	 */
	public boolean deleteParameterById(int Parameter_id) {

		boolean r = false;

		try {
			ParameterMapper.deleteParameterById(Parameter_id);
			r = true;
		} catch (Exception e) {
			logger.error("ParameterService.deleteParameterById() --> " + Parameter_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}