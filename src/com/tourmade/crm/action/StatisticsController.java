package com.tourmade.crm.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.tourmade.crm.entity.ContactRealStats;
import com.tourmade.crm.entity.ContactRealStatsTotal;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.ReasonOfDrainingStats;
import com.tourmade.crm.entity.ReasonOfDrainingStatsTotal;
import com.tourmade.crm.entity.UserAchRate;
import com.tourmade.crm.entity.UserAchievement;
import com.tourmade.crm.service.StatisticsService;
import com.tourmade.crm.entity.AgencyAchievementStats;
import com.tourmade.crm.entity.AgencyOrderStatus;
import com.tourmade.crm.entity.CaseAllotStats;
import com.tourmade.crm.entity.CaseAllotStatsTotal;
import com.tourmade.crm.entity.CaseSourceStats;
import com.tourmade.crm.entity.CaseSourceStatsTotal;
import com.tourmade.crm.entity.CustomerSourceLevelStats;
import com.tourmade.crm.entity.SellerCoverStats;
import com.tourmade.crm.entity.SellerNotAskStats;

import net.sf.json.JSONArray;

/**
 * 统计分析类
 * @author fjw
 *
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseSimpleFormController{
	@Autowired
	private StatisticsService service;
	
	/**
	 * 跟单员询单状态统计
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/usercasestatusstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String userAchievementStatsView(Model model){
		String source = "case.source";
		List<EntityList> sourceList = service.getParameterInfo(source);
		JSONArray sourceResult = JSONArray.fromObject(sourceList);
		model.addAttribute("source",sourceResult);
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/userCaseStatusStats";
	}
	/**
	 * 跟单员dateTables请求
	 * @param request
	 * @param session
	 * @param model
	 * @param customerId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/usercasestatusstats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(PageHelper page,String startCreateDateTime,String endCreateDateTime,String source) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		map.put("source", source);
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		} 
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryUserAchievementStats(map);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}
	
	@RequestMapping(value = "/usercasestatusstatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData1(PageHelper page,String startCreateDateTime,String endCreateDateTime,String source) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		map.put("source", source);
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		} 
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryUserAchievementStatsTotal(map);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}
	/**
	 * 返回沟通方式统计界面
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/contactrealstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String contactRealStatsView(Model model){
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/contactRealStats";
	}
	/**
	 * 沟通方式请求方法
	 * @param page
	 * @param startCreateDateTime
	 * @param endCreateDateTime
	 * @return
	 */
	@RequestMapping(value = "/contactrealstats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryContactReal(PageHelper page,String startCreateDateTime,String endCreateDateTime) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<ContactRealStats> contactRealList = service.queryContactReal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	@RequestMapping(value = "/contactrealstatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryContactRealTotal(PageHelper page,String startCreateDateTime,String endCreateDateTime) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<ContactRealStatsTotal> contactRealList = service.queryContactRealTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	/**
	 * 返回流失原因界面
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/reasonofdrainingstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	
	public String reasonOfDrainingView(Model model){
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/reasonOfDrainingStats";
	}
	
	/**
	 * 无效原因dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/reasonofdrainingstats1.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining1(PageHelper page,String startCreateDateTime,String endCreateDateTime){
		//设置查询参数
				Map<String,Object> map =new HashMap<>();
				if(startCreateDateTime==null||startCreateDateTime.trim()==""){
					startCreateDateTime=getLastMothFirstDay();
				}
				if(endCreateDateTime==null||endCreateDateTime.trim()==""){
					endCreateDateTime=getLastMothLastDay();
				}
				map.put("startCreateTime", startCreateDateTime+" 00:00:00");
				map.put("endCreateTime", endCreateDateTime+" 23:59:59");
				QueryResult<ReasonOfDrainingStats> contactRealList = service.queryReasonOfDraining(map);
				String result = JSONUtilS.object2json(contactRealList);
				
				return result;
	}
	
	@RequestMapping( value = "/reasonofdrainingstats1Total.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining1Total(PageHelper page,String startCreateDateTime,String endCreateDateTime){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<ReasonOfDrainingStatsTotal> contactRealList = service.queryReasonOfDrainingTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		
		return result;
	}
	
	/**
	 * 未成行原因dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/reasonofdrainingstats2.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining2(PageHelper page,String startCreateDateTime,String endCreateDateTime){
		//设置查询参数
				Map<String,Object> map =new HashMap<>();
				if(startCreateDateTime==null||startCreateDateTime.trim()==""){
					startCreateDateTime=getLastMothFirstDay();
				}
				if(endCreateDateTime==null||endCreateDateTime.trim()==""){
					endCreateDateTime=getLastMothLastDay();
				}
				map.put("startCreateTime", startCreateDateTime+" 00:00:00");
				map.put("endCreateTime", endCreateDateTime+" 23:59:59");
				QueryResult<ReasonOfDrainingStats> contactRealList = service.queryReasonOfDrainingNoDeal(map);
				String result = JSONUtilS.object2json(contactRealList);
				
				return result;
	}
	@RequestMapping( value = "/reasonofdrainingstats2Total.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryReasonOfDraining2Total(PageHelper page,String startCreateDateTime,String endCreateDateTime){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<ReasonOfDrainingStatsTotal> contactRealList = service.queryReasonOfDrainingNoDealTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		
		return result;
	}
	/**
	 * 跟单员业绩统计
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/userachievementstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String userAchievementStatsView2(Model model){
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/userAchievementStats";
	}
	
	
	
	/**
	 * 跟单员成交率dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/userachievementratestats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiRate(PageHelper page,String searchYear){
		//设置查询参数
				Map<String,Object> map =new HashMap<>();
				if(searchYear==null||searchYear.trim()==""){
					searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
				}
				map.put("startCreateTime", searchYear+"-01-01 00:00:00");
				map.put("endCreateTime", searchYear+"-12-31 23:59:59");
				QueryResult<UserAchRate> contactRealList = service.queryUserAchiRate(map);
				String result = JSONUtilS.object2json(contactRealList);
				
				return result;
	}
	
	@RequestMapping( value = "/userachievementratestatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiRateTotal(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryUserAchiRateTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	/**
	 * 跟单员金额dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/userachievementmoneystats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiMoney(PageHelper page,String searchYear){
		//设置查询参数
				Map<String,Object> map =new HashMap<>();
				if(searchYear==null||searchYear.trim()==""){
					searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
				}
				map.put("startCreateTime", searchYear+"-01-01 00:00:00");
				map.put("endCreateTime", searchYear+"-12-31 23:59:59");
				QueryResult<UserAchRate> contactRealList = service.queryUserAchiMoney(map);
				String result = JSONUtilS.object2json(contactRealList);
				
				return result;
	}
	
	@RequestMapping( value = "/userachievementmoneystatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryUserAchiMoneyTotal(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryUserAchiMoneyTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	/**
	 * 目的地询单状态统计
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/descasestatusstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String desCaseStatusStatsView(Model model){
		model.addAttribute("startTime", getLastMothFirstDay());
		model.addAttribute("endTime", getLastMothLastDay());
		return "/statistics/desCaseStatusStas";
	}
	/**
	 * 目的地dateTables请求
	 * @param request
	 * @param session
	 * @param model
	 * @param customerId
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/descasestatusstats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesCaseStatus(PageHelper page,String startCreateDateTime,String endCreateDateTime) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryDesCaseStatus(map);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}
	
	@RequestMapping(value = "/descasestatusstatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesCaseStatusTotal(PageHelper page,String startCreateDateTime,String endCreateDateTime) {
		
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(startCreateDateTime==null||startCreateDateTime.trim()==""){
			startCreateDateTime=getLastMothFirstDay();
		}
		if(endCreateDateTime==null||endCreateDateTime.trim()==""){
			endCreateDateTime=getLastMothLastDay();
		}
		map.put("startCreateTime", startCreateDateTime+" 00:00:00");
		map.put("endCreateTime", endCreateDateTime+" 23:59:59");
		QueryResult<UserAchievement> userAchievementList = service.queryDesCaseStatusTotal(map);
		String result = JSONUtilS.object2json(userAchievementList);
		return result;
	}
	
	/**
	 * 目的地成交统计
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/desachievementstats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String desAchievementStatsView(Model model){
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/desAchievementStats";
	}
	/**
	 * 目的地咨询数量dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/desachievementcountstats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiCaseCount(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiCaseCount(map);
		changeCountryCodeToChinese(service,contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	@RequestMapping( value = "/desachievementcountstatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiCaseCountTotal(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiCaseCountTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	/**
	 * 目的地成交率dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/desachievementratestats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiRate(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiRate(map);
		changeCountryCodeToChinese(service,contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	@RequestMapping( value = "/desachievementratestatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiRateTotal(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiRateTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	/**
	 * 目的地金额dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/desachievementmoneystats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiMoney(PageHelper page,String searchYear){
		//设置查询参数
		
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiMoney(map);
		
		changeCountryCodeToChinese(service,contactRealList);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	@RequestMapping( value = "/desachievementmoneystatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDesAchiMoneyTotal(PageHelper page,String searchYear){
		//设置查询参数
		
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryDesAchiMoneyTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	/**
	 * 客人来源统计
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/custsourcestats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String custSourceStatsView(Model model){
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		return "/statistics/custSourceStats";
	}
	
	
	
	/**
	 * 客人来源dataTables请求
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/custsourcestats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryCustSource(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryCustSource(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	@RequestMapping( value = "/custsourcestatstotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryCustSourceTotal(PageHelper page,String searchYear){
		//设置查询参数
		Map<String,Object> map =new HashMap<>();
		if(searchYear==null||searchYear.trim()==""){
			searchYear=String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		map.put("startCreateTime", searchYear+"-01-01 00:00:00");
		map.put("endCreateTime", searchYear+"-12-31 23:59:59");
		QueryResult<UserAchRate> contactRealList = service.queryCustSourceTotal(map);
		String result = JSONUtilS.object2json(contactRealList);
		return result;
	}
	
	/**
	 * 将多选的目的地，显示中文
	 * @param service
	 * @param list
	 */
	public static void changeCountryCodeToChinese(StatisticsService service,QueryResult<UserAchRate> list){
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		for(UserAchRate temp:list.getData()){
			String str = temp.getCode();
			if("".equals(str)||str==null){
				continue;
			}
			if(str.contains(",")){
				String[] coun= str.split(",");
				StringBuilder sb=new StringBuilder();
				for(String s:coun){
					for(EntityList item:countryList){
						if(s.equals( item.getId())){
							sb.append(item.getText()+",");
							break;
						}
					}
				}
				temp.setUserName(sb.toString().substring(0, sb.length()-1));
			}
		}
	}
	//返回上一个月第一天
	public static String getLastMothFirstDay(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(calendar.getTime());
	}
	//返回上一个月最后一天
	public static String getLastMothLastDay(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		calendar.add(Calendar.DATE, -1);
		return format.format(calendar.getTime());
	}
	
	//地接社订单状态统计
	@RequestMapping(value = "/agencyOrderStatusStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list1(Model model){
		
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		JSONArray destinationResult = JSONArray.fromObject(countryList);
		model.addAttribute("destination",destinationResult);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();    //获取当前日期
		calendar.add(Calendar.MONTH, -1);    //设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1);    //设置为上月1号
		model.addAttribute("searchStartDateTime",format.format(calendar.getTime()));
		
		Calendar calendar1 = Calendar.getInstance();    //获取当前日期
		calendar1.add(Calendar.MONTH, 0);    //设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0);    //设置为上月1号
		model.addAttribute("searchEndDateTime",format.format(calendar1.getTime()));
		
		return "/statistics/agencyOrderStatusStats";
	}
	
	@RequestMapping(value = "/agencyOrderStatusStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, AgencyOrderStatus agencyOrderStatus, Model model, PageHelper page) {

		if(agencyOrderStatus.getSearchStartTime()==null){
			agencyOrderStatus.setSearchStartTime("");
		}
		if(agencyOrderStatus.getSearchEndTime()==null){
			agencyOrderStatus.setSearchEndTime("");
		}
		
		QueryResult<AgencyOrderStatus> caseResult = service.queryAgencyOrderStatus(agencyOrderStatus,page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	@RequestMapping(value = "/agencyOrderStatusStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, AgencyOrderStatus agencyOrderStatus, Model model, PageHelper page) {
		
		if(agencyOrderStatus.getSearchStartTime()==null){
			agencyOrderStatus.setSearchStartTime("");
		}
		if(agencyOrderStatus.getSearchEndTime()==null){
			agencyOrderStatus.setSearchEndTime("");
		}
		
		QueryResult<AgencyOrderStatus> caseResult = service.queryAgencyOrderStatusTotal(agencyOrderStatus,page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//询单分配统计
	@RequestMapping(value = "/caseAllotStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list2(Model model){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();    //获取当前日期
		calendar.add(Calendar.MONTH, -1);    //设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1);    //设置为上月1号
		model.addAttribute("searchStartDateTime",format.format(calendar.getTime()));
		
		Calendar calendar1 = Calendar.getInstance();    //获取当前日期
		calendar1.add(Calendar.MONTH, 0);    //设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0);    //设置为上月1号
		model.addAttribute("searchEndDateTime",format.format(calendar1.getTime()));
		
		return "/statistics/caseAllotStats";
	}
	
	@RequestMapping(value = "/caseAllotStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseAllotStats caseAllotStats, Model model, PageHelper page) {

		if(caseAllotStats.getSearchStartTime()==null){
			caseAllotStats.setSearchStartTime("");
		}
		if(caseAllotStats.getSearchEndTime()==null){
			caseAllotStats.setSearchEndTime("");
		}
		
		QueryResult<CaseAllotStats> caseResult = service.queryCaseAllotStats(caseAllotStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	@RequestMapping(value = "/caseAllotStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseAllotStatsTotal caseAllotStatsTotal, Model model, PageHelper page) {
		
		if(caseAllotStatsTotal.getSearchStartTime()==null){
			caseAllotStatsTotal.setSearchStartTime("");
		}
		if(caseAllotStatsTotal.getSearchEndTime()==null){
			caseAllotStatsTotal.setSearchEndTime("");
		}
		
		QueryResult<CaseAllotStatsTotal> caseResult = service.queryCaseAllotStatsTotal(caseAllotStatsTotal, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//询单来源状态统计
	@RequestMapping(value = "/caseSourceStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list3(Model model){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();    //获取当前日期
		calendar.add(Calendar.MONTH, -1);    //设置上个月份
		calendar.set(Calendar.DAY_OF_MONTH, 1);    //设置为上月1号
		model.addAttribute("searchStartDateTime",format.format(calendar.getTime()));
		
		Calendar calendar1 = Calendar.getInstance();    //获取当前日期
		calendar1.add(Calendar.MONTH, 0);    //设置上个月份
		calendar1.set(Calendar.DAY_OF_MONTH, 0);    //设置为上月1号
		model.addAttribute("searchEndDateTime",format.format(calendar1.getTime()));
		
		return "/statistics/caseSourceStats";
	}
	@RequestMapping(value = "/caseSourceStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseSourceStatsTotal caseSourceStatsTotal, Model model, PageHelper page) {

		if(caseSourceStatsTotal.getSearchStartTime()==null){
			caseSourceStatsTotal.setSearchStartTime("");
		}
		if(caseSourceStatsTotal.getSearchEndTime()==null){
			caseSourceStatsTotal.setSearchEndTime("");
		}
		
		QueryResult<CaseSourceStatsTotal> caseResult = service.queryCaseSourceStatsTotal(caseSourceStatsTotal, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	@RequestMapping(value = "/caseSourceStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CaseSourceStats caseSourceStats, Model model, PageHelper page) {

		if(caseSourceStats.getSearchStartTime()==null){
			caseSourceStats.setSearchStartTime("");
		}
		if(caseSourceStats.getSearchEndTime()==null){
			caseSourceStats.setSearchEndTime("");
		}
		
		QueryResult<CaseSourceStats> caseResult = service.queryCaseSourceStats(caseSourceStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	//地接社业绩统计(成交率)
	@RequestMapping(value = "/agencyAchievementStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list4(Model model){
		
		Calendar calendar = Calendar.getInstance();
		model.addAttribute("searchYear", calendar.get(Calendar.YEAR));
		
		return "/statistics/agencyAchievementStats";
	}
	
	@RequestMapping(value = "/agencyAchievementStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {

		if(agencyAchievementStats.getSearchStartTime()==null){
			agencyAchievementStats.setSearchStartTime("");
		}
		if(agencyAchievementStats.getSearchEndTime()==null){
			agencyAchievementStats.setSearchEndTime("");
		}
		
		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStats(agencyAchievementStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	@RequestMapping(value = "/agencyAchievementStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {
		
		if(agencyAchievementStats.getSearchStartTime()==null){
			agencyAchievementStats.setSearchStartTime("");
		}
		if(agencyAchievementStats.getSearchEndTime()==null){
			agencyAchievementStats.setSearchEndTime("");
		}
		
		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStatsTotal(agencyAchievementStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//地接社业绩统计(成交金额)
	@RequestMapping(value = "/agencyAchievementStats2.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData1(HttpServletRequest request, HttpSession session, AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {

		if(agencyAchievementStats.getSearchStartTime()==null){
			agencyAchievementStats.setSearchStartTime("");
		}
		if(agencyAchievementStats.getSearchEndTime()==null){
			agencyAchievementStats.setSearchEndTime("");
		}
		
		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStatsM(agencyAchievementStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	@RequestMapping(value = "/agencyAchievementStats2Total.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData3(HttpServletRequest request, HttpSession session, AgencyAchievementStats agencyAchievementStats, Model model, PageHelper page) {
		
		if(agencyAchievementStats.getSearchStartTime()==null){
			agencyAchievementStats.setSearchStartTime("");
		}
		if(agencyAchievementStats.getSearchEndTime()==null){
			agencyAchievementStats.setSearchEndTime("");
		}
		
		QueryResult<AgencyAchievementStats> caseResult = service.queryAgencyAchievementStatsMTotal(agencyAchievementStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//商家覆盖统计
	@RequestMapping(value = "/sellerCoverStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list5(Model model){
		
		return "/statistics/sellerCoverStats";
	}
	
	@RequestMapping(value = "/sellerCoverStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, SellerCoverStats sellerCoverStats, Model model, PageHelper page) {

		QueryResult<SellerCoverStats> caseResult = service.querySellerCoverStats(sellerCoverStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);

		return result;
	}
	
	@RequestMapping(value = "/sellerCoverStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryDataTotal(HttpServletRequest request, HttpSession session, SellerCoverStats sellerCoverStats, Model model, PageHelper page) {
		
		QueryResult<SellerCoverStats> caseResult = service.querySellerCoverStatsTotal(sellerCoverStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//商家未询统计
	@RequestMapping(value = "/sellerNotAskStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list6(Model model){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();    //获取当前日期
		//calendar.add(Calendar.MONTH, -3);    //设置上个月份
		calendar.add(Calendar.DAY_OF_MONTH, -90);    //设置为那月1号
		model.addAttribute("searchStartDateTime",format.format(calendar.getTime()));
		
		Calendar calendar1 = Calendar.getInstance();    //获取当前日期
		model.addAttribute("searchEndDateTime",format.format(calendar1.getTime()));
		
		return "/statistics/sellerNotAskStats";
	}
	
	@RequestMapping(value = "/sellerNotAskStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, SellerNotAskStats sellerNotAskStats, Model model, PageHelper page) {
		
		if(sellerNotAskStats.getSearchStartTime()==null){
			sellerNotAskStats.setSearchStartTime("");
		}
		if(sellerNotAskStats.getSearchEndTime()==null){
			sellerNotAskStats.setSearchEndTime("");
		}
		
		QueryResult<SellerNotAskStats> caseResult = service.querySellerNotAskStats(sellerNotAskStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	@RequestMapping(value = "/sellerNotAskStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData3(HttpServletRequest request, HttpSession session, SellerNotAskStats sellerNotAskStats, Model model, PageHelper page) {
		
		if(sellerNotAskStats.getSearchStartTime()==null){
			sellerNotAskStats.setSearchStartTime("");
		}
		if(sellerNotAskStats.getSearchEndTime()==null){
			sellerNotAskStats.setSearchEndTime("");
		}
		
		QueryResult<SellerNotAskStats> caseResult = service.querySellerNotAskStatsTotal(sellerNotAskStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	@RequestMapping(value = "/sellerNotAskStatsD.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, SellerNotAskStats sellerNotAskStatsD, Model model, PageHelper page) {
		
		if(sellerNotAskStatsD.getSearchStartTime()==null){
			sellerNotAskStatsD.setSearchStartTime("");
		}
		if(sellerNotAskStatsD.getSearchEndTime()==null){
			sellerNotAskStatsD.setSearchEndTime("");
		}
		
		QueryResult<SellerNotAskStats> caseResult = service.querySellerNotAskStatsD(sellerNotAskStatsD, page, request);
		
		changeCountryCodeToChinese2(service,caseResult);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	//客人来源级别统计
	@RequestMapping(value = "/customerSourceLevelStats.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list7(Model model){
		
		return "/statistics/customerSourceLevelStats";
	}
	
	@RequestMapping(value = "/customerSourceLevelStats.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, CustomerSourceLevelStats customerSourceLevelStats, Model model, PageHelper page) {
		
		QueryResult<CustomerSourceLevelStats> caseResult = service.queryCustomerSourceLevelStats(customerSourceLevelStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	@RequestMapping(value = "/customerSourceLevelStatsTotal.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData2(HttpServletRequest request, HttpSession session, CustomerSourceLevelStats customerSourceLevelStats, Model model, PageHelper page) {
		
		QueryResult<CustomerSourceLevelStats> caseResult = service.queryCustomerSourceLevelStatsTotal(customerSourceLevelStats, page, request);
		
		String result = JSONUtilS.object2json(caseResult);
		
		return result;
	}
	
	/**
	 * 将多选的目的地，显示中文
	 * @param service
	 * @param list
	 */
	public static void changeCountryCodeToChinese2(StatisticsService service,QueryResult<SellerNotAskStats> list){
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		for(SellerNotAskStats temp:list.getData()){
			String str = temp.getCountry();
			
			if("".equals(str)||str==null){
				continue;
			}
			String[] coun= str.split(",");
			StringBuilder sb=new StringBuilder();
			for(String s:coun){
				for(EntityList item:countryList){
					if(s.equals( item.getId())){
						sb.append(item.getText()+",");
						break;
					}
				}
			}
			if(sb.length()>0){
				temp.setCountry(sb.toString().substring(0, sb.length()-1));
			}
		}
	}
}
