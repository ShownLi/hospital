package com.tourmade.crm.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.framework.util.JSONUtilS;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.csv.CSVUtil;
import com.tourmade.crm.entity.AgencyAchievementStats;
import com.tourmade.crm.entity.AgencyOrderStatus;
import com.tourmade.crm.entity.CaseAllotStats;
import com.tourmade.crm.entity.CaseSourceStats;
import com.tourmade.crm.entity.ContactRealStats;
import com.tourmade.crm.entity.CustomerSourceLevelStats;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.ReasonOfDrainingStats;
import com.tourmade.crm.entity.SellerCoverStats;
import com.tourmade.crm.entity.SellerNotAskStats;
import com.tourmade.crm.entity.SellerNotAskStatsD;
import com.tourmade.crm.entity.UserAchRate;
import com.tourmade.crm.entity.UserAchievement;
import com.tourmade.crm.service.StatisticsService;

import net.sf.json.JSONArray;

/**
 * 统计分析类
 * 
 * @author fjw
 *
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseSimpleFormController {
	@Autowired
	private StatisticsService service;

	/**
	 * 跟单员询单状态统计
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/usercasestatusstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String userAchievementStatsView(Model model) {
		String source = "case.source";
		List<EntityList> sourceList = service.getParameterInfo(source);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		model.addAttribute("source", sourceResult);
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/userCaseStatusStats";
	}

	/**
	 * 跟单员dateTables请求
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param customerId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/usercasestatusstats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(PageHelper page, String startCreateDateTime, String endCreateDateTime, String source) {
		QueryResult<UserAchievement> userAchievementList = queryUserCaseStatusMethod(startCreateDateTime,
				endCreateDateTime, source);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}

	public QueryResult<UserAchievement> queryUserCaseStatusMethod(String startCreateDateTime, String endCreateDateTime,
			String source) {

		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		map.put("source", source);
		if (startCreateDateTime == null || startCreateDateTime.trim() == "") {
			startCreateDateTime = getLastMothFirstDay();
		}
		if (endCreateDateTime == null || endCreateDateTime.trim() == "") {
			endCreateDateTime = getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime + " 00:00:00");
		map.put("endCreateTime", endCreateDateTime + " 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryUserAchievementStats(map);
		QueryResult<UserAchievement> userAchievementList2 = service.queryUserAchievementStatsTotal(map);
		List<UserAchievement> data = userAchievementList2.getData();
		data.get(0).setUserName("合计");
		userAchievementList.getData().addAll(data);
		return userAchievementList;
	}

	/**
	 * 返回沟通方式统计界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contactrealstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String contactRealStatsView(Model model) {
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/contactRealStats";
	}

	/**
	 * 沟通方式请求方法
	 * 
	 * @param page
	 * @param startCreateDateTime
	 * @param endCreateDateTime
	 * @return
	 */
	@RequestMapping(value = "/contactrealstats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryContactReal(PageHelper page, String startCreateDateTime, String endCreateDateTime) {

		QueryResult<ContactRealStats> contactRealList = queryContactRealMethod(startCreateDateTime, endCreateDateTime);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}

	public QueryResult<ContactRealStats> queryContactRealMethod(String startCreateDateTime, String endCreateDateTime) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (startCreateDateTime == null || startCreateDateTime.trim() == "") {
			startCreateDateTime = getLastMothFirstDay();
		}
		if (endCreateDateTime == null || endCreateDateTime.trim() == "") {
			endCreateDateTime = getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime + " 00:00:00");
		map.put("endCreateTime", endCreateDateTime + " 23:59:59");
		QueryResult<ContactRealStats> contactRealList = service.queryContactReal(map);
		QueryResult<ContactRealStats> contactRealList2 = service.queryContactRealTotal(map);
		List<ContactRealStats> data = contactRealList2.getData();
		data.get(0).setContactName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 返回流失原因界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reasonofdrainingstats.html", method = { RequestMethod.POST, RequestMethod.GET })

	public String reasonOfDrainingView(Model model) {
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/reasonOfDrainingStats";
	}

	/**
	 * 无效原因dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reasonofdrainingstats1.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining1(PageHelper page, String startCreateDateTime, String endCreateDateTime) {

		QueryResult<ReasonOfDrainingStats> contactRealList = queryReasonOfDraining1Method(startCreateDateTime,
				endCreateDateTime);
		String result = JSONUtilS.object2json(contactRealList);

		return result;
	}

	public QueryResult<ReasonOfDrainingStats> queryReasonOfDraining1Method(String startCreateDateTime,
			String endCreateDateTime) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (startCreateDateTime == null || startCreateDateTime.trim() == "") {
			startCreateDateTime = getLastMothFirstDay();
		}
		if (endCreateDateTime == null || endCreateDateTime.trim() == "") {
			endCreateDateTime = getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime + " 00:00:00");
		map.put("endCreateTime", endCreateDateTime + " 23:59:59");
		QueryResult<ReasonOfDrainingStats> contactRealList = service.queryReasonOfDraining(map);
		QueryResult<ReasonOfDrainingStats> contactRealList2 = service.queryReasonOfDrainingTotal(map);
		List<ReasonOfDrainingStats> data = contactRealList2.getData();
		data.get(0).setReasonOfDrainingName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 未成行原因dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reasonofdrainingstats2.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining2(PageHelper page, String startCreateDateTime, String endCreateDateTime) {

		QueryResult<ReasonOfDrainingStats> contactRealList = queryReasonOfDraining2Method(startCreateDateTime,
				endCreateDateTime);
		String result = JSONUtilS.object2json(contactRealList);

		return result;
	}

	public QueryResult<ReasonOfDrainingStats> queryReasonOfDraining2Method(String startCreateDateTime,
			String endCreateDateTime) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (startCreateDateTime == null || startCreateDateTime.trim() == "") {
			startCreateDateTime = getLastMothFirstDay();
		}
		if (endCreateDateTime == null || endCreateDateTime.trim() == "") {
			endCreateDateTime = getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime + " 00:00:00");
		map.put("endCreateTime", endCreateDateTime + " 23:59:59");
		QueryResult<ReasonOfDrainingStats> contactRealList = service.queryReasonOfDrainingNoDeal(map);
		QueryResult<ReasonOfDrainingStats> contactRealList2 = service.queryReasonOfDrainingNoDealTotal(map);
		List<ReasonOfDrainingStats> data = contactRealList2.getData();
		data.get(0).setReasonOfDrainingName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 跟单员业绩统计
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userachievementstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String userAchievementStatsView2(Model model) {
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/userAchievementStats";
	}

	/**
	 * 跟单员成交率dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userachievementratestats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiRate(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryUserAchiRateMethod(searchYear);
		String result = JSONUtilS.object2json(contactRealList);

		return result;
	}

	public QueryResult<UserAchRate> queryUserAchiRateMethod(String searchYear) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryUserAchiRate(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryUserAchiRateTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 跟单员金额dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userachievementmoneystats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiMoney(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryUserAchiMoneyMethod(searchYear);
		String result = JSONUtilS.object2json(contactRealList);

		return result;
	}

	public QueryResult<UserAchRate> queryUserAchiMoneyMethod(String searchYear) {

		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryUserAchiMoney(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryUserAchiMoneyTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}


	/**
	 * 目的地询单状态统计
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/descasestatusstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String desCaseStatusStatsView(Model model) {
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/desCaseStatusStas";
	}

	/**
	 * 目的地dateTables请求
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param customerId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/descasestatusstats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryDesCaseStatus(PageHelper page, String startCreateDateTime, String endCreateDateTime) {
		QueryResult<UserAchievement> userAchievementList = queryDesCaseStatusMethod(startCreateDateTime,
				endCreateDateTime);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}

	public QueryResult<UserAchievement> queryDesCaseStatusMethod(String startCreateDateTime, String endCreateDateTime) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (startCreateDateTime == null || startCreateDateTime.trim() == "") {
			startCreateDateTime = getLastMothFirstDay();
		}
		if (endCreateDateTime == null || endCreateDateTime.trim() == "") {
			endCreateDateTime = getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime + " 00:00:00");
		map.put("endCreateTime", endCreateDateTime + " 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryDesCaseStatus(map);
		QueryResult<UserAchievement> userAchievementList2 = service.queryDesCaseStatusTotal(map);
		List<UserAchievement> data = userAchievementList2.getData();
		data.get(0).setUserName("合计");
		userAchievementList.getData().addAll(data);
		return userAchievementList;
	}

	/**
	 * 目的地成交统计
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/desachievementstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String desAchievementStatsView(Model model) {
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/desAchievementStats";
	}

	/**
	 * 目的地咨询数量dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/desachievementcountstats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiCaseCount(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryDesAchiCaseCountMethod(searchYear);
		changeCountryCodeToChinese(service, contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiCaseCountMethod(String searchYear) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiCaseCount(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryDesAchiCaseCountTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 目的地成交率dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/desachievementratestats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiRate(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryDesAchiRateMethod(searchYear);
		changeCountryCodeToChinese(service, contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiRateMethod(String searchYear) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiRate(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryDesAchiRateTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 目的地金额dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/desachievementmoneystats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiMoney(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryDesAchiMoneyMethod(searchYear);
		changeCountryCodeToChinese(service, contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}

	public QueryResult<UserAchRate> queryDesAchiMoneyMethod(String searchYear) {
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiMoney(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryDesAchiMoneyTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 客人来源统计
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/custsourcestats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String custSourceStatsView(Model model) {
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/custSourceStats";
	}

	/**
	 * 客人来源dataTables请求
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/custsourcestats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryCustSource(PageHelper page, String searchYear) {
		QueryResult<UserAchRate> contactRealList = queryCustSourceMethod(searchYear);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}

	public QueryResult<UserAchRate> queryCustSourceMethod(String searchYear) {
		// 设置查询参数
		Map<String, Object> map = new HashMap<>();
		if (searchYear == null || searchYear.trim() == "") {
			searchYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear + "-01-01 00:00:00");
		map.put("endCreateTime", searchYear + "-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryCustSource(map);
		QueryResult<UserAchRate> contactRealList2 = service.queryCustSourceTotal(map);
		List<UserAchRate> data = contactRealList2.getData();
		data.get(0).setUserName("合计");
		contactRealList.getData().addAll(data);
		return contactRealList;
	}

	/**
	 * 将多选的目的地，显示中文
	 * 
	 * @param service
	 * @param list
	 */
	public static void changeCountryCodeToChinese(StatisticsService service, QueryResult<UserAchRate> list) {
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		for (UserAchRate temp : list.getData()) {
			String str = temp.getCode();
			if ("".equals(str) || str == null) {
				continue;
			}
			if (str.contains(",")) {
				String[] coun = str.split(",");
				StringBuilder sb = new StringBuilder();
				for (String s : coun) {
					for (EntityList item : countryList) {
						if (s.equals(item.getId())) {
							sb.append(item.getText() + ",");
							break;
						}
					}
				}
				temp.setUserName(sb.toString().substring(0, sb.length() - 1));
			}
		}
	}

	// 返回上一个月第一天
	public static String getLastMothFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(calendar.getTime());
	}

	// 返回上一个月最后一天
	public static String getLastMothLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		return format.format(calendar.getTime());
	}

	// 地接社订单状态统计
	@RequestMapping(value = "/agencyOrderStatusStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list1(Model model) {

		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		JSONArray destinationResult = JSONArray.fromObject(countryList);
		model.addAttribute("destination", destinationResult);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 获取当前日期
		calendar.add(Calendar.MONTH, -1); // 设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为上月1号
		model.addAttribute("searchStartDateTime", format.format(calendar.getTime()));

		Calendar calendar1 = Calendar.getInstance(); // 获取当前日期
		calendar1.add(Calendar.MONTH, 0); // 设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0); // 设置为上月1号
		model.addAttribute("searchEndDateTime", format.format(calendar1.getTime()));

		return "/statistics/agencyOrderStatusStats";
	}

	@RequestMapping(value = "/agencyOrderStatusStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, AgencyOrderStatus agencyOrderStatus,
			Model model, PageHelper page) {

		QueryResult<AgencyOrderStatus> caseResult = queryAgencyOrderStatusMethod(request, agencyOrderStatus, page);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<AgencyOrderStatus> queryAgencyOrderStatusMethod(HttpServletRequest request,
			AgencyOrderStatus agencyOrderStatus, PageHelper page) {
		if (agencyOrderStatus.getSearchStartTime() == null) {
			agencyOrderStatus.setSearchStartTime("");
		}
		if (agencyOrderStatus.getSearchEndTime() == null) {
			agencyOrderStatus.setSearchEndTime("");
		}

		QueryResult<AgencyOrderStatus> caseResult = service.queryAgencyOrderStatus(agencyOrderStatus, page, request);
		
		QueryResult<AgencyOrderStatus> caseResult2 = service.queryAgencyOrderStatusTotal(agencyOrderStatus, page,
				request);
		List<AgencyOrderStatus> data = caseResult2.getData();
		data.get(0).setAgencyName("合计");
		caseResult.getData().addAll(data);
		
		return caseResult;

	}

	// 询单分配统计
	@RequestMapping(value = "/caseAllotStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list2(Model model) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 获取当前日期
		calendar.add(Calendar.MONTH, -1); // 设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为上月1号
		model.addAttribute("searchStartDateTime", format.format(calendar.getTime()));

		Calendar calendar1 = Calendar.getInstance(); // 获取当前日期
		calendar1.add(Calendar.MONTH, 0); // 设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0); // 设置为上月1号
		model.addAttribute("searchEndDateTime", format.format(calendar1.getTime()));

		return "/statistics/caseAllotStats";
	}

	@RequestMapping(value = "/caseAllotStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseAllotStats caseAllotStats, Model model,
			PageHelper page) {

		QueryResult<CaseAllotStats> caseResult = queryCaseAllotStatsMethod(request, caseAllotStats, page);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<CaseAllotStats> queryCaseAllotStatsMethod(HttpServletRequest request,
			CaseAllotStats caseAllotStats, PageHelper page) {
		if (caseAllotStats.getSearchStartTime() == null) {
			caseAllotStats.setSearchStartTime("");
		}
		if (caseAllotStats.getSearchEndTime() == null) {
			caseAllotStats.setSearchEndTime("");
		}

		QueryResult<CaseAllotStats> caseResult = service.queryCaseAllotStats(caseAllotStats, page, request);
		QueryResult<CaseAllotStats> caseResult2 = service.queryCaseAllotStatsTotal(caseAllotStats, page, request);
		List<CaseAllotStats> data = caseResult2.getData();
		data.get(0).setUserName("合计");
		caseResult.getData().addAll(data);
		return caseResult;

	}

	// 询单来源状态统计
	@RequestMapping(value = "/caseSourceStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list3(Model model) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 获取当前日期
		calendar.add(Calendar.MONTH, -1); // 设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为上月1号
		model.addAttribute("searchStartDateTime", format.format(calendar.getTime()));

		Calendar calendar1 = Calendar.getInstance(); // 获取当前日期
		calendar1.add(Calendar.MONTH, 0); // 设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0); // 设置为上月1号
		model.addAttribute("searchEndDateTime", format.format(calendar1.getTime()));

		return "/statistics/caseSourceStats";
	}

	@RequestMapping(value = "/caseSourceStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseSourceStats caseSourceStats,
			Model model, PageHelper page) {

		QueryResult<CaseSourceStats> caseResult = queryCaseSourceStatsMethod(request, caseSourceStats, page);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<CaseSourceStats> queryCaseSourceStatsMethod(HttpServletRequest request,
			CaseSourceStats caseSourceStats, PageHelper page) {
		if (caseSourceStats.getSearchStartTime() == null) {
			caseSourceStats.setSearchStartTime("");
		}
		if (caseSourceStats.getSearchEndTime() == null) {
			caseSourceStats.setSearchEndTime("");
		}

		QueryResult<CaseSourceStats> caseResult = service.queryCaseSourceStats(caseSourceStats, page, request);
		QueryResult<CaseSourceStats> caseResult2 = service.queryCaseSourceStatsTotal(caseSourceStats, page,
				request);
		List<CaseSourceStats> data = caseResult2.getData();
		data.get(0).setSourceName("合计");
		caseResult.getData().addAll(data);
		return caseResult;

	}

	// 地接社业绩统计(成交率)
	@RequestMapping(value = "/agencyAchievementStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list4(Model model) {
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));

		return "/statistics/agencyAchievementStats";
	}

	@RequestMapping(value = "/agencyAchievementStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session,
			AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {

		QueryResult<AgencyAchievementStats> caseResult = queryAgencyAchievementStatsMethod(request,
				agencyAchievementStats, page);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<AgencyAchievementStats> queryAgencyAchievementStatsMethod(HttpServletRequest request,
			AgencyAchievementStats agencyAchievementStats, PageHelper page) {
		if (agencyAchievementStats.getSearchStartTime() == null) {
			agencyAchievementStats.setSearchStartTime("");
		}
		if (agencyAchievementStats.getSearchEndTime() == null) {
			agencyAchievementStats.setSearchEndTime("");
		}

		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStats(agencyAchievementStats,
				page, request);
		QueryResult<AgencyAchievementStats> caseResult2 = service
				.queryAgencyAchievementStatsTotal(agencyAchievementStats, page, request);
		List<AgencyAchievementStats> data = caseResult2.getData();
		data.get(0).setAgencyName("合计");
		caseResult.getData().addAll(data);
		
		return caseResult;

	}

	public QueryResult<AgencyAchievementStats> queryAgencyAchievementStatsMMethod(HttpServletRequest request,
			AgencyAchievementStats agencyAchievementStats, PageHelper page) {
		if (agencyAchievementStats.getSearchStartTime() == null) {
			agencyAchievementStats.setSearchStartTime("");
		}
		if (agencyAchievementStats.getSearchEndTime() == null) {
			agencyAchievementStats.setSearchEndTime("");
		}

		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStatsM(agencyAchievementStats,
				page, request);

		return caseResult;
	}

	// 地接社业绩统计(成交金额)
	@RequestMapping(value = "/agencyAchievementStats2.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData1(HttpServletRequest request, HttpSession session,
			AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {

		QueryResult<AgencyAchievementStats> caseResult = queryAgencyAchievementStatsMMethod(request,
				agencyAchievementStats, page);

		QueryResult<AgencyAchievementStats> caseResult2 = service
				.queryAgencyAchievementStatsMTotal(agencyAchievementStats, page, request);
		List<AgencyAchievementStats> data = caseResult2.getData();
		data.get(0).setAgencyName("合计");
		caseResult.getData().addAll(data);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	// 商家覆盖统计
	@RequestMapping(value = "/agencyAchievementStats2Total.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData3(HttpServletRequest request, HttpSession session,
			AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {

		if (agencyAchievementStats.getSearchStartTime() == null) {
			agencyAchievementStats.setSearchStartTime("");
		}
		if (agencyAchievementStats.getSearchEndTime() == null) {
			agencyAchievementStats.setSearchEndTime("");
		}

		QueryResult<AgencyAchievementStats> caseResult = service
				.queryAgencyAchievementStatsMTotal(agencyAchievementStats, page, request);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	// 商家覆盖统计
	@RequestMapping(value = "/sellerCoverStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list5(Model model) {

		return "/statistics/sellerCoverStats";
	}

	@RequestMapping(value = "/sellerCoverStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, SellerCoverStats sellerCoverStats,
			Model model, PageHelper page) {

		QueryResult<SellerCoverStats> caseResult = service.querySellerCoverStats(sellerCoverStats, page, request);
		QueryResult<SellerCoverStats> caseResult2 = service.querySellerCoverStatsTotal(sellerCoverStats, page, request);
		List<SellerCoverStats> data = caseResult2.getData();
		caseResult.getData().addAll(data);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	// 商家未询统计
	@RequestMapping(value = "/sellerNotAskStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list6(Model model) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(); // 获取当前日期
		// calendar.add(Calendar.MONTH, -3); //设置上个月份
		calendar.add(Calendar.DAY_OF_MONTH, -90); // 设置为那月1号
		model.addAttribute("searchStartDateTime", format.format(calendar.getTime()));

		Calendar calendar1 = Calendar.getInstance(); // 获取当前日期
		model.addAttribute("searchEndDateTime", format.format(calendar1.getTime()));

		return "/statistics/sellerNotAskStats";
	}

	@RequestMapping(value = "/sellerNotAskStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, SellerNotAskStats sellerNotAskStats,
			Model model, PageHelper page) {

		QueryResult<SellerNotAskStats> caseResult = querySellerNotAskStatsMethod(request, sellerNotAskStats, page);
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<SellerNotAskStats> querySellerNotAskStatsMethod(HttpServletRequest request,
			SellerNotAskStats sellerNotAskStats, PageHelper page) {
		if (sellerNotAskStats.getSearchStartTime() == null) {
			sellerNotAskStats.setSearchStartTime("");
		}
		if (sellerNotAskStats.getSearchEndTime() == null) {
			sellerNotAskStats.setSearchEndTime("");
		}

		QueryResult<SellerNotAskStats> caseResult = service.querySellerNotAskStats(sellerNotAskStats, page, request);
		return caseResult;

	}

	@RequestMapping(value = "/sellerNotAskStatsTotal.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData3(HttpServletRequest request, HttpSession session, SellerNotAskStats sellerNotAskStats,
			Model model, PageHelper page) {

		if (sellerNotAskStats.getSearchStartTime() == null) {
			sellerNotAskStats.setSearchStartTime("");
		}
		if (sellerNotAskStats.getSearchEndTime() == null) {
			sellerNotAskStats.setSearchEndTime("");
		}

		QueryResult<SellerNotAskStats> caseResult = service.querySellerNotAskStatsTotal(sellerNotAskStats, page,
				request);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	@RequestMapping(value = "/sellerNotAskStatsD.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, SellerNotAskStatsD sellerNotAskStatsD,
			Model model, PageHelper page) {

		QueryResult<SellerNotAskStatsD> caseResult = querySellerNotAskStatsDMethod(request, sellerNotAskStatsD, page);
		changeCountryCodeToChinese2(service, caseResult);
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	public QueryResult<SellerNotAskStatsD> querySellerNotAskStatsDMethod(HttpServletRequest request,
			SellerNotAskStatsD sellerNotAskStatsD, PageHelper page) {
		if (sellerNotAskStatsD.getSearchStartTime() == null) {
			sellerNotAskStatsD.setSearchStartTime("");
		}
		if (sellerNotAskStatsD.getSearchEndTime() == null) {
			sellerNotAskStatsD.setSearchEndTime("");
		}

		QueryResult<SellerNotAskStatsD> caseResult = service.querySellerNotAskStatsD(sellerNotAskStatsD, page, request);
		return caseResult;

	}

	// 客人来源级别统计
	@RequestMapping(value = "/customerSourceLevelStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list7(Model model) {

		return "/statistics/customerSourceLevelStats";
	}

	@RequestMapping(value = "/customerSourceLevelStats.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session,
			CustomerSourceLevelStats customerSourceLevelStats, Model model, PageHelper page) {

		QueryResult<CustomerSourceLevelStats> caseResult = service
				.queryCustomerSourceLevelStats(customerSourceLevelStats, page, request);
		QueryResult<CustomerSourceLevelStats> caseResult2 = service
				.queryCustomerSourceLevelStatsTotal(customerSourceLevelStats, page, request);
		List<CustomerSourceLevelStats> data = caseResult2.getData();
		data.get(0).setSource("合计");
		caseResult.getData().addAll(data);

		String result = JSONUtilS.object2json(caseResult);

		return result;
	}

	/**
	 * 将多选的目的地，显示中文
	 * 
	 * @param service
	 * @param list
	 */
	public static void changeCountryCodeToChinese2(StatisticsService service, QueryResult<SellerNotAskStatsD> list) {
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		for (SellerNotAskStatsD temp : list.getData()) {
			String str = temp.getCountry();

			if ("".equals(str) || str == null) {
				continue;
			}
			String[] coun = str.split(",");
			StringBuilder sb = new StringBuilder();
			for (String s : coun) {
				for (EntityList item : countryList) {
					if (s.equals(item.getId())) {
						sb.append(item.getText() + ",");
						break;
					}
				}
			}
			if (sb.length() > 0) {
				temp.setCountry(sb.toString().substring(0, sb.length() - 1));
			}
		}
	}

	/**
	 * 将跟单员询单状态表保存到本地
	 */
	@RequestMapping(value = "/saveusercasestatus.do", method = { RequestMethod.POST })
	public void saveUserCaseStatusExcel(HttpServletResponse response, String startCreateDateTime,
			String endCreateDateTime, String source) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryUserCaseStatusMethod(startCreateDateTime, endCreateDateTime, source).getData());// 将数据放入Map中
		String title = "跟单员,待处理,沟通中,地接设计中,成行,未成行,无效,已付款,询单数量,成交率";
		dataMap.put("fileName", "跟单员询单状态表（" + startCreateDateTime + "-" + endCreateDateTime + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savecontactreal.do", method = { RequestMethod.POST })
	public void saveContactReal(HttpServletResponse response, String startCreateDateTime, String endCreateDateTime) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryContactRealMethod(startCreateDateTime, endCreateDateTime).getData());// 将数据放入Map中
		String title = "沟通方式,待处理,沟通中,地接设计中,成行,未成行,无效,已付款,询单数量,成交率";
		dataMap.put("fileName", "沟通方式统计表（" + startCreateDateTime + "-" + endCreateDateTime + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savedescasestatus.do", method = { RequestMethod.POST })
	public void saveDesCaseStatus(HttpServletResponse response, String startCreateDateTime, String endCreateDateTime) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryDesCaseStatusMethod(startCreateDateTime, endCreateDateTime).getData());// 将数据放入Map中
		String title = "目的地,待处理,沟通中,地接设计中,成行,未成行,无效,已付款,询单数量,成交率";
		dataMap.put("fileName", "目的地询单状态统计表（" + startCreateDateTime + "-" + endCreateDateTime + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出无效原因统计
	 * 
	 * @param response
	 * @param startCreateDateTime
	 * @param endCreateDateTime
	 */
	@RequestMapping(value = "/savereasonofdraininginvalid.do", method = { RequestMethod.POST })
	public void saveReasonOfDrainingInvalid(HttpServletResponse response, String startCreateDateTime,
			String endCreateDateTime) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryReasonOfDraining1Method(startCreateDateTime, endCreateDateTime).getData());// 将数据放入Map中
		String title = "无效原因,询单数量,比例";
		dataMap.put("fileName", "流失原因-无效原因统计表（" + startCreateDateTime + "-" + endCreateDateTime + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savereasonofdrainingnodeal.do", method = { RequestMethod.POST })
	public void saveReasonOfDrainingNoDeal(HttpServletResponse response, String startCreateDateTime,
			String endCreateDateTime) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryReasonOfDraining2Method(startCreateDateTime, endCreateDateTime).getData());// 将数据放入Map中
		String title = "未成行原因,询单数量,比例";
		dataMap.put("fileName", "流失原因-未成行原因统计表（" + startCreateDateTime + "-" + endCreateDateTime + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跟单员绩效成交率表导出
	 * 
	 * @param response
	 * @param searchYear
	 */
	@RequestMapping(value = "/saveuserachirate.do", method = { RequestMethod.POST })
	public void saveUserAchiRate(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryUserAchiRateMethod(searchYear).getData());// 将数据放入Map中
		String title = "跟单员,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "跟单员绩效-成交率统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/saveuserachimoney.do", method = { RequestMethod.POST })
	public void saveUserAchiMoney(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("dataList", queryUserAchiMoneyMethod(searchYear).getData());// 将数据放入Map中
		String title = "跟单员,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "跟单员绩效-成交金额统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savedesachicount.do", method = { RequestMethod.POST })
	public void saveDesAchiCount(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<UserAchRate> dataList = queryDesAchiCaseCountMethod(searchYear);
		changeCountryCodeToChinese(service, dataList);
		dataMap.put("dataList", dataList.getData());// 将数据放入Map中
		String title = "目的地,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "目的地绩效-咨询数量统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savedesachirate.do", method = { RequestMethod.POST })
	public void saveDesAchiRate(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<UserAchRate> dataList = queryDesAchiRateMethod(searchYear);
		changeCountryCodeToChinese(service, dataList);
		dataMap.put("dataList", dataList.getData());// 将数据放入Map中
		String title = "目的地,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "目的地绩效-成交率统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savedesachimoney.do", method = { RequestMethod.POST })
	public void saveDesAchiMoney(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<UserAchRate> dataList = queryDesAchiMoneyMethod(searchYear);
		changeCountryCodeToChinese(service, dataList);
		dataMap.put("dataList", dataList.getData());// 将数据放入Map中
		String title = "目的地,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "目的地绩效-成交金额统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savecustsource.do", method = { RequestMethod.POST })
	public void saveCustSource(HttpServletResponse response, String searchYear) {

		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<UserAchRate> dataList = queryCustSourceMethod(searchYear);
		dataMap.put("dataList", dataList.getData());// 将数据放入Map中
		String title = "客人来源,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
		dataMap.put("fileName", "客人来源统计表（" + searchYear + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/saveagencyorderstatus.do", method = { RequestMethod.POST })
	public void saveAgencyOrderStatus(HttpServletRequest request, HttpServletResponse response,
			AgencyOrderStatus agencyOrderStatus, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<AgencyOrderStatus> result = queryAgencyOrderStatusMethod(request, agencyOrderStatus, page);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "地接社名称,订单数量,等待客人回复订单数,等待地接社回复订单数,成行订单数,未成行订单数,付款订单数,成交金额,成交比例";
		dataMap.put("fileName", "地接社订单状态统计表（" + agencyOrderStatus.getSearchStartTime().substring(0,agencyOrderStatus.getSearchStartTime().length()-9 ) + "-"
				+ agencyOrderStatus.getSearchEndTime().substring(0, agencyOrderStatus.getSearchEndTime().length()-9) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savecaseallot.do", method = { RequestMethod.POST })
	public void saveAgencyOrderStatus(HttpServletRequest request, HttpServletResponse response,
			CaseAllotStats caseAllotStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<CaseAllotStats> result = queryCaseAllotStatsMethod(request, caseAllotStats, page);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "跟单员,询单总数量,网站表单询单数,手机表单,直发表单,微信表单,网站在线客服,手机在线客服,电话客服,微信客服,线下活动,邮件咨询,朋友介绍,老客人,携程";
		dataMap.put("fileName", "询单分配统计表（" + caseAllotStats.getSearchStartTime().substring(0,caseAllotStats.getSearchStartTime().length()-9 ) + "-"
				+ caseAllotStats.getSearchEndTime().substring(0,caseAllotStats.getSearchEndTime().length()-9 ) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/saveagencyachirate.do", method = { RequestMethod.POST })
	public void saveAgencyAchiRate(HttpServletRequest request, HttpServletResponse response,
			AgencyAchievementStats agencyAchievementStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<AgencyAchievementStats> result = queryAgencyAchievementStatsMethod(request, agencyAchievementStats,page);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "地接社名称,一月成交率,二月成交率,三月成交率,四月成交率,五月成交率,六月成交率,七月成交率,八月成交率,九月成交率,十月成交率,十一月成交率,十二月成交率";
		dataMap.put("fileName", "地接社业绩-成交率统计表（" + agencyAchievementStats.getSearchStartTime().substring(0,agencyAchievementStats.getSearchStartTime().length()-15 )+ "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/saveagencyachimoney.do", method = { RequestMethod.POST })
	public void saveAgencyAchiMoney(HttpServletRequest request, HttpServletResponse response,
			AgencyAchievementStats sellerNotAskStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<AgencyAchievementStats> result = queryAgencyAchievementStatsMMethod(request, sellerNotAskStats,
				page);
		
		QueryResult<AgencyAchievementStats> caseResult2 = service
				.queryAgencyAchievementStatsMTotal(sellerNotAskStats, page, request);
		List<AgencyAchievementStats> data = caseResult2.getData();
		data.get(0).setAgencyName("合计");
		result.getData().addAll(data);
		
		
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		
		String title = "地接社名称,一月成交金额,二月成交金额,三月成交金额,四月成交金额,五月成交金额,六月成交金额,七月成交金额	,八月成交金额,九月成交金额,十月成交金额,十一月成交金额,十二月成交金额";
		dataMap.put("fileName", "地接社业绩-成交金额统计表（" + sellerNotAskStats.getSearchStartTime().substring(0,sellerNotAskStats.getSearchStartTime().length()-15 ) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savecasesource.do", method = { RequestMethod.POST })
	public void saveCaseSource(HttpServletRequest request, HttpServletResponse response,
			CaseSourceStats caseSourceStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<CaseSourceStats> result = queryCaseSourceStatsMethod(request, caseSourceStats, page);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "询单来源,待处理,沟通中,地接设计中,成行,未成行,无效,付款,询单总数,成交率";
		dataMap.put("fileName",
				"询单来源状态统计表（" + caseSourceStats.getSearchStartTime().substring(0,caseSourceStats.getSearchStartTime().length()-9 ) + "-" + caseSourceStats.getSearchEndTime().substring(0,caseSourceStats.getSearchEndTime().length()-9 ) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savecustsourcelevel.do", method = { RequestMethod.POST })
	public void saveCustSourceLevel(HttpServletRequest request, HttpServletResponse response,
			CustomerSourceLevelStats customerSourceLevelStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<CustomerSourceLevelStats> result = service.queryCustomerSourceLevelStats(customerSourceLevelStats,
				page, request);
		QueryResult<CustomerSourceLevelStats> caseResult2 = service
				.queryCustomerSourceLevelStatsTotal(customerSourceLevelStats, page, request);
		List<CustomerSourceLevelStats> data = caseResult2.getData();
		data.get(0).setSource("合计");
		result.getData().addAll(data);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "客人来源,普通客人数量,注册客人数量,下单客人数量,成行客人数量,成交比";
		dataMap.put("fileName", "客人来源级别统计表.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savesellercover.do", method = { RequestMethod.POST })
	public void saveSellerCover(HttpServletRequest request, HttpServletResponse response,
			SellerCoverStats sellerCoverStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<SellerCoverStats> result = service.querySellerCoverStats(sellerCoverStats, page, request);
		QueryResult<SellerCoverStats> caseResult2 = service.querySellerCoverStatsTotal(sellerCoverStats, page, request);
		List<SellerCoverStats> data = caseResult2.getData();
		result.getData().addAll(data);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "目的地国家名称,地接社数量(降序排列)";
		dataMap.put("fileName", "商家覆盖统计表.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savenocasedes.do", method = { RequestMethod.POST })
	public void saveNoCaseDes(HttpServletRequest request, HttpServletResponse response,
			SellerNotAskStats sellerNotAskStats, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<SellerNotAskStats> result = querySellerNotAskStatsMethod(request, sellerNotAskStats, page);

		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "目的地国家名称,包含地接社数量";
		dataMap.put("fileName", "商家未询-无询单目的地统计表（" + sellerNotAskStats.getSearchStartTime().substring(0,sellerNotAskStats.getSearchStartTime().length()-9 ) + "-"
				+ sellerNotAskStats.getSearchEndTime().substring(0,sellerNotAskStats.getSearchEndTime().length()-9 ) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/savenoorderagency.do", method = { RequestMethod.POST })
	public void saveNoOrderAgency(HttpServletRequest request, HttpServletResponse response,
			SellerNotAskStatsD sellerNotAskStatsD, PageHelper page) {
		Map<String, Object> dataMap = new HashMap<>();
		QueryResult<SellerNotAskStatsD> result = querySellerNotAskStatsDMethod(request, sellerNotAskStatsD, page);
		changeCountryCodeToChinese2(service, result);
		dataMap.put("dataList", result.getData());// 将数据放入Map中
		String title = "地接社国家名称,	服务国家";
		dataMap.put("fileName", "商家未询-无订单地接社统计表（" + sellerNotAskStatsD.getSearchStartTime().substring(0,sellerNotAskStatsD.getSearchStartTime().length()-9 ) + "-"
				+ sellerNotAskStatsD.getSearchEndTime().substring(0,sellerNotAskStatsD.getSearchEndTime().length()-9 ) + "）.csv");// 拼接csv表名
		try {
			CSVUtil.saveCsv(response, dataMap, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
