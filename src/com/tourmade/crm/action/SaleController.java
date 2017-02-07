package com.tourmade.crm.action;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.framework.util.JSONUtilS;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Sale;
import com.tourmade.crm.service.SaleService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/sale")
public class SaleController extends BaseSimpleFormController {

	@Autowired
	private SaleService service;

	@RequestMapping(value = "/list.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		return "/sale/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryData(HttpServletRequest request, HttpSession session, Model model, Sale sale, PageHelper page,int agencyId) {
		
		QueryResult<Sale> salePage = service.querySale(sale, page, agencyId, request);
		String result = JSONUtilS.object2json(salePage);

		return result;
	}
	
	@RequestMapping(value = "/add.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model,int agencyId) {
		
		List<EntityList> agencyList = service.getAgency();
		JSONArray result = JSONArray.fromObject(agencyList);
		model.addAttribute("agency",result);
		model.addAttribute("agencyId",agencyId);
		return "/sale/add";
	}

	@RequestMapping(value = "/add.do")
	public String doAdd(HttpServletRequest request, HttpSession session, Model model, Sale sale, @RequestParam("upnamecard")MultipartFile namecard, @RequestParam("upphoto")MultipartFile photo) {
		
		try {
			
			String photoName = "photo"+sale.getAgencyId()+sale.getSalesId()+photo.getOriginalFilename();  
			String photoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/view/attachment")+File.separator+photoName;
			String cardName = "namecard"+sale.getAgencyId()+sale.getSalesId()+namecard.getOriginalFilename();  
			String cardPath = request.getSession().getServletContext().getRealPath("/WEB-INF/view/attachment")+File.separator+cardName;
			File photoFile = new File(photoPath);  
			File cardFile = new File(cardPath);  
			
	        if (!photoFile.getParentFile().exists()) {  
	        	photoFile.getParentFile().mkdirs();  
	        }  
	        if (!photoFile.exists()) {  
	        	photoFile.createNewFile();  
	        }  
	        photo.transferTo(photoFile); //保存图片
	        namecard.transferTo(cardFile); //保存图片
	        sale.setPhoto(photoPath);
	        sale.setNamecard(cardPath);
			service.saveSale(sale);
		} catch (Exception e) {
			logger.error("SaleController.doAdd() --> " + sale.toString() + "\n" + e.getMessage());
		}
		
		return "redirect:/agency/edit.html?id="+sale.getAgencyId();
	}

	@RequestMapping(value = "/edit.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String edit(Model model, String id) {
		
		if (null != id && !"".equals(id)) {
			int i = Integer.parseInt(id);
			Sale u = service.getSaleById(i);
			
			if(u.getPhoto()!=null && u.getNamecard()!=null){
				
				String photoPath = u.getPhoto().split("view")[1].toString().replaceAll("\\\\", "/");
				String cardPath = u.getNamecard().split("view")[1].toString().replaceAll("\\\\", "/");
				u.setPhotoPath("WEB-INF"+File.separator+"view"+photoPath);
				u.setNameCardPath("WEB-INF"+File.separator+"view"+cardPath);
			}
			List<EntityList> v = service.getAgency();
			JSONArray result = JSONArray.fromObject(v);
			model.addAttribute("agency",result);
			model.addAttribute("sales",u);
		}
		
		return "/sale/edit";
	}

	@RequestMapping(value = "/edit.do")
	public String doEdit(HttpServletRequest request, HttpSession session, Model model, Sale sale, @RequestParam("upnamecard")MultipartFile namecard, @RequestParam("upphoto")MultipartFile photo) {
		try {
			//如果邮箱不为空，找到该客人对应的没有保存邮箱的订单，更新邮箱
			if(sale.getSalesEmail()!=""&&sale.getSalesEmail()!=null){
				service.updateOrderEmail(sale);
			}
			
			String photoName = "photo"+sale.getAgencyId()+sale.getSalesId()+photo.getOriginalFilename();  
			String photoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/view/attachment/")+photoName;
			String cardName = "namecard"+sale.getAgencyId()+sale.getSalesId()+namecard.getOriginalFilename();  
			String cardPath = request.getSession().getServletContext().getRealPath("/WEB-INF/view/attachment/")+cardName;
			File photoFile = new File(photoPath);  
			File cardFile = new File(cardPath);  
			
	        if (!photoFile.exists()) {  
	        	photoFile.mkdirs();  
	        }  
	        if (!photoFile.exists()) {  
	        	photoFile.createNewFile();  
	        }  
	        photo.transferTo(photoFile); //保存图片
	        namecard.transferTo(cardFile); //保存图片
	        sale.setPhoto(photoPath);
	        sale.setNamecard(cardPath);
	        
			service.updateSale(sale);
		} catch (Exception e) {
			logger.error("SaleController.doEdit() --> " + sale.toString() + "\n" + e.getMessage());
		}
		return "redirect:/agency/edit.html?id="+sale.getAgencyId();
	}
	
	@RequestMapping(value = "/del.do")
	@ResponseBody
	public Json doDel(HttpServletRequest request, HttpSession session, Model model, String id) {

		Json json = new Json();
		try {
			if (null != id && !"".equals(id)) {
				int saleId= Integer.parseInt(id);
				service.deleteSaleById(saleId);
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("SaleController.doDel() --> " + id + "\n" + e.getMessage());
		}
		
		return json;
	}
}
