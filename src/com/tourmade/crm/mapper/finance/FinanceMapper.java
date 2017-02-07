package com.tourmade.crm.mapper.finance;

import java.util.List;
import java.util.Map;

import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.PriceRecord;

public interface FinanceMapper {

	public List<CostRecord> getCostRecordListByOrderId(Integer id);

	public List<PriceRecord> getPriceRecordListByOrderId(Integer id);

	public int updatePriceRecord(PriceRecord priceRecord);

	public PriceRecord getAllSumPriceRecord(Integer orderId);
	
	public int updateCostRecord(CostRecord costRecord);

	public CostRecord getAllSumCostRecord(Integer orderId);
	
	public int updateOrderAfterUpdatePriceRecord(PriceRecord sumPriceRecord);

	public int updateOrderAfterUpdateCostRecord(CostRecord sumCostRecord);
	
	public int updateOrderFinanceStatus(Map<String,Object> map);
	public void balancePriceRecordByOrderId(int orderId);

	public void balanceCostRecordByOrderId(int orderId);

	public void balanceOrderByOrderId(int orderId);

	public int priceAdjustMethod(PriceRecord priceRecord);

	public int costAdjustMethod(CostRecord costRecord);


	public int savePriceRecord(PriceRecord priceRecord);

	public void updatePriceRecordPriceCode(PriceRecord priceRecord);

	public List<EntityList> getAllUser();

	public List<EntityList> getAllAgency();

	public void delPriceRecordByPriceId(int id);

	public void saveCostRecord(CostRecord costRecord);

	public void updateCostRecordOrder(CostRecord costRecord);

	public void updatePriceRecordOrder(PriceRecord priceRecord);

	public void delCostRecordByCostId(int id);

	public PriceRecord getPriceRecordById(int id);

	public CostRecord getCostRecordById(int id);


}
