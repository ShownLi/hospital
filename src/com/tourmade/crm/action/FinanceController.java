
package com.tourmade.crm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.service.FinanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmade.crm.common.action.BaseSimpleFormController;
import com.tourmade.crm.common.framework.bean.QueryResult;
import com.tourmade.crm.common.model.base.value.baseconfig.PageHelper;
import com.tourmade.crm.entity.CostRecord;
import com.tourmade.crm.entity.Order;
import com.tourmade.crm.entity.PriceRecord;
import com.tourmade.crm.service.FinanceService;
import com.tourmade.crm.service.OrderService;
@Controller
@RequestMapping("/finance")
public class FinanceController extends BaseSimpleFormController {
	@Autowired
	private FinanceService financeService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/list.html")
	public String list(){
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
		model.addAttribute("orderId", id);
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
	
}

