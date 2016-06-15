package com.tourmade.crm.mapper.sale;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.model.DemoList;
import com.tourmade.crm.model.DemoSale;

public interface DemoSaleMapper extends BaseMapper {
	
	public List<DemoSale> querySale(Map<String, Object> params);
	
	public long countSale(DemoSale sale);
	
	public void saveSale(DemoSale sale);

	public void updateSale(DemoSale sale);

	public void deleteSaleById(int sale_id);
	
	public DemoSale getSaleById(int sale_id);

	public List<DemoList> getAgency();
}