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
import com.tourmade.crm.entity.Parameter;
import com.tourmade.crm.mapper.parameter.ParameterMapper;

@Service
@Transactional(readOnly = false)
public class ParameterService extends BaseService {

	@Autowired
	private ParameterMapper parameterMapper;

	/**
	 * 查询系统参数数据，分页展示
	 * 
	 * @param parameter
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Parameter> queryParameter(Parameter parameter, PageHelper pageHelper, HttpServletRequest request) {

		QueryResult<Parameter> pageResult = new QueryResult<Parameter>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", pageHelper.getStart());
		
		map.put("length", pageHelper.getLength());
		if(parameter.getDomain()!=null){
			map.put("domain", parameter.getDomain());
		}
		
		if(parameter.getValue()!=null){
			map.put("value", parameter.getValue());
		}
		
		if(parameter.getChinese()!=null){
			map.put("chinese", parameter.getChinese());
		}
		
		if(parameter.getEnglish()!=null){
			map.put("english", parameter.getEnglish());
		}
		System.out.println(map);
		System.out.println(parameter);
		List<Parameter> data = parameterMapper.queryParameter(map);
		long count = parameterMapper.countParameter(parameter);
		
		pageResult.setData(data);
		pageResult.setCountTotal(count);
		pageResult.setCountFiltered(count);
		
		return pageResult;
	}

	/**
	 * 新增系统参数
	 * 
	 * @param parameter
	 * @return
	 */
	public int saveParameter(Parameter parameter) {

		try {
			parameterMapper.saveParameter(parameter);
		} catch (Exception e) {
			logger.error("ParameterService.saveParameter() --> " + parameter + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return parameter.getParameterId();
	}

	/**
	 * 根据主键获取系统参数信息
	 * 
	 * @param id
	 * @return
	 */
	public Parameter getParameterById(int parameterId) {
		Parameter parameter = null;
		try {
			parameter = parameterMapper.getParameterById(parameterId);
		} catch (Exception e) {
			logger.error("ParameterService.getParameterById() --> " + parameterId + "-->" + e.getMessage());
			parameter = null;
		}
		return parameter;
	}

	/**
	 * 更新系统参数信息(不修改密码)
	 * 
	 * @param parameter
	 * @return
	 */
	public void updateParameter(Parameter parameter) {
		try {
			parameterMapper.updateParameter(parameter);
		} catch (Exception e) {
			logger.error("ParameterService.updateParameter() --> " + parameter + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除系统参数（假删除）
	 * 
	 * @param parameterId
	 * @return
	 */
	public void deleteParameterById(int parameterId) {
		try {
			parameterMapper.deleteParameterById(parameterId);
		} catch (Exception e) {
			logger.error("ParameterService.deleteParameterById() --> " + parameterId + "-->" + e.getMessage());
		}
	}
}
