package com.tourmade.crm.common.framework.bean;

import java.util.List;

public class ComboTreeModel {
   
	
	private String label;//bootstrap
	private String value;//bootstrap
	private String parentid;
	private String title;
	private String selected;
	private List<ComboTreeModel> children;
	
	
	public List<ComboTreeModel> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTreeModel> children) {
		this.children = children;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getParentid() {
		return parentid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getSelected() {
		return selected;
	}
	
	
     
}
