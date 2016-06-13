package com.tourmade.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourmade.crm.common.framework.BaseService;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.mapper.sale.DemoSaleMapper;
import com.tourmade.crm.model.DemoSale;
import com.tourmade.crm.model.DemoUser;

@Service
@Transactional(readOnly = false)
public class SaleService extends BaseService {
	
	@Autowired
	private DemoSaleMapper SaleMapper;

	/**
	 * 查询地接社数据，分页展示
	 * 
	 * @param Sale
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoSale> querySale(DemoSale Sale, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoSale> r = new QueryResult<DemoSale>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == Sale) {
				Sale = new DemoSale();
			}
			Sale.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", Sale);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoSale> data = SaleMapper.querySale(map);
		long count = SaleMapper.countSale(Sale);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);

		
		
		return r;
	}

	/**
	 * 新增地接社
	 * 
	 * @param Sale
	 * @return
	 */
	public int saveSale(DemoSale Sale) {

		try {
			SaleMapper.saveSale(Sale);
		} catch (Exception e) {
			logger.error("SaleService.saveSale() --> " + Sale + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return Sale.getSale_id();
	}

	/**
	 * 根据主键获取地接社信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoSale getSaleById(int id) {
		DemoSale r = null;
		try {
			r = SaleMapper.getSaleById(id);
		} catch (Exception e) {
			logger.error("SaleService.getSaleById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 更新地接社信息(不修改密码)
	 * 
	 * @param Sale
	 * @return
	 */
	public boolean updateSale(DemoSale Sale) {

		boolean r = false;

		try {
			DemoSale u = SaleMapper.getSaleById(Sale.getSale_id());
			if (u != null) {
				u.setName(Sale.getName());
				SaleMapper.updateSale(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("SaleService.updateSale() --> " + Sale + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除地接社（假删除）
	 * 
	 * @param Sale_id
	 * @return
	 */
	public boolean deleteSaleById(int Sale_id) {

		boolean r = false;

		try {
			SaleMapper.deleteSaleById(Sale_id);
			r = true;
		} catch (Exception e) {
			logger.error("SaleService.deleteSaleById() --> " + Sale_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}