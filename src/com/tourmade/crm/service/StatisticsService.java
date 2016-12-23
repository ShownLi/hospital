package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.entity.ContactRealStats;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.ReasonOfDrainingStats;
import com.tourmade.crm.entity.UserAchRate;
import com.tourmade.crm.entity.UserAchievement;
import com.tourmade.crm.mapper.statistics.StatisticsMapper;
@Service
@Transactional(readOnly = false)
public class StatisticsService extends BaseService {

	@Autowired
	private StatisticsMapper statisticsMapper;

	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> para = null;
		try {
			para = statisticsMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("StatisticsService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			para = null;
		}
		return para;
	}

	public QueryResult<UserAchievement> queryUserAchievementStats(Map<String, Object> map) {
		
		QueryResult<UserAchievement> result = new QueryResult<UserAchievement>();
		
		List<UserAchievement> data = statisticsMapper.queryUserAchievementStats(map);
		long count = statisticsMapper.countCaseAllUsers(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	public QueryResult<ContactRealStats> queryContactReal(Map<String, Object> map) {
		QueryResult<ContactRealStats> result = new QueryResult<ContactRealStats>();

		List<ContactRealStats> data = statisticsMapper.queryContactReal(map);
		long count = statisticsMapper.countAllContact(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);

		return result;
	}

	public QueryResult<ReasonOfDrainingStats> queryReasonOfDraining(Map<String, Object> map) {
		QueryResult<ReasonOfDrainingStats> result = new QueryResult<ReasonOfDrainingStats>();
		List<ReasonOfDrainingStats> data = statisticsMapper.queryReasonOfDraining(map);
		//查询所给定时间段的所有无效信息
		long total = statisticsMapper.countCaseInvalid(map);
		//查询出给定时间段的无效原因的条目数
		long count = 0;
		if(data!=null){
			count = data.size();
			for(ReasonOfDrainingStats r:data){
				double temp = r.getNum();
				double result1 =temp/total*100;
				r.setPercent(String.format("%.2f", result1)+"%");
			}
		}else{
			
			count = 0;
		}
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<ReasonOfDrainingStats> queryReasonOfDrainingNoDeal(Map<String, Object> map) {
		QueryResult<ReasonOfDrainingStats> result = new QueryResult<ReasonOfDrainingStats>();
		List<ReasonOfDrainingStats> data = statisticsMapper.queryReasonOfDrainingNoDeal(map);
		//查询所给定时间段的所有无效信息
		long total = statisticsMapper.countCaseNoDeal(map);
		//查询出给定时间段的无效原因的条目数
		long count = 0;
		if(data!=null){
			count = data.size();
			for(ReasonOfDrainingStats r:data){
				double temp = r.getNum();
				double result1 =temp/total*100;
				r.setPercent(String.format("%.2f", result1)+"%");
			}
		}else{
			
			count = 0;
		}
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchRate> queryUserAchiRate(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryUserAchiRate(map);
		long count = statisticsMapper.countCaseAllUsers(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchRate> queryUserAchiMoney(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryUserAchiMoney(map);
		long count = statisticsMapper.countOrderAllUsers(map);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchievement> queryDesCaseStatus(Map<String, Object> map) {
		QueryResult<UserAchievement> result = new QueryResult<UserAchievement>();
		
		List<UserAchievement> data = statisticsMapper.queryDesCaseStatus(map);
		long count = statisticsMapper.countCaseAllDes(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiRate(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryDesAchiRate(map);
		long count = statisticsMapper.countCaseAllDes(map);
		
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiMoney(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryDesAchiMoney(map);
		UserAchRate rate=statisticsMapper.queryDesAchiMoneySum(map);
		
		long count = statisticsMapper.countOrderAllDes(map);
		if(rate!=null){
		rate.setUserName("合计");
		data.add(rate);
		count++;
		}
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchRate> queryCustSource(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryCustSource(map);
		long count = statisticsMapper.countAllCoustSource(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiCaseCount(Map<String, Object> map) {
		QueryResult<UserAchRate> result = new QueryResult<UserAchRate>();
		List<UserAchRate> data = statisticsMapper.queryDesAchiCaseCount(map);
		long count = statisticsMapper.countCaseAllDes(map);
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
		return result;
	}
}
