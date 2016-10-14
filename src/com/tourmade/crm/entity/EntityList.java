package com.tourmade.crm.entity;


import com.tourmade.crm.common.framework.BaseBean;

/**
 * 列表model
 * 
 * @author lianzheng
 *
 */
public class EntityList extends BaseBean<EntityList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423523863575074623L;

	
	private String id;
	
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemoList [id=" + id + ", text=" + text + "]";
	}

}
