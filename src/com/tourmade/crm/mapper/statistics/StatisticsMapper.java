package com.tourmade.crm.mapper.statistics;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
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

public interface StatisticsMapper extends BaseMapper{

	public List<AgencyOrderStatus> queryAgencyOrderStatus(Map<String, Object> params);
	
	public List<CaseSourceStats> queryCaseSourceStats(Map<String, Object> params);
	
	public List<CaseAllotStats> queryCaseAllotStats(Map<String, Object> params);
	
	public List<AgencyAchievementStats> queryAgencyAchievementStats(Map<String, Object> params);
	
	public List<AgencyAchievementStatsM> queryAgencyAchievementStatsM(Map<String, Object> params);
	
	public List<SellerCoverStats> querySellerCoverStats(Map<String, Object> params);
	
	public List<SellerNotAskStats> querySellerNotAskStats(Map<String, Object> params);
	
	public List<SellerNotAskStatsD> querySellerNotAskStatsD(Map<String, Object> params);
	
	public List<CustomerSourceLevelStats> queryCustomerSourceLevelStats(Map<String, Object> params);
	
	public long countAgencyOrderStatus(AgencyOrderStatus agencyOrderStatus);
	
	public long countCaseSourceStats(CaseSourceStats caseSourceStats);
	
	public long countCaseAllotStats(CaseAllotStats caseAllotStats);
	
	public long countAgencyAchievementStatsM(AgencyAchievementStatsM agencyAchievementStatsM);
	
	public long countAgencyAchievementStats(AgencyAchievementStats agencyAchievementStats);
	
	public long countSellerCoverStats(SellerCoverStats sellerCoverStats);
	
	public long countSellerNotAskStats(SellerNotAskStats sellerNotAskStats);
	
	public long countSellerNotAskStatsD(SellerNotAskStatsD sellerNotAskStatsD);
	
	public long countCustomerSourceLevelStats(CustomerSourceLevelStats customerSourceLevelStats);
	
	public List<EntityList> getParameterInfo(String domain);
}
