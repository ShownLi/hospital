package com.tourmade.crm.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.tourmade.crm.service.StatisticsService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseSimpleFormController{
	
	@Autowired
	private StatisticsService service;
	
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
	
	//询单来源统计
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
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
	
	//地接社业绩统计(成交金额)
	@RequestMapping(value = "/agencyAchievementStats2.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, AgencyAchievementStatsM sellerNotAskStats, Model model, PageHelper page) {

		if(sellerNotAskStats.getSearchStartTime()==null){
			sellerNotAskStats.setSearchStartTime("");
		}
		if(sellerNotAskStats.getSearchEndTime()==null){
			sellerNotAskStats.setSearchEndTime("");
		}
		
		QueryResult<AgencyAchievementStatsM> caseResult = service.queryAgencyAchievementStatsM(sellerNotAskStats, page, request);
		
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
	
	@RequestMapping(value = "/sellerNotAskStatsD.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, SellerNotAskStatsD sellerNotAskStatsD, Model model, PageHelper page) {
		
		if(sellerNotAskStatsD.getSearchStartTime()==null){
			sellerNotAskStatsD.setSearchStartTime("");
		}
		if(sellerNotAskStatsD.getSearchEndTime()==null){
			sellerNotAskStatsD.setSearchEndTime("");
		}
		
		QueryResult<SellerNotAskStatsD> caseResult = service.querySellerNotAskStatsD(sellerNotAskStatsD, page, request);
		
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
	
	/**
	 * 将多选的目的地，显示中文
	 * @param service
	 * @param list
	 */
	public static void changeCountryCodeToChinese2(StatisticsService service,QueryResult<SellerNotAskStatsD> list){
		String country = "country";
		List<EntityList> countryList = service.getParameterInfo(country);
		for(SellerNotAskStatsD temp:list.getData()){
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
