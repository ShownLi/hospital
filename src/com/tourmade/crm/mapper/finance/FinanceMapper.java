package com.tourmade.crm.mapper.finance;

import java.util.List;

import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.PriceRecord;

public interface FinanceMapper {

	public List<CostRecord> getCostRecordListByOrderId(Integer id);

	public List<PriceRecord> getPriceRecordListByOrderId(Integer id);

}
