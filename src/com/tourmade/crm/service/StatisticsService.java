package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;


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
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.AgencyAchievementStats;
import com.tourmade.crm.entity.AgencyOrderStatus;
import com.tourmade.crm.entity.CaseAllotStats;
import com.tourmade.crm.entity.CaseSourceStats;
import com.tourmade.crm.entity.CustomerSourceLevelStats;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.SellerCoverStats;
import com.tourmade.crm.entity.SellerNotAskStats;
import com.tourmade.crm.entity.SellerNotAskStatsD;
import com.tourmade.crm.entity.AgencyAchievementStatsM;
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
	
	/**
	 * 地接社业绩统计表，分页展示
	 * 
	 * @param AgencyOrderStatus
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<AgencyOrderStatus> queryAgencyOrderStatus(AgencyOrderStatus agencyOrderStatus, PageHelper ph, HttpServletRequest request) {

		QueryResult<AgencyOrderStatus> length = new QueryResult<AgencyOrderStatus>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//分页条件
		if(agencyOrderStatus.getSearchStartTime()!=null){
			agencyOrderStatus.setSearchStartTime(agencyOrderStatus.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", agencyOrderStatus.getSearchStartTime());
		}
		if(agencyOrderStatus.getSearchEndTime()!=null){
			agencyOrderStatus.setSearchEndTime(agencyOrderStatus.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", agencyOrderStatus.getSearchEndTime());
		}
		if(agencyOrderStatus.getDestination()!=null){
			map.put("destination", agencyOrderStatus.getDestination());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<AgencyOrderStatus> data = statisticsMapper.queryAgencyOrderStatus(map);
		long count = statisticsMapper.countAgencyOrderStatus(agencyOrderStatus);
			
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
	
		return length;
	}
	
	/**
	 * 询单来源统计
	 * 
	 * @param CaseSourceStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<CaseSourceStats> queryCaseSourceStats(CaseSourceStats caseSourceStats, PageHelper ph, HttpServletRequest request) {

		QueryResult<CaseSourceStats> length = new QueryResult<CaseSourceStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//分页条件
		if(caseSourceStats.getSearchStartTime()!=null){
			caseSourceStats.setSearchStartTime(caseSourceStats.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", caseSourceStats.getSearchStartTime());
		}
		if(caseSourceStats.getSearchEndTime()!=null){
			caseSourceStats.setSearchEndTime(caseSourceStats.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", caseSourceStats.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<CaseSourceStats> data = statisticsMapper.queryCaseSourceStats(map);
		long count = statisticsMapper.countCaseSourceStats(caseSourceStats);
			
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
	
		return length;
	}
	
	/**
	 * 询单分配统计
	 * 
	 * @param CaseSourceStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<CaseAllotStats> queryCaseAllotStats(CaseAllotStats caseAllotStats, PageHelper ph, HttpServletRequest request) {

		QueryResult<CaseAllotStats> length = new QueryResult<CaseAllotStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//分页条件
		if(caseAllotStats.getSearchStartTime()!=null){
			caseAllotStats.setSearchStartTime(caseAllotStats.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", caseAllotStats.getSearchStartTime());
		}
		if(caseAllotStats.getSearchEndTime()!=null){
			caseAllotStats.setSearchEndTime(caseAllotStats.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", caseAllotStats.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<CaseAllotStats> data = statisticsMapper.queryCaseAllotStats(map);
		long count = statisticsMapper.countCaseAllotStats(caseAllotStats);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
	
		return length;
	}

	/**
	 * 地接社业绩统计(成交率)
	 * 
	 * @param CaseSourceStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<AgencyAchievementStats> queryAgencyAchievementStats(AgencyAchievementStats agencyAchievementStats, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<AgencyAchievementStats> length = new QueryResult<AgencyAchievementStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//分页条件
		if(agencyAchievementStats.getSearchStartTime()!=null){
			agencyAchievementStats.setSearchStartTime(agencyAchievementStats.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", agencyAchievementStats.getSearchStartTime());
		}
		if(agencyAchievementStats.getSearchEndTime()!=null){
			agencyAchievementStats.setSearchEndTime(agencyAchievementStats.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", agencyAchievementStats.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<AgencyAchievementStats> data = statisticsMapper.queryAgencyAchievementStats(map);
		long count = statisticsMapper.countAgencyAchievementStats(agencyAchievementStats);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/**
	 * 地接社业绩统计(成交额)
	 * 
	 * @param CaseSourceStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<AgencyAchievementStatsM> queryAgencyAchievementStatsM(AgencyAchievementStatsM agencyAchievementStatsM, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<AgencyAchievementStatsM> length = new QueryResult<AgencyAchievementStatsM>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//分页条件
		if(agencyAchievementStatsM.getSearchStartTime()!=null){
			agencyAchievementStatsM.setSearchStartTime(agencyAchievementStatsM.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", agencyAchievementStatsM.getSearchStartTime());
		}
		if(agencyAchievementStatsM.getSearchEndTime()!=null){
			agencyAchievementStatsM.setSearchEndTime(agencyAchievementStatsM.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", agencyAchievementStatsM.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<AgencyAchievementStatsM> data = statisticsMapper.queryAgencyAchievementStatsM(map);
		long count = statisticsMapper.countAgencyAchievementStatsM(agencyAchievementStatsM);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/**
	 * 商家覆盖统计
	 * 
	 * @param SellerCoverStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<SellerCoverStats> querySellerCoverStats(SellerCoverStats sellerCoverStats, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<SellerCoverStats> length = new QueryResult<SellerCoverStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<SellerCoverStats> data = statisticsMapper.querySellerCoverStats(map);
		long count = statisticsMapper.countSellerCoverStats(sellerCoverStats);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/**
	 * 商家未询统计(列出没有询单的目的地，包括目的地名称和包含地接社数量)
	 * 
	 * @param SellerNotAskStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<SellerNotAskStats> querySellerNotAskStats(SellerNotAskStats sellerNotAskStats, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<SellerNotAskStats> length = new QueryResult<SellerNotAskStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(sellerNotAskStats.getSearchStartTime()!=null){
			sellerNotAskStats.setSearchStartTime(sellerNotAskStats.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", sellerNotAskStats.getSearchStartTime());
		}
		if(sellerNotAskStats.getSearchEndTime()!=null){
			sellerNotAskStats.setSearchEndTime(sellerNotAskStats.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", sellerNotAskStats.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<SellerNotAskStats> data = statisticsMapper.querySellerNotAskStats(map);
		long count = statisticsMapper.countSellerNotAskStats(sellerNotAskStats);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/**
	 * 商家未询统计(列出没有订单的地接社，包含地接社名称和服务国家)
	 * 
	 * @param SellerNotAskStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<SellerNotAskStatsD> querySellerNotAskStatsD(SellerNotAskStatsD sellerNotAskStatsD, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<SellerNotAskStatsD> length = new QueryResult<SellerNotAskStatsD>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(sellerNotAskStatsD.getSearchStartTime()!=null){
			sellerNotAskStatsD.setSearchStartTime(sellerNotAskStatsD.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", sellerNotAskStatsD.getSearchStartTime());
		}
		if(sellerNotAskStatsD.getSearchEndTime()!=null){
			sellerNotAskStatsD.setSearchEndTime(sellerNotAskStatsD.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", sellerNotAskStatsD.getSearchEndTime());
		}
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<SellerNotAskStatsD> data = statisticsMapper.querySellerNotAskStatsD(map);
		long count = statisticsMapper.countSellerNotAskStatsD(sellerNotAskStatsD);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/**
	 * 客人来级别统计
	 * 
	 * @param CustomerSourceLevelStats
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<CustomerSourceLevelStats> queryCustomerSourceLevelStats(CustomerSourceLevelStats customerSourceLevelStats, PageHelper ph, HttpServletRequest request) {
		
		QueryResult<CustomerSourceLevelStats> length = new QueryResult<CustomerSourceLevelStats>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());
		
		List<CustomerSourceLevelStats> data = statisticsMapper.queryCustomerSourceLevelStats(map);
		long count = statisticsMapper.countCustomerSourceLevelStats(customerSourceLevelStats);
		
		length.setData(data);
		length.setCountTotal(count);
		length.setCountFiltered(count);
		
		return length;
	}
	
	/*public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> agencyAchievement = null;
		try {
			agencyAchievement = statisticsMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("StatisticsService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			agencyAchievement = null;
		}
		return agencyAchievement;
	}*/
}
