package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.Case;
import com.tourmade.crm.entity.Email;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.MailTemplate;
import com.tourmade.crm.entity.MailTepBoat;
import com.tourmade.crm.mapper.emailQueue.EmailMapper;

@Service
@Transactional(readOnly = false)
public class EmailService extends BaseService {
	
	@Autowired
	private EmailMapper emailMapper;

	/**
	 * 查询邮件数据，分页展示
	 * 
	 * @param email
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Email> queryEmail(Email email, PageHelper ph, HttpServletRequest request) {

		QueryResult<Email> r = new QueryResult<Email>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<Email> data = emailMapper.queryEmail(map);
		long count = emailMapper.countEmail(email);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);
	
		return r;
	}
	
	/**
	 * 生成模板
	 * 
	 * @param email
	 * @return
	 */
	public String creatTemplate(Case crmcase, Order order) {
		
		MailTemplate template = new MailTemplate();
		MailTepBoat boat = new MailTepBoat();
		String result = null;
		template.setAdult(""+crmcase.getAdult());
		template.setChildren(""+crmcase.getChildren());
		template.setBaby(""+crmcase.getBaby());
		template.setStartTime(crmcase.getStartTime());
		template.setStartMonth(crmcase.getStartMonth());
		template.setDuring(crmcase.getDuring());
		template.setStartDate(crmcase.getStartDate());
		template.setEndDate(crmcase.getEndDate());
		template.setSubject(getSubject(order));
//		String budget = DecimalFormat.getNumberInstance().format(Integer.parseInt(order.getBudget()));
		String budget="";
		if(crmcase.getBudget()!=null){
			budget = DecimalFormat.getNumberInstance().format(crmcase.getBudget());
		}
		template.setBudget(budget);
		template.setRequirement(crmcase.getRequirement());
		
		template.setReplyto(order.getCustomerReEmailAlias());
		
		if(order.getOrderId() != 0){
			template.setOrderId(order.getOrderId());
		}
		
		if(crmcase.getRouteId() != null && !"".equals(crmcase.getRouteId())){
			String url = emailMapper.getRouteUrl();
			template.setRouteUrl(url+crmcase.getRouteId());			
		}
		template.setRouteName(crmcase.getRoute());
		template.setCustomerChineseName(crmcase.getChineseName());
		template.setCustomerEnglishName(crmcase.getEnglishName());
		/*if(crmcase.getCustomerId() != 0){
			boat.setId(""+crmcase.getCustomerId());
			boat = emailMapper.getCusZE(boat);
			template.setCustomerChineseName(boat.getChinese());
			template.setCustomerEnglishName(boat.getEnglish());
		}*/
		if(order.getSalesId() != 0){
			boat.setId(""+order.getSalesId());
			boat = emailMapper.getSalesZE(boat);
			template.setSalesChineseName(boat.getChinese());
			template.setSalesEnglishName(boat.getEnglish());
		}
		if(crmcase.getPreferLanguage() != null && !"".equals(crmcase.getPreferLanguage())){
			boat.setDomain("case.preferlanguage");
			boat.setValue(crmcase.getPreferLanguage());
			boat = emailMapper.getZhEn(boat);
			template.setPreferChineseLanguage(boat.getChinese());
			template.setPreferEnglishLanguage(boat.getEnglish());
		}
		if(crmcase.getWithwho() != null && !"".equals(crmcase.getWithwho())){
			boat.setDomain("case.withwho");
			boat.setValue(crmcase.getWithwho());
			boat = emailMapper.getZhEn(boat);
			template.setWithwhoChinese(boat.getChinese());
			template.setWithwhoEnglish(boat.getEnglish());
		}
		if(crmcase.getHotel() != null && !"".equals(crmcase.getHotel())){
			boat.setDomain("case.hotel");
			boat.setValue(crmcase.getHotel());
			boat = emailMapper.getZhEn(boat);
			template.setHotelChinese(boat.getChinese());
			template.setHotelEnglish(boat.getEnglish());
		}
		if(crmcase.getGuide() != null && !"".equals(crmcase.getGuide())){
			boat.setDomain("case.guide");
			boat.setValue(crmcase.getGuide());
			boat = emailMapper.getZhEn(boat);
			template.setGuideChinese(boat.getChinese());
			template.setGuideEnglish(boat.getEnglish());
		}
		if(crmcase.getMeals() != null && !"".equals(crmcase.getMeals())){
			boat.setDomain("case.meals");
			boat.setValue(crmcase.getMeals());
			boat = emailMapper.getZhEn(boat);
			template.setMealsChinese(boat.getChinese());
			template.setMealsEnglish(boat.getEnglish());
		}
		if(crmcase.getDestination() != null && !"".equals(crmcase.getDestination())){
	
			String[] destination = order.getDestination().split(",");
			String destinationChinese = "";
			String destinationEnglish = "";
			for(int i=0; i<destination.length; i++){
				boat.setDomain("country");
				boat.setValue(destination[i]);
				boat = emailMapper.getZhEn(boat);
				destinationChinese += boat.getChinese() + ",";
				destinationEnglish += boat.getEnglish() + ",";
			}
			destinationChinese=destinationChinese.substring(0, destinationChinese.length()-1);
			destinationEnglish=destinationEnglish.substring(0, destinationEnglish.length()-1);
			template.setDestinationChinese(destinationChinese);
			template.setDestinationEnglish(destinationEnglish);
		}
		if(crmcase.getPassport() != null && !"".equals(crmcase.getPassport())){
			boat.setDomain("case.passport");
			boat.setValue(crmcase.getPassport());
			boat = emailMapper.getZhEn(boat);
			template.setPassportChinese(boat.getChinese());
			template.setPassportEnglish(boat.getEnglish());
		}
		if(crmcase.getFlight() != null && !"".equals(crmcase.getFlight())){
			boat.setDomain("case.flight");
			boat.setValue(crmcase.getFlight());
			boat = emailMapper.getZhEn(boat);
			template.setFlightChinese(boat.getChinese());
			template.setFlightEnglish(boat.getEnglish());
		}
		if(crmcase.getVisa() != null && !"".equals(crmcase.getVisa())){
			boat.setDomain("case.visa");
			boat.setValue(crmcase.getVisa());
			boat = emailMapper.getZhEn(boat);
			template.setVisaChinese(boat.getChinese());
			template.setVisaEnglish(boat.getEnglish());
		}
		if(crmcase.getTailormade() != null && !"".equals(crmcase.getTailormade())){
			boat.setDomain("case.tailormade");
			boat.setValue(crmcase.getTailormade());
			boat = emailMapper.getZhEn(boat);
			template.setTailormadeChinese(boat.getChinese());
			template.setTailormadeEnglish(boat.getEnglish());
		}
		try{
			result = getMailContent(template);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据模板生成邮件正文
	 * 
	 * @param template
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public String getMailContent(MailTemplate template) throws Exception {
		//外网域名
		String endpoint = emailMapper.getUrl("alioss.endpoint");
		
		//内网域名
		//private String endpoint = "tourmade.oss-cn-beijing-internal.aliyuncs.com";
		
		// AccessKey and AccessKeySecret
		String accessKeyId = emailMapper.getUrl("alioss.accessKeyId");
		String accessKeySecret = emailMapper.getUrl("alioss.accessKeySecret");
		String bucket = emailMapper.getUrl("alioss.bucket");
		String key = emailMapper.getUrl("alioss.key");
		
		BufferedReader reader = null;
		String result = null;
		try {
			//File f = new File(template.getTemplatepath());
			// 创建OSSClient实例
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			
			OSSObject ossObject = ossClient.getObject(bucket, key);
			
				//InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
				reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent(),"UTF-8"));
			    //reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/TM/Desktop/order.html"),"UTF-8"));
				
				String tempString = null;
				StringBuffer str = new StringBuffer();
				int line = 1;
				while ((tempString = reader.readLine()) != null) {
					str.append(tempString + "\n");
					line++;
				}
				reader.close();
				result = str.toString();
			if(ossObject.getObjectContent() != null){	
				if (null != template) {
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					if (null != template.getSalesChineseName() && !"".equals(template.getSalesChineseName())) {
						result = result.replace("${salesname}",
								template.getSalesChineseName());
					}
					else{result = result.replace("${salesname}","");}
					
					/*if (null != template.getSalesname_en() && !"".equals(template.getSalesname_en())) {
						result = result.replace("${salesname_en}",
								template.getSalesname_en());
					}
					else{result = result.replace("${salesname_en}","");}*/
					
					if (null != template.getCustomerChineseName() && !"".equals(template.getCustomerChineseName())) {
						result = result.replace("${customername_zh}",
								template.getCustomerChineseName());
					}
					else{result = result.replace("${customername_zh}","");}
					
					if (null != template.getCustomerEnglishName() && !"".equals(template.getCustomerEnglishName())) {
						result = result.replace("${customername_en}",
								template.getCustomerEnglishName());
					}
					else{
						if(null != template.getCustomerChineseName() && !"".equals(template.getCustomerChineseName())){
							result = result.replace("${customername_en}", 
								template.getCustomerChineseName());
						}
						else{result = result.replace("${customername_en}", "");}
					}

					if (null != template.getPreferChineseLanguage() && !"".equals(template.getPreferChineseLanguage())) {
						result = result.replace("${preferlanguage_zh}",
								template.getPreferChineseLanguage());
					}
					else{result = result.replace("${preferlanguage_zh}","");}
					
					if (null != template.getPreferEnglishLanguage() && !"".equals(template.getPreferEnglishLanguage())) {
						result = result.replace("${preferlanguage_en}",
								template.getPreferEnglishLanguage());
					}
					else{result = result.replace("${preferlanguage_en}","");}
					
					if (null != template.getWithwhoChinese() && !"".equals(template.getWithwhoChinese())) {
						result = result.replace("${withwho_zh}",
								template.getWithwhoChinese());
					}
					else{result = result.replace("${withwho_zh}","");}
					
					if (null != template.getWithwhoEnglish() && !"".equals(template.getWithwhoEnglish())) {
						result = result.replace("${withwho_en}",
								template.getWithwhoEnglish());
					}
					else{result = result.replace("${withwho_en}","");}
					
					if (null != template.getAdult() && !"".equals(template.getAdult())) {
						result = result.replace("${adult}",
								template.getAdult());
					}
					else{result = result.replace("${adult}","");}
					
					if (null != template.getChildren() && !"".equals(template.getChildren())) {
						result = result.replace("${children}",
								template.getChildren());
					}
					else{result = result.replace("${children}","");}

					if (null != template.getBaby() && !"".equals(template.getBaby())) {
						result = result.replace("${baby}",
								template.getBaby());
					}
					else{result = result.replace("${baby}","");}

					/*if (null != template.getStart_time() && !"".equals(template.getStart_time())) {
						if(template.getStart_time().equals("1")){
							result = result.replace("${start_time_zh}","已确定");
							result = result.replace("${start_time_en}","Decided");
						}
						if(template.getStart_time().equals("0")){
							result = result.replace("${start_time_zh}","未确定");
							result = result.replace("${start_time_en}","Undecided");
						}
					}
					else{
						result = result.replace("${start_time_zh}","");
						result = result.replace("${start_time_en}","");
						}*/
					
					if (null != template.getStartTime() && !"".equals(template.getStartTime())) {
						if(template.getStartTime().equals("1")){
							result = result.replace("${uncerDis}","none");
						}
						if(template.getStartTime().equals("0")){
							result = result.replace("${cerDis}","none");
						}
					}

					
					if(template.getOrderId() != 0){
						String pattern="0000000";
						  java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
						  result = result.replace("${orderid}", ""+df.format(template.getOrderId()));
					}
					else{
						result = result.replace("{orderid", "");
					}
					
					
					if (null != template.getStartMonth() && !"".equals(template.getStartMonth())) {
						result = result.replace("${start_month}",
								format.format(template.getStartMonth()));
					}
					else{result = result.replace("${start_month}","");}

					if (null != template.getDuring() && !"".equals(template.getDuring())) {
						result = result.replace("${during}",
								template.getDuring());
					}
					else{result = result.replace("${during}","");}
					
					if (null != template.getStartDate() && !"".equals(template.getStartDate())) {
						result = result.replace("${start_date}",
								format.format(template.getStartDate()));
					}
					else{result = result.replace("${start_date}","");}
					
					if (null != template.getEndDate() && !"".equals(template.getEndDate())) {
						result = result.replace("${end_date}",
								format.format(template.getEndDate()));
					}
					else{result = result.replace("${end_date}","");}
					
					if (null != template.getHotelChinese() && !"".equals(template.getHotelChinese())) {
						result = result.replace("${hotel_zh}",
								template.getHotelChinese());
					}
					else{result = result.replace("${hotel_zh}","");}
					
					if (null != template.getHotelEnglish() && !"".equals(template.getHotelEnglish())) {
						result = result.replace("${hotel_en}",
								template.getHotelEnglish());
					}
					else{result = result.replace("${hotel_en}","");}
					
					if (null != template.getMealsChinese() && !"".equals(template.getMealsChinese())) {
						result = result.replace("${meals_zh}",
								template.getMealsChinese());
					}
					else{result = result.replace("${meals_zh}","");}
					
					if (null != template.getMealsEnglish() && !"".equals(template.getMealsEnglish())) {
						result = result.replace("${meals_en}",
								template.getMealsEnglish());
					}
					else{result = result.replace("${meals_en}","");}

					if (null != template.getGuideChinese() && !"".equals(template.getGuideChinese())) {
						result = result.replace("${guide_zh}",
								template.getGuideChinese());
					}
					else{result = result.replace("${guide_zh}","");}

					if (null != template.getGuideEnglish() && !"".equals(template.getGuideEnglish())) {
						result = result.replace("${guide_en}",
								template.getGuideEnglish());
					}
					else{result = result.replace("${guide_en}","");}

					if (null != template.getBudget() && !"".equals(template.getBudget())) {
						result = result.replace("${budget}",
								template.getBudget());
					}
					else{result = result.replace("${budget}","");}

					if (null != template.getDestinationChinese() && !"".equals(template.getDestinationChinese())) {
						result = result.replace("${destination_zh}",
								template.getDestinationChinese());
					}
					else{result = result.replace("${destination_zh}","");}

					if (null != template.getDestinationEnglish() && !"".equals(template.getDestinationEnglish())) {
						result = result.replace("${destination_en}",
								template.getDestinationEnglish());
					}
					else{result = result.replace("${destination_en}","");}

					if (null != template.getPassportChinese() && !"".equals(template.getPassportChinese())) {
						result = result.replace("${passport_zh}",
								template.getPassportChinese());
					}
					else{result = result.replace("${passport_zh}","");}

					if (null != template.getPassportEnglish() && !"".equals(template.getPassportEnglish())) {
						result = result.replace("${passport_en}",
								template.getPassportEnglish());
					}
					else{result = result.replace("${passport_en}","");}

					if (null != template.getVisaChinese() && !"".equals(template.getVisaChinese())) {
						result = result.replace("${visa_zh}",
								template.getVisaChinese());
					}
					else{result = result.replace("${visa_zh}","");}

					if (null != template.getVisaEnglish() && !"".equals(template.getVisaEnglish())) {
						result = result.replace("${visa_en}",
								template.getVisaEnglish());
					}
					else{result = result.replace("${visa_en}","");}

					if (null != template.getFlightChinese() && !"".equals(template.getFlightChinese())) {
						result = result.replace("${flight_zh}",
								template.getFlightChinese());
					}
					else{result = result.replace("${flight_zh}","");}

					if (null != template.getFlightEnglish() && !"".equals(template.getFlightEnglish())) {
						result = result.replace("${flight_en}",
								template.getFlightEnglish());
					}
					else{result = result.replace("${flight_en}","");}

					if (null != template.getTailormadeChinese() && !"".equals(template.getTailormadeChinese())) {
						result = result.replace("${tailormade_zh}",
								template.getTailormadeChinese());
					}
					else{result = result.replace("${tailormade_zh}","");}

					if (null != template.getTailormadeEnglish() && !"".equals(template.getTailormadeEnglish())) {
						result = result.replace("${tailormade_en}",
								template.getTailormadeEnglish());
					}
					else{result = result.replace("${tailormade_en}","");}

					if (null != template.getRequirement() && !"".equals(template.getRequirement())) {
						result = result.replace("${requirement}",
								template.getRequirement());
					}
					else{result = result.replace("${requirement}","");}

					if (null != template.getReplyto() && !"".equals(template.getReplyto())) {
						result = result.replace("${replyto}",
								template.getReplyto());
					}
					else{result = result.replace("${replyto}","");}
					
					if (null != template.getSubject() && !"".equals(template.getSubject())) {
						result = result.replace("${replySubject}",
								template.getSubject());
					}
					
					if (null != template.getRouteUrl() && !"".equals(template.getRouteUrl())) {
						
						result = result.replace("${route_url}",
								template.getRouteUrl());
						
					}
					else{
						result = result.replace("${route_url}","");
					}
					
					if(null != template.getRouteName() && !"".equals(template.getRouteName())) {
					result = result.replace("${route_name}", 
							template.getRouteName());	
					}
					else{
						 result = result.replace("${route_name}","");}
					}
					
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return result;
	}
	
	
	public String getSubject(Order order){

			MailTepBoat boat = new MailTepBoat();
			
			String[] destination = order.getDestination().split(",");
			String destinationChinese = "";
			String destinationEnglish = "";
			for(int i=0; i<destination.length; i++){
				boat.setDomain("country");
				boat.setValue(destination[i]);
				boat = emailMapper.getZhEn(boat);
				destinationChinese += boat.getChinese() + ",";
				destinationEnglish += boat.getEnglish() + ",";
			}
			destinationChinese=destinationChinese.substring(0, destinationChinese.length()-1);
			destinationEnglish=destinationEnglish.substring(0, destinationEnglish.length()-1);
			
			boat.setId(""+order.getCustomerId());
			boat = emailMapper.getCusZE(boat);
			String customerChineseName = boat.getChinese();
			String customerEnglishName = boat.getEnglish();
			
			String subject = customerChineseName+"去"+destinationChinese+"的需求 / Enquiry for "
					+customerEnglishName+" about "+destinationEnglish;
			
			return subject;

	}
	
	/**
	 * 新增邮件
	 * 
	 * @param email
	 * @return
	 */
	public void saveEmail(Order order, String result) {
		Email email = new Email();
		try {
			
			email.setContent(result);
			email.setAcount("order");
			email.setOrderId(order.getOrderId());
			email.setReciever(order.getAgencySeEmailAlias());
			email.setSender(order.getCustomerReEmailAlias());
			email.setSendName(order.getCustomerName());
			email.setRecieveName(order.getSalesName());
			
			//得到跟单员姓名与邮箱，写入bccName与bcc字段中
			Email bccEmail = getBccEmail(order);
			email.setBcc(bccEmail.getBcc());
			email.setBccName(bccEmail.getBccName());
			
			email.setSubject(getSubject(order));
			emailMapper.saveEmail(email);
		} catch (Exception e) {
			logger.error("EmailService.saveEmail() --> " + email + "-->" + e.getMessage());
			e.printStackTrace();
		}
	}

	public Email getBccEmail(Order order) {
		Email bccEmail = emailMapper.getBccEmail(order.getOperator());
		return bccEmail;
	}



	/**
	 * 新增邮件
	 * 
	 * @param email
	 * @return
	 */
	public MailTepBoat getZhEn(MailTepBoat boat) {
		boat = emailMapper.getZhEn(boat);
		return boat;
	}
	
	/**
	 * 新增邮件队列
	 * 
	 * @param orderrecord
	 * @return
	 */
	public int saveEmailQueue(Email email) {

		
		try {
			emailMapper.saveEmail(email);
		} catch (Exception e) {
			logger.error("OrderRecordService.saveOrderRecord() --> " + email + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return email.getEmailId();
	}
}