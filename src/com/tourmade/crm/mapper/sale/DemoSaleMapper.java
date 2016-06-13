package com.tourmade.crm.mapper.sale;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoSale;

public interface DemoSaleMapper extends BaseMapper {
	
	public List<DemoSale> querySale(Map<String, Object> params);
	
	public long countSale(DemoSale Sale);
	
	public void saveSale(DemoSale Sale);

	public void updateSale(DemoSale Sale);

	public void deleteSaleById(int Sale_id);
	
	public DemoSale getSaleById(int Sale_id);
}