
package com.tourmade.crm.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.Json;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.EntityList;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.PriceRecord;
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

	@RequestMapping("/list.html")
	public String list(Model model, String flag, HttpSession session) {

		String financeStatus = "order.finance_status";
		List<EntityList> financeStatusList = orderService.getParameterInfo(financeStatus);
		JSONArray financeStatusListResult = JSONArray.fromObject(financeStatusList);
		model.addAttribute("financeStatusList", financeStatusListResult);

		// 没有传递flag参数时，表示时从侧边栏访问的
		if ("".equals(flag) || flag == null) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			model.addAttribute("flag", "restart");
			Calendar calendar = Calendar.getInstance(); // 获取当前日期
			Order order = new Order();

			order.setSearchEndTime(format.format(calendar.getTime()));
			calendar.set(Calendar.MONTH, -3);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			order.setSearchStartTime(format.format(calendar.getTime()));
			model.addAttribute("searchFinanceOrder", order);
		} else
			model.addAttribute("flag", flag);
		return "/finance/list";
	}

	@RequestMapping(value = "/list.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public QueryResult<Order> queryData(Order order, PageHelper page, String flag, HttpSession session) {
		if ("old".equals(flag)) {
			Order search = (Order) session.getAttribute("searchFinanceOrder");
			if (search == null)
				search = new Order();
			order = search;
		} else {
			session.setAttribute("searchFinanceOrder", order);
		}
		order.setSearchStartTime(order.getSearchStartTime()+ " 00:00:00");
		order.setSearchEndTime(order.getSearchEndTime()+ " 24:00:00");
		QueryResult<Order> queryResult = financeService.queryOrder(order, page);
		order.setSearchStartTime(order.getSearchStartTime().substring(0,10));
		order.setSearchEndTime(order.getSearchEndTime().substring(0,10));
		return queryResult;
	}

	@RequestMapping("/edit.html")
	public String edit(Model model, Integer id) {
		// 收款账户
		String account = "finance.account";
		// 款项
		String paymentItem = "finance.item";
		// 货币种类
		String currency = "order.currency";

		String priceStatus = "finance.price.status";

		String costStatus = "finance.price.status";

		List<EntityList> accountList = orderService.getParameterInfo(account);
		List<EntityList> paymentItemList = orderService.getParameterInfo(paymentItem);
		List<EntityList> currencyList = orderService.getParameterInfo(currency);
		List<EntityList> priceStatusList = orderService.getParameterInfo(priceStatus);
		List<EntityList> costStatusList = orderService.getParameterInfo(costStatus);
		// 获取所有的操作员
		List<EntityList> userList = financeService.getAllUser();
		List<EntityList> agencyList = financeService.getAllAgency();
		JSONArray accountListResult = JSONArray.fromObject(accountList);
		JSONArray paymentItemListResult = JSONArray.fromObject(paymentItemList);
		JSONArray currencyResult = JSONArray.fromObject(currencyList);
		JSONArray userListResult = JSONArray.fromObject(userList);
		JSONArray priceStatusListResult = JSONArray.fromObject(priceStatusList);
		JSONArray costStatusListResult = JSONArray.fromObject(costStatusList);
		JSONArray agencyListResult = JSONArray.fromObject(agencyList);
		model.addAttribute("orderId", id);
		model.addAttribute("accountList", accountListResult);
		model.addAttribute("payItemList", paymentItemListResult);
		model.addAttribute("currencyList", currencyResult);
		model.addAttribute("userList", userListResult);
		model.addAttribute("priceStatusList", priceStatusListResult);
		model.addAttribute("costStatusList", costStatusListResult);
		model.addAttribute("agencyList", agencyListResult);

		return "/finance/edit";
	}

	/**
	 * 根据订单id获取订单详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOrder.do")
	@ResponseBody
	public Order getOrderById(Integer id) {
		Order order = orderService.getOrderById(id);
		return order;
	}

	/**
	 * 根据订单id获取收款记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPriceRecordList.do")
	@ResponseBody
	public QueryResult<PriceRecord> getPriceRecordByOrderId(Integer id) {
		QueryResult<PriceRecord> result = financeService.getPriceRecordListByOrderId(id);
		
		return result;
	}

	/**
	 * 根据订单id获取付款记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getCostRecordList.do")
	@ResponseBody
	public QueryResult<CostRecord> getCostRecordByOrderId(Integer id) {
		QueryResult<CostRecord> result = financeService.getCostRecordListByOrderId(id);
		return result;
	}

	/**
	 * 财务管理，更新收款记录信息
	 * 
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value = "/updatePriceRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public int updatePriceRecord(PriceRecord priceRecord) {
								
		return financeService.updatePriceRecord(priceRecord);
	}

	/**
	 * 订单编辑，更新收款记录信息
	 * 
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value = "/updatePriceRecordOrder.do", method = RequestMethod.POST)
	@ResponseBody
	public Json updatePriceRecordOrder(PriceRecord priceRecord) {
		Json json = new Json();
		
		try {
			
			if(priceRecord.getPriceCode().equals("")||priceRecord.getPriceCode()==null){
				financeService.updatePriceRecordPriceCode(priceRecord);
			}
			financeService.updatePriceRecordOrder(priceRecord);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("FinanceController.updatePriceRecord() --> " + priceRecord.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	/**
	 * 订单编辑，更新付款记录信息
	 * 
	 * @param costRecord
	 * @return
	 */
	@RequestMapping(value = "/updateCostRecordOrder.do", method = RequestMethod.POST)
	@ResponseBody
	public Json updateCostRecordOrder(CostRecord costRecord) {
		Json json = new Json();
		
		try {
			financeService.updateCostRecordOrder(costRecord);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("FinanceController.updateCostRecordOrder() --> " + costRecord.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	/**
	 * 财务管理，更新付款记录信息
	 * 
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value = "/updateCostRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateCostRecord(CostRecord costRecord) {
		return financeService.updateCostRecord(costRecord);

	}

	/**
	 * 根据订单ID结算订单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/orderBalance.do", method = RequestMethod.GET)
	public String orderBalance(Integer orderId) {
		financeService.orderBalance(orderId);
		return "redirect:/finance/edit.html?id=" + orderId;

	}

	/**
	 * 根据收款编号更改收款记录的调整金额
	 * 
	 * @param priceRecord
	 * @return
	 */
	@RequestMapping(value = "/priceAdjust.do", method = RequestMethod.GET)
	@ResponseBody
	public int priceAdjust(PriceRecord priceRecord) {
		return financeService.priceAdjustMethod(priceRecord);

	}

	/**
	 * 根据付款ID更改付款记录的调整金额
	 * 
	 * @param costRecord
	 * @return
	 */
	@RequestMapping(value = "/costAdjust.do", method = RequestMethod.GET)
	@ResponseBody
	public int costAdjust(CostRecord costRecord) {

		return financeService.costAdjustMethod(costRecord);

	}
	
	/**
	 * 保存收款记录
	 * 
	 * @param PriceRecord
	 * @return
	 */
	@RequestMapping(value = "/savePriceRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public Json savePriceRecord(PriceRecord priceRecord) {
		
		
		Json json = new Json();	
		
		try {
			priceRecord.setSTATUS(1);
			System.out.println(priceRecord);
			financeService.savePriceRecord(priceRecord);
			financeService.updatePriceRecordPriceCode(priceRecord);
			
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("FinanceController.savePriceRecord() --> " + priceRecord.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	/**
	 * 保存付款记录
	 * 
	 * @param CostRecord
	 * @return
	 */
	@RequestMapping(value = "/saveCostRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public Json savePriceRecord(CostRecord costRecord) {
		
		
		Json json = new Json();	
		
		try {
			costRecord.setStatus(1);
			financeService.saveCostRecord(costRecord);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			logger.error("FinanceController.saveCostRecord() --> " + costRecord.toString() + "\n" + e.getMessage());
		}
		return json;
	}
	
	
	/**
	 * 删除收款记录
	 * 
	 * @param PriceRecord
	 * @return
	 */
	@RequestMapping(value = "/delPriceRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public void delPriceRecord(Integer id,Integer orderId) {
		PriceRecord pr = financeService.getPriceRecordById(id);
		if(pr.getSTATUS()==1||pr.getSTATUS()==null){
			financeService.delPriceRecordByPriceId(id,orderId);
		}
		
	}
	
	/**
	 * 删除付款记录
	 * 
	 * @param PriceRecord
	 * @return
	 */
	@RequestMapping(value = "/delCostRecord.do", method = RequestMethod.GET)
	@ResponseBody
	public void delCostRecord(Integer id,Integer orderId) {
		CostRecord cr = financeService.getCostRecordById(id);
		if(cr.getStatus()==1||cr.getStatus()==null){
			financeService.delCostRecordByCostId(id,orderId);
		}	
		
	}
}
