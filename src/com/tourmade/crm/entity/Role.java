package com.tourmade.crm.entity;

import com.tourmade.crm.common.framework.BaseBean;

/**
 * 菜单类
 * @author lxy
 *
 */
public class Role extends BaseBean<Role>{

	private static final long serialVersionUID = 8141876345433539394L;

	private Integer role_id;
	
	private String role_name;
	
	private Integer menu_id;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", menu_id=" + menu_id + "]";
	}
}
