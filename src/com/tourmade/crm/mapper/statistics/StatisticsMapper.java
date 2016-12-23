package com.tourmade.crm.mapper.statistics;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.ContactRealStats;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.ReasonOfDrainingStats;
import com.tourmade.crm.entity.UserAchRate;
import com.tourmade.crm.entity.UserAchievement;

public interface StatisticsMapper extends BaseMapper{

	/**
	 * 根据作用域获取参数
	 * @param domain
	 * @return
	 */
	List<EntityList> getParameterInfo(String domain);

	List<UserAchievement> queryUserAchievementStats(Map<String, Object> map);

	long countAllUsers();

	List<ContactRealStats> queryContactReal(Map<String, Object> map);

	long countAllContact(Map<String, Object> map);
	/**
	 * 获取无效询单统计数据
	 * @param map
	 * @return
	 */
	List<ReasonOfDrainingStats> queryReasonOfDraining(Map<String, Object> map);

	/**
	 * 计算一段时间内的无效询单总数
	 * @param map 
	 * @return
	 */
	long countCaseInvalid(Map<String, Object> map);

	List<ReasonOfDrainingStats> queryReasonOfDrainingNoDeal(Map<String, Object> map);

	long countCaseNoDeal(Map<String, Object> map);

	List<UserAchRate> queryUserAchiRate(Map<String, Object> map);

	long countCaseAllUsers(Map<String, Object> map);

	List<UserAchRate> queryUserAchiMoney(Map<String, Object> map);

	long countOrderAllUsers(Map<String, Object> map);

	List<UserAchievement> queryDesCaseStatus(Map<String, Object> map);

	long countCaseAllDes(Map<String, Object> map);

	List<UserAchRate> queryDesAchiRate(Map<String, Object> map);

	List<UserAchRate> queryDesAchiMoney(Map<String, Object> map);

	long countOrderAllDes(Map<String, Object> map);

	/**
	 * 计算合计
	 * @param map
	 * @return
	 */
	UserAchRate queryDesAchiRateSum(Map<String, Object> map);

	UserAchRate queryDesAchiMoneySum(Map<String, Object> map);

	List<UserAchRate> queryCustSource(Map<String, Object> map);

	long countAllCoustSource(Map<String, Object> map);

	List<UserAchRate> queryDesAchiCaseCount(Map<String, Object> map);

}
