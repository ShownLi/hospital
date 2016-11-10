package com.tourmade.crm.entity;

import java.util.Date;

/**
 * API返回的order对象，包括orderId,最后回复时间，orderrecord的content，订单状态的中文名，销售的portalId
 * @author Lzp
 *
 */
public class PortalOrder {
	private static final long serialVersionUID = 1423523863575074623L;

	private Integer orderId;
	
	private Integer salesPortalId;
	
	private String content;
	
	private Date lastResponse;
	
	private String status;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getSalesPortalId() {
		return salesPortalId;
	}

	public void setSalesPortalId(Integer salesPortalId) {
		this.salesPortalId = salesPortalId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(Date lastResponse) {
		this.lastResponse = lastResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
