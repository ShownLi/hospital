package com.tourmade.crm.mapper.sale;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.common.framework.BaseMapper;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Sale;

public interface SaleMapper extends BaseMapper {
	
	public List<Sale> querySale(Map<String, Object> params);
	
	public long countSale(Sale sale);
	
	public void saveSale(Sale sale);

	public void updateSale(Sale sale);

	public void deleteSaleById(int saleId);
	
	public Sale getSaleById(int saleId);

	public List<EntityList> getAgency();
}