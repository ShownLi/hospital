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
	 * @param sale
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
	 * @param sale
	 * @return
	 */
	public int saveSale(DemoSale sale) {
		// sale.setPwd("123456");
		// sale.setPwd(MD5.MD5Encode("123456"));
		try {
			saleMapper.saveSale(sale);
		} catch (Exception e) {
			logger.error("SaleService.saveSale() --> " + sale + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return sale.getSaleid();
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
	 * 更新销售信息(不修改密码)
	 * 
	 * @param sale
	 * @return
	 */
	public boolean updateSale(DemoSale sale) {

		boolean r = false;

		try {
			DemoSale u = saleMapper.getSaleById(sale.getSaleid());
			if (u != null) {
				u.setName(sale.getName());
				// u.setPwd(sale.getPwd());
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
	 * @param saleid
	 * @return
	 */
	public boolean deleteSaleById(int saleid) {

		boolean r = false;

		try {
			saleMapper.deleteSaleById(saleid);
			r = true;
		} catch (Exception e) {
			logger.error("SaleService.deleteSaleById() --> " + saleid + "-->" + e.getMessage());
			r = false;
		}

		return r;
	}
}
