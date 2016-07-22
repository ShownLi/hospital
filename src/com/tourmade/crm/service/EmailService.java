package com.tourmade.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	 * 新增邮件
	 * 
	 * @param email
	 * @return
	 */
	public String creatTemplate(DemoCase crmcase, DemoOrder order) {
		
		MailTemplate template = new MailTemplate();
		String result = null;
		
		template.setAdult(""+crmcase.getAdult());
		template.setChildren(""+crmcase.getChildren());
		template.setBaby(""+crmcase.getBaby());
		template.setBudget(order.getBudget());
		template.setStart_date(crmcase.getStartdate());
		template.setDuring(crmcase.getDuring());
		template.setRequirement(crmcase.getRequirement());
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
					if (null != template.getSalesname_zh()) {
						result = result.replace("${salesname_zh}",
								template.getSalesname_zh());
					}
					else{result = result.replace("${salesname_zh}","");}
					
					if (null != template.getSalesname_en()) {
						result = result.replace("${salesname_en}",
								template.getSalesname_en());
					}
					else{result = result.replace("${salesname_en}","");}
					
					if (null != template.getCustomername_zh()) {
						result = result.replace("${customername_zh}",
								template.getCustomername_zh());
					}
					else{result = result.replace("${customername_zh}","");}
					
					if (null != template.getCustomername_en()) {
						result = result.replace("${customername_en}",
								template.getCustomername_en());
					}
					else{result = result.replace("${customername_en}","");}
					
					if (null != template.getAdult()) {
						result = result.replace("${adult}",
								template.getAdult());
					}
					else{result = result.replace("${adult}","");}
					
					if (null != template.getChildren()) {
						result = result.replace("${children}",
								template.getChildren());
					}
					else{result = result.replace("${children}","");}

					if (null != template.getBaby()) {
						result = result.replace("${baby}",
								template.getBaby());
					}
					else{result = result.replace("${baby}","");}

					if (null != template.getStart_time()) {
						if(template.getStart_time() == "1"){
							result = result.replace("${start_time_zh}","已确定");
							result = result.replace("${start_time_en}","Decided");
						}
						if(template.getStart_time() == "0"){
							result = result.replace("${start_time_zh}","未确定");
							result = result.replace("${start_time_en}","Undecided");
						}
					}

					if (null != template.getStart_month()) {
						result = result.replace("${start_month}",
								template.getStart_month().toString());
					}
					else{result = result.replace("${start_month}","");}

					if (null != template.getDuring()) {
						result = result.replace("${during}",
								template.getDuring());
					}
					else{result = result.replace("${during}","");}
					
					if (null != template.getStart_date()) {
						result = result.replace("${start_date}",
								template.getStart_date().toString());
					}
					else{result = result.replace("${start_date}","");}
					
					if (null != template.getEnd_date()) {
						result = result.replace("${end_date}",
								template.getEnd_date().toString());
					}
					else{result = result.replace("${end_date}","");}
					
					if (null != template.getHotel_zh()) {
						result = result.replace("${hotel_zh}",
								template.getHotel_zh());
					}
					else{result = result.replace("${hotel_zh}","");}
					
					if (null != template.getHotel_en()) {
						result = result.replace("${hotel_en}",
								template.getHotel_en());
					}
					else{result = result.replace("${hotel_en}","");}
					
					if (null != template.getMeals_zh()) {
						result = result.replace("${meals_zh}",
								template.getMeals_zh());
					}
					else{result = result.replace("${meals_zh}","");}
					
					if (null != template.getMeals_en()) {
						result = result.replace("${meals_en}",
								template.getMeals_en());
					}
					else{result = result.replace("${meals_en}","");}

					if (null != template.getGuide_zh()) {
						result = result.replace("${guide_zh}",
								template.getGuide_zh());
					}
					else{result = result.replace("${guide_zh}","");}

					if (null != template.getGuide_en()) {
						result = result.replace("${guide_en}",
								template.getGuide_en());
					}
					else{result = result.replace("${guide_en}","");}

					if (null != template.getBudget()) {
						result = result.replace("${budget}",
								template.getBudget());
					}
					else{result = result.replace("${budget}","");}

					if (null != template.getDestination_zh()) {
						result = result.replace("${destination_zh}",
								template.getDestination_zh());
					}
					else{result = result.replace("${destination_zh}","");}

					if (null != template.getDestination_en()) {
						result = result.replace("${destination_en}",
								template.getDestination_en());
					}
					else{result = result.replace("${destination_en}","");}

					if (null != template.getPassport_zh()) {
						result = result.replace("${passport_zh}",
								template.getPassport_zh());
					}
					else{result = result.replace("${passport_zh}","");}

					if (null != template.getPassport_en()) {
						result = result.replace("${passport_en}",
								template.getPassport_en());
					}
					else{result = result.replace("${passport_en}","");}

					if (null != template.getVisa_zh()) {
						result = result.replace("${visa_zh}",
								template.getVisa_zh());
					}
					else{result = result.replace("${visa_zh}","");}

					if (null != template.getVisa_en()) {
						result = result.replace("${visa_en}",
								template.getVisa_en());
					}
					else{result = result.replace("${visa_en}","");}

					if (null != template.getFlight_zh()) {
						result = result.replace("${flight_zh}",
								template.getFlight_zh());
					}
					else{result = result.replace("${flight_zh}","");}

					if (null != template.getFlight_en()) {
						result = result.replace("${flight_en}",
								template.getFlight_en());
					}
					else{result = result.replace("${flight_en}","");}

					if (null != template.getTailormade_zh()) {
						result = result.replace("${tailormade_zh}",
								template.getTailormade_zh());
					}
					else{result = result.replace("${tailormade_zh}","");}

					if (null != template.getTailormade_en()) {
						result = result.replace("${tailormade_en}",
								template.getTailormade_en());
					}
					else{result = result.replace("${tailormade_en}","");}

					if (null != template.getRequirement()) {
						result = result.replace("${requirement}",
								template.getRequirement());
					}
					else{result = result.replace("${requirement}","");}

					if (null != template.getReplyto()) {
						result = result.replace("${replyto}",
								template.getReplyto());
					}
					else{result = result.replace("${replyto}","");}

					if (null != template.getRoute_url()) {
						result = result.replace("${route_url}",
								template.getRoute_url());
					}
					else{result = result.replace("${route_url}","");}
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

}