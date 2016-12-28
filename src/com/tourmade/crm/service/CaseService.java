package com.tourmade.crm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.log.SysoLogger;
import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.CaseStatus;
import com.tourmade.crm.entity.Customer;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Parameter;
import com.tourmade.crm.mapper.crmcase.CaseMapper;

import net.sf.json.JSONObject;

@Service
@Transactional(readOnly = false)
public class CaseService extends BaseService {
	
	@Autowired
	private CaseMapper caseMapper;

	/**
	 * 查询询单数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return 
	 */
	public QueryResult<Case> queryCase(Case crmcase, PageHelper ph, HttpServletRequest request) {

		QueryResult<Case> result = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());;
		//分页条件
		if(crmcase.getCustomerId()!=null){
			map.put("customerId", crmcase.getCustomerId());
		}
		if(crmcase.getChineseName()!=null){
			map.put("chineseName", crmcase.getChineseName());
		}
		if(crmcase.getCaseId()!=null){
			map.put("caseId", crmcase.getCaseId());
		}
		if(crmcase.getBudget()!=null){
			map.put("budget", crmcase.getBudget());
		}
		if(crmcase.getDestination()!=null){
			map.put("destination", crmcase.getDestination());
		}
		if(crmcase.getSource()!=null){
			map.put("source", crmcase.getSource());
		}
		if(crmcase.getOperator()!=null){
			map.put("operator", crmcase.getOperator());
		}
		if(crmcase.getStatus()!=null){
			map.put("status", crmcase.getStatus().trim());
		}
		if(crmcase.getComment()!=null){
			map.put("comment", crmcase.getComment());
		}
		if(crmcase.getRequirement()!=null){
			map.put("requirement", crmcase.getRequirement());
		}
		if(crmcase.getEmail()!=null){
			map.put("email", crmcase.getEmail());
		}
		if(crmcase.getMobile()!=null){
			map.put("mobile", crmcase.getMobile());
		}
		if(crmcase.getSearchStartTime()!=null){
			crmcase.setSearchStartTime(crmcase.getSearchStartTime()+" 00:00:00");
			map.put("searchStartTime", crmcase.getSearchStartTime());
		}
		if(crmcase.getSearchEndTime()!=null){
			crmcase.setSearchEndTime(crmcase.getSearchEndTime()+" 24:00:00");
			map.put("searchEndTime", crmcase.getSearchEndTime());
		}
		List<Case> data = caseMapper.queryCase(map);
		long count = caseMapper.countCase(crmcase);
		List<CaseStatus> countStatus = caseMapper.countCaseByStatus(crmcase);	
		for(CaseStatus caseStatus : countStatus){
			if(caseStatus.getStatus()==0){
				result.setStatus0(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==1){
				result.setStatus1(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==2){
				result.setStatus2(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==3){
				result.setStatus3(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==4){
				result.setStatus4(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==5){
				result.setStatus5(caseStatus.getCount());
			}
			if(caseStatus.getStatus()==6){
				result.setStatus6(caseStatus.getCount());
			}
		}
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}

	/**
	 * 查询询单数据，分页展示
	 * 
	 * @param case
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Case> queryCaseFromCustomer(int customerId, PageHelper ph, HttpServletRequest request) {

		QueryResult<Case> result = new QueryResult<Case>();
		Map<String, Object> map = new HashMap<String, Object>();


		
		map.put("customerId", customerId);
		/*map.put("start", ph.getStart());
		map.put("length", ph.getLength());*/

		List<Case> data = caseMapper.queryCasesByCustomerId(map);
		/*long count = caseMapper.countCaseFC(customerId);*/
			
		result.setData(data);
//		result.setCountTotal(count);
//		result.setCountFiltered(count);
	
		return result;
	}
	
	/*
	 * 查询是否有老客人
	 */
	public List<Customer> judgeCustomer(Case crmcase){
		try {
			List<Customer> list = caseMapper.getCustomerByCommunication(crmcase);	
			return list;
		} catch (Exception e) {
			logger.error("CaseService.judgeCustomer() --> "  + "-->" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 添加客人
	 */
	public void saveCustomer(Case crmcase){
		try {
			Customer cus = case2Customer(crmcase);
			setCusLevel(cus);
			String caseSource = crmcase.getSource().trim();
			cus.setSource("others");
			if(caseSource.equals("web_form")){
				cus.setSource("form");
			}
			if(caseSource.equals("mobile_form")){
				cus.setSource("form");
			}
			if(caseSource.equals("direct_form")){
				cus.setSource("form");
			}
			if(caseSource.equals("wechat_form")){
				cus.setSource("form");
			}
			if(caseSource.equals("web_service")){
				cus.setSource("online_service");
			}
			if(caseSource.equals("mobile_service")){
				cus.setSource("online_service");
			}
			if(caseSource.equals("phone_service")){
				cus.setSource("phone_service");
			}
			if(caseSource.equals("wechat_service")){
				cus.setSource("wechat_service");
			}
			if(caseSource.equals("offline")){
				cus.setSource("offline");
			}
			if(caseSource.equals("email")){
				cus.setSource("email");
			}
			if(caseSource.equals("friends")){
				cus.setSource("friends");
			}
			if(caseSource.equals("ctrip")){
				cus.setSource("ctrip");
			}
			
			
			//caseMapper.saveCustomer(crmcase);
			caseMapper.saveCustomer(cus);
			crmcase.setCustomerId(cus.getCustomerId());
		} catch (Exception e) {
			logger.error("CaseService.seveCustomer() --> " + crmcase.getCustomerId() + "-->" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private Customer case2Customer(Case crmcase) {
		Customer cus = new Customer();
		if(crmcase.getChineseName()!=null){
			cus.setChineseName(crmcase.getChineseName());
		}
		if(crmcase.getEnglishName()!=null){
			cus.setEnglishName(crmcase.getEnglishName());
		}
		if(crmcase.getLevel()!=null){
			cus.setLevel(crmcase.getLevel());
		}
		if(crmcase.getLocation()!=null){
			cus.setLocation(crmcase.getLocation());
		}
		if(crmcase.getSource()!=null){
			cus.setSource(crmcase.getLocation());
		}
		if(crmcase.getTelephone()!=null){
			cus.setTelephone(crmcase.getTelephone());
		}
		if(crmcase.getMobile()!=null){
			cus.setMobilephone(crmcase.getMobile());
		}
		if(crmcase.getWechat()!=null){
			cus.setWechat(crmcase.getWechat());
		}
		if(crmcase.getQq()!=null){
			cus.setQq(crmcase.getQq());
		}
		if(crmcase.getEmail()!=null){
			cus.setEmail(crmcase.getEmail());
		}
		
		return cus;
	}

	/**
	 * 新增询单
	 * 
	 * @param case
	 * @return
	 */

	public void saveCase(Case crmcase) {
		try {
			
			caseMapper.saveCase(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.saveCase() --> " + crmcase + "-->" + e.getMessage());
			e.printStackTrace();

		}
	}	
		/*
		 * 修改客人信息
		 * 同时将客人等级设置为普通客人
		 */
	
	public void updateCustomer(Case crmcase) {
		
		try {
			Customer customer = getCustomerByCusId(crmcase.getCustomerId());
			setCusLevel(customer);
			if(crmcase.getChineseName()!=null){customer.setChineseName(crmcase.getChineseName());}
			if(crmcase.getAgeGroup()!=null){customer.setAgeGroup(crmcase.getAgeGroup());}
			if(crmcase.getBirthday()!=null){customer.setBirthday(crmcase.getBirthday());}
			if(crmcase.getEmail()!=null){customer.setEmail(crmcase.getEmail());}
			if(crmcase.getEnglishName()!=null){customer.setEnglishName(crmcase.getEnglishName());}
			if(crmcase.getGender()!=null){customer.setGender(crmcase.getGender());}			
			if(crmcase.getLocation()!=null){customer.setLocation(crmcase.getLocation());}
			if(crmcase.getMobile()!=null){customer.setMobilephone(crmcase.getMobile());}
			if(crmcase.getPortalId()!=null){customer.setPortalId(crmcase.getPortalId());}
			if(crmcase.getQq()!=null){customer.setQq(crmcase.getQq());}
			if(crmcase.getTelephone()!=null){customer.setTelephone(crmcase.getTelephone());}
			if(crmcase.getWechat()!=null){customer.setWechat(crmcase.getWechat());}
			caseMapper.updateCustomer(customer);
			
/*			crmcase.setStatus("1");
			caseMapper.saveCase(crmcase);*/

			
/*			if(!customer.getLevel().equals("0")){
				customer.setLevel(crmcase.getLevel());
			}else{
				customer.setLevel("0");
			}	*/			
			
		} catch (Exception e) {
			logger.error("CaseService.updateCustomer() --> " + crmcase + "-->" + e.getMessage());
			e.printStackTrace();

		}
	}	
		
//		try {

/*				Customer customer2=new Customer();
>>>>>>> 9fe0568af00ba8628041b1c4ab2cd7ff6a525b45
				customer2.setCustomerId(customer.getCustomerId());
				if(crmcase.getChineseName()!=null){customer2.setChineseName(crmcase.getChineseName());}
				if(crmcase.getAgeGroup()!=null){customer2.setAgeGroup(crmcase.getAgeGroup());}
				if(crmcase.getBirthday()!=null){customer2.setBirthday(crmcase.getBirthday());}
				if(crmcase.getEmail()!=null){customer2.setEmail(crmcase.getEmail());}
				if(crmcase.getEnglishName()!=null){customer2.setEnglishName(crmcase.getEnglishName());}
				if(crmcase.getGender()!=null){customer2.setGender(crmcase.getGender());}			
				if(crmcase.getLocation()!=null){customer2.setLocation(crmcase.getLocation());}
				if(crmcase.getMobile()!=null){customer2.setMobilephone(crmcase.getMobile());}
				if(crmcase.getPortalId()!=null){customer2.setPortalId(crmcase.getPortalId());}
				if(crmcase.getQq()!=null){customer2.setQq(crmcase.getQq());}
				if(crmcase.getSource()!=null){customer2.setSource(crmcase.getSource());}
				if(crmcase.getTelephone()!=null){customer2.setTelephone(crmcase.getTelephone());}
				if(crmcase.getWechat()!=null){customer2.setWechat(crmcase.getWechat());}
				if(!customer2.getLevel().equals("0")){
					customer2.setLevel(crmcase.getLevel());
				}else{
					customer2.setLevel("0");
				}				
				caseMapper.updateCustomer(customer2);
<<<<<<< HEAD
				crmcase.setCustomerId(customer.getCustomerId());
			}else{
				int customerId = caseMapper.saveCustomer(crmcase);
				crmcase.setCustomerId(customerId);
=======
				crmcase.setCustomerId(customer.getCustomerId());*/
/*			}else{
				//生成新客人
				int customerId = caseMapper.saveCustomer(crmcase);
				crmcase.setCustomerId(crmcase.getCustomerId());
>>>>>>> 9fe0568af00ba8628041b1c4ab2cd7ff6a525b45
			}		
			crmcase.setStatus("1");
			caseMapper.saveCase(crmcase);*/
/*		} catch (Exception e) {
			logger.error("CaseService.saveCase() --> " + crmcase + "-->" + e.getMessage());
			e.printStackTrace();
			return map;
		}
		return map;*/
	
	/*
	 * 设置客人等级
	 */
	private void setCusLevel(Customer customer) {
		if(customer.getLevel()!=null){	
			int cusLevel = Integer.parseInt(customer.getLevel());
			if(cusLevel!=3){
				customer.setLevel("2");
			}
		}
		else{
			customer.setLevel("2");
		}
	
	}

	private Customer getCustomerByCusId(Integer customerId) {
		Customer customer = null;
		try {
			customer = caseMapper.getCustomerByCusId(customerId);
		} catch (Exception e) {
			logger.error("CaseService.getCustomerById() --> " + customerId + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}

	/**
	 * 根据主键获取询单信息
	 * 
	 * @param id
	 * @return
	 */
	public Case getCaseById(int id) {
		Case crmcase = null;
		try {
			crmcase = caseMapper.getCaseById(id);
		} catch (Exception e) {
			logger.error("CaseService.getCaseById() --> " + id + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
	
	/**
	 * 根据作用域获得参数
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getParameterInfo(String domain) {
		List<EntityList> crmcase = null;
		try {
			crmcase = caseMapper.getParameterInfo(domain);
		} catch (Exception e) {
			logger.error("CaseService.getParameterInfo() --> " + domain + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
	
	/**
	 * 获得客人信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getCustomer() {
		List<EntityList> customerList = null;
		try {
			customerList = caseMapper.getCustomer();
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			customerList = null;
		}
		return customerList;
	}
	
	/**
	 * 根据id获得客人简单信息
	 * @return
	 */
	public List<EntityList> getCustomerById(int customerId) {
		List<EntityList> customer = null;
		try {
			customer = caseMapper.getCustomerById(customerId);
		} catch (Exception e) {
			logger.error("CaseService.getCustomer() --> -->" + e.getMessage());
			customer = null;
		}
		return customer;
	}
	
	/**
	 * 根据id获得客人基本信息
	 * @param i
	 * @return
	 */
	public Customer getCustomerInfoById(int customerId) {
		Customer customer = null;
		try{
			customer=caseMapper.getCustomerInfoById(customerId);
		} catch(Exception e) {
			logger.error("CaseService.getCustomerInfo() --> -->"+e.getMessage());
			customer = null;
		}
		return customer;
	}

	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getUser() {
		List<EntityList> userList = null;
		try {
			userList = caseMapper.getUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			userList = null;
		}
		return userList;
	}
	
	/**
	 * 获得客服用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getAllUser() {
		List<EntityList> users = null;
		try {
			users = caseMapper.getAllUser();
		} catch (Exception e) {
			logger.error("CaseService.getUser() --> -->" + e.getMessage());
			users = null;
		}
		return users;
	}
	
	/**
	 * 获得销售信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSales() {
		List<EntityList> sales = null;
		try {
			sales = caseMapper.getSales();
		} catch (Exception e) {
			logger.error("CaseService.getSales() --> -->" + e.getMessage());
			sales = null;
		}
		return sales;
	}
	
	/**
	 * 获得地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public List<EntityList> getSalesByAgency(List<String> destinationList) {
		List<EntityList> agencys = new ArrayList<>();
		try {
			agencys = caseMapper.getSalesByAgency(destinationList);
		} catch (Exception e) {
			logger.error("CaseService.getSalesByAgency() --> -->" + e.getMessage());
			agencys = null;
		}
		return agencys;
	}
	
	/**
	 * 更新询单信息
	 * 
	 * @param case
	 * @return zyy 10-19
	 */
	public void updateCase(Case crmcase) {

		try {
			caseMapper.updateCase(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + crmcase + "-->" + e.getMessage());
		}

	}

	/**
	 * 询单生成订单时更改询单状态
	 * 
	 * @param case
	 * @return
	 */
	public boolean case2order(int id) {
		boolean judge = false;
		try {
			Case  crmcase= caseMapper.getCaseById(id);
			if (crmcase != null) {
				crmcase.setStatus("2");
				caseMapper.updateCase(crmcase);
				judge = true;
			} else {
				judge = false;
			}
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + id + "-->" + e.getMessage());
			judge = false;
		}
		return judge;
	}
	
	/**
	 * 询单分配地接社时，客人没有邮箱，询单状态改为“地接社设计中”
	 */
	public boolean case2orderNoEmail(int id) {
		boolean judge = false;
		try {
			Case crmcase = caseMapper.getCaseById(id);
			if (crmcase != null) {
				crmcase.setStatus("2");
				caseMapper.updateCase(crmcase);
				judge = true;
			} else {
				judge = false;
			}
		} catch (Exception e) {
			logger.error("CaseService.updateCase() --> " + id + "-->" + e.getMessage());
			judge = false;
		}
		return judge;
	}
	
	/**
	 * 根据询单id查询order表中同一caseId下的order.status!=4的数量
	 * 
	 * @param case
	 * @return
	 */
	public int caseStatus(int caseId) {
		int sum = caseMapper.caseStatus(caseId);
		return sum;
	}
	/**
	 * 询单失效
	 * 
	 * @param case_id
	 * @return
	 */
	public boolean deleteCaseById(int caseId) {

		boolean judge = false;

		try {
			caseMapper.deleteCaseById(caseId);
			judge = true;
		} catch (Exception e) {
			logger.error("CaseService.deleteCaseById() --> " + caseId + "-->" + e.getMessage());
			judge = false;
		}

		return judge;
	}
	/**
	 * 询单未成行
	 * 
	 * @param case_id
	 * @return
	 */
	public boolean deleteCaseNodealById(Map<String,Object> map) {
		
		boolean judge = false;
		
		try {
			
			int res = caseMapper.deleteCaseNodealById(map);
			if (res > 0)
				judge = true;
			else
				judge = false;
			
		} catch (Exception e) {
			logger.error("CaseService.deleteCaseById() --> " + map.get("caseId") + "-->" + e.getMessage());
			judge = false;
		}
		
		return judge;
	}
	
	/*
	 * 出发时间0,1（未确定，已确定）
	 */
	public Case validateStartTime(Case crmcase){
		String startTime = crmcase.getStartTime();
		if(startTime==null||startTime.isEmpty()||Integer.parseInt(startTime)!=1){
			crmcase.setStartTime("0");
		}
		return crmcase;
	}

	public Case getCaseByOrderId(int orderId) {
		Case crmcase = null;
		try {
			crmcase = caseMapper.getCaseByOrderId(orderId);
		} catch (Exception e) {
			logger.error("CaseService.getCaseByOrderId() --> " + orderId + "-->" + e.getMessage());
			crmcase = null;
		}
		return crmcase;
	}
		
	
	public Json validatePortalId(JSONObject jsonObject, Json j) {
		try {
			
			if(jsonObject.has("portal_id")&&!jsonObject.getString("protal_id").equals("")){
				j.setSuccess(true);
			}
			else {
				j.setMsg("找不到客人Id");
			}
			}catch (Exception e) {
				e.getMessage();
		}
		return j;
	}
	
	/**
	 * 根据Json信息校验必填字段
	 * 
	 * @param 
	 * @return
	 */
	public Json validateUserInfo(JSONObject jsonobject, Json j) {
		try {
    		if(!jsonobject.has("customer_name_zh") || jsonobject.getString("customer_name_zh").equals("")){j.setMsg("立刻咨询验证失败，找不到中文名");}
    		else if(!jsonobject.has("requirement") || jsonobject.getString("requirement").equals("")){j.setMsg("立刻咨询验证失败，找不到客人要求");}
    		else if((!jsonobject.has("email") || jsonobject.getString("email").equals("")) &&
    				(!jsonobject.has("mobilephone") || jsonobject.getString("mobilephone").equals("")) &&
    				(!jsonobject.has("wechat") || jsonobject.getString("wechat").equals(""))){j.setMsg("立刻咨询验证失败，找不到联系方式");}
    		else{
    			j.setSuccess(true);
    		}
			}catch (Exception e) {
				e.getMessage();
		}
		return j;
	}

	/**
	 * 根据Json信息生成询单
	 * 
	 * @param 
	 * @return
	 */
	public Case Json2case(JSONObject jsonObject) {
		Case crmcase = new Case();
		Customer customer = null;
		try {	
			if(jsonObject.has("portal_id") && !jsonObject.getString("portal_id").equals("")){
				int portalId = Integer.valueOf(jsonObject.getString("portal_id"));
				customer = getCustomerByPortalId(portalId);
				crmcase.setCustomerId(customer.getCustomerId());
				
				if(jsonObject.has("email") && !jsonObject.getString("email").equals("")){customer.setEmail(jsonObject.getString("email"));}
				if(jsonObject.has("customer_name_zh") && !jsonObject.getString("customer_name_zh").equals("")){customer.setChineseName(jsonObject.getString("customer_name_zh"));}
				if(jsonObject.has("customer_name_en") && !jsonObject.getString("customer_name_en").equals("")){customer.setEnglishName(jsonObject.getString("customer_name_en"));}
				if(jsonObject.has("mobilephone") && !jsonObject.getString("mobilephone").equals("")){customer.setMobilephone(jsonObject.getString("mobilephone"));}
				if(jsonObject.has("wechat") && !jsonObject.getString("wechat").equals("")){customer.setWechat(jsonObject.getString("wechat"));}
				if(jsonObject.has("qq") && !jsonObject.getString("qq").equals("")){customer.setQq(jsonObject.getString("qq"));}
				caseMapper.updateCustomer(customer);
				crmcase.setEmail(customer.getEmail());
				crmcase.setChineseName(customer.getChineseName());
				crmcase.setEnglishName(customer.getEnglishName());
				crmcase.setMobile(customer.getMobilephone());
				crmcase.setWechat(customer.getWechat());
				crmcase.setQq(customer.getQq());
				}
			
			crmcase.setStatus("0");
    		if(jsonObject.has("requirement") && !jsonObject.getString("requirement").equals("")){crmcase.setRequirement(jsonObject.getString("requirement"));}
    		if(jsonObject.has("customer_name_zh") && !jsonObject.getString("customer_name_zh").equals("")){customer.setChineseName(jsonObject.getString("customer_name_zh"));}
    		if(jsonObject.has("customer_name_en") && !jsonObject.getString("customer_name_en").equals("")){customer.setEnglishName(jsonObject.getString("customer_name_en"));}
    		if(jsonObject.has("email") && !jsonObject.getString("email").equals("")){customer.setEmail(jsonObject.getString("email"));}
    		if(jsonObject.has("mobilephone") && !jsonObject.getString("mobilephone").equals("")){customer.setMobilephone(jsonObject.getString("mobilephone"));}
			if(jsonObject.has("wechat") && !jsonObject.getString("wechat").equals("")){customer.setWechat(jsonObject.getString("wechat"));}
			if(jsonObject.has("qq") && !jsonObject.getString("qq").equals("")){customer.setQq(jsonObject.getString("qq"));}
		
    		if(jsonObject.has("with_who") && !jsonObject.getString("with_who").equals("")){crmcase.setWithwho(jsonObject.getString("with_who"));}	 
    		if(jsonObject.has("adult") && !jsonObject.getString("adult").equals("")){crmcase.setAdult(jsonObject.getInt("adult"));}	 
    		if(jsonObject.has("children") && !jsonObject.getString("children").equals("")){crmcase.setChildren(jsonObject.getInt("children"));}	 
    		if(jsonObject.has("baby") && !jsonObject.getString("baby").equals("")){crmcase.setBaby(jsonObject.getInt("baby"));}	 
    		if(jsonObject.has("start_time") && !jsonObject.getString("start_time").equals("")){crmcase.setStartTime(jsonObject.getString("start_time"));}	 
    		if(jsonObject.has("start_month") && !jsonObject.getString("start_month").equals("")){
    			Date startmonth = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(jsonObject.getString("start_month"));
    			crmcase.setStartMonth(startmonth);}	 
    		if(jsonObject.has("start_date") && !jsonObject.getString("start_date").equals("")){
    			Date startdate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(jsonObject.getString("start_date"));
    			crmcase.setStartDate(startdate);}
    		if(jsonObject.has("end_date") && !jsonObject.getString("end_date").equals("")){
    			Date enddate = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(jsonObject.getString("end_date"));
    			crmcase.setEndDate(enddate);}
    		if(jsonObject.has("during") && !jsonObject.getString("during").equals("")){crmcase.setDuring(jsonObject.getString("during"));}	 
    		if(jsonObject.has("hotel") && !jsonObject.getString("hotel").equals("")){crmcase.setHotel(jsonObject.getString("hotel"));}	 
    		if(jsonObject.has("meals") && !jsonObject.getString("meals").equals("")){crmcase.setMeals(jsonObject.getString("meals"));}	 
    		if(jsonObject.has("guide") && !jsonObject.getString("guide").equals("")){crmcase.setGuide(jsonObject.getString("guide"));}	 
    		if(jsonObject.has("budget") && !jsonObject.getString("budget").equals("")){crmcase.setBudget(jsonObject.getInt("budget"));}	 
    		if(jsonObject.has("sales_id") && !jsonObject.getString("sales_id").equals("")){
    			crmcase.setSalesId(jsonObject.getInt("sales_id"));
    			}	 
    		if(jsonObject.has("sales_name") && !jsonObject.getString("sales_name").equals("")){crmcase.setSalesName(jsonObject.getString("sales_name"));}	
    		if(jsonObject.has("destination_code") && !jsonObject.getString("destination_code").equals("")){crmcase.setDestinationCode(jsonObject.getString("destination_code"));}	
    		if(jsonObject.has("destination") && !jsonObject.getString("destination").equals("")){crmcase.setDestination(jsonObject.getString("destination"));}	
    		if(jsonObject.has("route_id") && !jsonObject.getString("route_id").equals("")){crmcase.setRouteId(jsonObject.getString("route_id"));}
    		if(jsonObject.has("route") && !jsonObject.getString("route").equals("")){crmcase.setRoute(jsonObject.getString("route"));}
    		if(jsonObject.has("passport") && !jsonObject.getString("passport").equals("")){crmcase.setPassport(jsonObject.getString("passport"));}
    		if(jsonObject.has("visa") && !jsonObject.getString("visa").equals("")){crmcase.setVisa(jsonObject.getString("visa"));}
    		if(jsonObject.has("flight") && !jsonObject.getString("flight").equals("")){crmcase.setFlight(jsonObject.getString("flight"));}
    		if(jsonObject.has("tailormade") && !jsonObject.getString("tailormade").equals("")){crmcase.setTailormade(jsonObject.getString("tailormade"));}
    		if(jsonObject.has("submit_type") && !jsonObject.getString("submit_type").equals("")){crmcase.setSubmitType(jsonObject.getString("submit_type"));}
    		if(jsonObject.has("source") && !jsonObject.getString("source").equals("")){crmcase.setSource(jsonObject.getString("source"));}
    		if(jsonObject.has("promote_code") && !jsonObject.getString("promote_code").equals("")){crmcase.setPromoteCode(jsonObject.getString("promote_code"));}
    		if(jsonObject.has("ip_address") && !jsonObject.getString("ip_address").equals("")){crmcase.setIpAddress(jsonObject.getString("ip_address"));}
		}catch (Exception e) {
			e.printStackTrace();
			crmcase.setCustomerId(0);
		}
			return crmcase;
		
	}

	public Customer getCustomerByPortalId(int portalId) {
		Customer customer = null;
		try {
			customer = caseMapper.getCustomerByPortalId(portalId);
		} catch (Exception e) {
			logger.error("CaseService.getCustomerByPortalId() --> " + portalId + "-->" + e.getMessage());
			customer = null;
		}
		return customer;
	}

	public QueryResult<Customer> queryCusByComm(Case crmcase, PageHelper ph, HttpServletRequest request) {
		QueryResult<Customer> result = new QueryResult<Customer>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", ph.getStart());
		map.put("length", ph.getLength());;
		
		if(crmcase.getEmail()!=null){
			map.put("email", crmcase.getEmail());
		}
		if(crmcase.getMobile()!=null){
			map.put("mobilephone", crmcase.getMobile());
		}
		if(crmcase.getWechat()!=null){
			map.put("wechat", crmcase.getWechat());
		}
		if(crmcase.getQq()!=null){
			map.put("qq", crmcase.getQq());
		}
		
		List<Customer> data = caseMapper.queryCusByComm(map);
		long count = caseMapper.countCusByComm(map);
			
		result.setData(data);
		result.setCountTotal(count);
		result.setCountFiltered(count);
	
		return result;
	}


	public void confirmPay(Case crmcase) {
		try {
			Case caseInfo = caseMapper.getCaseById(crmcase.getCaseId());
			caseInfo.setStatus("6");
			caseMapper.updateCase(caseInfo);
			
			caseMapper.updateOrderConPay(crmcase);
		} catch (Exception e) {
			logger.error("CaseService.confirmPay() --> " + crmcase + "-->" + e.getMessage());
		}
	}

}