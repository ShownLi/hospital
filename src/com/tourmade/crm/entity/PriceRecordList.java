package com.tourmade.crm.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
;

public class PriceRecordList {
	private List<Integer> paymentItem = new ArrayList<Integer>();
	private List<BigDecimal> priceBudget = new ArrayList<BigDecimal>();
	private List<Date> deadline = new ArrayList<Date>();
	private List<String> comment = new ArrayList<String>();
	public List<Integer> getPaymentItem() {
		return paymentItem;
	}
	public void setPaymentItem(Integer paymentItem) {
		this.paymentItem.add(paymentItem);
	}
	public List<BigDecimal> getPriceBudget() {
		return priceBudget;
	}
	public void setPriceBudget(BigDecimal priceBudget) {
		this.priceBudget.add(priceBudget);
	}
	public List<Date> getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline.add(deadline);
	}
	public List<String> getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment.add(comment);
	}
	
	
}
