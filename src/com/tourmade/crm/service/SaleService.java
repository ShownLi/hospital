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

@Service
@Transactional(readOnly = false)
public class SaleService extends BaseService {
	
	@Autowired
	private DemoSaleMapper saleMapper;

	/**
	 * 查询销售数据，分页展示
	 * 
	 * @param Sale
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<DemoSale> querySale(DemoSale sale, PageHelper ph, HttpServletRequest request) {

		QueryResult<DemoSale> r = new QueryResult<DemoSale>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(ph);
		
		String seachValue = ph.getSearch().get("value");
		
		if (null != seachValue && !"".equals(seachValue)) {
			if (null == sale) {
				sale = new DemoSale();
			}
			sale.setSeachValue(seachValue);
		}
			
		
		
		map.put("pojo", sale);
		map.put("b", ph.getStart());
		map.put("e", ph.getLength());
//		map.put("s", ph.getSort());
//		map.put("o", ph.getOrder());

		List<DemoSale> data = saleMapper.querySale(map);
		long count = saleMapper.countSale(sale);
			
		r.setData(data);
		r.setCountTotal(count);
		r.setCountFiltered(count);

		
		
		return r;
	}

	/**
	 * 新增销售
	 * 
	 * @param Sale
	 * @return
	 */
	public int saveSale(DemoSale sale) {

		try {
			saleMapper.saveSale(sale);
		} catch (Exception e) {
			logger.error("SaleService.saveSale() --> " + sale + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return sale.getSale_id();
	}

	/**
	 * 根据主键获取销售信息
	 * 
	 * @param id
	 * @return
	 */
	public DemoSale getSaleById(int id) {
		DemoSale r = null;
		try {
			r = saleMapper.getSaleById(id);
		} catch (Exception e) {
			logger.error("SaleService.getSaleById() --> " + id + "-->" + e.getMessage());
			r = null;
		}
		return r;
	}

	/**
	 * 更新销售信息
	 * 
	 * @param Sale
	 * @return
	 */
	public boolean updateSale(DemoSale sale) {

		boolean r = false;

		try {
			DemoSale u = saleMapper.getSaleById(sale.getSale_id());
			if (u != null) {
				u.setName(sale.getName());
				saleMapper.updateSale(u);
				r = true;
			} else {
				r = false;
			}
		} catch (Exception e) {
			logger.error("SaleService.updateSale() --> " + sale + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

	/**
	 * 删除销售（假删除）
	 * 
	 * @param Sale_id
	 * @return
	 */
	public boolean deleteSaleById(int sale_id) {

		boolean r = false;

		try {
			saleMapper.deleteSaleById(sale_id);
			r = true;
		} catch (Exception e) {
			logger.error("SaleService.deleteSaleById() --> " + sale_id + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}

}