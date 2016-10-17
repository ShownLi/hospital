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
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Sale;
import com.tourmade.crm.mapper.sale.SaleMapper;

@Service
@Transactional(readOnly = false)
public class SaleService extends BaseService {

	@Autowired
	private SaleMapper saleMapper;

	/**
	 * 查询销售数据，分页展示
	 * 
	 * @param sale
	 * @param ph
	 * @param request
	 * @return
	 */
	public QueryResult<Sale> querySale(Sale sale, PageHelper ph, int agencyId,HttpServletRequest request) {

		QueryResult<Sale> pageResult = new QueryResult<Sale>();
		Map<String, Object> map = new HashMap<String, Object>();		
		
		map.put("agencyId", agencyId);
		map.put("start", ph.getStart());
		map.put("length", ph.getLength());

		List<Sale> data = saleMapper.querySale(map);
		long count = saleMapper.countSale(sale);
		
		pageResult.setData(data);
		pageResult.setCountTotal(count);
		pageResult.setCountFiltered(count);

		return pageResult;
	}

	/**
	 * 新增销售
	 */
	public int saveSale(Sale sale) {
		
		try {
			saleMapper.saveSale(sale);
		} catch (Exception e) {
			logger.error("SaleService.saveSale() --> " + sale + "-->" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return sale.getSalesId();
	}

	/**
	 * 根据主键获取销售信息
	 */
	public Sale getSaleById(int id) {
		Sale sale = null;
		try {
			sale = saleMapper.getSaleById(id);
		} catch (Exception e) {
			logger.error("SaleService.getSaleById() --> " + id + "-->" + e.getMessage());
			sale = null;
		}
		return sale;
	}
	
	/**
	 * 获取地接社列表
	 */
	public List<EntityList> getAgency() {
		List<EntityList> r = null;
		try {
			r = saleMapper.getAgency();
		} catch (Exception e) {
			logger.error("SaleService.getAgency() -->" + e.getMessage());
			r = null;
		}
		return r;
	}
	
	/**
	 * 更新销售信息(不修改密码)
	 */
	public void updateSale(Sale sale) {

		try {
			Sale s = saleMapper.getSaleById(sale.getSalesId());
			if (s != null) {
/*				u.setSalesName(sale.getSalesName());
				u.setSalesName(sale.getSalesName());
				u.setSalesPortalId(sale.getSalesPortalId());
				u.setSalesEmail(sale.getSalesEmail());*/
				saleMapper.updateSale(sale);
			}
		} catch (Exception e) {
			logger.error("SaleService.updateSale() --> " + sale + "-->" + e.getMessage());
		}
	}

	/**
	 * 删除销售（假删除）
	 */
	public void deleteSaleById(int saleId) {

		try {
			saleMapper.deleteSaleById(saleId);
		} catch (Exception e) {
			logger.error("SaleService.deleteSaleById() --> " + saleId + "-->" + e.getMessage());
		}
	}
}
