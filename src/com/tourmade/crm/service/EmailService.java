package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.tourmade.crm.mapper.email.DemoEmailMapper;
import com.tourmade.crm.model.DemoCase;
import com.tourmade.crm.model.DemoEmail;
import com.tourmade.crm.model.DemoOrder;
import com.tourmade.crm.model.MailTemplate;
import com.tourmade.crm.model.MailTepBoat;

@Service
@Transactional(readOnly = false)
public class EmailService extends BaseService {
	
	@Autowired
	private DemoEmailMapper emailMapper;

	/**
	 * 查询邮件数据，分页展示
	 * 
	 * @param email
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoEmail> queryEmail(DemoEmail email, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoEmail> r = new QueryResult<DemoEmail>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoEmail> data = emailMapper.queryEmail(map);
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
	public String creatTemplate(DemoCase crmcase, DemoOrder order) {
		
		MailTemplate template = new MailTemplate();
		MailTepBoat boat = new MailTepBoat();
		String result = null;
		template.setAdult(""+crmcase.getAdult());
		template.setChildren(""+crmcase.getChildren());
		template.setBaby(""+crmcase.getBaby());
		template.setStart_time(crmcase.getStarttime());
		template.setStart_month(crmcase.getStartmonth());
		template.setDuring(crmcase.getDuring());
		template.setStart_date(crmcase.getStartdate());
		template.setEnd_date(crmcase.getEnddate());
		template.setBudget(order.getBudget());
		template.setRequirement(crmcase.getRequirement());
		template.setReplyto("mailto:"+order.getCustomeremailalias());
		if(crmcase.getRouteid() != null && !"".equals(crmcase.getRouteid())){
			String url = emailMapper.getRouteUrl();
			template.setRoute_url(url+crmcase.getRouteid());			
		}
		template.setRoute_name(crmcase.getRoute());
		if(order.getCustomerid() != 0){
			boat.setId(""+order.getCustomerid());
			boat = emailMapper.getCusZE(boat);
			template.setCustomername_zh(boat.getChinese());
			template.setCustomername_en(boat.getEnglish());
		}
		if(order.getSalesid() != 0){
			boat.setId(""+order.getSalesid());
			boat = emailMapper.getSalesZE(boat);
			template.setSalesname_zh(boat.getChinese());
			template.setSalesname_en(boat.getEnglish());
		}
		if(crmcase.getPreferlanguage() != null && !"".equals(crmcase.getPreferlanguage())){
			boat.setDomain("case.preferlanguage");
			boat.setValue(crmcase.getPreferlanguage());
			boat = emailMapper.getZhEn(boat);
			template.setPreferlanguage_zh(boat.getChinese());
			template.setPreferlanguage_en(boat.getEnglish());
		}
		if(crmcase.getWithwho() != null && !"".equals(crmcase.getWithwho())){
			boat.setDomain("case.withwho");
			boat.setValue(crmcase.getWithwho());
			boat = emailMapper.getZhEn(boat);
			template.setWithwho_zh(boat.getChinese());
			template.setWithwho_en(boat.getEnglish());
		}
		if(crmcase.getHotel() != null && !"".equals(crmcase.getHotel())){
			boat.setDomain("case.hotel");
			boat.setValue(crmcase.getHotel());
			boat = emailMapper.getZhEn(boat);
			template.setHotel_zh(boat.getChinese());
			template.setHotel_en(boat.getEnglish());
		}
		if(crmcase.getGuide() != null && !"".equals(crmcase.getGuide())){
			boat.setDomain("case.guide");
			boat.setValue(crmcase.getGuide());
			boat = emailMapper.getZhEn(boat);
			template.setGuide_zh(boat.getChinese());
			template.setGuide_en(boat.getEnglish());
		}
		if(crmcase.getMeals() != null && !"".equals(crmcase.getMeals())){
			boat.setDomain("case.meals");
			boat.setValue(crmcase.getMeals());
			boat = emailMapper.getZhEn(boat);
			template.setMeals_zh(boat.getChinese());
			template.setMeals_en(boat.getEnglish());
		}
		if(order.getDestination() != null && !"".equals(order.getDestination())){
			boat.setDomain("country");
			boat.setValue(order.getDestination());
			boat = emailMapper.getZhEn(boat);
			template.setDestination_zh(boat.getChinese());
			template.setDestination_en(boat.getEnglish());
		}
		if(crmcase.getPassport() != null && !"".equals(crmcase.getPassport())){
			boat.setDomain("case.passport");
			boat.setValue(crmcase.getPassport());
			boat = emailMapper.getZhEn(boat);
			template.setPassport_zh(boat.getChinese());
			template.setPassport_en(boat.getEnglish());
		}
		if(crmcase.getFlight() != null && !"".equals(crmcase.getFlight())){
			boat.setDomain("case.flight");
			boat.setValue(crmcase.getFlight());
			boat = emailMapper.getZhEn(boat);
			template.setFlight_zh(boat.getChinese());
			template.setFlight_en(boat.getEnglish());
		}
		if(crmcase.getVisa() != null && !"".equals(crmcase.getVisa())){
			boat.setDomain("case.visa");
			boat.setValue(crmcase.getVisa());
			boat = emailMapper.getZhEn(boat);
			template.setVisa_zh(boat.getChinese());
			template.setVisa_en(boat.getEnglish());
		}
		if(crmcase.getTailormade() != null && !"".equals(crmcase.getTailormade())){
			boat.setDomain("case.tailormade");
			boat.setValue(crmcase.getTailormade());
			boat = emailMapper.getZhEn(boat);
			template.setTailormade_zh(boat.getChinese());
			template.setTailormade_en(boat.getEnglish());
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
		String endpoint = "oss-cn-beijing.aliyuncs.com";
		
		//内网域名
		//private String endpoint = "tourmade.oss-cn-beijing-internal.aliyuncs.com";
		
		// AccessKey and AccessKeySecret
		String accessKeyId = "R0ZPaQkN0Abjk9Pj";
		String accessKeySecret = "9LZt0R2sSVi9JsxOCN6yzVO2wuPM6S";
		String bucket = "bk-test-1";
		String key = "发给地接社的第一封邮件的模板";
		
		BufferedReader reader = null;
		String result = null;
		try {
			//File f = new File(template.getTemplatepath());
			// 创建OSSClient实例
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			
			OSSObject ossObject = ossClient.getObject(bucket, key);
			
				//InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
				reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
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
					if (null != template.getSalesname_zh() && !"".equals(template.getSalesname_zh())) {
						result = result.replace("${salesname_zh}",
								template.getSalesname_zh());
					}
					else{result = result.replace("${salesname_zh}","");}
					
					if (null != template.getSalesname_en() && !"".equals(template.getSalesname_en())) {
						result = result.replace("${salesname_en}",
								template.getSalesname_en());
					}
					else{result = result.replace("${salesname_en}","");}
					
					if (null != template.getCustomername_zh() && !"".equals(template.getCustomername_zh())) {
						result = result.replace("${customername_zh}",
								template.getCustomername_zh());
					}
					else{result = result.replace("${customername_zh}","");}
					
					if (null != template.getCustomername_en() && !"".equals(template.getCustomername_en())) {
						result = result.replace("${customername_en}",
								template.getCustomername_en());
					}
					else{result = result.replace("${customername_en}","");}

					if (null != template.getPreferlanguage_zh() && !"".equals(template.getPreferlanguage_zh())) {
						result = result.replace("${preferlanguage_zh}",
								template.getPreferlanguage_zh());
					}
					else{result = result.replace("${preferlanguage_zh}","");}
					
					if (null != template.getPreferlanguage_en() && !"".equals(template.getPreferlanguage_en())) {
						result = result.replace("${preferlanguage_en}",
								template.getPreferlanguage_en());
					}
					else{result = result.replace("${preferlanguage_en}","");}
					
					if (null != template.getWithwho_zh() && !"".equals(template.getWithwho_zh())) {
						result = result.replace("${withwho_zh}",
								template.getWithwho_zh());
					}
					else{result = result.replace("${withwho_zh}","");}
					
					if (null != template.getWithwho_en() && !"".equals(template.getWithwho_en())) {
						result = result.replace("${withwho_en}",
								template.getWithwho_en());
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

					if (null != template.getStart_time() && !"".equals(template.getStart_time())) {
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
						}
					
					if (null != template.getStart_month() && !"".equals(template.getStart_month())) {
						result = result.replace("${start_month}",
								format.format(template.getStart_month()));
					}
					else{result = result.replace("${start_month}","");}

					if (null != template.getDuring() && !"".equals(template.getDuring())) {
						result = result.replace("${during}",
								template.getDuring());
					}
					else{result = result.replace("${during}","");}
					
					if (null != template.getStart_date() && !"".equals(template.getStart_date())) {
						result = result.replace("${start_date}",
								format.format(template.getStart_date()));
					}
					else{result = result.replace("${start_date}","");}
					
					if (null != template.getEnd_date() && !"".equals(template.getEnd_date())) {
						result = result.replace("${end_date}",
								format.format(template.getEnd_date()));
					}
					else{result = result.replace("${end_date}","");}
					
					if (null != template.getHotel_zh() && !"".equals(template.getHotel_zh())) {
						result = result.replace("${hotel_zh}",
								template.getHotel_zh());
					}
					else{result = result.replace("${hotel_zh}","");}
					
					if (null != template.getHotel_en() && !"".equals(template.getHotel_en())) {
						result = result.replace("${hotel_en}",
								template.getHotel_en());
					}
					else{result = result.replace("${hotel_en}","");}
					
					if (null != template.getMeals_zh() && !"".equals(template.getMeals_zh())) {
						result = result.replace("${meals_zh}",
								template.getMeals_zh());
					}
					else{result = result.replace("${meals_zh}","");}
					
					if (null != template.getMeals_en() && !"".equals(template.getMeals_en())) {
						result = result.replace("${meals_en}",
								template.getMeals_en());
					}
					else{result = result.replace("${meals_en}","");}

					if (null != template.getGuide_zh() && !"".equals(template.getGuide_zh())) {
						result = result.replace("${guide_zh}",
								template.getGuide_zh());
					}
					else{result = result.replace("${guide_zh}","");}

					if (null != template.getGuide_en() && !"".equals(template.getGuide_en())) {
						result = result.replace("${guide_en}",
								template.getGuide_en());
					}
					else{result = result.replace("${guide_en}","");}

					if (null != template.getBudget() && !"".equals(template.getBudget())) {
						result = result.replace("${budget}",
								template.getBudget());
					}
					else{result = result.replace("${budget}","");}

					if (null != template.getDestination_zh() && !"".equals(template.getDestination_zh())) {
						result = result.replace("${destination_zh}",
								template.getDestination_zh());
					}
					else{result = result.replace("${destination_zh}","");}

					if (null != template.getDestination_en() && !"".equals(template.getDestination_en())) {
						result = result.replace("${destination_en}",
								template.getDestination_en());
					}
					else{result = result.replace("${destination_en}","");}

					if (null != template.getPassport_zh() && !"".equals(template.getPassport_zh())) {
						result = result.replace("${passport_zh}",
								template.getPassport_zh());
					}
					else{result = result.replace("${passport_zh}","");}

					if (null != template.getPassport_en() && !"".equals(template.getPassport_en())) {
						result = result.replace("${passport_en}",
								template.getPassport_en());
					}
					else{result = result.replace("${passport_en}","");}

					if (null != template.getVisa_zh() && !"".equals(template.getVisa_zh())) {
						result = result.replace("${visa_zh}",
								template.getVisa_zh());
					}
					else{result = result.replace("${visa_zh}","");}

					if (null != template.getVisa_en() && !"".equals(template.getVisa_en())) {
						result = result.replace("${visa_en}",
								template.getVisa_en());
					}
					else{result = result.replace("${visa_en}","");}

					if (null != template.getFlight_zh() && !"".equals(template.getFlight_zh())) {
						result = result.replace("${flight_zh}",
								template.getFlight_zh());
					}
					else{result = result.replace("${flight_zh}","");}

					if (null != template.getFlight_en() && !"".equals(template.getFlight_en())) {
						result = result.replace("${flight_en}",
								template.getFlight_en());
					}
					else{result = result.replace("${flight_en}","");}

					if (null != template.getTailormade_zh() && !"".equals(template.getTailormade_zh())) {
						result = result.replace("${tailormade_zh}",
								template.getTailormade_zh());
					}
					else{result = result.replace("${tailormade_zh}","");}

					if (null != template.getTailormade_en() && !"".equals(template.getTailormade_en())) {
						result = result.replace("${tailormade_en}",
								template.getTailormade_en());
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

					if (null != template.getRoute_url() && !"".equals(template.getRoute_url())) {
						result = result.replace("${route_url}",
								template.getRoute_url());
						result = result.replace("${route_name}", 
								template.getRoute_name());
					}
					else{result = result.replace("${route_url}","");
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
	
	/**
	 * 新增邮件
	 * 
	 * @param email
	 * @return
	 */
	public void saveEmail(DemoOrder order, String result) {
		DemoEmail email = new DemoEmail();
		try {
			email.setContent(result);
			email.setAcount("customer");
			email.setOrderid(order.getOrderid());
			email.setReciever(order.getAgencyemailreal());
			email.setSender(order.getCustomeremailalias());
			email.setSendname(order.getCustomername());
			email.setSubject(order.getCustomername()+"去"+order.getDestination()+"的需求");
			emailMapper.saveEmail(email);
		} catch (Exception e) {
			logger.error("EmailService.saveEmail() --> " + email + "-->" + e.getMessage());
			e.printStackTrace();
		}
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
}