package com.tourmade.crm.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.ReasonOfDrainingStats;
import com.tourmade.crm.entity.UserAchRate;
import com.tourmade.crm.entity.UserAchievement;
import com.tourmade.crm.service.StatisticsService;

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
	

}
