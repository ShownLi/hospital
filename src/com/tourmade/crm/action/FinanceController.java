package com.tourmade.crm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.PriceRecord;
import com.tourmade.crm.service.CaseService;
import com.tourmade.crm.service.FinanceService;
import com.tourmade.crm.service.OrderService;

import net.sf.json.JSONArray;
@Controller
@RequestMapping("/finance")
public class FinanceController extends BaseSimpleFormController {
	@Autowired
	private FinanceService financeService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CaseService caseService;
	@RequestMapping("/list.html")
	public String list(Model model){
		
		String financeStatus = "finance.finance_status";
		List<EntityList> financeStatusList = orderService.getParameterInfo(financeStatus);
		JSONArray financeStatusListResult = JSONArray.fromObject(financeStatusList);
		model.addAttribute("financeStatusList", financeStatusListResult);
		return "/finance/list";
	}
	
	@RequestMapping(value = "/list.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public QueryResult<Order> queryData(Order order, PageHelper page) {
		QueryResult<Order> queryResult = financeService.queryOrder(order, page);
		return queryResult;
	}
	@RequestMapping("/edit.html")
	public String edit(Model model,Integer id){
		//收款账户
		String account = "finance.account";
		//款项
		String paymentItem = "finance.item";
		//货币种类
		String currency = "order.currency";
		List<EntityList> accountList = orderService.getParameterInfo(account);
		List<EntityList> paymentItemList = orderService.getParameterInfo(paymentItem);
		List<EntityList> currencyList = orderService.getParameterInfo(currency);
		//获取所有的操作员
		List<EntityList> userList = caseService.getAllUser();
		JSONArray accountListResult = JSONArray.fromObject(accountList);
		JSONArray paymentItemListResult = JSONArray.fromObject(paymentItemList);
		JSONArray currencyResult = JSONArray.fromObject(currencyList);
		JSONArray userListResult = JSONArray.fromObject(userList);
		model.addAttribute("orderId", id);
		model.addAttribute("accountList", accountListResult);
		model.addAttribute("payItemList", paymentItemListResult);
		model.addAttribute("currencyList", currencyResult);
		model.addAttribute("userList", userListResult);
		
		return "/finance/edit";
	}
	/**
	 * 根据订单id获取订单详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOrder.do")
	@ResponseBody
	public Order getOrderById(Integer id){
		Order order = orderService.getOrderById(id);
		return order;
	}
	/**
	 * 根据订单id获取收款记录
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPriceRecordList.do")
	@ResponseBody
	public QueryResult<PriceRecord> getPriceRecordByOrderId(Integer id){
		QueryResult<PriceRecord> result = financeService.getPriceRecordListByOrderId(id);;
		return result;
	}
	/**
	 * 根据订单id获取付款记录
	 * @param id
	 * @return
	 */
	@RequestMapping("/getCostRecordList.do")
	@ResponseBody
	public QueryResult<CostRecord> getCostRecordByOrderId(Integer id){
		QueryResult<CostRecord> result = financeService.getCostRecordListByOrderId(id);
		return result;
	}
	/**
	 * 财务管理，更新收款记录信息
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value="/updatePriceRecord.do",method=RequestMethod.POST)
	@ResponseBody
	public int updatePriceRecord(PriceRecord priceRecord){
		return financeService.updatePriceRecord(priceRecord);
		
	}
	/**
	 * 根据订单ID结算订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="/orderBalance.do",method=RequestMethod.GET)
	@ResponseBody
	public int orderBalance(int orderId){
		return financeService.orderBalance(orderId);
		
	}
	/**
	 * 根据收款编号更改收款记录的调整金额
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value="/priceAdjust.do",method=RequestMethod.GET)
	@ResponseBody
	public int priceAdjust(PriceRecord priceRecord){
		return financeService.priceAdjustMethod(priceRecord);
		
	}
	/**
	 * 根据付款ID更改付款记录的调整金额
	 * @param costRecord
	 * @return
	 */
	@RequestMapping(value="/costAdjust.do",method=RequestMethod.GET)
	@ResponseBody
	public int costAdjust(CostRecord costRecord){
		
		return financeService.costAdjustMethod(costRecord);
		
	}
}
