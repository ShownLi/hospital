package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 菜单类
 * @author lxy
 *
 */
public class Menu extends BaseBean<Menu>{

	private static final long serialVersionUID = 8141876345433539394L;

	private String menuName;
	
	private String menuCategory;
	
	private String url;
	
	private Integer menuID;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMenuID() {
		return menuID;
	}

	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", menuCategory=" + menuCategory + ", url=" + url + ", menuID=" + menuID
				+ "]";
	}
}
